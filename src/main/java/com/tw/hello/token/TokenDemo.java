package com.tw.hello.token;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.net.URLCodec;

/**
 * Created by tphuang on 6/4/15.
 */
public class TokenDemo {
    public static String KkTokenGen(String username, String secret, String charset) {

        String LtpaToken = "";
//        String header = handleHeader(username);
        long ctime = 1433420033;
        long etime = 1433423633;
        String header = getHeader(username, ctime, etime);
        ////��5570F4CA5571816Awangxin

        //验证码：ASCII数组运算(sha1加密(Header码 + base64解码(秘钥)))
        //sha1加密
//		SHA1 sha1 = new SHA1();
        try {

//		String resultSha1 = sha1.Digest(header + new String(Base64.decodeBase64(secret),charset) );
//      String resultSha1 = buildIdentity(header + new String(Base64.decodeBase64(secret), charset));
		String resultSha1 = EncoderHandler.encode("SHA1",header + new String(Base64.decodeBase64(secret),charset));
            //ACSII转换
            String stringToByte2STR = stringToByte2(resultSha1);
            //BASE64_encode转换
            String resultBase64Encode = new String(Base64.encodeBase64((header + stringToByte2STR).getBytes(charset)));
            //URL_encode转换
            String resultURLEncoder = java.net.URLEncoder.encode(resultBase64Encode, charset);
            return resultURLEncoder;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return LtpaToken;
    }

    private static String handleHeader(String username) {
        //Header码是： 4位占位符 + 8位16进制创建时间 + 8位16进制过期时间 + username
        //4位占位符
        String headerCode = String.valueOf(ascii2Char(0))
                + String.valueOf(ascii2Char(1))
                + String.valueOf(ascii2Char(2))
                + String.valueOf(ascii2Char(3));
        //java 时间戳和PHP时间戳精度不同
        //JAVA时间戳长度是13位，如：1294890876859
        //PHP时间戳长度是10位， 如：1294890859
        //时间处理，用不过期
        Date date = new Date();
        long time = date.getTime();
        String dateline = time + "";
        dateline = dateline.substring(0, 10); //PHP时间戳长度是10位,需要处理
        String dateNowHex = Long.toHexString(Long.parseLong(dateline));
        String dateExpHex = Long.toHexString(6666666666L);
        //组装header头码
        String header = (headerCode + dateNowHex + dateExpHex).toUpperCase() + username;
        System.out.println("handleHeader() header： "+ header ); // 5570837018D5D42AAwangxin
        return header;
    }

    private static String getHeader(String username, long ctime, long etime) {
        //Header码是： 4位占位符 + 8位16进制创建时间 + 8位16进制过期时间 + username
        //String headerCode = String.valueOf((char)65)+String.valueOf((char)66)+String.valueOf((char)67)+String.valueOf((char)68);
        String headerCode = String.valueOf((char) 0) + String.valueOf((char) 1) + String.valueOf((char) 2) + String.valueOf((char) 3);
        System.out.println("getHeader() headerCode" + headerCode);

        String header = (headerCode + Long.toHexString(ctime) + Long.toHexString(etime)).toUpperCase() + username;
        System.out.println("getHeader() header: " + header);// 5570410155704F11wangxin
        return header;
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

    public static String buildIdentity(String identity) {
        try {
            return new String(new URLCodec().encode(toSHA1(identity.getBytes("utf-8"))), "iso-8859-1").toLowerCase();
        } catch (UnsupportedEncodingException e) {
            // should never happen, utf-8 and iso-8859-1 support is required by jvm specification. In any case, we rethrow.
            throw new RuntimeException(e);
        }
    }

    public static byte[] toSHA1(byte[] convertme) throws UnsupportedEncodingException {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(convertme);
            return md.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    //java 合并两个byte数组
    public static byte[] byteMerger(byte[] byte_1, byte[] byte_2) {
        byte[] byte_3 = new byte[byte_1.length + byte_2.length];
        System.arraycopy(byte_1, 0, byte_3, 0, byte_1.length);
        System.arraycopy(byte_2, 0, byte_3, byte_1.length, byte_2.length);
        return byte_3;
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
        String username = "wangxin";
        //String ctime = "1433420033";
        //String etime = "1433423633";
        long ctime = 1433420033;
        long etime = 1433423633;

        String secret = "ypVsl3BuxmeUYZvHmmZjbpWZlDk=";
        String header = getHeader(username, ctime, etime);
//        String header = handleHeader(username);

        String kk_token = "null";
        //base64_encode($header.self::stringToByte(sha1($header.base64_decode($secret))));
        try {
            String resultSha1 = EncoderHandler.encode("SHA1",header + new String(Base64.decodeBase64(secret),"ISO-8859-1"));
//            String decodeString = Base64.decodeBase64(secret).toString();

            //
            String stringToByte2STR = stringToByte2(resultSha1);
            //BASE64_encode转换
            String resultBase64Encode = new String(Base64.encodeBase64((header + stringToByte2STR).getBytes("ISO-8859-1")));
//            String resultBase64Encode = new String(Base64.encodeBase64((header + resultSha1).getBytes("ISO-8859-1")));
            //URL_encode转换
            String resultURLEncoder = java.net.URLEncoder.encode(resultBase64Encode, "ISO-8859-1");

            System.out.println("kk_token: " + resultURLEncoder);
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
