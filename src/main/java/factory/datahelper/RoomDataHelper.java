package factory.datahelper;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.roomdataservice.RoomDataService;
import po.RoomPO;

/**
 * @author Saltwater
 * @version 1.0
 */
public class RoomDataHelper implements RoomDataService{
	
	private RoomDataService room_service;
	
	/**
	 * @param room_service
	 */
	public RoomDataHelper(RoomDataService room_service) {
		super();
		this.room_service = room_service;
	}

	@Override
	public ArrayList<RoomPO> find(String HotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(RoomPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(RoomPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
