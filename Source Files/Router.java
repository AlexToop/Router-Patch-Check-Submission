/**
 * 
 * Contains methods for a Router. Strings used for most details so that
 * incorrect data inserted can be dealt with easily in the RouterValidator.
 * 
 * @author Alexander Toop
 *
 */
public class Router {
	private String hostname;
	private String ipAddress;
	private String updated;
	private String osVersion;
	private String extraDetails;
	private Boolean isValid;

	/**
	 * Takes in no parameters but initialises most values to "". However,
	 * isValid is true until proven otherwise.
	 */
	public Router() {
		this.hostname = "";
		this.ipAddress = "";
		this.updated = "";
		this.osVersion = "";
		this.extraDetails = "";
		this.isValid = true;
	}

	/**
	 * @return isValid Boolean which has a default value of true.
	 */
	public Boolean getIsValid() {
		return isValid;
	}

	/**
	 * @param isValid
	 *            Boolean if this router should be updated.
	 */
	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	/**
	 * @return String Hostname of the router.
	 */
	public String getHostname() {
		return hostname;
	}

	/**
	 * @param hostname
	 *            Sets the Hostname of the router.
	 */
	public void setHostname(String hostname) {
		this.hostname = hostname.toLowerCase();
	}

	/**
	 * @return String ipAddress of the router.
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * @param ipAddress
	 *            Set the IP Address of the router using a String.
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * @return String if the router has already been updated.
	 */
	public String getUpdated() {
		return updated;
	}

	/**
	 * @param updated
	 *            String if the router has been updated.
	 */
	public void setUpdated(String updated) {
		this.updated = updated.toLowerCase();
	}

	/**
	 * @return osVersion double, used as only 12+ can be updated.
	 */
	public String getOsVersion() {
		return osVersion;
	}

	/**
	 * @param givenOsVersion
	 *            The specified OS version of the router.
	 */
	public void setOsVersion(String givenOsVersion) {
		this.osVersion = givenOsVersion;
	}

	/**
	 * @return extraDetails String information surplus to requirements added.
	 */
	public String getExtraDetails() {
		return extraDetails;
	}

	/**
	 * @param extraDetails
	 *            Stores any extra details about the router.
	 */
	public void setExtraDetails(String extraDetails) {
		this.extraDetails = extraDetails;
	}

	/**
	 * Returns information about the Router in the format as specified.
	 */
	public String toString() {
		String toReturn = hostname + " (" + ipAddress + "), OS version " + osVersion;
		if (!extraDetails.equals("")) {
			toReturn += " [" + extraDetails + "]";
		}
		return toReturn;
	}

}
