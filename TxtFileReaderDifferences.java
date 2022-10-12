import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class TxtFileReaderDifferences extends TxtFileReader {
    
	//gets filePath of 2nd file to compare with
	public TxtFileReaderDifferences(String secondFilePath)
	{
		super();
		this.secondFilePath = secondFilePath;
	}

	private String secondFilePath;
	
	@Override
	public String Read(String filePath) {
		ArrayList<String> fileContent1 = new ArrayList<String>();
		ArrayList <String> fileContent2 = new ArrayList<String>();
		ArrayList <String> diff1 = new ArrayList<String>();
		ArrayList <String> diff2 = new ArrayList<String>();
        String str = null;
        String str2 = null;
        
        //For each file, adds a line number before each line of its content and stores it in the fileContent
        try {
            BufferedReader in = new BufferedReader(new FileReader(filePath));
            var lineNumber = 1;
            while ((str = in.readLine()) != null) {
                fileContent1.add("Line "+lineNumber+": "+str);
                lineNumber++;
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            BufferedReader in = new BufferedReader(new FileReader(this.secondFilePath));
            var lineNumber = 1;
            while ((str2 = in.readLine()) != null) {
                fileContent2.add("Line "+lineNumber+": "+str2);
                lineNumber++;
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // for each line in file1, check if 2nd file contains it else add it to the removed elements
        for (String str3 : fileContent1) {
            if (!fileContent2.contains(str3)) {
                diff1.add(str3);
            }
        }
        // for each line in file2, check if initial file contains it else add it to the added elements
        for (String str5 : fileContent2) {
            if (!fileContent1.contains(str5)) {
                diff2.add(str5);
            }
        }
        
        // stores the content of added/removed elements into a single string
        String removedElements = String.join("\n", diff1);
        String addedElements = String.join("\n", diff2);

        return "Added elements: \n" + addedElements + "\n \nRemoved elements: \n" + removedElements;
	}	
}
