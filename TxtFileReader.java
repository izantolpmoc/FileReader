import java.io.File;

public abstract class TxtFileReader implements FileReader<String> {

    //creates a file from a given filePath
	protected File getFile(String filePath) {
		 return new File(filePath);
	}
}
