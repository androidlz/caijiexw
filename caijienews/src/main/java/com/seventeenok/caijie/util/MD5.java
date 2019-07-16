package com.seventeenok.caijie.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by ShiQing on 2018/3/6 0006 16:10
 * Desc:
 */

public class MD5 {
    /**
     * 获取MD5消息摘要
     * @param data 源数据
     * @return MD5消息摘要
     */
    public static byte[] getMD5(byte[] data){
        byte[] md5 = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md5 = md.digest(data);
        } catch (Exception e) {
        }
        return md5;
    }
    
    /*
     * MD5字符串
     */
    public static String getMD5Str(String str) {
        MessageDigest messageDigest = null;
        
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException = " + e.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        byte[] byteArray = messageDigest.digest();
        
        StringBuffer md5StrBuff = new StringBuffer();
        
        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
                md5StrBuff.append("0").append(
                        Integer.toHexString(0xFF & byteArray[i]));
            else
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
        }
        return md5StrBuff.toString().toLowerCase();
    }
    
    /*
     * MD5字符串
     */
    public static String getMD5Str(byte[] data) {
        MessageDigest messageDigest = null;
        
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            
            messageDigest.reset();
            
            messageDigest.update(data);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException = " + e.toString());
        }
        
        byte[] byteArray = messageDigest.digest();
        
        StringBuffer md5StrBuff = new StringBuffer();
        
        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
                md5StrBuff.append("0").append(
                        Integer.toHexString(0xFF & byteArray[i]));
            else
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
        }
        return md5StrBuff.toString().toLowerCase();
    }
    
    /*
     * 得到文件的MD5字符串
     */
    public static String getFileMD5(String filename) {
        
        File file = new File(filename);
        return getFileMD5(file);
        
    }
    
    /*
	 * 得到文件的MD5字符串
	 */
    public static String getFileMD5(File file) {
        InputStream fis;
        byte[] buffer = new byte[1024];
        int numRead = 0;
        MessageDigest md5;
        try{
            fis = new FileInputStream(file);
            md5 = MessageDigest.getInstance("MD5");
            while((numRead=fis.read(buffer)) > 0) {
                md5.update(buffer,0,numRead);
            }
            fis.close();
            
            byte[] byteArray = md5.digest();
            
            StringBuffer md5StrBuff = new StringBuffer();
            
            for (int i = 0; i < byteArray.length; i++) {
                if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
                    md5StrBuff.append("0").append(
                            Integer.toHexString(0xFF & byteArray[i]));
                else
                    md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
            }
            return md5StrBuff.toString().toLowerCase();
            
        } catch (Exception e) {
            return null;
        }
    }
}
