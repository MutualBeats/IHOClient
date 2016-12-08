package config.location;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class PlaceConfig {
	
	private final static String length_cfg_path = "src/main/resources/config/place_config.xml";

	private final static String PROVINCE_NAME = "province_name";
	
	private final static String CITY_NAME = "city_name";
	
	private final static String FIELD_NAME = "field_name";
	
	private final static String GROUP_NAME = "group_name";
	
	
	public static ArrayList<Province> getProvince() {
		ArrayList<Province> provinces = new ArrayList<>();
		
		SAXReader reader = new SAXReader();
		File cfg_file = new File(length_cfg_path);
		try {
			Document document = reader.read(cfg_file);
			Element root = document.getRootElement();
			
			//Each province;
			@SuppressWarnings("unchecked")
			Iterator<Element> province_iterator = root.elementIterator("province");
			while(province_iterator.hasNext()) {
				Element each_pro = province_iterator.next();
				String pro_name = each_pro.attributeValue(PROVINCE_NAME);
				ArrayList<City> cities = getCity(each_pro);
				Province province = new Province(pro_name, cities);
				provinces.add(province);
			}
		}catch (DocumentException e) {
			e.printStackTrace();
		}
		return provinces;
	}
	
	public static ArrayList<City> getCity(Element province) {
		ArrayList<City> cities = new ArrayList<>();
		@SuppressWarnings("unchecked")
		Iterator<Element> city_iterator = province.elementIterator("city");
		while(city_iterator.hasNext()) {
			Element each_city = city_iterator.next();
			String city_name = each_city.attributeValue(CITY_NAME);
			ArrayList<Field> fields = getField(each_city);
			City city = new City(city_name, fields);
			cities.add(city);
		}
		return cities;
	}

	private static ArrayList<Field> getField(Element city) {
		ArrayList<Field> fields = new ArrayList<>();
		@SuppressWarnings("unchecked")
		Iterator<Element> field_iterator = city.elementIterator("field");
		while (field_iterator.hasNext()) {
			Element each_field = field_iterator.next();
			String field_name = each_field.attributeValue(FIELD_NAME);
			
			ArrayList<String> groups = new ArrayList<>();
			@SuppressWarnings("unchecked")
			Iterator<Element> group_iterator = each_field.elementIterator("group");
			while(group_iterator.hasNext()) {
				Element each_group = group_iterator.next();
				groups.add(each_group.attributeValue(GROUP_NAME));
			}
			
			Field field = new Field(field_name, groups);
			fields.add(field);
		}
		return fields;
	}
	
	public static void main(String[] args) {
		ArrayList<City> list = getProvince().get(0).getCity();
		
		System.out.println(list.get(1).getCity_name());
	}
	
}
