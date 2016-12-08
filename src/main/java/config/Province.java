package config;

import java.util.ArrayList;
import java.util.Iterator;

public class Province {
	
	private static ArrayList<Province> provinces;
	
	public static void init(ArrayList<Province> p_List) {
		provinces = p_List;
	}
	
	public static Iterator<Province> getProvince() {
		if(provinces == null) {
			provinces = PlaceConfig.getProvince();
		}
		return provinces.iterator();
	}
	
	private ArrayList<City> cities;
	
	private String provinceName;
	
	public Province(String provinceName, ArrayList<City> cities) {
		this.cities = cities;
		this.provinceName = provinceName;
	}
	
	public Iterator<City> getCity() {
		return this.cities.iterator();
	}

	public String getProvinceName() {
		return this.provinceName;
	}
	
}
