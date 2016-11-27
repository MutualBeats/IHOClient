package vo.user;

public class MarketerVO {
	/*
	 * 网站营销人员ID
	 */
	public String marketerID;
	/*
	 * 网站营销人员姓名
	 */
	public String marketername;
	/*
	 * 网站营销人员联系方式
	 */
	public String contactWay;
	/*
	 * 构造方法
	 * @param staffID
	 * @param staffname
	 * @param hotelname
	 */
	public MarketerVO(String marketerID, String marketername, String tel_number){
		this.marketerID = marketerID;
		this.marketername = marketername;
		this.contactWay = tel_number;
	}
}
