package util;

public class LengthOfID {
	// Length of UserID
	private static final int UserID = 10;
	// Length of HotelID
	private static final int HotelID = 8;
	// Length of UserName
	private static final int MinUserName = 6;
	private static final int MaxUserName = 12;

	public static int getMinUserName() {
		return MinUserName;
	}

	public static int getMaxUserName() {
		return MaxUserName;
	}

	public static int getUserID() {
		return UserID;
	}

	public static int getHotelID() {
		return HotelID;
	}

}
