/**
 * @author huangxiao
 * @version 2016年12月25日
 */
package driver;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogicservice.userblservice.StaffBLService;
import util.exception.NetException;
import vo.user.StaffVO;

public class Staff_Driver {
    
	public static void main(String[] args) {

        try {
            StaffBLService service = ControllerFactory.getStaffBLServiceInstance();
            drive(service);
        } catch (NetException e) {
            System.out.println("Net Error");
        }

    }

    public static void drive(StaffBLService staff_service) throws NetException {
        StaffVO staffVO = staff_service.showData("test_staff");
        System.out.println(staffVO.name + " " + staffVO.contactWay + " " + staffVO.hotelID);
    }

}
