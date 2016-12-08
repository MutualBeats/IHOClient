package config;

import java.util.ArrayList;
import java.util.Iterator;

public class City {
	
	private ArrayList<Field> fields ;
	
	private String city_name;
	
	public City(ArrayList<Field> fields) {
		this.fields = fields;
	}

	public Iterator<Field> getField() {
		return fields.iterator();
	}

	public String getCity_name() {
		return city_name;
	}
	
	

}
