
public interface FileReader<T> {
	//T type enables to return any type of object, not just text
	T Read(String filePath);
}
