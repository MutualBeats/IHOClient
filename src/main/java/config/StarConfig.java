package config;

import java.util.ArrayList;

public class StarConfig {
	
	public final static ArrayList<Integer> STAR_SEPERATE;
	
	public final static ArrayList<Integer> SCORE_SEPERATE;
	
	static {
		STAR_SEPERATE = new ArrayList<>();
		STAR_SEPERATE.add(1);
		STAR_SEPERATE.add(2);
		STAR_SEPERATE.add(3);
		STAR_SEPERATE.add(4);
		STAR_SEPERATE.add(5);
		
		SCORE_SEPERATE= new ArrayList<>();
		SCORE_SEPERATE.add(1);
		SCORE_SEPERATE.add(2);
		SCORE_SEPERATE.add(3);
		SCORE_SEPERATE.add(4);
		SCORE_SEPERATE.add(5);
	}
	
}
