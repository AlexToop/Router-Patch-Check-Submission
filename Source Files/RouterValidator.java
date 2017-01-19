import java.util.ArrayList;

/**
 * 
 * Takes in an ArrayList of Router objects and checks to see if they are valid
 * to update.
 * 
 * @author Alexander Toop
 *
 */
public class RouterValidator {
	public ArrayList<Router> validatedRouters;

	/**
	 * Takes an ArrayList of Routers to be validated and then sets isValid to
	 * false for Routers that should not be updated. Nested for efficiency.
	 * 
	 * @param input
	 *            ArrayList of Routers to be validated.
	 */
	public RouterValidator(ArrayList<Router> input) {
		for (int i = 0; i < input.size(); i++) {
			if (checkOS(input.get(i))) {
				if (!(checkUpdated(input.get(i)))) {
					checkHostnameAndIp(input.get(i), input);
				} else {
					input.get(i).setIsValid(false);
				}
			} else {
				input.get(i).setIsValid(false);
			}
		}
		validatedRouters = input;
	}

	/**
	 * @param given
	 *            Router passed from constructor.
	 * @return Returns true if the routers OS version is valid for updating.
	 */
	private Boolean checkOS(Router given) {
		double osVer;
		try {
			osVer = Float.parseFloat(given.getOsVersion());
		} catch (NumberFormatException e) {
			given.setIsValid(false);
			return false;
		}
		if (osVer >= 12) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param given
	 *            Router passed from constructor.
	 * @return Returns false if not updated, true otherwise.
	 */
	private Boolean checkUpdated(Router given) {
		if (given.getUpdated().equals("no")) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Checks givenRouter to see if its Hostname or IP address appears more than
	 * once in the file. If it does, both instances are invalidated.
	 * 
	 * @param givenRouter
	 * @param routers
	 */
	private void checkHostnameAndIp(Router givenRouter, ArrayList<Router> routers) {
		int dupHostFound = 0;
		int dupIpFound = 0;
		for (int i = 0; i < routers.size(); i++) {
			if (givenRouter.getHostname().equals(routers.get(i).getHostname())) {
				dupHostFound++;
			}
			if (givenRouter.getIpAddress().equals(routers.get(i).getIpAddress())) {
				dupIpFound++;
			}
			if (dupHostFound > 1 | dupIpFound > 1) {
				givenRouter.setIsValid(false);
				routers.get(i).setIsValid(false);
				break;
			}
		}
		// Regex to check that the IP Address and Hostname are of the correct
		// format.
		if (!(givenRouter.getIpAddress().matches("^[0-9]*\\.[0-9]*\\.[0-9]*\\.[0-9]*$"))) {
			givenRouter.setIsValid(false);
		}
		if (!(givenRouter.getHostname().matches("^[a-z0-9]+\\.[a-z0-9]+\\.[a-z]+$"))) {
			givenRouter.setIsValid(false);
		}
	}

	/**
	 * @return ArrayList of objects type: Router, that have been validated.
	 */
	public ArrayList<Router> getValidated() {
		return validatedRouters;
	}

}
