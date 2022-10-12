public class FileReaderMain {

	public static void main(String[] args) {
		
		System.out.println("Displaying file normally: \n");
		TxtFileReaderNormal reader = new TxtFileReaderNormal();
		var content = reader.Read("TxtDocuments/document1.txt");
		System.out.println(content + "\n\n");
		
		System.out.println("Displaying file in reverse by lines: \n");
		TxtFileReaderReverse reverseReader = new TxtFileReaderReverse();
		var reverseContent = reverseReader.Read("TxtDocuments/document1.txt");
		System.out.println(reverseContent + "\n");
		
		System.out.println("Displaying file in reverse by letters: \n");
		TxtFileReaderPalindromic palindromicReader = new TxtFileReaderPalindromic();
		var palindromicContent = palindromicReader.Read("TxtDocuments/document1.txt");
		System.out.println(palindromicContent + "\n");
		
		System.out.println("Displaying file differences with second file: \n");
		TxtFileReaderDifferences differencesReader = new TxtFileReaderDifferences("TxtDocuments/document2.txt");
		var differencesContent = differencesReader.Read("TxtDocuments/document1.txt");
		System.out.println(differencesContent);
	}

}
