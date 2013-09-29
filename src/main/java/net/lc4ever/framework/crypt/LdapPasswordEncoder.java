/*
 * btvpms: com.dota.framework.security.LdapPasswordEncoder.java Create On 2010-3-4 上午09:45:47 By Q-Wang
 * $Revision: 1.1 $
 */
package net.lc4ever.framework.crypt;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.util.Assert;

/**
 * @author Q-Wang
 */
@SuppressWarnings("deprecation")
public class LdapPasswordEncoder implements PasswordEncoder,org.springframework.security.crypto.password.PasswordEncoder, InitializingBean {

	private PasswordEncodingAlgorithm encoding = PasswordEncodingAlgorithm.PLANTEXT;

	/**
	 * @param encoding
	 *            the encoding to set
	 */
	public void setEncoding(final PasswordEncodingAlgorithm encoding) {
		this.encoding = encoding;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(encoding);
	}

	/**
	 * @see org.springframework.security.providers.encoding.PasswordEncoder#encodePassword(java.lang.String, java.lang.Object)
	 * @deprecated use {@link #encode(CharSequence)} instead
	 */
	@Override
	@Deprecated
	public String encodePassword(final String rawPass, final Object salt) throws DataAccessException {
		return encoding.encodePassword(rawPass, salt);
	}

	/**
	 * @see org.springframework.security.providers.encoding.PasswordEncoder#isPasswordValid(java.lang.String, java.lang.String, java.lang.Object)
	 * @deprecated use {@link #matches(CharSequence, String)} instead
	 */
	@Deprecated
	@Override
	public boolean isPasswordValid(final String encPass, final String rawPass, final Object salt) throws DataAccessException {
		PasswordEncodingAlgorithm algorithm = PasswordEncodingAlgorithm.algorithmOf(encPass);
		return algorithm.isPasswordValid(encPass, rawPass, salt);
	}

	/**
	 * @see org.springframework.security.crypto.password.PasswordEncoder#encode(java.lang.CharSequence)
	 */
	@Override
	public String encode(CharSequence rawPassword) {
		return encoding.encode(rawPassword);
	}

	/**
	 * @see org.springframework.security.crypto.password.PasswordEncoder#matches(java.lang.CharSequence, java.lang.String)
	 */
	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		PasswordEncodingAlgorithm algorithm = PasswordEncodingAlgorithm.algorithmOf(encodedPassword);
		return algorithm.matches(rawPassword, encodedPassword);
	}
}
