public class LibraryManagement {
    FileIO fileIO;  //holds fileIO object
    Issue[][] issueList;

    //default constructor
    public LibraryManagement(){
        initializeIssueList();
    }

    //initializeIssueList
    private void initializeIssueList(){
        fileIO = new FileIO();
        issueList = new Issue[3][];
        createAllLibraryIssuesList();
    }

    //Takes library number as int. Returns all issues that the library has.
    private String[] readIssueFile(int libraryNumber) {
        String issueString = fileIO.readFile(decideIssueFile(libraryNumber)); //read the file
        String[] issues = issueString.split("\n");
        return issues;
    }

    ////Takes library number as int. Creates all issues that the library has.
    private Issue[] createIssueList(int libraryNumber){
        String[] issues = readIssueFile(libraryNumber);
        Issue[] issueList = new Issue[issues.length];
        for (int i = 0; i<issueList.length; i++){
            String[] issueDetail = issues[i].split(",");
            issueList[i] = new Issue(createIssue(issueDetail,libraryNumber));
        }
        return issueList;
    }

    //Takes issue details as a string array, and library number as a int. Creates and returns issue.
    private Issue createIssue(String[] issueDetail, int number){
        Member member = new Member();
        Member targetMember = member.findMember(Integer.parseInt(issueDetail[1]));
        Library library = new Library(number);
        Book targetBook = library.findBook(issueDetail[2]);
        return new Issue(Integer.parseInt(issueDetail[0]), targetMember, targetBook, issueDetail[3], issueDetail[4]);
    }

    //Returns filename as string based on library number.
    private String decideIssueFile(int libraryNumber){
        switch (libraryNumber){
            case 1:
                return "L1_Issues.csv";
            case 2:
                return "L2_Issues.csv";
            case 3:
                return "L3_Issues.csv";
            default:
                return "";
        }
    }

    //creates a list of all libraries' issues.
    private void createAllLibraryIssuesList(){
        Issue[] library1issues = createIssueList(1);
        Issue[] library2issues = createIssueList(2);
        Issue[] library3issues = createIssueList(3);
        issueList[0] = new Issue[library1issues.length];
        issueList[1] = new Issue[library2issues.length];
        issueList[2] = new Issue[library3issues.length];
        for (int i = 0; i<3; i++){
            for (int j = 0; j < issueList[i].length; j++){
                switch (i){
                    case 0:
                        issueList[i][j] = new Issue(library1issues[j]);
                        break;
                    case 1:
                        issueList[i][j] = new Issue(library2issues[j]);
                        break;
                    default:
                        issueList[i][j] = new Issue(library3issues[j]);
                        break;

                }
            }
        }
    }

    //return issue array
    public Issue[][] getIssueList(){
        Issue[][] tempIssueList = new Issue[3][];
        tempIssueList[0] = new Issue[issueList[0].length];
        tempIssueList[1] = new Issue[issueList[1].length];
        tempIssueList[2] = new Issue[issueList[2].length];
        for (int i = 0; i<3; i++){
            for (int j = 0; j<tempIssueList[i].length; j++){
                tempIssueList[i][j] = issueList[i][j];
            }
        }
        return tempIssueList;
    }
}
