
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class LibraryQuery {
	
	//default constructor
	public LibraryQuery() {}
	
	//Creates objects belonging to other classes in order to use in the methods below
	Library library1 = new Library(1);
	Library library2 = new Library(2);
	Library library3 = new Library(3);
	
	LibraryManagement libraryManagement = new LibraryManagement();

	//Finds the index of a book object in a library
	private int indexOf(Book book, Library library) {
		int index = 0;
		for (int i = 0; i<library.getBookList().length;i++) {
			if (book.getId().equals(library.getBookList()[i].getId())) {
				index = i;
			}
		}		
		return index;
	}
	
	//Finds the index of an integer in an array
	private int indexOf(int element, int[] numberOfIssues) {
		int index = 0;
		for (int i = 0; i<numberOfIssues.length;i++) {
			if ( numberOfIssues[i] == element) {
				index = i;
			}
		}		
		return index;
	}

	//Finds the most issued book among all libraries
	private void mostIssuedBook() {
		
		Book mostIssuedBook = new Book();
		
		//Creates arrays containing the issue numbers of corresponding books
		int[] library1_numberOfIssues = new int[library1.getBookList().length];
		int[] library2_numberOfIssues = new int[library2.getBookList().length];
		int[] library3_numberOfIssues = new int[library3.getBookList().length];
		
		for (Issue issue : libraryManagement.getIssueList()[0]) {
			int index = indexOf(issue.getBook(),library1);
			library1_numberOfIssues[index]++;
		}
				
		for (Issue issue : libraryManagement.getIssueList()[1]) {
			int index = indexOf(issue.getBook(),library2);
			library2_numberOfIssues[index]++;
		}
		
		for (Issue issue : libraryManagement.getIssueList()[2]) {
			int index = indexOf(issue.getBook(),library3);
			library3_numberOfIssues[index]++;
		}
		
		//Finds the maximum number of issues and the corresponding book which is issued the most as a result
		int maxNumberOfIssues = 0;
		
		for (int element : library1_numberOfIssues) {
			if (element>maxNumberOfIssues) {
				maxNumberOfIssues = element;
				mostIssuedBook = library1.getBookList()[indexOf(element,library1_numberOfIssues)];
			}
		}
				
		for (int element : library2_numberOfIssues) {
			if (element>maxNumberOfIssues) {
				maxNumberOfIssues = element;
				mostIssuedBook = library2.getBookList()[indexOf(element,library2_numberOfIssues)];
			}
		}
				
		for (int element : library3_numberOfIssues) {
			if (element>maxNumberOfIssues) {
				maxNumberOfIssues = element;
				mostIssuedBook = library3.getBookList()[indexOf(element,library3_numberOfIssues)];
			}
		}
				
		System.out.println("1) " + mostIssuedBook.getTitle());
	}

	//Finds the member who issued the most books
	public void memberIssuedMostBooks() {
				
		Member memberIssuedMostBooks = new Member();
		
		Member[] members = memberIssuedMostBooks.readMemberFile();
		int[] issueNumbersOfMembers = new int[members.length];
		
		//Covers all issues and counts which member issued how many books
		for (int i = 0; i<3; i++){
			for (Issue issue : libraryManagement.getIssueList()[i]) {
				int id = issue.getMember().getId();
				switch (id) {
					case 2801:
						issueNumbersOfMembers[0]++;
						break;
					case 2802:
						issueNumbersOfMembers[1]++;
						break;
					case 2803:
						issueNumbersOfMembers[2]++;
						break;
					default:
						issueNumbersOfMembers[3]++;
						break;
				}
			}
		}
		
		//Decides which member issued most books by comparing the number of issues
		int mostIssues = issueNumbersOfMembers[0];
		
		for (int x : issueNumbersOfMembers) {
			if (x>mostIssues) {
				mostIssues = x;
			}
		}
		
		int indexOfMember = 0;
		
		for (int y = 0; y<issueNumbersOfMembers.length; y++) {
			if (issueNumbersOfMembers[y] == mostIssues) {
				indexOfMember = y;
			}
		}
		
		memberIssuedMostBooks = members[indexOfMember];
		
		System.out.println("2) " + memberIssuedMostBooks.getName());
	}

	//Calculates highest penalty for late returning
	public void highestPenalty() {		
		
		long highestPenalty = 0;
		int definedDays = 14;
		long latestReturn = 0;
		double penaltyCoefficient = 0.5;
		
		//Finds the maximum number of days concerning "late returning" among all issues
		for (int i = 0; i<3; i++) {
			
			for (Issue issue : libraryManagement.getIssueList()[i]) {
				
				Date issueDate = issue.getIssueDate();
				LocalDate issueDate_temporal = issueDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				Date returningDate = issue.getReturningDate();
				LocalDate returningDate_temporal = returningDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				
				long numberOfDays = ChronoUnit.DAYS.between(issueDate_temporal,returningDate_temporal);
				if (numberOfDays>latestReturn) {
					
					latestReturn = numberOfDays;
				}
				
			}
		}
		
		highestPenalty = (long) ((latestReturn-definedDays)*penaltyCoefficient);
		
		System.out.println("3) " + highestPenalty + " TL");
	}
	
	//Finds the book with most copies among three libraries
	public void bookWithMostCopies() {
				
		Book bookWithMostCopies = new Book();
		
		int numOfCopies = 0;
		
		//Checks the quantities of all books in all libraries one by one
		//Decides the highest quantity
		for(Book book : library1.getBookList()) {
			
			if (book.getQuantity()>numOfCopies) {
				numOfCopies = book.getQuantity();
				bookWithMostCopies = book;
			}
		}
		
		for(Book book : library2.getBookList()) {
			
			if (book.getQuantity()>numOfCopies) {
				numOfCopies = book.getQuantity();
				bookWithMostCopies = book;
			}
		}
		
		for(Book book : library3.getBookList()) {
			
			if (book.getQuantity()>numOfCopies) {
				numOfCopies = book.getQuantity();
				bookWithMostCopies = book;
			}
		}
		
		System.out.println("4) " + bookWithMostCopies.getTitle());
	}

	//Finds the book with fewest copies among all previously issued books
	public void bookWithFewestCopies_Issued() {
		
		
		Book bookWithFewestCopies_Issued = new Book();
		
		int initialCount = libraryManagement.getIssueList()[0][0].getBook().getQuantity();
		
		//Checks the issues of all libraries
		for (int i = 0; i<3;i++) {
			
			//Checks the quantity of books related to the issue
			//compares it to before, decides the fewest
			for (Issue issue : libraryManagement.getIssueList()[i]) {
				if (issue.getBook().getQuantity()<initialCount) {
					initialCount = issue.getBook().getQuantity();
					bookWithFewestCopies_Issued = issue.getBook();
				}
			}
		}
		
		System.out.println("5) " + bookWithFewestCopies_Issued.getTitle());
	}

	//Finds the member who issued least books from CS library
	public void memberIssuedLeast_CS() {
		
		Issue[] library3_issues = libraryManagement.getIssueList()[2];
		
		Member memberIssuedLeast_CS = new Member();
		
		Member[] members = memberIssuedLeast_CS.readMemberFile();
		int[] issueNumbersOfMembers = new int[members.length];
		
		//Calculates the number of issues for each member
		for (Issue issue : library3_issues) {
			
			int id = issue.getMember().getId();
			switch (id) {
				case 2801:
					issueNumbersOfMembers[0]++;
					break;
				case 2802:
					issueNumbersOfMembers[1]++;
					break;
				case 2803:
					issueNumbersOfMembers[2]++;
					break;
				default:
					issueNumbersOfMembers[3]++;
					break;
			}			
		}
		
		//Finds the smallest number of issues
		int leastIssues = issueNumbersOfMembers[0];
		
		for (int i : issueNumbersOfMembers) {
			if (i<leastIssues) {
				leastIssues = i;
			}
		}
		
		int indexOfMember = 0;
		
		//Finds to whom that smaller number is belong to
		for (int i = 0; i<issueNumbersOfMembers.length; i++) {
			if (issueNumbersOfMembers[i] == leastIssues) {
				indexOfMember = i;
			}
		}
		
		memberIssuedLeast_CS = members[indexOfMember];
		
		System.out.println("6) " + memberIssuedLeast_CS.getName());
	}

	//Gather all required methods in the LibraryQuery together
	public void startApp(){
		mostIssuedBook();
		memberIssuedMostBooks();
		highestPenalty();
		bookWithMostCopies();
		bookWithFewestCopies_Issued();
		memberIssuedLeast_CS();
	}
}

