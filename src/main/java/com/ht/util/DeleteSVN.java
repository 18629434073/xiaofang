package com.ht.util;

import java.io.File;

public class DeleteSVN {

	public static void main(String[] args) {
//		String path = "E:\\chenhao\\library";
		String path = "F:\\intellij\\icare";
		File file = new File(path);
		deleteSvn(file);
	}
	public static void deleteSvn(File file){
		for (File f : file.listFiles()) {
			if (f.isDirectory() && f.getName().equals("CVS")) {
				deleteFile(f);
			}
			else if(f.isDirectory()){
				deleteSvn(f);
			}
		}
		
	}
	private static void deleteFile(File file) {
		System.out.println(file.getName());
		if (file.isFile()) {
			file.delete();
		} else {
			File[] files = file.listFiles();
			for (File f : files) {
				deleteFile(f);
			}
			file.delete();
		}
	}
}
