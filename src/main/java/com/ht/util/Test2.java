package com.ht.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * Created by de on 2016/5/19.
 */
public class Test2 {

    public static void main(String[] args) throws FileNotFoundException {
        String path = "D:\\icare";
        File file = new File(path);
        changeCVS(file);
    }
    public static void changeCVS(File file) throws FileNotFoundException {
        for (File f : file.listFiles()) {
            if (!f.isDirectory() && f.getName().equals("Root")) {
                PrintWriter pw = new PrintWriter(new FileOutputStream(f));
                pw.println(":pserver:guoming@192.168.1.180:/home/cvsroot");
                pw.flush();
                pw.close();
            }
            else if(f.isDirectory()){
                changeCVS(f);
            }
        }

    }

}
