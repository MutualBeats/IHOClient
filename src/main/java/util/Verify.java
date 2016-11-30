package util;

/**
 * 
 * Identify Verify
 * 
 * @author heleninsa
 *
 */
public class Verify {

	private static int USER_NAME_MIN_LENGTH;
	private static int USER_NAME_MAX_LENGTH;
	
	private static int PASSWORD_MIN_LENGTH;
	private static int PASSWORD_MAX_LENGTH;

	/**
	 * Initialization of length config
	 * 
	 * @param user_min
	 * @param user_max
	 * @param pass_min
	 * @param pass_max
	 */
	public static void init(int user_min, int user_max, int pass_min, int pass_max) {
		USER_NAME_MIN_LENGTH = user_min;
		USER_NAME_MAX_LENGTH = user_max;
		PASSWORD_MIN_LENGTH = pass_min;
		PASSWORD_MAX_LENGTH = pass_max;
	}

	/**
	 * check the identity of user
	 * 
	 * @param user_name
	 *            : Identity of user
	 * @return
	 */
	public static UserIdentity identify(String user_name) {
		return null;
	}

	
	/**
	 * Check the name formatter
	 * 
	 * @param length
	 * @return
	 */
	public static boolean nameFormatterCheck(int length) {
		if(length > USER_NAME_MAX_LENGTH || length < USER_NAME_MIN_LENGTH) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Check the password formatter
	 * 
	 * @param length
	 * @return
	 */
	public static boolean passFormatterCheck(int length) {
		if(length > PASSWORD_MAX_LENGTH || length < PASSWORD_MIN_LENGTH) {
			return false;
		}
		
		return true;	
	}

}
