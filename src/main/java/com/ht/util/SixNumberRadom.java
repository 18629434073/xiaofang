package com.ht.util;

/**
 * ����6λ������ַ���
 *
 */
public class SixNumberRadom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
		}
	}
	
	public static String getVerificationCode(){
		String result="";
		for(int i=0;i<6;i++){
			int intVal=(int)(Math.random()*26+97);
			result=result+(char)intVal;
		}
		System.out.println(result);
		return result;
	}

}
