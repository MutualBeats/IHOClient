package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * 通用时间处理类
 * 
 * @author heleninsa
 *
 */
public class Time {
	
	public static String getCurrentTime(){
		SimpleDateFormat df=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String time=df.format(new Date());
		return time;
	}
	
	public static String getCurrentDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		String date = df.format(new Date());
		return date;
	}

	public static String getCurrentYear(){
		SimpleDateFormat df=new SimpleDateFormat("yyyy");
		String year=df.format(new Date());
		return year;
	}

	public static String getCurrentMonth(){
		SimpleDateFormat df=new SimpleDateFormat("MM");
		String month=df.format(new Date());
		return month;
	}

	public static String getCurrentDay(){
		SimpleDateFormat df=new SimpleDateFormat("dd");
		String date=df.format(new Date());
		return date;
	}
	
	public static long deltaTime(String time1, String time2) throws ParseException {
		// 计算两个时间点间的时间间隔（单位为秒）
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date beginTime = df.parse(time1);
		Date endTime = df.parse(time2);
		return (long)(endTime.getTime() - beginTime.getTime()) / 1000;
	}
	
	/**
	 * 计算时间间隔
	 * 
	 * @param date1
	 * @param date2
	 * @return 返回为正如果Date2晚于Date1
	 * @throws ParseException
	 */
	public static int deltaDate(String date1, String date2) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		Date beginDate = df.parse(date1);
		Date endDate = df.parse(date2);
		return (int)((endDate.getTime() - beginDate.getTime()) / (1000 * 60 * 60 * 24));
	}

	//若传入的time1为null或者""，返回“1970/1/1 0:0:0”
	public static String jdugeTime1(String time1){
		if(time1!=null&&!time1.equals("")){
			return time1;
		}else{
			return "1970/01/01 00:00:00";
		}
	}

	//若传入的time2为null或者""，返回现在的时间
	public static String jdugeTime2(String time2){
		if(time2!=null&&!time2.equals("")){
			return time2;
		}else{
			return getCurrentTime();
		}
	}
	
	public static void main(String[] args) throws ParseException {
		String time1 = "2016/12/01";
		String time2 = "2016/12/01";
		System.out.println(deltaDate(time1, time2));
	}
	
}
