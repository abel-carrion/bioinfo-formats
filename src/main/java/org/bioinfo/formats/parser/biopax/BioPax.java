package org.bioinfo.formats.parser.biopax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BioPax {
	
	private Map<String,BioPaxElement> elementMap = new HashMap<String,BioPaxElement>();
	
	private List<String> geneList = new ArrayList<String>();
	private List<String> interactionList = new ArrayList<String>();
	private List<String> pathwayList = new ArrayList<String>();
	private List<String> physicalEntityList = new ArrayList<String>();

	public void addEntity(String id, String entityClass, BioPaxElement bioPaxElement) {
		elementMap.put(id, bioPaxElement);
		if ("gene".equalsIgnoreCase(entityClass)) {
			geneList.add(id);
		} else if ("interaction".equalsIgnoreCase(entityClass)) {
			interactionList.add(id);
		} else if ("pathway".equalsIgnoreCase(entityClass)) {
			pathwayList.add(id);
		} else if ("physicalEntity".equalsIgnoreCase(entityClass)) {
			physicalEntityList.add(id);
		}
	}
	
	public String toString() {
		BioPaxElement element = null;
		StringBuilder sb = new StringBuilder();
		
		//sb.append("---------> GENES\n");
		System.out.println("---------> GENES\n");
		for(String str: geneList) {
			element = elementMap.get(str);
			//sb.append(element.toString());
			System.out.println(element.toString());
		}
		//sb.append("---------> INTERACTION\n");
		System.out.println("---------> INTERACTION\n");
		for(String str: interactionList) {
			element = elementMap.get(str);
			//sb.append(element.toString());
			System.out.println(element.toString());
		}
		//sb.append("---------> PATHWAY\n");
		System.out.println("---------> PATHWAY\n");
		for(String str: pathwayList) {
			element = elementMap.get(str);
			//sb.append(element.toString());
			System.out.println(element.toString());
		}
		//sb.append("---------> PHYSICAL ENTITY\n");
		System.out.println("---------> PHYSICAL ENTITY\n");
		for(String str: physicalEntityList) {
			element = elementMap.get(str);
			//sb.append(element.toString());
			System.out.println(element.toString());
		}
		
		return sb.toString();
	}
	
	public Map<String,BioPaxElement> getElementMap() {
		return elementMap;
	}

	public List<String> getGeneList() {
		return geneList;
	}

	public void setGeneList(List<String> geneList) {
		this.geneList = geneList;
	}

	public List<String> getInteractionList() {
		return interactionList;
	}

	public void setInteractionList(List<String> interactionList) {
		this.interactionList = interactionList;
	}

	public List<String> getPathwayList() {
		return pathwayList;
	}

	public void setPathwayList(List<String> pathwayList) {
		this.pathwayList = pathwayList;
	}

	public List<String> getPhysicalEntityList() {
		return physicalEntityList;
	}

	public void setPhysicalEntityList(List<String> physicalEntityList) {
		this.physicalEntityList = physicalEntityList;
	}	
}
