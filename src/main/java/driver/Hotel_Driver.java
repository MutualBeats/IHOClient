package driver;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogicservice.hotelblservice.HotelBLService;
import util.Time;
import util.exception.NetException;
import util.hotel.SearchCondition;
import util.resultmessage.ResultMessage_Hotel;
import vo.hotel.HotelEvaluationVO;
import vo.hotel.HotelVO;

import java.util.ArrayList;

/**
 * Created by heleninsa on 2016/12/25.
 */
public class Hotel_Driver {

    public static void main(String[] args) {

        try {

            HotelBLService service = ControllerFactory.getHotelBLServiceInstance();
            drive(service);

        } catch (NetException e) {
            System.out.println("Net Error");
        }

    }

    private static void drive(HotelBLService service) throws NetException {

        HotelVO hotel_info = service.showHotelInfo("00000001");
        System.out.println("酒店名称 : " + hotel_info.hotelName + " \r\n" +
                "酒店所属地区" + hotel_info.region + "\r\n" +
                "酒店地址 ： " + hotel_info.address);

        hotel_info.hotelName = "神秘大酒店";
        ResultMessage_Hotel result = service.changeHotelInfo(hotel_info);
        System.out.println("更新结果： " + result.toString());

        ArrayList<HotelEvaluationVO> evaluationVOS = service.getHotelEvalutions(hotel_info.hotelID);
        System.out.println("酒店当前评价数目 ： " + evaluationVOS.size());

        HotelEvaluationVO evaluation = new HotelEvaluationVO(hotel_info.hotelID, "test_client", "000000000000001", Time.getCurrentTime(), 5, "满分好评！！！");
        ResultMessage_Hotel eval_result = service.evaluate(evaluation);
        System.out.println("评价结果： " + eval_result.toString());

    }

}
