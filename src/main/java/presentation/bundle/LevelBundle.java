package presentation.bundle;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ResourceBundle;

public class LevelBundle extends ResourceBundle{
	private ArrayList<Integer> credit;
	private ArrayList<Double> discount;
	
	private final static String CREDIT="credit_list";
	private final static String DISCOUNT= "discount_list";
	
	public LevelBundle(ArrayList<Integer> credit, ArrayList<Double> discount) {
		// 初始化
		this.credit=credit;
		this.discount=discount;
	}
	
	@Override
	protected Object handleGetObject(String key) {
		// TODO Auto-generated method stub
		if(CREDIT.equals(key)){
			return  credit;
		}
		else if(DISCOUNT.equals(key)){
			return discount;
		}
		return null;
	}

	@Override
	public Enumeration<String> getKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}
