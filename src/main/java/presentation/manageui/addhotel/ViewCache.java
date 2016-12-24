package presentation.manageui.addhotel;

import vo.hotel.HotelVO;
import vo.user.StaffVO;

/**
 * 
 * 添加酒店界面Cache
 * 
 * @author heleninsa
 *
 */
public class ViewCache {

	//Hotel
	public static HotelVO hotel_info;

	public static int province_index;

	public static int city_index;

	public static int field_index;

	public static int group_index;

	public static int star_index;
	
	//Staff
	public static StaffVO staff_info;
	
	public static String ps;
	
	public static String ps_again;

	public static void initHotel(HotelVO info) {
		hotel_info = info;
	}

	public static void initStaff(StaffVO info, String psw, String psa) {
		staff_info = info;
		ps = psw;
		ps_again = psa;
	}

	/**
	 * @param p_index
	 *            Province
	 * @param c_index
	 *            City
	 * @param f_index
	 *            Field
	 * @param g_index
	 *            Group
	 * @param s_index
	 *            Star
	 */
	public static void init(int p_index, int c_index, int f_index, int g_index, int s_index) {
		province_index = p_index;
		city_index = c_index;
		field_index = f_index;
		group_index = g_index;
		star_index = s_index;
	}

	/**
	 * 清除Cache
	 */
	public static void clearCache() {
		clearHotelCache();
		clearStaffCache();
	}
	
	public static void clearStaffCache() {
		staff_info = null;
		ps = null;
	}
	
	public static void clearHotelCache() {
		hotel_info = null;
		province_index = -1;
		city_index = -1;
		field_index = -1;
		group_index = -1;
		star_index = -1;
	}

}
