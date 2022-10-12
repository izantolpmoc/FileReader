import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TxtFileReaderNormal extends TxtFileReader {

	public TxtFileReaderNormal()
	{
		super();
	}

	@Override
	public String Read(String filePath) {
		File file = super.getFile(filePath);
		FileInputStream stream = null;
		try 
		{
    		stream = new FileInputStream(file);
    		int i; 
            String content = "";
            //while there is content, add it to content and transforms the bytes to letters
            while ((i = stream.read()) != -1) {
                content += (char)i;
            }
            return content;
		}
		catch (IOException e) {
            e.printStackTrace();
        }
		finally {
			if(stream != null)
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
		}
		return null;
	}	

}
