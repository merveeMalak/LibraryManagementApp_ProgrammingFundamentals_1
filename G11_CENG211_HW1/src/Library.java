public class Library {
    private Book[] bookList;  //holds books
    private int capacity;  //holds array capacity
    private int lastIndex; //holds last index of array
    private int libraryNumber; //holds the information of which library it is

    //takes the information of which library it is as a int
    public Library(int libraryNumber) {
        this.libraryNumber = libraryNumber;
        initializeArray();
        createLibraryBookList();
    }

    //initialize array
    private void initializeArray() {
        int initialCapacity = 10; //the initial capacity
        this.capacity = 10;
        this.lastIndex = 0;
        bookList = new Book[initialCapacity];
        for (int i = 0; i < bookList.length; i++) {
            bookList[i] = new Book();
        }
    }

    //creates a list of books the library has
    public void createLibraryBookList() {
        FileIO fileIO = new FileIO();
        String bookString = fileIO.readFile(chooseLibrary());

        String[] books = bookString.split("\n");

        for (int i = 0; i < books.length; i++) {
            String[] bookDetail = books[i].split(",");
            ensureCapacity(); //check array capacity
            addBook(bookList[i], bookDetail); //add book in the array
        }
    }

    //takes a book to add to the array and information of the book as a string array.
    private void addBook(Book book, String[] bookDetail){
        book.setId(bookDetail[0]);
        book.setTitle(bookDetail[1]);
        book.setAuthor(bookDetail[2]);
        book.setPublisher(bookDetail[3]);
        book.setEdition(Integer.parseInt(bookDetail[4]));
        book.setGenre(bookDetail[5]);
        book.setQuantity(Integer.parseInt(bookDetail[6]));
        lastIndex++;
    }

    //Returns filename as string based on library number.
    private String chooseLibrary() {
        switch (libraryNumber) {
            case 1:
                return "L1_Books.csv";
            case 2:
                return "L2_Books.csv";
            case 3:
                return "L3_Books.csv";
            default:
                return "";
        }
    }

    //Returns book array.
    public Book[] getBookList() {
        Book[] tempBookList = new Book[bookList.length];
        for (int i = 0; i < bookList.length; i++) {
            tempBookList[i] = bookList[i];
        }
        return tempBookList;
    }
    //Takes id as parameter. It finds the book with the same id as the parameter given and returns that book.
    public Book findBook(String id){
        for (Book book:bookList){
            if (book.getId().equals(id)){
                return  new Book(book);
            }
        }
        return null;
    }

    //if the array capacity is full, the capacity of the array is increased. Otherwise nothing is done.
    private void ensureCapacity() {
        if (isFull()) {
            Book[] oldBookList = bookList;
            Book[] tempBookList = new Book[2 * this.capacity];
            bookList = tempBookList;
            for (int i = 0; i < capacity; i++) {
                bookList[i] = oldBookList[i];
            }
            this.capacity = 2 * capacity;
            for (int i = lastIndex; i < capacity; i++) {
                bookList[i] = new Book();
            }
        }
    }

    //Returns true if the array is full, otherwise false.
    private boolean isFull() {
        if (lastIndex == capacity) {
            return true;
        }
        return false;
    }
}