import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileIO {

    //default constructor
    public FileIO() { }


    //Takes filename as parameter. Returns the whole file as a string.
    public String readFile(String fileName) {
        String allText = "";
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {  //reads the file line by line
                allText += scanner.nextLine();
                allText += "\n";
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return allText;
    }
}

