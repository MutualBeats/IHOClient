/**
 * @author huangxiao
 * @version 2016年12月25日
 */
package driver;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogicservice.userblservice.ClientBLService;
import util.exception.NetException;
import util.user.MemberType;
import vo.user.ClientInfoChangeVO;
import vo.user.ClientRegistVO;
import vo.user.ClientVO;
import vo.user.MemberVO;

public class Client_Driver {
	
    public static void main(String[] args) {

        try {
            ClientBLService service = ControllerFactory.getClientBLServiceInstance();
            drive(service);
        } catch (NetException e) {
            System.out.println("Net Error");
        }

    }

    public static void drive(ClientBLService client_service) throws NetException {
        ClientRegistVO registVO = new ClientRegistVO("test_client", "Test", "12345678999", "12345678");
        System.out.println(client_service.regist(registVO));
        
        ClientVO clientVO = client_service.getClientInfo("test_client");
        System.out.println(clientVO.name + " " + clientVO.contactWay + " " + clientVO.credit);
        
        ClientInfoChangeVO changeVO = new ClientInfoChangeVO("test_client", "ChangeTest", "98765432111");
        System.out.println(client_service.changeClientInfo(changeVO));
        
        MemberVO memberVO = new MemberVO("test_client", MemberType.Enterprise, 0, "测试企业");
        System.out.println(client_service.registerMember(memberVO));
        
    }

}
