package driver;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogicservice.roomblservice.RoomBLService;
import util.exception.NetException;

/**
 * Created by heleninsa on 2016/12/25.
 */
public class Room_Driver {

    public static void main(String[] args) {

        try {
            RoomBLService service = ControllerFactory.getRoomBLServiceInstance();
            drive(service);
        } catch (NetException e) {
            e.printStackTrace();
        }

    }

    public static void drive(RoomBLService service) throws NetException {



    }

}
