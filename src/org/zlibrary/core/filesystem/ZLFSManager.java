package org.zlibrary.core.filesystem;

import java.util.Collections;
import java.util.Map;

public abstract class ZLFSManager {
	private Map<String,Integer> myForcedFiles;
	protected static ZLFSManager ourInstance;
	
	public static void deleteInstance() {
		if (ourInstance != null) {
			ourInstance = null;
		}
	}
	
	public Map<String,Integer> getForcedFiles() {
		return Collections.unmodifiableMap(myForcedFiles);
	}
	
	public void putForcedFiles(String key, Integer value) {
		myForcedFiles.put(key, value);
	}
	
	public static ZLFSManager instance() {
		return ourInstance;
	}

		
	//protected ZLFSManager();
		
	public void normalize(String path) {}

	abstract protected ZLInputStream createPlainInputStream(String path);
	abstract protected ZLOutputStream createOutputStream(String path);
	//abstract protected ZLFSDir createPlainDirectory(String path);
	//abstract protected ZLFSDir createNewDirectory(String path);
	abstract protected ZLFileInfo fileInfo(String path);
	abstract protected boolean removeFile(String path);
	abstract protected String convertFilenameToUtf8(String name);

	abstract protected int findArchiveFileNameDelimiter(String path);
	abstract protected int findLastFileNameDelimiter(String path);
	abstract protected ZLDir rootDirectory();
	abstract protected String rootDirectoryPath();
	abstract protected String parentPath(String path);

}