package driver;

import java.util.ArrayList;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogicservice.creditblservice.CreditBLService;
import util.Time;
import util.credit.CreditChangeAction;
import util.exception.NetException;
import util.resultmessage.ResultMessage_Credit;
import vo.credit.CreditVO;

/**
 * Created by heleninsa on 2016/12/25.
 */
public class Credit_Driver {

    public static void main(String[] args) {

        try {
            CreditBLService service = ControllerFactory.getCreditBLServiceInstance();
            drive(service);
        } catch (NetException e) {
            System.out.println("Net Error");
        }

    }

    public static void drive(CreditBLService credit_service) throws NetException {
        ArrayList<CreditVO> vos = credit_service.checkCreditRecord("test_client");
        System.out.println("当前记录条数： " + vos.size());
        CreditVO updateVO = new CreditVO("test_client", Time.getCurrentTime(), 1000, 1000 + vos.get(0).credit, CreditChangeAction.Deposit, "");
        ResultMessage_Credit result = credit_service.creditUpdate(updateVO);
        System.out.println("Update Result : " + result.toString());
        vos = credit_service.checkCreditRecord("test_client");
        System.out.println("当前记录条数： " + vos.size());
    }

}
