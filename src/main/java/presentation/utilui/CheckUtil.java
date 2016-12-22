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

public class CheckUtil {

	private final static Pattern pattern = Pattern.compile("[\\s]*");
	private final static Pattern point_pattern = Pattern.compile("^\\d+(\\.\\d+)?$");
	private final static Pattern value_pattern = Pattern.compile("^[0-9]\\d*$");

	public static boolean checkWarningBefore(Label label) {
		String warning = label.getText();
		if (warning.length() != 0) {
			label.setText("");
			return true;
		}
		return false;
	}

	public static boolean checkValue(String value) {
		return value_pattern.matcher(value).matches();
	}

	public static boolean checkScore(String score) {
		return point_pattern.matcher(score).matches();
	}

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
		for(int i = 0; i < size; i ++ ) {
			if(discount_list.get(i) != list.get(size - i - 1)) {
				return false;
			}
		}
		return true;
	}
	
	private static String get_two_bits(int value) {
 		if(value > 99) {
 			return "";
 		} else {
 			if((int)(value/10) == 0) {
 				return "0" + value;
 			} else {
 				return "" + value;
 			}
 		}
	}
	
	public static StringConverter<LocalDate> getConverter() {
		StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/mm/dd");

			@Override
			public String toString(LocalDate date) {
				if (date != null) {
					return date.getYear() + "/" + get_two_bits(date.getMonthValue()) + "/" + get_two_bits(date.getDayOfMonth());
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
	
	public static void init(DatePicker checkInDatePicker, DatePicker checkOutDatePicker, LocalDate s, LocalDate e) {
		
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
