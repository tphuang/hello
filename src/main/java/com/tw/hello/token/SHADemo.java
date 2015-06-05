package com.tw.hello.token;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.net.URLCodec;

/**
 * Created by tphuang on 6/4/15.
 */
public class SHADemo {
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

    public static void main(String[] args) {
        //asfasfasdf: %bep%c3%9cc%dc%e4%89%f6n%0cw%fb%a3%95%ba%d8%c9r%82
        //Hello:f7ff9e8b7bb2e09b70935a5d785e0cc5d9d0abf0
        String str = "Hello";
        String result = buildIdentity(str);
        System.out.println("The result is: " + result.replace("%", ""));
    }
}
