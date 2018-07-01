package com.ilmtest.lib.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IOUtils
{
	public static String readFileUtf8(File f) throws IOException {
		return readFile( f.getPath(), StandardCharsets.UTF_8 );
	}

	public static String readFile(String path, Charset encoding) throws IOException 
	{
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return encoding.decode(ByteBuffer.wrap(encoded)).toString();
	}
	
	public static File getFreshFile(String path)
	{
		File f = new File(path);

		if ( f.exists() ) {
			f.delete();
		}
		
		return f;
	}
	
	public static void writeFile(String path, String data)
	{
		BufferedWriter writer = null;
		try {
			File logFile = new File(path);
			writer = new BufferedWriter(new FileWriter(logFile));
			writer.write(data);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Close the writer regardless of what happens...
				writer.close();
			} catch (Exception e) {
			}
		}
	}
}