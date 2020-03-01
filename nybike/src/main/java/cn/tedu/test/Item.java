package cn.tedu.test;

public class Item {
         private int sid;
         private int nba;
         private int nda;
         private double abi;
		public Item() {
		}
		public Item(int sid, int nba, int nda, double abi) {
			this.sid = sid;
			this.nba = nba;
			this.nda = nda;
			this.abi = abi;
		}
		public int getSid() {
			return sid;
		}
		public void setSid(int sid) {
			this.sid = sid;
		}
		public int getNba() {
			return nba;
		}
		public void setNba(int nba) {
			this.nba = nba;
		}
		public int getNda() {
			return nda;
		}
		public void setNda(int nda) {
			this.nda = nda;
		}
		public double getAbi() {
			return abi;
		}
		public void setAbi(double abi) {
			this.abi = abi;
		}
		@Override
		public String toString() {
			return "Item [sid=" + sid + ", nba=" + nba + ", nda=" + nda + ", abi=" + abi + "]";
		}
		
         
}
