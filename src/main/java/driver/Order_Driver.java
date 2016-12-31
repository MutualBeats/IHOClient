package driver;

import java.util.ArrayList;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogicservice.orderblservice.OrderBLService;
import util.Time;
import util.exception.NetException;
import util.exception.TimeConflictException;
import util.order.OrderState;
import util.resultmessage.ResultMessage_Order;
import vo.order.OrderMakeVO;
import vo.order.OrderVO;

/**
 * Created by heleninsa on 2016/12/01.
 */
public class Order_Driver {

    public static void main(String[] args) {

        try {
            OrderBLService service = ControllerFactory.getOrderBLServiceInstance();
            drive(service);
        }catch (NetException e) {
            System.out.println("网络异常");
        }

    }

    public static void drive(OrderBLService service) throws NetException{
        ArrayList<String > room_number = new ArrayList<>();
        room_number.add("3B346");
        OrderMakeVO vo = new OrderMakeVO("test_client", "00000001", room_number, "2016/12/01", "2016/12/05", 5, false);
        OrderVO waiting = null;
        try {
            waiting = service.getOrderVOBeforeMake(vo);
        } catch (TimeConflictException e) {
            System.out.println("时间冲突");
            return;
        }

        OrderVO dulplicate = service.queryOrderById(waiting.orderID);
        System.out.println("检测订单信息是否相同 ： \r\n" +
                "订单号 ： " + dulplicate.clientID+"" +
                "生成时间 : " + dulplicate.makeTime);

        ResultMessage_Order result = service.cancelOrder(waiting.orderID);
        System.out.println("撤销订单结果 ： " + result.toString());

        ArrayList<OrderVO> user_order = service.queryUserOrder(waiting.clientID, OrderState.All);
        System.out.println("客户订单数目 ： "  + user_order.size());

        ArrayList<OrderVO> hotel_order = service.queryHotelOrder(waiting.hotelID, OrderState.All);
        System.out.println("酒店订单数目 ： "  + hotel_order.size());

        ArrayList<OrderVO> unexe_order = service.queryUnexecutedOrder(Time.getCurrentDate());
        System.out.println("未执行订单数目 ： "  + unexe_order.size());

        ArrayList<OrderVO> exception_order = service.queryAbnormalOrder();
        System.out.println("异常订单数目 ： "  + exception_order.size());
        if(exception_order.size() > 0) {
            ResultMessage_Order put_up_result = service.putUpOrder(exception_order.get(0).orderID);
            System.out.println("补录结果 ： " + put_up_result.toString());
        }

    }

}
