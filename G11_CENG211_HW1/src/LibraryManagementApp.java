
/** This class has the main method of the Library Management Application.
 * It calls LibraryQuery class to start the app.
 *
 * @author Merve Malak     260201043
 * @author Berfin Yucak    280201096
 */



public class LibraryManagementApp {


	public static void main(String[] args) {
		
		LibraryQuery libraryQuery = new LibraryQuery();
		libraryQuery.startApp();
		
	}
}
