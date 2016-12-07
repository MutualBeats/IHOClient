package presentation.manageui.addhotel;

import vo.user.MarketerVO;
import vo.user.StaffVO;

public class ViewCache {
	
	public static MarketerVO marketer_info;
	
	public static StaffVO staff_info;
	
	public static void initMarketer(MarketerVO info) {
		marketer_info = info;
	}
	
	public static void initStaff(StaffVO info) {
		staff_info = info;
	}
	
	public static void clearCache() {
		marketer_info = null;
		staff_info = null;
	}
	
}
