/**
 * University of Freiburg.
 * This code has been provided within the scope of
 * the lecture Data Analysis and Query Languages
 * (Summer term 2017)
 */
package daql.ss2017.programmingtask1.config;

/**
 * The configuration class is aware of the paths of the input files and the 
 * namespace used to build the RDF statements.
 */
public class Configuration {
	//Path to user items (likes)
	private final static String USER_BOOKS = 
			"./data/user_items/users_books.tsv";
	private final static String USER_MOVIES = 
			"./data/user_items/users_movies.tsv";
	private final static String USER_MUSIC = 
			"./data/user_items/users_music.tsv";
	
	//Path to mapping files (from item ID to dbpedia URI)
	private final static String BOOKS =
			"./data/items/books.tsv";
	private final static String MOVIES =
			"./data/items/movies.tsv";
	private final static String MUSIC =
			"./data/items/music.tsv";
	
    private final static String NAMESPACE = "http://daql.ss2017/";       

    //Getters and Setters
    public static String getUserBooks() {
		return USER_BOOKS;
	}

	public static String getUserMovies() {
		return USER_MOVIES;
	}

	public static String getUserMusic() {
		return USER_MUSIC;
	}

	public static String getBooks() {
		return BOOKS;
	}

	public static String getMovies() {
		return MOVIES;
	}

	public static String getMusic() {
		return MUSIC;
	}

	public static String getNamespace() {
		return NAMESPACE;
	}
}
