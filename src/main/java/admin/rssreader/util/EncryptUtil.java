package admin.rssreader.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

public class EncryptUtil {
	private static MessageDigest md;
	
	static {
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	public static String md5(String username, String password) {
		password += username + "8877";
		
		return Hex.encodeHexString(md.digest(password.getBytes()));
	}
}
