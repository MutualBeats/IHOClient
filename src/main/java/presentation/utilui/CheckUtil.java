package presentation.utilui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import javafx.util.StringConverter;

/**
 * 
 * 用于界面输入以及界面检查的工具类
 * 
 * @author heleninsa
 *
 */
public class CheckUtil {

	/* 筛选 */
	private final static Pattern pattern = Pattern.compile("[\\s]*");
	private final static Pattern point_pattern = Pattern.compile("^\\d+(\\.\\d+)?$");
	private final static Pattern value_pattern = Pattern.compile("^[0-9]\\d*$");

	/**
	 * 检查是否有过警告
	 * 
	 * @param warning_label
	 *            : 警告显示的Label
	 * @return
	 */
	public static boolean checkWarningBefore(Label warning_label) {
		String warning = warning_label.getText();
		if (warning.length() != 0) {
			warning_label.setText("");
			return true;
		}
		return false;
	}

	/**
	 * 检查输入价格是否为正整数
	 * 
	 * @param value
	 * @return
	 */
	public static boolean checkValue(String value) {
		return value_pattern.matcher(value).matches();
	}

	/**
	 * 检查评分是否为正double
	 * 
	 * @param score
	 * @return
	 */
	public static boolean checkScore(String score) {
		return point_pattern.matcher(score).matches();
	}

	/**
	 * 检查折扣是否符合0～10
	 * 
	 * @param discount
	 * @return
	 */
	public static boolean checkDiscount(String discount) {
		if (point_pattern.matcher(discount).matches()) {
			double dis = Double.parseDouble(discount);
			if (dis > 10 || dis <= 0) {
				return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * 检查是否选中
	 * 
	 * @param comboBox
	 * @return
	 */
	public static boolean checkSelect(ComboBox<?> comboBox) {
		return comboBox.getSelectionModel().getSelectedIndex() != -1;
	}

	public static boolean checkText(TextField text) {
		String content = text.getText();
		return !pattern.matcher(content).matches();
	}

	public static boolean checkText(TextArea text) {
		String content = text.getText();
		return !pattern.matcher(content).matches();
	}

	public static boolean checkSelect(DatePicker picker) {
		String date = picker.getEditor().getText();
		return date.length() == 0;
	}

	public static boolean checkSelect(TableView<?> tableView) {
		return tableView.getSelectionModel().getSelectedIndex() != -1;
	}

	public static boolean checkDiscount(ArrayList<Double> discount_list) {
		ArrayList<Double> list = new ArrayList<>();
		list.addAll(discount_list);
		Collections.sort(list);
		int size = discount_list.size();
		for (int i = 0; i < size; i++) {
			if (discount_list.get(i) != list.get(size - i - 1)) {
				return false;
			}
		}
		return true;
	}

	private static String get_two_bits(int value) {
		if (value > 99) {
			return "";
		} else {
			if ((int) (value / 10) == 0) {
				return "0" + value;
			} else {
				return "" + value;
			}
		}
	}

	/**
	 * 获取Converter
	 * 
	 * @return
	 */
	public static StringConverter<LocalDate> getConverter() {
		StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/mm/dd");

			@Override
			public String toString(LocalDate date) {
				if (date != null) {
					return date.getYear() + "/" + get_two_bits(date.getMonthValue()) + "/"
							+ get_two_bits(date.getDayOfMonth());
					// return date.toString();
				} else {
					return "";
				}
			}

			@Override
			public LocalDate fromString(String string) {
				if (string != null && !string.isEmpty()) {
					return LocalDate.parse(string, dateFormatter);
				} else {
					return null;
				}
			}
		};
		return converter;
	}

	/**
	 * 入住和离开日期的DatePicker的初始化
	 * 
	 * @param checkInDatePicker
	 * @param checkOutDatePicker
	 * @param s
	 * @param e
	 */
	public static void inAndOutDatePickerInit(DatePicker checkInDatePicker, DatePicker checkOutDatePicker, LocalDate s,
			LocalDate e) {

		checkInDatePicker.setConverter(getConverter());
		checkOutDatePicker.setConverter(getConverter());

		checkInDatePicker.setValue(s);
		checkOutDatePicker.setValue(checkInDatePicker.getValue().plusDays(1));

		// First day factory
		final Callback<DatePicker, DateCell> dayCellFactory2 = new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(final DatePicker datePicker) {
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);

						if (item.isBefore(LocalDate.now())) {
							setDisable(true);
							setStyle("-fx-background-color: #ffc0cb;");
						}

						checkOutDatePicker.setValue(checkInDatePicker.getValue().plusDays(1));
					}
				};
			}
		};

		// Second day cell
		final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(final DatePicker datePicker) {
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);
						// 设置out比in晚
						if (item.isBefore(checkInDatePicker.getValue().plusDays(1))) {
							setDisable(true);
							setStyle("-fx-background-color: #ffc0cb;");
						}
					}
				};
			}
		};

		checkInDatePicker.setDayCellFactory(dayCellFactory2);
		checkOutDatePicker.setDayCellFactory(dayCellFactory);

	}

}
