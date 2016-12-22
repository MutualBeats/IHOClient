package util.resultmessage;

public enum ResultMessage_Verify {

	USER_NOT_EXIST,

	PASSWORD_WRONG,

	USER_EXIST_ALREADY,

	CLIENT {
		@Override
		public String toString() {
			return "用户";
		}
	},

	STAFF {
		@Override
		public String toString() {
			return "酒店工作人员";
		}
	},

	MARKETER {
		@Override
		public String toString() {
			return "网站营销人员";
		}
	},

	MANAGER {
		@Override
		public String toString() {
			return "网管";
		}
	},

	NET_ERROR,
}
