/**
 * University of Freiburg.
 * This code has been provided within the scope of
 * the lecture Data Analysis and Query Languages
 * (Summer term 2017)
 */
package daql.ss2017;

import static org.junit.Assert.assertEquals;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.junit.Test;

import daql.ss2017.programmingtask1.config.Configuration;
import daql.ss2017.programmingtask1.data.modelling.DataModeler;

/**
 * The following class tests whether the RDF model built is correct.
 *
 */
public class ModelTest {

	@Test
	public void rdfModelTest() throws Exception {
		
	    Model tripleStoreModel = ModelFactory.createDefaultModel();
		
		DataModeler dataModeler = new DataModeler(tripleStoreModel);
		//Here the files are processed
		dataModeler.processItems("./data/testcases/books_test.tsv");		
		dataModeler.processUserItems("./data/testcases/users_books_test.tsv", 
				Configuration.getNamespace());
		
		Long expectedNumOfTriples = 5L;
		
		assertEquals(expectedNumOfTriples, new Long(tripleStoreModel.size()));
		
		//Add the required JUnit tests here....
		//Complete the code here....
	}	
}
