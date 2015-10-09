package org.corpus_tools.salt.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;

import org.corpus_tools.salt.exceptions.SaltResourceException;

/**
 * This class provides some helpers for testing Salt.
 * 
 * @author florian
 *
 */
public class SaltTestsUtil {
	public static final String FILE_RESOURCE_DIR = "./src/test/resources/";

	/**
	 * Returns a temporary folder, where Salt can store temp files. The returned
	 * temporary folder is a combination of the systems standard temp folder,
	 * the prefix 'salt-test', and the users name or a randomized unique
	 * sequence of characters, if the user name is not available and suffixed by
	 * the passed segments.
	 * 
	 * @return path, where to store temporary files
	 * @param segments
	 *            segments or subfolders to be attached to the created temp
	 *            folder, subfolders are separated by '/'
	 * @param prefix
	 *            the prefix to be used like 'salt' or salt-test etc.
	 * @return
	 */
	public static synchronized File getTempTestFolder(String segments) {
		File file = null;
		if (segments == null) {
			file = getTempTestFolder();
		} else {
			file = new File(getTempTestFolder().getAbsolutePath() + (segments.startsWith("/") ? segments : "/" + segments));
		}
		if (!file.exists()) {
			file.mkdirs();
		}
		return (file);
	}

	/**
	 * Returns a temporary folder, where Salt can store temp files. The returned
	 * temporary folder is a combination of the systems standard temp folder,
	 * the prefix 'salt-test', and the users name or a randomized unique
	 * sequence of characters.
	 * 
	 * @return path, where to store temporary files
	 * @param prefix
	 *            the prefix to be used like 'salt' or salt-test etc.
	 * @return
	 */
	public static synchronized File getTempTestFolder() {
		String usr = System.getProperty("user.name");
		String path = null;
		if ((usr != null) && (!usr.isEmpty())) {
			path = System.getProperty("java.io.tmpdir");
			if (!path.endsWith("/")) {
				path = path + "/";
			}
			path = path + "salt-test" + "_" + usr + "/";
		} else {
			try {
				path = Files.createTempDirectory("salt-test" + "_", new FileAttribute<?>[0]).toFile().getAbsolutePath();
				if (!path.endsWith("/")) {
					path = path + "/";
				}
			} catch (IOException e) {
				throw new SaltResourceException("Cannot create temporary folder at " + System.getProperty("java.io.tmpdir") + ". ");
			}
		}

		File file = null;
		file = new File(path);
		return (file);
	}
}
