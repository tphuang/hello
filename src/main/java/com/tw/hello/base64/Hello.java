package com.tw.hello.base64;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.net.URLCodec;

//import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
public class Hello {
	/*
	 public static String KkTokenGen(String username,String secret,String charset){

		String LtpaToken="";
		//4位占位符
		String headerCode = String.valueOf(ascii2Char(0))
		+ String.valueOf(ascii2Char(1))
		+ String.valueOf(ascii2Char(2))
		+ String.valueOf(ascii2Char(3))	;
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
		//System.out.println("### header： "+header );
		//sha1加密
		sha1 sha1 = new SHA1();
		try {
		//String resultSha1 = sha1.Digest(header + new String(Base64.decodeBase64(secret),charset) );
		String resultSha1 = EncoderHandler.encode("SHA1",header + new String(Base64.decodeBase64(secret),charset));
		//ACSII转换
		String stringToByte2STR = stringToByte2(resultSha1);
		//BASE64_encode转换
		String resultBase64Encode = new String(Base64.encodeBase64((header + stringToByte2STR).getBytes(charset) ));
		//URL_encode转换
		String resultURLEncoder = java.net.URLEncoder.encode(resultBase64Encode,charset);
		return resultURLEncoder;
		} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
		}
		return LtpaToken;
		}

		public static String stringToByte2(String str){
		int len = str.length()/2;
		String[] arrStr = new String[len];
		String result = "";
		for (int i=0;i<len;i++)
		{
		arrStr[i] = str.substring(i*2,i*2 + 2);
		result += String.valueOf(ascii2Char(Integer.valueOf(Integer.parseInt(arrStr[i],16))));
		//System.out.println("arrStr[i] 十六进制 :"+"["+i+"]" + arrStr[i]);
		//System.out.println("arrStr[i] 十进制 :"+"["+i+"]" + Integer.valueOf(Integer.parseInt(arrStr[i],16)));
		//System.out.println("arrStr[i] ASCII:"+"["+i+"]" + String.valueOf(ascii2Char(Integer.valueOf(Integer.parseInt(arrStr[i],16)))));
		}
		return result;
		}

		static char ascii2Char(int ASCII) {
			return (char) ASCII;
		}
	 */

    /**
     * @param args
     */
    public static String buildIdentity(String identity) {
        try {
            return new String(new URLCodec().encode(toSHA1(identity.getBytes("utf-8"))), "iso-8859-1");
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
        // TODO Auto-generated method stub
        //System.out.println("Hello World!");
		/*
	 	将字符串转化为成字节
		static function stringToByte($str){
			//add by lmk
			$strByte = '';

			$arrStr = str_split($str, 2);
			foreach ($arrStr as $c){
				$strByte.=chr(hexdec($c));
			}
			return $strByte;
		}

		生成LTPATOKEN值
		static function encode_sso($username,$ctime,$etime,$secret){
			$headerCode = chr(0).chr(1).chr(2).chr(3);
			$header = strtoupper($headerCode.dechex($ctime).dechex($etime)).$username;
			return base64_encode($header.self::stringToByte(sha1($header.base64_decode($secret))));
		}
		*/
		/*
		wangxin
		1433420033
		1433420033 + 3600
		ypVsl3BuxmeUYZvHmmZjbpWZlDk=
		=f?
		AAECAzU1NzA0MDFBNTU3MDRFMkF3YW5neGlu8OHgywnnXvyU28Nd72jk0YMJ4Uk%3D
		*/
        String result = "Hello World 002";
        System.out.println(result);

        String username = "wangxin";

        //String ctime = "1433420033";
        //String etime = "1433423633";
        long ctime = 1433420033;
        long etime = 1433423633;

        String secret = "ypVsl3BuxmeUYZvHmmZjbpWZlDk=";

        String kk_token = "null";

        //String headerCode = String.valueOf((char)65)+String.valueOf((char)66)+String.valueOf((char)67)+String.valueOf((char)68);
        String headerCode = String.valueOf((char)0)+String.valueOf((char)1)+String.valueOf((char)2)+String.valueOf((char)3);
        System.out.println(headerCode);

        String header = (headerCode+Long.toHexString(ctime)+Long.toHexString(etime)).toUpperCase()+username;
        System.out.println(header);

        //base64_encode($header.self::stringToByte(sha1($header.base64_decode($secret))));
            String decodeString = Base64.decodeBase64(secret).toString();

//            kk_token = Base64.encodeBase64(header + buildIdentity(header + decodeString).getBytes("ISO-8859-1"));

        System.out.println(kk_token);
    }
}
