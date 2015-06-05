package com.tw.hello.base64;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

/**
 * Created by tphuang on 6/5/15.
 */
public class KKTokenGen {
    public static String KkTokenGen(String username,int createTime,int expTime,String secret,String charset) throws UnsupportedEncodingException {

        String LtpaToken="";
        //4位占位符
        String headerCode = String.valueOf(ascii2Char(0))
                + String.valueOf(ascii2Char(1))
                + String.valueOf(ascii2Char(2))
                + String.valueOf(ascii2Char(3))	;

        String headerCode1 = Character.toString((char) 0)
                + Character.toString((char) 1)
                + Character.toString((char) 2)
                + Character.toString((char) 3);

        System.out.println("### headerCode： "+ headerCode.equals(headerCode1) );

        //java 时间戳和PHP时间戳精度不同
        //JAVA时间戳长度是13位，如：1294890876859
        //PHP时间戳长度是10位， 如：1294890859
        //时间处理，永不过期

        String dateNowHex = Long.toHexString(createTime);
        String dateExpHex = Long.toHexString(expTime);
        //组装header头码
        String header = (headerCode + dateNowHex + dateExpHex).toUpperCase() + username;

        //sha1加密
//        SHA1 sha1 = new SHA1();
        try {
            String resultSha1 = SHA1(header + new String(Base64.decodeBase64(secret),charset));
            System.out.println("apc### resultSha1： "+resultSha1 );

            //ACSII转换
            String stringToByte2STR = stringToByte2(resultSha1);
            String resultBase64Encode = new String(Base64.encodeBase64((header+stringToByte2STR).getBytes(charset) ));
            //URL_encode转换
            String resultURLEncoder =  java.net.URLEncoder.encode(resultBase64Encode,charset);
            return resultURLEncoder;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return LtpaToken;
    }

    public static String stringToByte2(String str) {
        int len = str.length() / 2;
        String[] arrStr = new String[len];
        String result = "";
        for (int i = 0; i < len; i++) {
            arrStr[i] = str.substring(i * 2, i * 2 + 2);
            result += String.valueOf(ascii2Char(Integer.valueOf(Integer.parseInt(arrStr[i], 16))));
            //System.out.println("arrStr[i] 十六进制 :"+"["+i+"]" + arrStr[i]);
            //System.out.println("arrStr[i] 十进制 :"+"["+i+"]" + Integer.valueOf(Integer.parseInt(arrStr[i],16)));
            //System.out.println("arrStr[i] ASCII:"+"["+i+"]" + String.valueOf(ascii2Char(Integer.valueOf(Integer.parseInt(arrStr[i],16)))));
        }
        return result;
    }

    static char ascii2Char(int ASCII) {
        return (char) ASCII;
    }

    public static String SHA1(String str){
        String sha1 = "";
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.reset();
            md.update(stringToByte(str));

            sha1 = byteToHex(md.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sha1;
    }

    private static String byteToHex(byte[] b)
    {
        String result = "";
        for (int i=0; i < b.length; i++) {
            result +=
                    Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
        }
        return result;
    }

    public static byte[] stringToByte(String str){
        return str.getBytes(StandardCharsets.ISO_8859_1); // change to adapt other charset
    }

    public static String stringToByteString(String str){
        String result = "";
        int len = 2;
        int end = len;
        String s;
        for (int i = 0; i < str.length();) {
            if (end > str.length()){
                end = str.length();
            }

            s = str.substring(i, end);
            i = end;
            end = i + len;

            int tmp = Integer.valueOf(s, 16);

            result += Character.toString((char) tmp);
        }
        return result;
    }

    public static void main(String[] args) {
		/*
		wangxin
		1433420033
		1433420033 + 3600
		ypVsl3BuxmeUYZvHmmZjbpWZlDk=
		=f?
		AAECAzU1NzA0MDFBNTU3MDRFMkF3YW5neGlu8OHgywnnXvyU28Nd72jk0YMJ4Uk%3D
		*/
        String username = "zhoukaiqi";
        //String ctime = "1433420033";
        //String etime = "1433423633";
        int ctime = 1433471659;
        int etime = 1433471659 + 6000000;

        String secret = "ypVsl3BuxmeUYZvHmmZjbpWZlDk=";
        String kk_token = "null";
        try {
            kk_token = KkTokenGen(username,ctime, etime, secret, "iso-8859-1");
            System.out.println("kk_token: " + kk_token);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

//        String kkTokenGen = KkTokenGen(username, secret, "iso-8859-1");
//        System.out.printf("KKTokenGen: " + kkTokenGen);
        //Header码是： 4位占位符 + 8位16进制创建时间 + 8位16进制过期时间 + username
        //expect: AAECAzU1NkZBMkNGNTU3MDRCOEZ3YW5neGluJ9RXzzwqWA9tBPgL0bHa8aRdOdg%3D (65位)
        //result1: AAECAzU1NzA0MTAxNTU3MDRGMTF3YW5neGlumV%2FWkbwO1PKsmbErC9iuACeGK7I%3D
        //result2: AAECAzU1NzA4OEYzMThENUQ0MkFBd2FuZ3hpbpU9z6z7mFXfe%2FG%2FL0nT0VYacP%2FA
    }
}
