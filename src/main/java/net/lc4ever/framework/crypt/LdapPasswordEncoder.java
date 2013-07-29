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
 *
 *
 * @author Q-Wang
 */
public class LdapPasswordEncoder implements PasswordEncoder, InitializingBean {

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
	 */
	@Override
	public String encodePassword(final String rawPass, final Object salt) throws DataAccessException {
		return encoding.encodePassword(rawPass, salt);
	}

	/**
	 * @see org.springframework.security.providers.encoding.PasswordEncoder#isPasswordValid(java.lang.String, java.lang.String, java.lang.Object)
	 */
	@Override
	public boolean isPasswordValid(final String encPass, final String rawPass, final Object salt) throws DataAccessException {
		PasswordEncodingAlgorithm algorithm = PasswordEncodingAlgorithm.algorithmOf(encPass);
		return algorithm.isPasswordValid(encPass, rawPass, salt);
	}
}
