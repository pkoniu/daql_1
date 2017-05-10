/**
 * University of Freiburg.
 * This code has been provided within the scope of
 * the lecture Data Analysis and Query Languages
 * (Summer term 2017)
 */
package daql.ss2017.programmingtask1.data.parser;

import java.io.*;

/**
 * The following class parses a TSV file and can return for each line
 * the single tokens. These are obtained when splitting the line
 * using TAB as separator.
 */
public class UserItemsTsvParser {

    private String currentLine = "";

    /**
     * This is the array that contains the tokens of the current read line.
     */
    private String[] currentLineTokens = null;

    /**
     * A BufferedReader that doesn't require to load the file completely in
     * memory.
     */
    private BufferedReader fileReader = null;

    //These are the three columns that are read in each line.
    private String currentUserId = "";
    private String currentItemId = "";

    /**
     * Constructor of the TSV parser.
     *
     * @param relativeFilePath A relative path. Ex. "./data/blabla.txt".
     * @throws IOException
     */
    public UserItemsTsvParser(String relativeFilePath) throws IOException {
        File file = new File(relativeFilePath);
        this.fileReader = new BufferedReader(new FileReader(file));
    }

    /**
     * It reads the next line of the file.
     *
     * @return
     * @throws IOException
     */
    public void readNextLine() throws IOException {
        this.currentLine = this.fileReader.readLine();

        if (this.currentLine == null) return;

        this.currentLineTokens = this.currentLine.split("\t");

        this.currentUserId = this.currentLineTokens[0];
        this.currentItemId = this.currentLineTokens[1];
    }

    /**
     * Returns TRUE if EOF has been reached by the reader.
     *
     * @return
     * @throws IOException
     */
    public boolean hasReachedEndOfFile() throws IOException {
        return this.currentLine == null;
    }

    //GETTERS AND SETTERS
    public String getCurrentUserId() {
        return currentUserId;
    }

    public String getCurrentItemId() {
        return currentItemId;
    }
}
