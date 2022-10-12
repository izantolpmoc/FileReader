import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TxtFileReaderPalindromic extends TxtFileReader {
	
	public TxtFileReaderPalindromic()
	{
		super();
	}

	@Override
	public String Read(String filePath) {
		File file = super.getFile(filePath);
		Scanner fileStream = null;
		try 
		{
			fileStream = new Scanner(file);
            String content = new String ("");
            while (fileStream.hasNext())
            {
                //reads each line of the file and gets every letter backwards using their index
            	String temp = fileStream.nextLine();
                for (int i = temp.length() - 1; i >= 0; i--) {
                    content+=temp.charAt(i);
                }
                content += "\n";
            }
            return content;
		}
    	catch (IOException e) {
             e.printStackTrace();
        }
		finally {
			if(fileStream != null)
				fileStream.close();
		}
		return null;
	}	
}
