package org.bioinfo.formats.parser.biopax;

import java.util.List;

import org.bioinfo.commons.utils.StringUtils;
import org.dom4j.Namespace;

public class BioPaxConstants {

	// OWL
	//
	//	public static final String OWL_IMPORTS_ELEMENT = "imports";
	//	public static final String OWL_ONTOLOGY_ELEMENT = "Ontology";

	public static final String OWL_NAMESPACE_URI = "http://www.w3.org/2002/07/owl";
	public static final String OWL_NAMESPACE_PREFIX = "owl";	

	public static final Namespace OWL_NAMESPACE = Namespace.get(BioPaxConstants.OWL_NAMESPACE_PREFIX, BioPaxConstants.OWL_NAMESPACE_URI);


	// RDF
	//
	public static final String RDF_ROOT_NAME = "RDF";

	public static final String RDF_ID_ATTRIBUTE = "id";
	public static final String RDF_ABOUT_ATTRIBUTE = "about";
	public static final String RDF_RESOURCE_ATTRIBUTE = "resource";

	public static final String RDF_NAMESPACE_URI = "http://www.w3.org/1999/02/22-rdf-syntax-ns";
	public static final String RDF_NAMESPACE_PREFIX = "rdf";	

	public static final Namespace RDF_NAMESPACE = Namespace.get(BioPaxConstants.RDF_NAMESPACE_PREFIX, BioPaxConstants.RDF_NAMESPACE_URI);


	// BIOPAX
	//
	public static final String BIOPAX_LEVEL_3_NAMESPACE_URI = "http://www.w3.org/1999/02/22-rdf-syntax-ns";
	public static final String BIOPAX_NAMESPACE_PREFIX = "bp";	

	public static final Namespace BIOPAX_LEVEL_3_NAMESPACE = Namespace.get(BioPaxConstants.BIOPAX_NAMESPACE_PREFIX, BioPaxConstants.BIOPAX_LEVEL_3_NAMESPACE_URI);

	public static final List<String> BIOPAX_GENE_LIST = StringUtils.toList("Gene");
	public static final List<String> BIOPAX_INTERACTION_LIST = StringUtils.toList("Interaction,Control,Catalysis,Modulation,TemplateReactionRegulation,Conversion,BiochemicalReaction,ComplexAssembly,Degradation,Transport,TransportWithBiochemicalreaction,GeneticInteraction,MolecularInteraction,TemplateReaction");
	public static final List<String> BIOPAX_PATHWAY_LIST = StringUtils.toList("Pathway");
	public static final List<String> BIOPAX_PHYSICAL_ENTITY_LIST = StringUtils.toList("PhysicalEntity,Complex,DNA,Protein,RNA,SmallMolecule");

	public static final List<String> BIOPAX_UTILITY_LIST = StringUtils.toList("UtilityClass,BioSource,ChemicalStructure,ControlledVocabulary,CellularLocationVocabulary,CellVocabulary,EntityReferenceGroupVocabulary,EvidenceCodeVocabulary,ExperimentalFormVocabulary,InteractionVocabulary,PhenotypeVocabulary,SequenceLocationVocabulary,SequenceModificationVocabulary,TissueVocabulary,DeltaGPrime0,EntityFeature,BindingFeature,ModificationFeature,EntityReference,DnaReference,ProteinReference,RnaReference,SmallMoleculeReference,Evidence,ExperimentalForm,KPrime,PathwayStep,Provenance,Score,SequenceLocation,SequenceInterval,SequenceSite,Stoichiometry,Xref,PublicationXref,RelationshipXref,UnificationXref");

	public static boolean isGene(String name) {
		return BIOPAX_GENE_LIST.contains(name);
	}

	public static boolean isInteraction(String name) {
		return BIOPAX_INTERACTION_LIST.contains(name);
	}

	public static boolean isPathway(String name) {
		return BIOPAX_PATHWAY_LIST.contains(name);
	}

	public static boolean isPhysicalEntity(String name) {
		return BIOPAX_PHYSICAL_ENTITY_LIST.contains(name);
	}

	public static boolean isUtility(String name) {
		return BIOPAX_UTILITY_LIST.contains(name);
	}

	public static String getEntityClass(String name) {
		if (isPhysicalEntity(name)) {
			return "PhysicalEntity";
		} else if (isPathway(name)) {
			return "Pathway";
		} else if (isInteraction(name)) {
			return "Interaction";
		} else if (isGene(name)) {
			return "Gene";
		} else if (isUtility(name)) {
			return "Utility";
		} 
		return null;
	}
}
