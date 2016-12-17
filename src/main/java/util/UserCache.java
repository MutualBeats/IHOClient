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
	
	private static String hotel_id;
	
	public static void init_Cache (String user_id) {
		UserCache.user_id = user_id;
	}
	
	public static void setHotelID(String hotel_id) {
		UserCache.hotel_id = hotel_id;
	}
	
	public static String getID() {
		return user_id;
	}
	
	public static String getHotelID() {
		return hotel_id;
	}
	
}
