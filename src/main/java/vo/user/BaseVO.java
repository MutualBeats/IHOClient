package vo.user;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import util.resultmessage.ResultMessage_Verify;

public class BaseVO {
	
	private StringProperty id_property;
	private StringProperty name_property;
	private StringProperty contact_property;
	private StringProperty type_property;
	
	public void setNameProperty(String name) {
		this.name = name;
		name_property = new SimpleStringProperty(name);
	}
	
	public void setContactProperty(String contact) {
		contactWay = contact;
		contact_property = new SimpleStringProperty(contact);
	}
	
	public StringProperty getId_property() {
		return id_property;
	}

	public StringProperty getName_property() {
		return name_property;
	}

	public StringProperty getContact_property() {
		return contact_property;
	}

	public StringProperty getType_property() {
		return type_property;
	}

	/*
	 * 用户ID
	 */
	public String id;
	/*
	 * 用户姓名/名称
	 */
	public String name;
	/*
	 * 用户联系方式
	 */
	public String contactWay;
	
	public ResultMessage_Verify type;

	public BaseVO(String id, String name, String contactWay, ResultMessage_Verify type) {
		super();
		this.id = id;
		this.name = name;
		this.contactWay = contactWay;
		this.type = type;
		//Property
		id_property = new SimpleStringProperty(id);
		name_property = new SimpleStringProperty(name);
		contact_property = new SimpleStringProperty(contactWay);
		type_property = new SimpleStringProperty(type.toString());
	}
	
	
	
}
