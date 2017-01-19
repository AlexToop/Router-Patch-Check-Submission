import java.util.ArrayList;

/**
 * 
 * File contains main and will be run with one argument
 * 
 * @author Alexander Toop
 *
 */
public class RouterPatchCheck {

	/**
	 * Converts a given String to an ArrayList of objects type: Router.
	 * 
	 * @param input
	 *            The String to be processed.
	 * @return An ArrayList<Router> from the passed in String.
	 */
	public static ArrayList<Router> stringToRouterArr(String input) {
		String[] lines;
		String[] lineParts;
		int noLines;
		int noLineParts;
		ArrayList<Router> allRouters;
		allRouters = new ArrayList<Router>();

		// We split the input up into lines.
		lines = input.split(System.getProperty("line.separator"));
		noLines = lines.length;

		// We then go through all of the lines and split those up.
		for (int i = 0; i < (noLines); i++) {
			lineParts = lines[i].split(",");
			noLineParts = lineParts.length;
			allRouters.add(new Router());

			for (int j = 0; j < noLineParts; j++) {
				switch (j) {
				case 0:
					allRouters.get(i).setHostname(lineParts[j]);
					break;
				case 1:
					allRouters.get(i).setIpAddress(lineParts[j]);
					break;
				case 2:
					allRouters.get(i).setUpdated(lineParts[j]);
					break;
				case 3:
					allRouters.get(i).setOsVersion(lineParts[j]);
					break;
				case 4:
					allRouters.get(i).setExtraDetails(lineParts[j]);
					break;
				default:
					break;
				}
			}
		}
		return allRouters;
	}

	/**
	 * main() function of the program.
	 * 
	 * @param args
	 *            Specify the file to run. There should be only one argument
	 *            provided.
	 */
	public static void main(String[] args) {
		String returnedInput;
		ArrayList<Router> routers;

		// Program will only run with one argument.
		if (args.length == 0 | args.length > 1) {
			System.out.println("Error: Please provide one argument containing file name. (Example: 'sample.csv')");
			System.exit(0);
		}

		// Fetches content of the file specified.
		ReadInput input = new ReadInput(args[0]);
		returnedInput = input.getContent();

		// Populates array 'routers' with objects of Router.
		routers = stringToRouterArr(returnedInput);

		// Makes sure that every Router is validated.
		RouterValidator checker = new RouterValidator(routers);
		routers = checker.getValidated();

		// Prints to CLI routers that can be updated.
		for (int i = 0; i < routers.size(); i++) {
			if (routers.get(i).getIsValid().equals(true)) {
				System.out.println(routers.get(i).toString());
			}
		}

	}
}
