import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TxtFileReaderReverse extends TxtFileReader {
	
	public TxtFileReaderReverse()
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
            //adds every line before the previous one
            while (fileStream.hasNextLine())
            {
                content = fileStream.nextLine() + "\n" + content;
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