package factory.datahelper;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.hoteldataservice.HotelDataService;
import po.HotelEvaluationPO;
import po.HotelPO;
import util.SearchCondition;

public class HotelDataHelper implements HotelDataService{
	
	private HotelDataService hotel_service;
	
	public HotelDataHelper(HotelDataService hotel_service) {
		this.hotel_service = hotel_service;
	}

	@Override
	public HotelPO findHotelData(String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HotelPO> findHotelListData(SearchCondition sc) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateHotelData(HotelPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertHotelEvaluation(HotelEvaluationPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertHotel(HotelPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<HotelEvaluationPO> findHotelEvaluation(String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
