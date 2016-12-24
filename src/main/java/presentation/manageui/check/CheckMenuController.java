/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation.manageui.check;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import config.urlconfig.ManageUIURLConfig;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Window;
import presentation.bundle.ManageIDInputHandle;
import presentation.utilui.WindowGrab;
import vo.user.BaseVO;
import vo.user.ClientVO;
import vo.user.ManagerVO;
import vo.user.MarketerVO;
import vo.user.StaffVO;

/**
 * 
 * 查看人员信息界面控制器
 * 
 * @author heleninsa
 *
 */
public class CheckMenuController implements Initializable {

	@FXML
	private Label check_title;

	@FXML
	private Button cancel;

	@FXML
	private Button check_button;

	@FXML
	private Button search;

	@FXML
	private RadioButton total;

	@FXML
	private RadioButton client;

	@FXML
	private RadioButton staff;

	@FXML
	private RadioButton marketer;

	@FXML
	private TextField search_text;

	@FXML
	private TableView<BaseVO> people;

	@FXML
	private TableColumn<BaseVO, String> type;

	@FXML
	private TableColumn<BaseVO, String> id;

	@FXML
	private TableColumn<BaseVO, String> contact;

	@FXML
	private TableColumn<BaseVO, String> name;

    @FXML
    private Button addhotel;

    @FXML
    private Button addpeople;

    @FXML
    private Button peopleInfo;
	
    @FXML
    private Button change;
    
    @FXML
    private Button check;
    
	final ToggleGroup buttom_group = new ToggleGroup();

	/*界面缓存*/
	private ArrayList<ClientVO> clientVOs;
	private ArrayList<StaffVO> staffVOs;
	private ArrayList<MarketerVO> marketerVOs;

	private ObservableList<BaseVO> total_list = FXCollections.observableArrayList();
	private ObservableList<BaseVO> client_list = FXCollections.observableArrayList();
	private ObservableList<BaseVO> staff_list = FXCollections.observableArrayList();
	private ObservableList<BaseVO> marketer_list = FXCollections.observableArrayList();

	private ManagerVO managerInfo;

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		clientVOs = (ArrayList<ClientVO>) resources.getObject("client");
		staffVOs = (ArrayList<StaffVO>) resources.getObject("staff");
		marketerVOs = (ArrayList<MarketerVO>) resources.getObject("marketer");
		managerInfo = (ManagerVO) resources.getObject("manager");

		client_list.addAll(clientVOs);
		staff_list.addAll(staffVOs);
		marketer_list.addAll(marketerVOs);
		total_list.add(managerInfo);
		total_list.addAll(marketer_list);
		total_list.addAll(staff_list);
		total_list.addAll(client_list);

		// Default
		people.setItems(total_list);

		init();
	}

	private void init() {
		// Init group
		total.setToggleGroup(buttom_group);
		client.setToggleGroup(buttom_group);
		marketer.setToggleGroup(buttom_group);
		staff.setToggleGroup(buttom_group);
		total.setSelected(true);
	
		buttom_group.selectedToggleProperty()
				.addListener((ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) -> {
					if (buttom_group.getSelectedToggle() != null) {
						Toggle toggle = buttom_group.getSelectedToggle();
						if (toggle == total) {
							people.setItems(total_list);
						} else if (toggle == client) {
							people.setItems(client_list);
						} else if (toggle == staff) {
							people.setItems(staff_list);
						} else {
							people.setItems(marketer_list);
						}
					}
				});
		
		//Init table column
		type.setCellValueFactory(cellData->cellData.getValue().getType_property());
		id.setCellValueFactory(cellData->cellData.getValue().getId_property());
		contact.setCellValueFactory(cellData->cellData.getValue().getContact_property());
		name.setCellValueFactory(cellData->cellData.getValue().getName_property());
	}

	

	@FXML
	void on_check(ActionEvent event) {
		BaseVO info = people.getSelectionModel().getSelectedItem();
		Window window = WindowGrab.getWindow(event);
		if (info != null) {
			switch (info.type) {
			case CLIENT:
				WindowGrab.openClientInformation(info, window);
				break;
			case MARKETER:
				WindowGrab.openMarketerInformation(info, window);
				break;
			case MANAGER:
				WindowGrab.openManageInformation(info, window);
				break;
			case STAFF:
				WindowGrab.openStaffInformation(info, window);
				break;
			default:
				return;
			}
		} else {
			WindowGrab.startErrorWindow(window, "请选择需查看人员");
		}
	}

	@FXML
	void on_search(ActionEvent event) {
		ObservableList<BaseVO> satisfy = null;
		Toggle toggle = buttom_group.getSelectedToggle();
		String filter = search_text.getText();
		if (toggle != null) {
			if (toggle == total) {
				satisfy = getSatisfyList(total_list.iterator(), filter);
			} else if (toggle == client) {
				satisfy = getSatisfyList(client_list.iterator(), filter);
			} else if (toggle == staff) {
				satisfy = getSatisfyList(staff_list.iterator(), filter);
			} else {
				satisfy = getSatisfyList(marketer_list.iterator(), filter);
			}
		}

		people.setItems(satisfy);
	}

	private ObservableList<BaseVO> getSatisfyList(Iterator<BaseVO> iterator, String filter) {
		ObservableList<BaseVO> baseVOs = FXCollections.observableArrayList();
		while (iterator.hasNext()) {
			BaseVO each = iterator.next();
			if (each.id.contains(filter) || each.name.contains(filter)) {
				baseVOs.add(each);
			}
		}
		return baseVOs;
	}
	
	//界面跳转
	@FXML
    void peopleInfo(ActionEvent event) {
		WindowGrab.changeScene(ManageUIURLConfig.manage_menu_fxml(), ManageUIURLConfig.manage_menu_css(), event);
    }


    @FXML
    void add_people(ActionEvent event) {
    	WindowGrab.changeScene(ManageUIURLConfig.manage_add_people_fxml(), ManageUIURLConfig.manage_add_people_css(), event);
    }

    @FXML
    void add_hotel(ActionEvent event) {
    	WindowGrab.changeScene(ManageUIURLConfig.manage_add_hotel_one_fxml(), ManageUIURLConfig.manage_add_hotel_one_css(), event);
    }

    @FXML
    void on_change(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
		WindowGrab.startIDInputWindow(window, new ManageIDInputHandle());
    }

}
