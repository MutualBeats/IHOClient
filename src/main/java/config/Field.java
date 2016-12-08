package config;

import java.util.ArrayList;
import java.util.Iterator;

public class Field {
	
private ArrayList<String> group ;
	
	private String field_name;
	
	public Field(ArrayList<String> group) {
		this.group = group;
	}

	public Iterator<String> getGroup() {
		return group.iterator();
	}

	public String getField_name() {
		return field_name; 
	}
	
	
}
