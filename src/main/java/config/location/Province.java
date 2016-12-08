package config.location;

import java.util.ArrayList;

public class Province {
	
	private static ArrayList<Province> provinces;
	
	public static void init(ArrayList<Province> p_List) {
		provinces = p_List;
	}
	
	public static ArrayList<Province> getProvince() {
		if(provinces == null) {
			provinces = PlaceConfig.getProvince();
		}
		return provinces;
	}
	
	private ArrayList<City> cities;
	
	private String provinceName;
	
	public Province(String provinceName, ArrayList<City> cities) {
		this.cities = cities;
		this.provinceName = provinceName;
	}
	
	public ArrayList<City> getCity() {
		return this.cities;
	}

	public String getProvinceName() {
		return this.provinceName;
	}
	
	@Override
	public String toString() {
		return provinceName;
	}
	
}
