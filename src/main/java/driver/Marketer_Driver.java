/**
 * @author huangxiao
 * @version 2016年12月25日
 */
package driver;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogicservice.userblservice.MarketerBLService;
import util.exception.NetException;
import vo.user.MarketerVO;

public class Marketer_Driver {
	
    public static void main(String[] args) {

        try {
            MarketerBLService service = ControllerFactory.getMarketerBLServiceInstance();
            drive(service);
        } catch (NetException e) {
            System.out.println("Net Error");
        }

    }

    public static void drive(MarketerBLService marketer_service) throws NetException {
        MarketerVO marketerVO = marketer_service.showData("marketer");
        System.out.println(marketerVO.name + " " + marketerVO.contactWay);
        
    }

}
