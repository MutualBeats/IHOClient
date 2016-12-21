package urlconfig_test;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

import config.urlconfig.*;

public class URLConfigTest {
	//assertEquals(new URL("file:src/main/resources/ui/"), UIURLConfig);
	
	@Test
	public void LoginUIURLConfigTest() throws MalformedURLException{
		assertEquals(new URL("file:src/main/resources/ui/loginui/fxml/login.fxml"), LoginUIURLConfig.login_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/loginui/css/login.css"), LoginUIURLConfig.login_css_url());
		assertEquals(new URL("file:src/main/resources/ui/loginui/fxml/signin.fxml"), LoginUIURLConfig.signin_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/loginui/css/signin.css"), LoginUIURLConfig.signin_css_url());
	}
	
	@Test
	public void UtilUIURLConfigTest() throws MalformedURLException{
		assertEquals(new URL("file:src/main/resources/ui/utilui/fxml/confirm.fxml"), UtilUIURLConfig.confirm_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/utilui/css/confirm.css"), UtilUIURLConfig.confirm_css_url());
		assertEquals(new URL("file:src/main/resources/ui/utilui/fxml/error.fxml"), UtilUIURLConfig.error_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/utilui/css/error.css"), UtilUIURLConfig.error_css_url());
		assertEquals(new URL("file:src/main/resources/ui/utilui/fxml/notice.fxml"), UtilUIURLConfig.notice_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/utilui/css/notice.css"), UtilUIURLConfig.notice_css_url());
		assertEquals(new URL("file:src/main/resources/ui/utilui/fxml/order_information.fxml"), UtilUIURLConfig.order_info_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/utilui/css/order_information.css"), UtilUIURLConfig.order_info_css_url());
	}
	
	@Test
	public void ClientUIURLConfigTest() throws MalformedURLException{
		assertEquals(new URL("file:src/main/resources/ui/clientui/fxml/browse_order.fxml"), ClientUIURLConfig.client_browse_order_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/clientui/css/browse_order.css"), ClientUIURLConfig.client_browse_order_css_url());
		assertEquals(new URL("file:src/main/resources/ui/clientui/fxml/change.fxml"), ClientUIURLConfig.client_change_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/clientui/css/change.css"), ClientUIURLConfig.client_change_css_url());
		assertEquals(new URL("file:src/main/resources/ui/clientui/fxml/check.fxml"), ClientUIURLConfig.client_check_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/clientui/css/check.css"), ClientUIURLConfig.client_check_css_url());
		assertEquals(new URL("file:src/main/resources/ui/clientui/fxml/clientmenu.fxml"), ClientUIURLConfig.client_menu_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/clientui/css/clientmenu.css"), ClientUIURLConfig.client_menu_css_url());
		assertEquals(new URL("file:src/main/resources/ui/clientui/fxml/create_order_confirm.fxml"), ClientUIURLConfig.client_create_order_confirm_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/clientui/css/create_order_confirm.css"), ClientUIURLConfig.client_create_order_confirm_css_url());
		assertEquals(new URL("file:src/main/resources/ui/clientui/fxml/credit.fxml"), ClientUIURLConfig.client_credit_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/clientui/css/credit.css"), ClientUIURLConfig.client_credit_css_url());
		assertEquals(new URL("file:src/main/resources/ui/clientui/fxml/evaluate_hotel.fxml"), ClientUIURLConfig.client_evaluate_hotel_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/clientui/css/evaluate_hotel.css"), ClientUIURLConfig.client_evaluate_hotel_css_url());
		assertEquals(new URL("file:src/main/resources/ui/clientui/fxml/executed_check.fxml"), ClientUIURLConfig.client_executed_check_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/clientui/css/executed_check.css"), ClientUIURLConfig.client_executed_check_css_url());
		assertEquals(new URL("file:src/main/resources/ui/clientui/fxml/hotel_info.fxml"), ClientUIURLConfig.client_hotel_info_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/clientui/css/hotel_info.css"), ClientUIURLConfig.client_hotel_info_css_url());
		assertEquals(new URL("file:src/main/resources/ui/clientui/fxml/hotel_list.fxml"), ClientUIURLConfig.client_hotel_list_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/clientui/css/hotel_list.css"), ClientUIURLConfig.client_hotel_list_css_url());
		assertEquals(new URL("file:src/main/resources/ui/clientui/fxml/maintain_message.fxml"), ClientUIURLConfig.client_maintain_message_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/clientui/css/maintain_message.css"), ClientUIURLConfig.client_maintain_message_css_url());
		assertEquals(new URL("file:src/main/resources/ui/clientui/fxml/makeorder.fxml"), ClientUIURLConfig.client_make_order_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/clientui/css/makeorder.css"), ClientUIURLConfig.client_make_order_css_url());
		assertEquals(new URL("file:src/main/resources/ui/clientui/fxml/member.fxml"), ClientUIURLConfig.client_member_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/clientui/css/member.css"), ClientUIURLConfig.client_member_css_url());
		assertEquals(new URL("file:src/main/resources/ui/clientui/fxml/revoke_order.fxml"), ClientUIURLConfig.client_revoke_order_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/clientui/css/revoke_order.css"), ClientUIURLConfig.client_revoke_order_css_url());
		assertEquals(new URL("file:src/main/resources/ui/clientui/fxml/search_hotel.fxml"), ClientUIURLConfig.client_search_hotel_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/clientui/css/search_hotel.css"), ClientUIURLConfig.client_search_hotel_css_url());
	}
	
	@Test
	public void StaffUIURLConfigTest() throws MalformedURLException{
		assertEquals(new URL("file:src/main/resources/ui/staffui/fxml/enterprise_input.fxml"), StaffUIURLConfig.staff_enterprise_input_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/staffui/css/enterprise_input.css"), StaffUIURLConfig.staff_enterprise_input_css_url());
		assertEquals(new URL("file:src/main/resources/ui/staffui/fxml/hotel_promotion_change.fxml"), StaffUIURLConfig.staff_hotel_promotion_change_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/staffui/css/hotel_promotion_change.css"), StaffUIURLConfig.staff_hotel_promotion_change_css_url());
		assertEquals(new URL("file:src/main/resources/ui/staffui/fxml/hotel_promotion_check.fxml"), StaffUIURLConfig.staff_hotel_promotion_check_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/staffui/css/hotel_promotion_check.css"), StaffUIURLConfig.staff_hotel_promotion_check_css_url());
		assertEquals(new URL("file:src/main/resources/ui/staffui/fxml/hotel_promotion_create.fxml"), StaffUIURLConfig.staff_hotel_promotion_create_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/staffui/css/hotel_promotion_create.css"), StaffUIURLConfig.staff_hotel_promotion_create_css_url());
		assertEquals(new URL("file:src/main/resources/ui/staffui/fxml/hotel_promotion.fxml"), StaffUIURLConfig.staff_hotel_promotion_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/staffui/css/hotel_promotion.css"), StaffUIURLConfig.staff_hotel_promotion_css_url());
		assertEquals(new URL("file:src/main/resources/ui/staffui/fxml/maintain_hotel.fxml"), StaffUIURLConfig.staff_maintain_hotel_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/staffui/css/maintain_hotel.css"), StaffUIURLConfig.staff_maintain_hotel_css_url());
		assertEquals(new URL("file:src/main/resources/ui/staffui/fxml/order_check.fxml"), StaffUIURLConfig.staff_order_check_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/staffui/css/order_check.css"), StaffUIURLConfig.staff_order_check_css_url());
		assertEquals(new URL("file:src/main/resources/ui/staffui/fxml/order_manage.fxml"), StaffUIURLConfig.staff_order_manage_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/staffui/css/order_manage.css"), StaffUIURLConfig.staff_order_manage_css_url());
		assertEquals(new URL("file:src/main/resources/ui/staffui/fxml/room_check.fxml"), StaffUIURLConfig.staff_room_check_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/staffui/css/room_check.css"), StaffUIURLConfig.staff_room_check_css_url());
		assertEquals(new URL("file:src/main/resources/ui/staffui/fxml/room_create.fxml"), StaffUIURLConfig.staff_room_create_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/staffui/css/room_create.css"), StaffUIURLConfig.staff_room_create_css_url());
		assertEquals(new URL("file:src/main/resources/ui/staffui/fxml/room_manage.fxml"), StaffUIURLConfig.staff_room_manage_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/staffui/css/room_manage.css"), StaffUIURLConfig.staff_room_manage_css_url());
		assertEquals(new URL("file:src/main/resources/ui/staffui/fxml/room_update.fxml"), StaffUIURLConfig.staff_room_update_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/staffui/css/room_update.css"), StaffUIURLConfig.staff_room_update_css_url());
		assertEquals(new URL("file:src/main/resources/ui/staffui/fxml/roomcreate_confirm.fxml"), StaffUIURLConfig.staff_room_create_confirm_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/staffui/css/roomcreate_confirm.css"), StaffUIURLConfig.staff_room_create_confirm_css_url());
		assertEquals(new URL("file:src/main/resources/ui/staffui/fxml/roomupdate_confirm.fxml"), StaffUIURLConfig.staff_room_update_confirm_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/staffui/css/roomupdate_confirm.css"), StaffUIURLConfig.staff_room_update_confirm_css_url());
		assertEquals(new URL("file:src/main/resources/ui/staffui/fxml/staff_main.fxml"), StaffUIURLConfig.staff_main_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/staffui/css/staff_main.css"), StaffUIURLConfig.staff_main_css_url());
	}
	
	@Test
	public void MarketUIURLConfigTest() throws MalformedURLException{
		assertEquals(new URL("file:src/main/resources/ui/marketui/fxml/appeal_credit.fxml"), MarketUIURLConfig.market_appeal_credit_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/marketui/css/appeal_credit.css"), MarketUIURLConfig.market_appeal_credit_css_url());
		assertEquals(new URL("file:src/main/resources/ui/marketui/fxml/credit_excute.fxml"), MarketUIURLConfig.market_credit_excute_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/marketui/css/credit_excute.css"), MarketUIURLConfig.market_credit_excute_css_url());
		assertEquals(new URL("file:src/main/resources/ui/marketui/fxml/field_promotion.fxml"), MarketUIURLConfig.market_field_promotion_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/marketui/css/field_promotion.css"), MarketUIURLConfig.market_field_promotion_css_url());
		assertEquals(new URL("file:src/main/resources/ui/marketui/fxml/marketmenu.fxml"), MarketUIURLConfig.market_market_menu_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/marketui/css/marketmenu.css"), MarketUIURLConfig.market_market_menu_css_url());
		assertEquals(new URL("file:src/main/resources/ui/marketui/fxml/member_level.fxml"), MarketUIURLConfig.market_member_level_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/marketui/css/member_level.css"), MarketUIURLConfig.market_member_level_css_url());
		assertEquals(new URL("file:src/main/resources/ui/marketui/fxml/promotion_check.fxml"), MarketUIURLConfig.market_promotion_check_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/marketui/css/promotion_check.css"), MarketUIURLConfig.market_promotion_check_css_url());
		assertEquals(new URL("file:src/main/resources/ui/marketui/fxml/time_promotion.fxml"), MarketUIURLConfig.market_time_promotion_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/marketui/css/time_promotion.css"), MarketUIURLConfig.market_time_promotion_css_url());
		assertEquals(new URL("file:src/main/resources/ui/marketui/fxml/unexecuted_order.fxml"), MarketUIURLConfig.market_unexecuted_order_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/marketui/css/unexecuted_order.css"), MarketUIURLConfig.market_unexecuted_order_css_url());
		assertEquals(new URL("file:src/main/resources/ui/marketui/fxml/unusual_order.fxml"), MarketUIURLConfig.market_unusual_order_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/marketui/css/unusual_order.css"), MarketUIURLConfig.market_unusual_order_css_url());
		assertEquals(new URL("file:src/main/resources/ui/marketui/fxml/web_promotion_choose.fxml"), MarketUIURLConfig.market_web_promotion_choose_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/marketui/css/web_promotion_choose.css"), MarketUIURLConfig.market_web_promotion_choose_css_url());
		assertEquals(new URL("file:src/main/resources/ui/marketui/fxml/web_promotion.fxml"), MarketUIURLConfig.market_web_promotion_fxml_url());
		assertEquals(new URL("file:src/main/resources/ui/marketui/css/web_promotion.css"), MarketUIURLConfig.market_web_promotion_css_url());
	}
	
	@Test
	public void ManageUIURLConfigTest() throws MalformedURLException{
		assertEquals(new URL("file:src/main/resources/ui/manageui/fxml/add_people_confirm.fxml"), ManageUIURLConfig.manage_add_people_confirm_fxml());
		assertEquals(new URL("file:src/main/resources/ui/manageui/css/add_people_confirm.css"), ManageUIURLConfig.manage_add_people_confirm_css());
		assertEquals(new URL("file:src/main/resources/ui/manageui/fxml/addhotel_one.fxml"), ManageUIURLConfig.manage_add_hotel_one_fxml());
		assertEquals(new URL("file:src/main/resources/ui/manageui/css/addhotel_one.css"), ManageUIURLConfig.manage_add_hotel_one_css());
		assertEquals(new URL("file:src/main/resources/ui/manageui/fxml/addhotel_three.fxml"), ManageUIURLConfig.manage_add_hotel_three_fxml());
		assertEquals(new URL("file:src/main/resources/ui/manageui/css/addhotel_three.css"), ManageUIURLConfig.manage_add_hotel_three_css());
		assertEquals(new URL("file:src/main/resources/ui/manageui/fxml/addhotel_two.fxml"), ManageUIURLConfig.manage_add_hotel_two_fxml());
		assertEquals(new URL("file:src/main/resources/ui/manageui/css/addhotel_two.css"), ManageUIURLConfig.manage_add_hotel_two_css());
		assertEquals(new URL("file:src/main/resources/ui/manageui/fxml/addpeople.fxml"), ManageUIURLConfig.manage_add_people_fxml());
		assertEquals(new URL("file:src/main/resources/ui/manageui/css/addpeople.css"), ManageUIURLConfig.manage_add_people_css());
		assertEquals(new URL("file:src/main/resources/ui/manageui/fxml/changemessage.fxml"), ManageUIURLConfig.manage_change_message_fxml());
		assertEquals(new URL("file:src/main/resources/ui/manageui/css/changemessage.css"), ManageUIURLConfig.manage_change_message_css());
		assertEquals(new URL("file:src/main/resources/ui/manageui/fxml/changemessageconfirm.fxml"), ManageUIURLConfig.manage_change_message_confirm_fxml());
		assertEquals(new URL("file:src/main/resources/ui/manageui/css/changemessageconfirm.css"), ManageUIURLConfig.manage_change_message_confirm_css());
		assertEquals(new URL("file:src/main/resources/ui/manageui/fxml/check_menu.fxml"), ManageUIURLConfig.manage_check_menu_fxml());
		assertEquals(new URL("file:src/main/resources/ui/manageui/css/check_menu.css"), ManageUIURLConfig.manage_check_menu_css());
		assertEquals(new URL("file:src/main/resources/ui/manageui/fxml/ID_input.fxml"), ManageUIURLConfig.manage_ID_input_fxml());
		assertEquals(new URL("file:src/main/resources/ui/manageui/css/ID_input.css"), ManageUIURLConfig.manage_ID_input_css());
		assertEquals(new URL("file:src/main/resources/ui/manageui/fxml/informationLook.fxml"), ManageUIURLConfig.manage_info_look_fxml());
		assertEquals(new URL("file:src/main/resources/ui/manageui/css/informationLook.css"), ManageUIURLConfig.manage_info_look_css());
		assertEquals(new URL("file:src/main/resources/ui/manageui/fxml/managemenu.fxml"), ManageUIURLConfig.manage_menu_fxml());
		assertEquals(new URL("file:src/main/resources/ui/manageui/css/managemenu.css"), ManageUIURLConfig.manage_menu_css());
	}
	
}