package com.libaoshen.hrs.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	/**
	 * byte����ת��Ϊ16�����ַ���
	 * @param src
	 * @return
	 */
	public static String byteToString(byte[] src){
		StringBuilder stringBuilder = new StringBuilder();       

        if (src == null || src.length <= 0) {       
            return null;       
        }       

        for(int i = 0; i < src.length; i++) {       
            int v = src[i] & 0xFF;       
            String hv = Integer.toHexString(v);       
            if (hv.length() < 2) {       
                stringBuilder.append(0);       
            }       
            stringBuilder.append(hv);       
        }       

        return stringBuilder.toString();       
    }
	
	/**
	 * ��һ���ַ���תΪMD5����
	 * @param s
	 * @return
	 */
	public static String getMD5Code(String s){
		byte[] src = null;
		try {
			src = MessageDigest.getInstance("MD5").digest(s.getBytes());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return byteToString(src);
	}
}
