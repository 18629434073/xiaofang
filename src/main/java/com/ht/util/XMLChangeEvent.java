package com.ht.util;

public class XMLChangeEvent
{
  private int action;
  private int type;
  private String name;
  private String oldName;
  public static final int ITEM_ADDED = 1;
  public static final int ITEM_REMOVED = 2;
  public static final int ITEM_CHANGED = 3;
  public static final int CUBE = 1;
  public static final int DATAMART = 2;
  public static final int MAPPING = 3;
  public static final int PACKAGE = 4;
  public static final int DATASOURCE = 5;
  public static final int SCHEDULE = 6;
  public static final int DATAMAP = 7;
  public static final int ETLQUEUE = 8;
  public static final int REPORT = 9;

  public XMLChangeEvent(String name, int action, int type)
  {
    this.name = name;
    this.type = type;
    this.action = action;
    this.oldName = name;
  }

  public XMLChangeEvent(String oldName, String newName, int type)
  {
    this.oldName = oldName;
    this.name = newName;
    this.action = 3;
    this.type = type;
  }

  public String getName()
  {
    return this.name;
  }

  public String getOldName()
  {
    return this.oldName;
  }

  public int getType()
  {
    return this.type;
  }

  public int getAction()
  {
    return this.action;
  }
}