package util;

public enum ResultMessage_For_User {
	LoginSuccess,
	LoginFail,
	UserID_Invalid,//ID非法
	PasswordWrong,//密码错误
	Account_Not_Exist,//账户不存在
	
	GetDataSuccess,
	GetDataFail,

	UpdateSuccess,
	UpdateFail,
	UserName_Invalid,
	Tel_Invalid,

	OriginalRegisterSuccess,
	BusinessRegisterSuccess,
	OriginalRegisterFail,
	BusinessRegisterFail,
	OriginalMember_Exist,
	BusinessMember_Exist,
	
	AddSucccess,
	AddFail,
	Account_Exist,
	
	Hotel_Not_Exist,
	Hotel_Have_Staff,
}
