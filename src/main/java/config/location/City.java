package config.location;

import java.util.ArrayList;

public class City {
	
	private ArrayList<Field> fields ;
	
	private String city_name;
	
	public City(String city_name, ArrayList<Field> fields) {
		this.fields = fields;
		this.city_name = city_name;
	}

	public ArrayList<Field> getField() {
		return fields;
	}

	public String getCity_name() {
		return city_name;
	}
	
	@Override
	public String toString() {
		return city_name;
	}

}
