/*
 * btvpms: com.dota.framework.security.PasswordEncodingAlgorithm.java Create On 2010-3-4 上午10:03:45 By Q-Wang
 * $Revision: 1.1 $
 */
package net.lc4ever.framework.crypt;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.util.Assert;

/**
 *
 *
 * @author Q-Wang
 */
public enum PasswordEncodingAlgorithm implements PasswordEncoder {
	PLANTEXT(null,false,null),
	SSHA("SHA",true,"{SSHA}"),
	SHA("SHA",false,"{SHA}"),
	MD5("MD5",false,"{MD5}"),
	SMD5("MD5",true,"{SMD5}");

	private String algorithm;

	private boolean needSalt;

	private String prefix;

	private int size;

	private PasswordEncodingAlgorithm(final String algorithm,final boolean needSalt,final String prefix) {
		this.algorithm = algorithm;
		this.needSalt = needSalt;
		this.prefix = prefix;
		if (algorithm!=null) {
			try {
				this.size = MessageDigest.getInstance(algorithm).getDigestLength();
			} catch (NoSuchAlgorithmException e) {
				throw new IllegalArgumentException("Algorithm:" + algorithm + " not supported.");
			}
		}
	}

	/**
	 * @return the algorithm
	 */
	public String getAlgorithm() {
		return algorithm;
	}

	/**
	 * @return the needSalt
	 */
	public boolean isNeedSalt() {
		return needSalt;
	}

	/**
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}

	private byte[] combineHashAndSalt(final byte[] hash, final byte[] salt) {
		if (salt == null) {
			return hash;
		}
		byte[] hashAndSalt = new byte[hash.length + salt.length];
		System.arraycopy(hash, 0, hashAndSalt, 0, hash.length);
		System.arraycopy(salt, 0, hashAndSalt, hash.length, salt.length);
		return hashAndSalt;
	}

	public static PasswordEncodingAlgorithm algorithmOf(final String encPass) {
		String prefix = extractPrefix(encPass);
		if (prefix==null) {
			return PLANTEXT;
		}
		for (PasswordEncodingAlgorithm algorithm:PasswordEncodingAlgorithm.values()) {
			if (prefix.equalsIgnoreCase(algorithm.getPrefix())) {
				return algorithm;
			}
		}
		return null;
	}

	@Override
	public String encodePassword(final String rawPass, final Object salt) throws DataAccessException {
		if (algorithm==null) {
			return rawPass;
		}
		try {
			MessageDigest digester = MessageDigest.getInstance(algorithm);
			digester.update(rawPass.getBytes("UTF-8"));
			if (needSalt) {
				Assert.notNull(salt);
				Assert.isInstanceOf(byte[].class, salt);
				digester.update((byte[])salt);
			}
			byte[] hash = combineHashAndSalt(digester.digest(),(byte[])salt);
			return prefix+new String(Base64.encodeBase64(hash));
		} catch (NoSuchAlgorithmException algorithmException) {
			throw new IllegalStateException();
		} catch (UnsupportedEncodingException encodingException) {
			throw new IllegalStateException();
		}
	}

	@Override
	public boolean isPasswordValid(final String encPass, final String rawPass, Object salt) throws DataAccessException {
		if (needSalt) {
			salt = extractSalt(encPass);
			return encPass.equals(encodePassword(rawPass, salt));
		} else {
			return encPass.equals(encodePassword(rawPass, salt));
		}
	}

	private byte[] extractSalt(final String encPass) {
		String encPassNoLabel = encPass.substring(prefix.length());
		byte[] hash = Base64.decodeBase64(encPassNoLabel.getBytes());
		byte[] salt = new byte[hash.length-size];
		System.arraycopy(hash, size, salt, 0, salt.length);
		return salt;
	}

	private static String extractPrefix(final String encPass) {
		if (encPass.charAt(0)!='{') {
			return null;
		}
		int secondBrace = encPass.lastIndexOf('}');
		if (secondBrace < 0) {
			throw new IllegalArgumentException("Couldn't find closing brace for SHA prefix");
		}
		return encPass.substring(0, secondBrace + 1);
	}
}
