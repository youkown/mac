/*
 * Framework: net.lc4ever.framework.config.Constants.java create by q-wang on May 16, 2013 2:49:28 PM
 * VCS Tag: $Id$
 */
package net.lc4ever.framework.config;

import java.lang.reflect.Field;

/**
 * @author <a href="mailto:apeidou@gmail.com">Q-Wang</a>
 */
public class Constants {

	public static final String fileEncoding = System.getProperty("file.encoding");
	public static final String fileSeparator = System.getProperty("file.separator");
	public static final String javaClassPath = System.getProperty("java.class.path");
	public static final String javaClassVersion = System.getProperty("java.class.version");
	public static final String javaIoTmpdir = System.getProperty("java.io.tmpdir");
	public static final String javaRuntimeVersion = System.getProperty("java.runtime.version");
	public static final String javaSpecificationVersion = System.getProperty("java.specification.version");
	public static final String javaVersion = System.getProperty("java.version");
	public static final String javaVmSpecificationVersion = System.getProperty("java.vm.specification.version");
	public static final String javaVmVersion = System.getProperty("java.vm.version");
	public static final String lineSeparator = System.getProperty("line.separator");
	public static final String osArch = System.getProperty("os.arch");
	public static final String osName = System.getProperty("os.name");
	public static final String osVersion = System.getProperty("os.version");
	public static final String pathSeparator = System.getProperty("path.separator");

	public static final String sunArchDataModel = System.getProperty("sun.arch.data.model");
	public static final String sunCpuEndian = System.getProperty("sun.cpu.endian");

	public static final String userCountry = System.getProperty("user.country");
	public static final String userLanguage = System.getProperty("user.language");
	public static final String userName = System.getProperty("user.name");
	public static final String userHome = System.getProperty("user.home");
	public static final String userDir = System.getProperty("user.dir");

	public static final int availableProcessors = Runtime.getRuntime().availableProcessors();
	public static final long maxMemory = Runtime.getRuntime().maxMemory();

	public static void main(String[] args) throws Exception {
		Field[] fields = Constants.class.getDeclaredFields();
		for (Field field:fields) {
			System.out.println(field.getName()+"\t"+field.get(null));
		}

	}
}
