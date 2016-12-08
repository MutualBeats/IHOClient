package config.location;

import java.util.ArrayList;
import java.util.Iterator;

public class Field {
	
private ArrayList<String> group ;
	
	private String field_name;
	
	public Field(String field_name, ArrayList<String> group) {
		this.group = group;
		this.field_name = field_name;
	}

	public ArrayList<String> getGroup() {
		return group;
	}

	public String getField_name() {
		return field_name; 
	}
	
	
}
