package config.location;

import java.util.ArrayList;
import java.util.Iterator;

public class City {
	
	private ArrayList<Field> fields ;
	
	private String city_name;
	
	public City(String city_name, ArrayList<Field> fields) {
		this.fields = fields;
		this.city_name = city_name;
	}

	public Iterator<Field> getField() {
		return fields.iterator();
	}

	public String getCity_name() {
		return city_name;
	}
	
	

}
