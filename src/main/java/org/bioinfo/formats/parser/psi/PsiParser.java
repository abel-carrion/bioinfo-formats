package org.bioinfo.formats.parser.psi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class PsiParser {

	public final static String PSI253_CONTEXT = "org.bioinfo.formats.parser.psi.v253jaxb";
	public final static String PSI254_CONTEXT = "org.bioinfo.formats.parser.psi.v254jaxb";
	
	public static void saveXMLInfo(Object obj, String filename) throws FileNotFoundException, JAXBException {
		JAXBContext jaxbContext;
		jaxbContext = JAXBContext.newInstance(PSI254_CONTEXT);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.marshal(obj, new FileOutputStream(filename));	
	}

	/**
	 * Checks if XML info file exists and loads it
	 * @throws JAXBException 
	 * @throws IOException
	 */
	public static Object loadXMLInfo(String filename) throws JAXBException {
		Object obj = null;
		JAXBContext jaxbContext = JAXBContext.newInstance(PSI254_CONTEXT);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		obj =  unmarshaller.unmarshal(new File(filename));
		return obj;
	}
	
	/**
	 * 
	 * @param filename
	 * @param psiVersion
	 * @return
	 * @throws JAXBException
	 */
	public static Object loadXMLInfo(String filename, String psiVersion) throws JAXBException {
		Object obj = null;
		JAXBContext jaxbContext = JAXBContext.newInstance(psiVersion);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		obj =  unmarshaller.unmarshal(new File(filename));
		return obj;
	}
}
