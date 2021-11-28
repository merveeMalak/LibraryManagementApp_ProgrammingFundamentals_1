import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Issue {
	
	private int id;
	private Member member; //holds member object
	private Book book; //holds book object
	private Date issueDate; //holds issue date as a date object
	private Date returningDate; //holds returning date as a date object

	//default constructor
	public Issue(){
		this.id = 0;
		this.member = new Member();
		this.book = new Book();
		this.issueDate = new Date();
		this.returningDate = new Date();
	};

	//full arguments constructor
	public Issue(int id, Member member, Book book, String issueDate, String returningDate){
		this.id = id;
		this.member = new Member(member);
		this.book = new Book(book);
		this.issueDate = stringToDate(issueDate);
		this.returningDate = stringToDate(returningDate);
	}


	public Issue(Issue issue){
		this.id = issue.id;
		this.member = new Member(issue.member);
		this.book = new Book(issue.book);
		this.issueDate = issue.issueDate;
		this.returningDate = issue.returningDate;
	}

	//Converts the string type it reads from the file to date type
	public Date stringToDate(String sDate){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy", Locale.ENGLISH);
		try {
			Date date = formatter.parse(sDate);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	//starts getter and setter methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Member getMember() {
		return new Member(member);
	}

	public void setMember(Member member) {
		this.member = new Member(member);
	}

	public Book getBook() {
		return new Book(book);
	}

	public void setBook(Book book) {
		this.book = new Book(book);
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturningDate() {
		return returningDate;
	}

	public void setReturningDate(Date returningDate) {
		this.returningDate = returningDate;
	}
	//finishes getter and setter methods


	public boolean equals(Issue otherIssue){
		return (id == otherIssue.id) &&
				(member.equals(otherIssue.member)) &&
				(book.equals(otherIssue.book)) &&
				(issueDate.equals(otherIssue.issueDate)) &&
				(returningDate.equals(otherIssue.returningDate));
	}

	public String toString() {
		return "Id: " + id + "\nIssue Date: " + issueDate + "\nReturning Date: " + returningDate;
	}
}
