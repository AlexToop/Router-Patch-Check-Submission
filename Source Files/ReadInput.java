import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class used to get user input and then create a String will all of the files
 * contents.
 * 
 * @author Alexander Toop
 */
public class ReadInput {
	public String returnedString = "";

	public ReadInput(String givenFileName) {
		returnedString = getContents(givenFileName);
	}

	/**
	 * Fetches all of the contents of the specified file and then appends them
	 * to a String.
	 * 
	 * @param givenFileName
	 *            File name as given.
	 * @return filesContent The content of the file passed in.
	 */
	private String getContents(String givenFileName) {
		String filesContent = "";

		try {
			BufferedReader contents = new BufferedReader(new FileReader(givenFileName));
			StringBuilder stringBuilder = new StringBuilder();
			while ((filesContent = contents.readLine()) != null) {
				filesContent += (char) (10);
				stringBuilder.append(filesContent);
			}
			contents.close();
			return stringBuilder.toString();
		} catch (IOException ioe) {
			System.out.println("Error: File not found");
		}
		return filesContent;
	}

	/**
	 * getter method to fetch the created string
	 * 
	 * @return returnedString, The String created from the fetched file.
	 */
	public String getContent() {
		return returnedString;
	}

}
