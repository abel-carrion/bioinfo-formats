package org.bioinfo.formats.parser.biopax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bioinfo.commons.utils.ListUtils;

public class BioPaxElement {
	
	private String Id;
	private String bioPaxClassName;
	private Map<String,List<String>> params = new HashMap<String,List<String>>();

	public BioPaxElement(String Id, String bioPaxClassName) {
		this.Id = Id;
		this.bioPaxClassName = bioPaxClassName;
	}

	public void put(String name, String value) {
		if (!params.containsKey(name)) {
			params.put(name, new ArrayList<String>());
		}
		params.get(name).add(value);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(bioPaxClassName).append(", id = ").append(Id).append("\n");
		for(String key: params.keySet()) {
			sb.append("\t").append(key).append("\t").append(ListUtils.toString(params.get(key), ",")).append("\n");
		}
		return sb.toString();
	}
	
	public void setBioPaxClassName(String bioPaxClassName) {
		this.bioPaxClassName = bioPaxClassName;
	}

	public String getBioPaxClassName() {
		return bioPaxClassName;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public Map<String, List<String>> getParams() {
		return params;
	}
}
