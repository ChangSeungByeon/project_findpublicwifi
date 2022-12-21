package DB;

public class ttest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Service sv = new Service();
//		
		
//		sv.dbInsert_WIFILIST_API();
		
		int temp = sv.dbSelect_DISTANCE_same(37.5030426,127.041563);
		
		System.out.println(temp);
		
//		System.out.println(sv.dbDelete_WIFILIST());
		
//		sv.dbDelete_MEMBER(7);
		
//		sv.dbDelete_all("MEMBER");
		
//		sv.dbInsert_DISTANCE(4.2, 4.4);
//		System.out.println( sv.dbSelect_DISTANCE_same(4.2, 4.4));
//		System.out.println(sv.dbSelect_DISTANCE(4.2, 4.3));
		

	}

}
