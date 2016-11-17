package userbl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.usebl.Marketer.Marketer;
import vo.MarketerVO;

public class MarketerBlTest {
	MarketerVO vo;
	Marketer marketer;
	
	@Before
	public void init(){
		vo = new MarketerVO("0000000001", "admin", "123456789");
		marketer = new Marketer();
	}
	
	@Test
	public void testShowData(){
		String marketerID = vo.marketerID;
		MarketerVO vo = marketer.showData(marketerID);
		assertEquals(this.vo.marketername, vo.marketername);
	}
}
