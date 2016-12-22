package util.resultmessage;

public enum ResultMessage_Verify {

	USER_NOT_EXIST,

	PASSWORD_WRONG,

	USER_EXIST_ALREADY,

	CLIENT {
		@Override
		public String toString() {
			return "-IHO-";
		}
	},

	STAFF {
		@Override
		public String toString() {
			return "酒店工作人员操作界面";
		}
	},

	MARKETER {
		@Override
		public String toString() {
			return "营销人员操作界面";
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
