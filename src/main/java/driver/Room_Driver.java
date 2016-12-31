package driver;

import java.util.ArrayList;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogicservice.roomblservice.RoomBLService;
import util.exception.NetException;
import util.resultmessage.ResultMessage_Room;
import util.room.RoomState;
import util.room.RoomType;
import vo.room.RoomRecordVO;
import vo.room.RoomVO;

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
        String hotel_id = "00000001";
        RoomVO room1 = new RoomVO(hotel_id, "3B346", RoomType.Four, 10000, RoomState.NotReserved);
        RoomVO room2 = new RoomVO(hotel_id, "3B347", RoomType.Four, 1000, RoomState.NotReserved);
        RoomVO room3 = new RoomVO(hotel_id, "3B348", RoomType.Four, 1000, RoomState.NotReserved);
        ArrayList<RoomVO> room_list = new ArrayList<>();
        room_list.add(room1);
        room_list.add(room2);
        room_list.add(room3);

        ArrayList<String> rooms_unimport = service.importRoom(room_list);
        System.out.println("未成功录入房间列表 ： ");
        for (String each : rooms_unimport) {
            System.out.println("   " + each);
        }
        System.out.println("==================");

        room_list = service.getRoomList(hotel_id);
        System.out.println("酒店房间列表 ： ");
        for (RoomVO each : room_list) {
            System.out.println("   " + each.roomNumber);
        }
        System.out.println("==================");

        RoomVO room_info = service.getRoomInfo(hotel_id, "3B346");
        System.out.println("房间信息 ：  \r\n" +
                "房间类型 ： " + room_info.type.toString() + "\r\n" +
                "房间价格 ： " + room_info.price);
        System.out.println("==================");
        System.out.println("酒店预定列表 ： ");
        ArrayList<RoomRecordVO> recordVOS = service.getOrderRecord(hotel_id, "3B346");
        for (RoomRecordVO each : recordVOS) {
            System.out.println("预定入住时间 ： " + each.checkInDate + "\r\n" +
                    "预定离开时间 ： " + each.estimateCheckOutDate);
        }

        RoomRecordVO vo = new RoomRecordVO("2016/12/25", "2016/12/30", "00000000000000001", hotel_id, "3B346");
        ResultMessage_Room result = service.addRecord(vo);
        System.out.println("房间记录添加结果 ： " + result.toString());

        result = service.checkIn(hotel_id, "3B346");
        System.out.println("入住结果 ： " + result.toString());

        result = service.checkOut(hotel_id, "3B346");
        System.out.println("退房结果 ： " + result.toString());
    }

}
