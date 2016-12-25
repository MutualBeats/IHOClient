package driver;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogic.promotionbl.Promotion;
import bussinesslogicservice.promotionblservice.PromotionBLService;
import util.Time;
import util.exception.NetException;
import util.promotion.PromotionType;
import util.resultmessage.ResultMessage_Hotel;
import util.resultmessage.ResultMessage_Promotion;
import vo.promotion.PromotionVO;

import java.util.ArrayList;

/**
 * Created by heleninsa on 2016/12/25.
 */
public class Promotion_Driver {

    public static void main(String[] args) {

        try {
            PromotionBLService service = ControllerFactory.getPromotionBLServiceInstance();
            drive(service);
        } catch (NetException e) {
            e.printStackTrace();
        }

    }

    public static void drive(PromotionBLService service) throws NetException {
        ArrayList<Double> discount = new ArrayList<>();
        discount.add(10.0);
        discount.add(9.0);
        discount.add(8.0);
        discount.add(7.0);
        PromotionVO vo = new PromotionVO("", "促销策略", PromotionType.Room, discount, "00000001", Time.getCurrentDate(), "2017\02\02");
        String h_id = service.addhotelPromotion(vo);
        System.out.println("酒店促销策略ID : " + h_id);

        vo.hotelID = "江苏省 南京市 南京市 栖霞商圈";
        vo.type = PromotionType.BusinessDistrict;
        String w_id = service.addWebPromotion(vo);
        System.out.println("商圈促销策略ID : " + h_id);

        ArrayList<PromotionVO> h_vo = service.getHotelPromotion("00000001");
        System.out.println("当前酒店促销策略数目 ： " + h_vo.size());

        ArrayList<PromotionVO> w_vo = service.getWebPromotion();
        System.out.println("当前网站促销策略数目 : " + w_vo.size());

        PromotionVO dulplicate = service.getPromotionById(h_id);
        System.out.println("检查促销策略信息 :  " + "\r\n" +
                "名称 ： " + dulplicate.promotionName + "\r\n" +
                "地址" + dulplicate.hotelID);

        ResultMessage_Promotion result = service.cancel(h_id);
        System.out.println("撤销结果 ： " + result.toString());

        ArrayList<Integer> member_level = service.getMemberLevel();
        for (int i = 0; i < member_level.size(); i++) {
            System.out.println("Level " + i + " : " + member_level.get(i));
        }

        ArrayList<Double> discounts = service.getMemberDiscount();
        for (int i = 0; i < discounts.size(); i++) {
            System.out.println("Level " + i + " : " + discounts.get(i));
        }

        ArrayList<Integer> level = new ArrayList<>();
        level.add(1000);
        level.add(900);
        level.add(800);
        level.add(700);
        ResultMessage_Promotion level_result = service.makeLevel(level, discount);
        System.out.println("等级制定结果 ： " + level_result.toString());
    }

}
