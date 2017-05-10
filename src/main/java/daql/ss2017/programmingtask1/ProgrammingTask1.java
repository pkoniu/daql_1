/**
 * University of Freiburg.
 * This code has been provided within the scope of
 * the lecture Data Analysis and Query Languages
 * (Summer term 2017)
 */
package daql.ss2017.programmingtask1;

import org.apache.jena.rdf.model.*;

import daql.ss2017.programmingtask1.config.Configuration;
import daql.ss2017.programmingtask1.data.modelling.DataModeler;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Each programming task contains a main method that is the one that has to be
 * invoked when the task is solved and the code is completed. 
 */
public class ProgrammingTask1 {
	/**
	 * Main method for Programming task 1.
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		//We first create the RDF model in which the triples will be added.
	    Model tripleStoreModel = ModelFactory.createDefaultModel();
		
		//The data modeler is used to parse and process the input files and to
		//add the triples to the RDF model.
		DataModeler dataModeler = new DataModeler(tripleStoreModel);
		
		//Here the files are processed
		dataModeler.processItems(Configuration.getBooks());		
		dataModeler.processItems(Configuration.getMovies());
		dataModeler.processItems(Configuration.getMusic());
		
		dataModeler.processUserItems(Configuration.getUserBooks(), 
				Configuration.getNamespace());
		dataModeler.processUserItems(Configuration.getUserMovies(), 
				Configuration.getNamespace());
		dataModeler.processUserItems(Configuration.getUserMusic(), 
				Configuration.getNamespace());
		
		//Finally the model is serialized as a .TTL file
		String serializedRdfModel = "./results/userLikes.ttl";
		FileWriter triplesOut = new FileWriter(serializedRdfModel);
		try {
			tripleStoreModel.write(triplesOut, "TTL");
			triplesOut.close();
		} 
		catch (IOException closeException) {
			closeException.printStackTrace();
		}
	}
}
