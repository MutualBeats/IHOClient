/**
 * @author huangxiao
 * @version 2016年12月8日
 */
package data_test.promotion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import factory.datahelper.DataHelperFactory;
import factory.datahelper.PromotionDataHelper;
import util.resultmessage.ResultMessage_Promotion;

public class PromotionDataTest {

	private PromotionDataHelper promotion;
	
	@Before
	public void init() {
		try {
			promotion = DataHelperFactory.getDataFactoryHelperInstance().getPromotionDatabase();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeletePromotion() {
		ResultMessage_Promotion result;
		result = promotion.deletePromotion("abc");
		assertEquals(ResultMessage_Promotion.Promotion_Not_Exist, result);
		result = promotion.deletePromotion("000007");
		assertEquals(ResultMessage_Promotion.Delete_Successful, result);
	}
	
}
