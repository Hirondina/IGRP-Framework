package nosi.core.webapp.helpers;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.servlet.http.Part;
import nosi.core.webapp.helpers.ImportExportApp.FileOrderCompile;

/**
 * @author: Emanuel Pereira
 * 31 Oct 2017
 */
public class ZipUnzipFile {

	//Extract files jar format
	public static List<FileOrderCompile> getZipFiles(Part file){
		List<FileOrderCompile> contents = null;
		try{
			contents = new ArrayList<>();
			CheckedInputStream cis = new CheckedInputStream(file.getInputStream(), new Adler32());
			ZipInputStream zis = new ZipInputStream(new BufferedInputStream(cis));
			ZipEntry entry = null;
			while((entry=zis.getNextEntry())!=null){	
				   String         ls = System.getProperty("line.separator");
				   String         line = null;
				   DataInputStream in = new DataInputStream(zis); 
				   StringBuilder content = new StringBuilder();  
				   BufferedReader d = new BufferedReader(new InputStreamReader(in));
				   while((line=d.readLine())!=null){
				   	content.append(line);
				   	content.append(ls);
				   } 
				   
				   int order = 3;

				   if(entry.getName().endsWith(".xml") || entry.getName().endsWith(".json") || entry.getName().endsWith(".xsl")){
					   order = 4;
				   }
				   if(entry.getName().startsWith("SQL/CONFIG") && entry.getName().endsWith("_ENV.xml")){
					   order = 1;
				   }
				   if(entry.getName().startsWith("SQL/CONFIG")  && entry.getName().endsWith("_ACTION.xml") ){
					   order = 2;
				   }
				   FileOrderCompile f = new ImportExportApp().new FileOrderCompile(entry.getName(), content.toString(), order);
				contents.add(f);
				zis.closeEntry();
			}
			zis.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		Collections.sort(contents);
		return contents;
	}
}
