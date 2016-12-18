package com.ht.util;

import java.lang.ref.WeakReference;
import java.util.Vector;

public class XMLChangeBroadcaster
{
  protected Vector listeners;

  public XMLChangeBroadcaster()
  {
    this.listeners = new Vector();
  }

  public void addListener(XMLChangeListener listener)
  {
    WeakReference wr = new WeakReference(listener);
    this.listeners.addElement(wr);
  }

  public void removeListener(XMLChangeListener listener)
  {
    int size = this.listeners.size();
    int i = 0;
    while (i < size)
    {
      WeakReference wr = (WeakReference)this.listeners.elementAt(i);
      XMLChangeListener xcl = (XMLChangeListener)wr.get();
      if (xcl == null)
      {
        this.listeners.removeElement(wr);
        --size;
      }
      else if (xcl == listener)
      {
        this.listeners.removeElement(wr);
        --size;
      }
      else
      {
        ++i;
      }
    }
  }

  protected void fireChange(String name, int action, int type)
  {
    XMLChangeEvent evt = null;
    Vector l = (Vector)this.listeners.clone();
    int size = l.size();
    int i = 0;

    while (i < size)
    {
      WeakReference wr = (WeakReference)l.elementAt(i);
      XMLChangeListener xcl = (XMLChangeListener)wr.get();
      if (xcl == null)
      {
        this.listeners.removeElement(wr);
      }
      else
      {
        if (evt == null)
        {
          evt = new XMLChangeEvent(name, action, type);
        }
        xcl.XMLChanged(evt);
      }
      ++i;
    }
  }

  protected void fireChange(String oldName, String newName, int type)
  {
    XMLChangeEvent evt = null;
    Vector l = (Vector)this.listeners.clone();
    int size = l.size();
    int i = 0;

    while (i < size)
    {
      WeakReference wr = (WeakReference)l.elementAt(i);
      XMLChangeListener xcl = (XMLChangeListener)wr.get();
      if (xcl == null)
      {
        this.listeners.removeElement(wr);
      }
      else
      {
        if (evt == null)
        {
          evt = new XMLChangeEvent(oldName, newName, type);
        }
        xcl.XMLChanged(evt);
      }
      ++i;
    }
  }
}