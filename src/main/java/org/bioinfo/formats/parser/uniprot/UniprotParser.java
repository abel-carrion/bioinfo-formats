package org.bioinfo.formats.parser.uniprot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class UniprotParser {

	public final static String UNIPROT_CONTEXT_v135 = "org.bioinfo.formats.parser.uniprot.v135jaxb";
	public final static String UNIPROT_CONTEXT_v140 = "org.bioinfo.formats.parser.uniprot.v140jaxb";

	public static void saveXMLInfo(Object obj, String filename) throws FileNotFoundException, JAXBException {
		JAXBContext jaxbContext;
		jaxbContext = JAXBContext.newInstance(UNIPROT_CONTEXT_v135);
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
		JAXBContext jaxbContext = JAXBContext.newInstance(UNIPROT_CONTEXT_v140);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		obj =  unmarshaller.unmarshal(new File(filename));
		return obj;
	}
	
	/**
	 * Checks if XML info file exists and loads it
	 * @throws JAXBException 
	 * @throws IOException
	 */
	public static Object loadXMLInfo(String filename, String uniprotVersion) throws JAXBException {
		Object obj = null;
		JAXBContext jaxbContext = JAXBContext.newInstance(uniprotVersion);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		obj =  unmarshaller.unmarshal(new File(filename));
		return obj;
	}
}
