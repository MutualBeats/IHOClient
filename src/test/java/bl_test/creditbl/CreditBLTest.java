package bl_test.creditbl;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bussinesslogic._test.Credit_Test;
import dataservice.creditdataservice.CreditDataServiceImpl_Stub;
import factory.datahelper.CreditDataHelper;
import util.ResultMessage_For_Stub;
import vo.credit.CreditVO;

public class CreditBLTest {
	
	private PrintStream err_console;
	private ByteArrayOutputStream err_content ;
	private PrintStream out_console;
	private ByteArrayOutputStream out_content ;
	private Credit_Test credit;
	
	@Before
	public void initConsoleStream() {
		err_console = System.err;
		err_content = new ByteArrayOutputStream();
		out_console = System.out;
		out_content = new ByteArrayOutputStream();
		// Error\Out 输出流重定向
		System.setErr(new PrintStream(err_content));
		System.setOut(new PrintStream(out_content));
		
		CreditDataHelper creditDataHelper = new CreditDataHelper(new CreditDataServiceImpl_Stub());
		credit = new Credit_Test(creditDataHelper);
	}
	
	@After
	public void finish() {
		//Default Error Out 
		System.setErr(err_console);
		System.setOut(out_console);
	}
	
	@Test
	public void creditIncreaseTest() {
		assertEquals(credit.increaseCredit("12345678", -10010), ResultMessage_For_Stub.CreditIncreaseFailed);
//		String errorInfo = err_content.toString();
//		assertEquals(errorInfo, "Error ! Value change of credit to increase must be positive !\r\n");
		assertEquals(credit.increaseCredit("12345678", 10010), ResultMessage_For_Stub.CreditIncreaseSuccess);
//		String okInfo = out_content.toString();
//		assertEquals(okInfo, "Find Succeed!\r\nInsert Succeed!\r\n");
//		credit.in
	}
	
	@Test
	public void creditDecreaseTest() {
		assertEquals(credit.decreaseCredit("12345678", 10010), ResultMessage_For_Stub.CreditDecreaseFailed);
//		String errorInfo = err_content.toString();
//		assertEquals(errorInfo, "Error ! Value change of credit to decrease must be negative !\r\n");
		assertEquals(credit.decreaseCredit("12345678", -10010), ResultMessage_For_Stub.CreditDecreaseSuccess);
//		String okInfo = out_content.toString();
//		assertEquals(okInfo, "Find Succeed!\r\nInsert Succeed!\r\n");
	}
	
	@Test
	public void creditFindTest() {
		Iterator<CreditVO> records = credit.checkCreditRecord("12345678");
		CreditVO newest = records.next();
		assertEquals(newest.credit, 300);
		assertEquals(newest.changeTime, "2016/10/16 11:30:24");
		assertEquals(newest.changeValue, 100);
	}
	
}
