package util.user;

public enum MemberType {
	Not {
		@Override
		public String toString() {
			return "非会员";
		}
	},
	Ordinary {
		@Override
		public String toString() {
			return "普通会员";
		}
	},
	Enterprise {
		@Override
		public String toString() {
			return "企业会员";
		}
	}
}
