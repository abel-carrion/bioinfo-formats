package org.bioinfo.formats.core.variant.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bioinfo.commons.io.utils.FileUtils;
import org.bioinfo.commons.io.utils.IOUtils;
import org.bioinfo.commons.utils.StringUtils;
import org.bioinfo.formats.commons.AbstractFormatReader;
import org.bioinfo.formats.core.variant.Vcf4;
import org.bioinfo.formats.core.variant.vcf4.VcfFilter;
import org.bioinfo.formats.core.variant.vcf4.VcfFormat;
import org.bioinfo.formats.core.variant.vcf4.VcfInfo;
import org.bioinfo.formats.core.variant.vcf4.VcfRecord;
import org.bioinfo.formats.core.variant.vcf4.filter.VcfGenericFilter;
import org.bioinfo.formats.exception.FileFormatException;

public class Vcf4Reader extends AbstractFormatReader<VcfRecord> {

	private Vcf4 vcf4;
	private BufferedReader bufferedReader;

	private List<VcfGenericFilter> vcfFilters;
	
	private static final int DEFAULT_NUMBER_RECORDS = 40000;
	
	
	public Vcf4Reader(String filename) throws IOException, FileFormatException {
		this(new File(filename));
	}
	
	public Vcf4Reader(File file) throws IOException, FileFormatException {
		super(file);
		this.file = file;
	
		init();
//		metaInformation = new LinkedHashMap<String, String>();
		
//		vcfInfos = new ArrayList<VcfInfo>();
//		vcfFilters = new ArrayList<VcfGenericFilter>();
//		vcfFormats = new ArrayList<VcfFormat>();
		
//		bufferedReader = new BufferedReader(new FileReader(file));
//		processMetaInformation();
	}
	
	public void init() throws FileFormatException, IOException {
		vcf4 = new Vcf4();
		vcfFilters = new ArrayList<VcfGenericFilter>();
		
		FileUtils.checkFile(file);
		bufferedReader = new BufferedReader(new FileReader(file));
		
		// read meta data from VCF4 file
		processMetaInformation();
	}

	
	private void processMetaInformation() throws IOException, FileFormatException {
		VcfInfo vcfInfo;
		VcfFilter vcfFilter;
		VcfFormat vcfFormat;
		List<String> headerLine;
		String line = "";
		String[] fields;
		BufferedReader localBufferedReader = new BufferedReader(new FileReader(file));
		while((line = localBufferedReader.readLine()) != null && line.startsWith("#")) {
//			logger.debug("line: "+line);
			if(line.startsWith("##fileformat")) {
				if(line.split("=").length > 1) {
//					this.fileFormat = line.split("=")[1].trim();
					vcf4.setFileFormat(line.split("=")[1].trim());
				}else {
					throw new FileFormatException("");
				}
			}else {
				if(line.startsWith("##INFO")) {
//					System.out.println(line);
//					System.out.println(new VcfInfo(line).toString()+"\n");
					vcfInfo = new VcfInfo(line);
					vcf4.getInfo().put(vcfInfo.getId(), vcfInfo);
				}else {
					if(line.startsWith("##FILTER")) {
//						System.out.println(line);
//						System.out.println(new VcfGenericFilter(line).toString()+"\n");
						vcfFilter = new VcfFilter(line);
						vcf4.getFilter().put(vcfFilter.getId(), vcfFilter);
					}else {
						if(line.startsWith("##FORMAT")) {
//							System.out.println(line);
//							System.out.println(new VcfFormat(line).toString()+"\n");
							vcfFormat = new VcfFormat(line);
							vcf4.getFormat().put(vcfFormat.getId(), vcfFormat);
						}else {
							if(line.startsWith("#CHROM")) {
								headerLine = StringUtils.toList(line.replace("#", ""), "\t");
//								System.out.println(headerLine.toString());
								vcf4.setHeaderLine(headerLine);
							}else {
								fields = line.replace("#", "").split("=", 2);
								vcf4.getMetaInformation().put(fields[0], fields[1]);
//								System.out.println(metaInformation.toString());
//								logger.warn("Warning in 'processMetaInformation': Execution cannot reach this code, line: "+line);
							}
						}
					}
				}
			}
		}
		localBufferedReader.close();
	}
	
	public Vcf4 parse() throws FileFormatException, IOException {
//		init();
		vcf4.setRecords(readAll());
		close();
		return vcf4;
	}
	
	public void addFilter(VcfGenericFilter vcfFilter) {
		vcfFilters.add(vcfFilter);
	}
	
	@Override
	public VcfRecord read() throws FileFormatException {
		String line;
		try {
//			line = bufferedReader.readLine();
			while((line = bufferedReader.readLine()) != null && (line.trim().equals("") || line.startsWith("#"))) {
				;
			}
			if(line != null) {
//				logger.debug("line: "+line);
				String [] fields = line.split("\t");
				StringBuilder format = new StringBuilder();
				for(int i=8; i<fields.length; i++) {
					format.append(fields[i]).append("\t");
				}
				return new VcfRecord(fields[0], Integer.parseInt(fields[1]), fields[2], fields[3], fields[4], fields[5], fields[6], fields[7], format.toString().trim());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public VcfRecord read(String regexFilter) throws FileFormatException {
//		new VcfRecord(chromosome, position, id, reference, alternate, quality, filter, info, format, samples)
		return null;
	}

	@Override
	public List<VcfRecord> read(int size) throws FileFormatException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VcfRecord> readAll() throws FileFormatException, IOException {
		List<VcfRecord> records = new ArrayList<VcfRecord>(DEFAULT_NUMBER_RECORDS);
		String line;
		String[] fields;
		VcfRecord vcfRecord = null;
		boolean passFilter;
		bufferedReader = new BufferedReader(new FileReader(file));
		while((line = bufferedReader.readLine()) != null) {
			if(!line.startsWith("#")) {
				fields = line.split("\t");
				if(fields.length == 8) {
					vcfRecord = new VcfRecord(fields[0], Integer.parseInt(fields[1]), fields[2], fields[3], fields[4], fields[5], fields[6], fields[7]);
				}else {
					if(fields.length > 8) {
						vcfRecord = new VcfRecord(fields);
					}
				}
				if(vcfFilters != null && vcfFilters.size() > 0) {
					passFilter = false;
					for(int i=0; i<vcfFilters.size() && !passFilter; i++) {
						passFilter = vcfFilters.get(i).filter(vcfRecord);
					}
					if(passFilter) {
						records.add(vcfRecord);
					}	
				}else {
					records.add(vcfRecord);
				}
			}
		}
		bufferedReader.close();
		return records;
	}

	@Override
	public List<VcfRecord> readAll(String pattern) throws FileFormatException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() throws IOException, FileFormatException {
		int total = IOUtils.countLines(file);
		int comment = IOUtils.grep(file, "#·+").size();
		return total-comment;
	}
	
	@Override
	public void close() throws IOException {
		bufferedReader.close();
	}

	
	
	/**
	 * @return the vcfFilters
	 */
	public List<VcfGenericFilter> getVcfFilters() {
		return vcfFilters;
	}

	/**
	 * @param vcfFilters the vcfFilters to set
	 */
	public void setVcfGenericFilters(List<VcfGenericFilter> vcfFilters) {
		this.vcfFilters = vcfFilters;
	}

	
	
}
