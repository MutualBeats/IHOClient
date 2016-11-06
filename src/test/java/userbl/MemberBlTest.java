package userbl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.usebl.client.Member;
import util.ResultMessage;
import vo.MemberVO;

public class MemberBlTest {

	MemberVO vo;
	Member member;
	
	@Before
	public void init(){
		vo = new MemberVO("12345678", "NJU", 1);
		member = new Member();
	}
	
	@Test
	public void testbusinessRegister(){
		assertEquals(ResultMessage.RegisterSuccess, member.businessRegister(this.vo));
	}
	
	@Test
	public void testoriginalRegister(){
		assertEquals(ResultMessage.RegisterSuccess, member.originalRegister(this.vo));
	}
	
	@Test
	public void testget(){
		String memberID = vo.memberID;
		MemberVO vo = member.get(memberID);
		assertEquals(this.vo.memberMessage, vo.memberMessage);
	}
	
	@Test
	public void testlevelUpdate(){
		assertEquals(ResultMessage.UpdateSucceed, member.levelUpdate(new ArrayList<Integer>(), 1));
	}
	
	@Test
	public void testupdate(){
		String memberID = vo.memberID;
		assertEquals(ResultMessage.UpdateSucceed, member.update(memberID, vo));
	}
}
