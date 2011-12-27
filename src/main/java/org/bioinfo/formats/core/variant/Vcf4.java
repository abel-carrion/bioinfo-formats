package org.bioinfo.formats.core.variant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.bioinfo.commons.utils.ListUtils;
import org.bioinfo.formats.core.variant.vcf4.VcfAlternate;
import org.bioinfo.formats.core.variant.vcf4.VcfFilter;
import org.bioinfo.formats.core.variant.vcf4.VcfFormat;
import org.bioinfo.formats.core.variant.vcf4.VcfInfo;
import org.bioinfo.formats.core.variant.vcf4.VcfRecord;

public class Vcf4 {

	private String fileFormat;
	private Map<String, String> metaInformation;
	
	private Map<String, VcfAlternate> alternate;
	private Map<String, VcfFilter> filter;
	private Map<String, VcfInfo> info;
	private Map<String, VcfFormat> format;
	
	private List<String> headerLine;
	private List<VcfRecord> records;
	
	public Vcf4() {
		this("VCFv4.0");
	}
	
	public Vcf4(String fileformat) {
		this.fileFormat = fileformat;
		metaInformation = new LinkedHashMap<String, String>();
		
		alternate = new LinkedHashMap<String, VcfAlternate>();
		filter = new LinkedHashMap<String, VcfFilter>();
		info = new LinkedHashMap<String, VcfInfo>();
		format = new LinkedHashMap<String, VcfFormat>();
		
		headerLine = new ArrayList<String>(1);
		records = new ArrayList<VcfRecord>();
	}
	
	public void addMetaInfo(String key, String value) {
		if(metaInformation == null) {
			metaInformation = new HashMap<String, String>();
		}
		metaInformation.put(key, value);
	}
	
	public void addAlternate(String id, String description) {
		if(alternate == null) {
			alternate = new LinkedHashMap<String, VcfAlternate>();
		}
		alternate.put(id, new VcfAlternate(id, description));
	}
	
	public void addFilter(String id, String description) {
		if(filter == null) {
			filter = new LinkedHashMap<String, VcfFilter>();
		}
		filter.put(id, new VcfFilter(id, description));
	}
	
	public void addInfo(String id, String number, String type, String description) {
		if(info == null) {
			info = new LinkedHashMap<String, VcfInfo>();
		}
		info.put(id, new VcfInfo(id, number, type, description));
	}
	
	public void addFormat(String id, String number, String type, String description) {
		if(format == null) {
			format = new LinkedHashMap<String, VcfFormat>();
		}
		format.put(id, new VcfFormat(id, number, type, description));
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("##fileformat=").append(fileFormat).append("\n");
		// print metaInformation
		Iterator<String> iter = metaInformation.keySet().iterator();
		String headerKey;
		while(iter.hasNext()) {
			headerKey = iter.next();
			stringBuilder.append("##").append(headerKey).append("=").append(metaInformation.get(headerKey)).append("\n");
		}
		
		for(VcfAlternate vcfAlternate: alternate.values()) {
			stringBuilder.append(vcfAlternate.toString()).append("\n");
		}
		
		for(VcfFilter vcfFilter: filter.values()) {
			stringBuilder.append(vcfFilter.toString()).append("\n");
		}
		
		for(VcfInfo vcfInfo: info.values()) {
			stringBuilder.append(vcfInfo.toString()).append("\n");
		}
		
		for(VcfFormat vcfFormat: format.values()) {
			stringBuilder.append(vcfFormat.toString()).append("\n");
		}
		
		// header and data lines
		stringBuilder.append("#").append(ListUtils.toString(headerLine, "\t")).append("\n");
		for(VcfRecord vcfRecord: records) {
			stringBuilder.append(vcfRecord.toString()).append("\n");
		}
		return stringBuilder.toString().trim();
	}

	
	/**
	 * @return the fileFormat
	 */
	public String getFileFormat() {
		return fileFormat;
	}

	/**
	 * @param fileFormat the fileFormat to set
	 */
	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}

	
	/**
	 * @return the metaInformation
	 */
	public Map<String, String> getMetaInformation() {
		return metaInformation;
	}

	/**
	 * @param metaInformation the metaInformation to set
	 */
	public void setMetaInformation(Map<String, String> metaInformation) {
		this.metaInformation = metaInformation;
	}

	
	/**
	 * @return the alternate
	 */
	public Map<String, VcfAlternate> getAlternate() {
		return alternate;
	}

	/**
	 * @param alternate the alternate to set
	 */
	public void setAlternate(Map<String, VcfAlternate> alternate) {
		this.alternate = alternate;
	}

	
	/**
	 * @return the filter
	 */
	public Map<String, VcfFilter> getFilter() {
		return filter;
	}

	/**
	 * @param filter the filter to set
	 */
	public void setFilter(Map<String, VcfFilter> filter) {
		this.filter = filter;
	}

	
	/**
	 * @return the info
	 */
	public Map<String, VcfInfo> getInfo() {
		return info;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(Map<String, VcfInfo> info) {
		this.info = info;
	}

	
	/**
	 * @return the format
	 */
	public Map<String, VcfFormat> getFormat() {
		return format;
	}

	/**
	 * @param format the format to set
	 */
	public void setFormat(Map<String, VcfFormat> format) {
		this.format = format;
	}

	
	/**
	 * @return the headerLine
	 */
	public List<String> getHeaderLine() {
		return headerLine;
	}

	/**
	 * @param headerLine the headerLine to set
	 */
	public void setHeaderLine(List<String> headerLine) {
		this.headerLine = headerLine;
	}

	
	/**
	 * @return the records
	 */
	public List<VcfRecord> getRecords() {
		return records;
	}

	/**
	 * @param records the records to set
	 */
	public void setRecords(List<VcfRecord> records) {
		this.records = records;
	}

}
