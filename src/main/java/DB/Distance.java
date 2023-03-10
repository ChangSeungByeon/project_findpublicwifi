package DB;

public class Distance {
	
	double LAT;
	double LNT;
	
	Distance (double LAT, double LNT){
		this.LAT = LAT;
		this.LNT = LNT;
	}
	
	
	double distance(double lat2, double lon2) {
        double lat1 = this.LAT;
        double lon1 = this.LNT;
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
         
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
         
        
//        dist = dist * 1.609344;
        
 
        return (dist);
    }
     
 
    // This function converts decimal degrees to radians
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }
     
    // This function converts radians to decimal degrees
    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }

}
