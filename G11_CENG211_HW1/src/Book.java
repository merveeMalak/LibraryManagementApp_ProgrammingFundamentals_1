public class Book {
	
	private String id;
	private String title;
	private String author;
	private String publisher;
	private int edition;
	private String genre;
	private int quantity;

	//full parameters constructor
	public Book(String  id, String title, String author, String publisher, int edition, String genre, int quantity){
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.edition = edition;
		this.genre = genre;
		this.quantity = quantity;
	}

	//default constructor
	public Book(){
		this.id = "";
		this.title = "";
		this.author = "";
		this.publisher = "";
		this.edition = 0;
		this.genre = "";
		this.quantity = 0;
	};

	//takes all arguments as a string array
	public Book(String[] bookInfo){
		this.id = bookInfo[0];
		this.title = bookInfo[1];
		this.author = bookInfo[2];
		this.publisher = bookInfo[3];
		this.edition = Integer.parseInt(bookInfo[4]);
		this.genre = bookInfo[5];
		this.quantity = Integer.parseInt(bookInfo[6]);
	}

	public Book(Book book){
		this.id = book.id;
		this.title = book.title;
		this.author = book.author;
		this.publisher = book.publisher;
		this.edition = book.edition;
		this.genre = book.genre;
		this.quantity = book.quantity;
	}

	//starts getter and setter methods
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	//finishes getter and setter methods

	public boolean equals(Book otherBook){
		return (id.equals(otherBook.id)) &&
				(title.equals(otherBook.title)) &&
				(author.equals(otherBook.publisher)) &&
				(publisher.equals(otherBook.publisher)) &&
				(edition == otherBook.edition) &&
				(genre.equals(otherBook.genre)) &&
				(quantity == otherBook.quantity);
	}

	@Override
	public String toString() {
		return "Book Name: " + title + "\nAuthor: " + author + "\nEdition: " + edition;
	}
}
