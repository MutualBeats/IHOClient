package bl_test.creditbl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.creditbl.Credit;
import util.credit.CreditChangeAction;
import util.exception.NetException;
import vo.credit.CreditVO;

public class CreditBLTest {
	
	private Credit credit;
	
	@Before
	public void init() {
		try {
			// TODO
			credit = new Credit();
		} catch (NetException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCheckCredit() {
		try {
			ArrayList<CreditVO> creditList = credit.checkCreditRecord("huangxiao");
			assertNotNull(creditList);
			if(creditList.size() == 0)
				fail();
			assertEquals(CreditChangeAction.Register, creditList.get(creditList.size() - 1).action);
		} catch (NetException e) {
			System.err.println("Please check the Internet");
		}
	}
	
	
}
