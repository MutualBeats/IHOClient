package util.room;

public enum RoomType {
	Single{
		@Override
		public String toString() {
			return "单人间";
		}
	},Double{
		@Override
		public String toString() {
			return "双人间";
		}
	},Triple{
		@Override
		public String toString() {
			return "三人间";
		}
	},Four{
		@Override
		public String toString() {
			return "四人间";
		}
	}, 
	ALL{
		@Override
		public String toString() {
			return "全部";
		}
	}
	
	
}
