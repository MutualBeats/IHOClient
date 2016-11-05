package bussinesslogicservice.orderblservice;

import java.util.ArrayList;

import util.MemberType;
import util.OrderState;
import util.ResultMessage;
import util.RoomType;
import vo.OrderVO;

public class OrderBLService_Driver {
	public void drive (OrderBLService orderBLService){
		OrderVO vo1 = new OrderVO("1234567890123456", "1234567890", "WoDeMa", "12345678901", MemberType.Ordinary, OrderState.UnExcuted, "12345678", "和园宾馆", "3B346", RoomType.Single, 1,10000 ,1000, "2016/10/14", "2016/10/15", "2016/10/16", "2016/10/14", "2016/10/16", "2016/10/15","2015/10/15",1,false);
		OrderVO vo2 = new OrderVO("1234567890123457", "1234567891", "WoDeTian", "98765432125", MemberType.Enterprise, null, "12345678", "和园宾馆", "3B347",RoomType.Double, 2,10000 ,-1000, "2016/10/14", "", "", "2016/10/14", "2016/10/16", "2016/10/14","2015/10/15",4,false);
		OrderVO vo3 = new OrderVO("1234567890123458", "1234567891", "WoDeTian", "98765432125", MemberType.Enterprise, OrderState.Exception, "12345678", "和园宾馆", "3B347",RoomType.Double, 1,10000 ,-1000, "2016/10/17", "", "", "2016/10/17", "2016/10/19", "2016/10/17","2015/10/18",1,false);
		
		ResultMessage result;
		
		result = orderBLService.putUpOrder(vo3.orderId);
		System.out.println(result.toString());
		
		result = orderBLService.makeOrder(vo2);
		System.out.println(result.toString());
		
		result = orderBLService.cancelOrder(vo1.orderId);
		System.out.println(result.toString());
		
		ArrayList<OrderVO> vos;
		
		vos = orderBLService.queryHotelOrder(vo2.hotelId);
		System.out.println("Order Num : " + vos.size() + "Sec :: MT : " + vos.get(1).makeTime);
		
		vos = orderBLService.queryOrderByHotel(vo2.hotelId, vo2.userId);
		System.out.println("Order Num : " + vos.size() + " Info :: MT : " + vos.get(1).makeTime + " Room : " + vos.get(1).roomId);
		
		vos = orderBLService.queryRoomOrder(vo1.hotelId, vo1.roomId);
		System.out.println("Order Num : " + vos.size());
		
		vos = orderBLService.queryUserOrder(vo2.userId);
		System.out.println("Order Num : " + vos.size() + " Info :: MT : " + vos.get(1).makeTime + " Room : " + vos.get(1).roomId);
		
		result = orderBLService.excuteOrder(vo2.orderId);
		System.out.println(result.toString());
	}
}
