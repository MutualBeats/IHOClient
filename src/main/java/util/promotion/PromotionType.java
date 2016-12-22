/**
 * @author huangxiao
 * @version 2016年12月6日
 */
package util.promotion;

public enum PromotionType {
	Birthday {
		@Override
		public String toString() {
			return "生日特惠折扣";
		}
	}, 
	
	Room {
		@Override
		public String toString() {
			return "三间以上预订折扣";
		}
	},
	
	Holiday {
		@Override
		public String toString() {
			return "普通限时折扣";
		}
	},
	
	Enterprise {
		@Override
		public String toString() {
			return "合作企业客户折扣";
		}
	},
	
	BusinessDistrict {
		@Override
		public String toString() {
			return "商圈专属折扣";
		}
	},

}
