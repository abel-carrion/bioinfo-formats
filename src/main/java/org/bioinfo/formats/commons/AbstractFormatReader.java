package org.bioinfo.formats.commons;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bioinfo.commons.io.utils.FileUtils;
import org.bioinfo.formats.exception.FileFormatException;

public abstract class AbstractFormatReader<T> {

	protected File file;
	
	protected AbstractFormatReader(){
	}
	
	protected AbstractFormatReader(File f) throws IOException {
		FileUtils.checkFile(f);
		this.file = f;
	}

	public abstract int size() throws IOException, FileFormatException;
	
	public abstract T read() throws FileFormatException;
	
	public abstract T read(String regexFilter) throws FileFormatException;
	
	public abstract List<T> read(int size) throws FileFormatException;
	
	public abstract List<T> readAll() throws FileFormatException;
	
	public abstract List<T> readAll(String pattern) throws FileFormatException;
	
	public abstract void close() throws IOException;
	
}
