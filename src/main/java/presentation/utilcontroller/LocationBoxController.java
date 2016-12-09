package presentation.utilcontroller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import config.StarConfig;
import config.location.City;
import config.location.Field;
import config.location.Province;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionModel;

/**
 * 
 * Abstract Controller For Box
 * 
 * 用于处理对应的地区 Combobox 的事件
 * 
 * @author heleninsa
 *
 */
public abstract class LocationBoxController implements Initializable {

	@FXML
	protected ComboBox<Province> province;

	@FXML
	protected ComboBox<Field> field;

	@FXML
	protected ComboBox<City> city;

	@FXML
	protected ComboBox<String> group;
	
	@FXML
	protected ComboBox<Integer> star;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initView();
	}
	
	private void initView() {
		province.getItems().addAll(Province.getProvince());
		star.getItems().addAll(StarConfig.STAR_SEPERATE);

		// Seperate
		SelectionModel<Province> pro_model = province.getSelectionModel();
		SelectionModel<City> city_model = city.getSelectionModel();
		SelectionModel<Field> field_model = field.getSelectionModel();
		pro_model.selectedItemProperty().addListener(new ChangeListener<Province>() {
			@Override
			public void changed(ObservableValue<? extends Province> observable, Province oldValue, Province newValue) {
				Province province = pro_model.getSelectedItem();
				if (province != null) {
					ArrayList<City> cities = province.getCity();
					city.getItems().clear();
					city.getItems().addAll(cities);
					field.getItems().clear();
					group.getItems().clear();
				}
			}
		});

		city_model.selectedItemProperty().addListener(new ChangeListener<City>() {
			@Override
			public void changed(ObservableValue<? extends City> observable, City oldValue, City newValue) {
				City city = city_model.getSelectedItem();
				if (city != null) {
					ArrayList<Field> fields = city.getField();
					field.getItems().clear();
					field.getItems().addAll(fields);
					group.getItems().clear();
				}
			}
		});

		field_model.selectedItemProperty().addListener(new ChangeListener<Field>() {
			@Override
			public void changed(ObservableValue<? extends Field> observable, Field oldValue, Field newValue) {
				Field field = field_model.getSelectedItem();
				if (field != null) {
					ArrayList<String> groups = field.getGroup();
					group.getItems().clear();
					group.getItems().addAll(groups);
				}
			}
		});

	}

}
