/**
 * University of Freiburg.
 * This code has been provided within the scope of
 * the lecture Data Analysis and Query Languages
 * (Summer term 2017)
 */
package daql.ss2017.programmingtask1.data.modelling;


import daql.ss2017.programmingtask1.data.parser.ItemsTsvParser;
import daql.ss2017.programmingtask1.data.parser.UserItemsTsvParser;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The class builds an RDF model from the input files.
 */
public class DataModeler {
    /**
     * The data modeler uses internally an item parser for parsing the files
     * within ./data/items/.
     */
    private ItemsTsvParser itemsParser;

    /**
     * The data modeler uses internally a user-items parser parsing the files
     * within ./data/user_items/.
     */
    private UserItemsTsvParser userItemsParser;

    /**
     * This hash map is used to store all the items found in the dataset
     * (within ./data/items/).
     * KEY: is an item ID, e.g. "mo3676".
     * VALUE: the item URI and the item type.
     */
    private Map<String, ArrayList<String>> itemsMap = null;

    /**
     * The RDF model that stores the RDF triples.
     */
    private Model tripleStoreModel;

    /**
     * The constructor takes the RDF model as input in which the triples will
     * be added.
     */
    public DataModeler(Model tripleStoreModel) {
        this.tripleStoreModel = tripleStoreModel;
        this.itemsMap = new HashMap();
    }

    /**
     * This method processes the item files (within ./data/items/).
     * In each of these files the first column corresponds to an item ID,
     * e.g. "mo3676". This is used as the key to be stored in "itemsMap".
     *
     * @param itemFilename
     * @throws IOException
     */
    public void processItems(String itemFilename) throws IOException {
        this.itemsParser = new ItemsTsvParser(itemFilename);

        while (!this.itemsParser.hasReachedEndOfFile()) {
            this.itemsParser.readNextLine();
            String key = this.itemsParser.getCurrentItemId();
            ArrayList value = new ArrayList();
            String itemUri = this.itemsParser.getCurrentItemUri();
            String itemType = this.itemsParser.getCurrentItemType();
            value.add(itemUri);
            value.add(itemType);
            this.itemsMap.put(key, value);
        }
        System.out.println();
    }

    /**
     * This method processes the user preferences files
     * (within ./data/user_items/). New triples are created and added to the
     * RDF model.
     *
     * @param userItemsFilename
     * @param namespace
     * @throws IOException
     */
    public void processUserItems(String userItemsFilename, String namespace)
            throws IOException {

        this.userItemsParser = new UserItemsTsvParser(userItemsFilename);
        while (this.userItemsParser.hasReachedEndOfFile()) {
            this.userItemsParser.readNextLine();
//            String subject = this.itemsParser.getCurrentItemUri();
//            String predicate = "rdf:type";
//            String object = ;
//            Triple triple = new Triple();
        }
        //Add the triples as required
        //Complete the code here....

        //DO NOT REMOVE THIS CODE
        tripleStoreModel.setNsPrefix("daql", "http://daql.ss2017/");
        tripleStoreModel.setNsPrefix("foaf", "http://xmlns.com/foaf/0.1/");
        tripleStoreModel.setNsPrefix("rdf", "https://www.w3.org/1999/02/22-rdf-syntax-ns#");
    }

    /**
     * This method returns an RDF (ontology) resource for a given item type.
     * The items types that can be found are "book", "movie", "music_band"
     * and "music_artist".
     * For each of these types there is a corresponding RDF resource that is
     * returned.
     *
     * @param itemType
     * @return
     */
    private static Resource getItemTypeResource(String itemType) {
        Resource res = null;

        return res;
    }

    //GETTERS AND SETTERS
    public Model getModel() {
        return tripleStoreModel;
    }
}
