package presentation.manageui.addhotel;

import vo.user.MarketerVO;
import vo.user.StaffVO;

public class ViewCache {
	
	public static MarketerVO marketer_info;
	
	public static StaffVO staff_info;
	
	public static int province_index;
	
	public static int city_index;
	
	public static int field_index;
	
	public static int group_index;
	
	public static void initMarketer(MarketerVO info) {
		marketer_info = info;
	}
	
	public static void initStaff(StaffVO info) {
		staff_info = info;
	}
	
	public static void init(int p_index, int c_index, int f_index, int g_index){
		province_index = p_index;
		city_index = c_index;
		field_index = f_index;
		group_index = g_index;
	}
	
	public static void clearCache() {
		marketer_info = null;
		staff_info = null;
		province_index = -1;
		city_index = -1;
		group_index = -1;
	}
	
}
