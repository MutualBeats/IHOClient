package util;

/**
 * 
 * Cache for 
 * 
 * @author heleninsa
 *
 */
public class UserCache {

	private static String user_id;
	
	public static void init_Cache (String user_id) {
		UserCache.user_id = user_id;
	}
	
	public static String getID() {
		return user_id;
	}
	
}
