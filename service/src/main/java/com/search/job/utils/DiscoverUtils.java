package com.search.job.utils;

import java.util.Hashtable;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

public abstract class DiscoverUtils {
	
	public static String discoverClass(String unqualifiedName, String startFrom) {
		return discoverResource(unqualifiedName, startFrom, "class");
	}

	public static String discoverResource(String unqualifiedName, String startFrom) {
		return discoverResource(unqualifiedName, startFrom, "");
	}

	/**
	 * 
	 * @param unqualifiedName -
	 *            unqualified name of the class.
	 * @param startFrom
	 *            the package under which this class resides.
	 * @return fully qualified name of the class.
	 */
	public static String discoverResource(String unqualifiedName, String startFrom, String extension) {
		try {
			extension = (extension == null) ? "" : "." + extension;
			startFrom = startFrom.replaceAll("\\.", "/");
			PathMatchingResourcePatternResolver x = new PathMatchingResourcePatternResolver();
			Resource[] r = x.getResources("classpath*:" + startFrom + "/**/"
					+ unqualifiedName + extension);
			
				String y = r[0].getURL().getFile();
				y = y.substring(y.lastIndexOf(startFrom), y.length()
						- extension.length());
				return y.replaceAll("/", ".");
			

		} catch (Exception e) {
		}
		return null;
	}

	public static String[] discoverResource(String wildcard) throws Exception {
		Resource[] r = resolveResource(wildcard);
		String[] s = new String[r.length];
		int i = 0;
		String prefix = wildcard.substring(0, wildcard.indexOf("*"));
		for (Resource a : r) {
			String y = a.getURL().getFile();
			s[i++] = y.substring(y.lastIndexOf(prefix), y.length());
		}
		return s;
	}

	public static Resource[] resolveResource(String wildcard) throws Exception {
		PathMatchingResourcePatternResolver x = new PathMatchingResourcePatternResolver();
		return x.getResources("classpath*:" + wildcard);
	}

	protected static Map<String, Class> discoveredClasses = new Hashtable<String, Class>();

	public static Class obtainFullyQualifiedClass(String classShortName, String basePackage) {
		String actualClassName = classShortName.substring(0, 1).toUpperCase()
				+ classShortName.substring(1);
		if (!discoveredClasses.containsKey(actualClassName)) {
			String fullyQualifiedClassName = discoverClass(actualClassName,
					basePackage);
			if (fullyQualifiedClassName == null)
				throw new RuntimeException("Cannot discover class "
						+ classShortName + " in package " + basePackage);
			try {
				discoveredClasses.put(actualClassName, Class
						.forName(fullyQualifiedClassName));
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Class " + fullyQualifiedClassName
						+ "not found.");
			}
		}
		return discoveredClasses.get(actualClassName);
	}

}
