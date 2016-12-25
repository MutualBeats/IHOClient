/**
 * @author huangxiao
 * @version 2016年12月25日
 */
package driver;

import java.util.ArrayList;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogicservice.userblservice.ManagerBLService;
import util.exception.NetException;
import vo.hotel.HotelVO;
import vo.user.ClientInfoChangeVO;
import vo.user.ClientVO;
import vo.user.ManagerVO;
import vo.user.MarketerVO;
import vo.user.StaffChangeVO;
import vo.user.StaffVO;

public class Manager_Driver {
	
    public static void main(String[] args) {

        try {
            ManagerBLService service = ControllerFactory.getManagerBLServiceInstance();
            drive(service);
        } catch (NetException e) {
            System.out.println("Net Error");
        }

    }

    public static void drive(ManagerBLService manager_service) throws NetException {
        ManagerVO managerVO = manager_service.getManagerInfor();
        System.out.println(managerVO.name + " " + managerVO.contactWay);
        
        managerVO.name = "test_change";
        System.out.println(manager_service.changeManagerInfo(managerVO));
        
        ClientVO clientVO = manager_service.showClientData("test_client");
        System.out.println(clientVO.name + " " + clientVO.contactWay);
        
        ClientInfoChangeVO changeVO = new ClientInfoChangeVO("test_client", "test_change", "98765432111");
        System.out.println(manager_service.changeClientInfo(changeVO));
        
        ArrayList<ClientVO> clients = manager_service.getClientList();
        System.out.println("Total client number: " + clients.size());
        
        ArrayList<StaffVO> staffs = manager_service.getStaffList();
        System.out.println("Total staff number: " + staffs.size());
        
        StaffVO staffVO = manager_service.showStaffData(staffs.get(0).id);
        System.out.println(staffVO.name + " " + staffVO.contactWay);
        
        StaffChangeVO staffChangeVO = new StaffChangeVO(staffVO.id, "test_change", "98765432111");
        System.out.println(manager_service.changeStaffData(staffChangeVO));
        
        staffVO.id = "test_add_staff";
        System.out.println(manager_service.addStaff(staffVO, "12345678"));
        
        HotelVO hotelVO = new HotelVO("10000000", "test_add_hotel", "test_adress", "江苏省 南通市 如皋市", "如城商圈", 5, 5);
        System.out.println("Generate hotelID: " + manager_service.addHotel(hotelVO));
        
        MarketerVO marketerVO = new MarketerVO("test_add", "test", "12345678999");
        System.out.println(manager_service.addMarketer(marketerVO, "12345678"));
        
        marketerVO = manager_service.showMarketerData("marketer");
        System.out.println(marketerVO.name + " " + marketerVO.contactWay);
        
        marketerVO.name = "change_test";
        System.out.println(manager_service.changeMarketerData(marketerVO));
        
        ArrayList<MarketerVO> marketers = manager_service.getMarketerList();
        System.out.println("Total marketer number: " + marketers.size());      
        
    }

}
