package DB;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class JasonParser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		parseJSON();

	}
	

	public static void parseJSON(String json) {
//	    String json = "{\"name\":\"Dave\",\"department\":\"HR\",\"employeeNumber\":123}";
//		String json = "{"TbPublicWifiInfo":{"list_total_count":17768,"RESULT":{"CODE":"INFO-000","MESSAGE":"정상 처리되었습니다"},"row":[{"X_SWIFI_MGR_NO":"ARI00001","X_SWIFI_WRDOFC":"서대문구","X_SWIFI_MAIN_NM":"상수도사업본부","X_SWIFI_ADRES1":"서소문로 51","X_SWIFI_ADRES2":"본관 1F","X_SWIFI_INSTL_FLOOR":"","X_SWIFI_INSTL_TY":"7-1. 공공 - 행정","X_SWIFI_INSTL_MBY":"서울시(AP)","X_SWIFI_SVC_SE":"공공WiFi","X_SWIFI_CMCWR":"수도사업소자가망","X_SWIFI_CNSTC_YEAR":"2014","X_SWIFI_INOUT_DOOR":"실내","X_SWIFI_REMARS3":"","LAT":"37.561924","LNT":"126.96675","WORK_DTTM":"2022-12-16 10:58:08.0"},{"X_SWIFI_MGR_NO":"ARI00002","X_SWIFI_WRDOFC":"서대문구","X_SWIFI_MAIN_NM":"상수도사업본부","X_SWIFI_ADRES1":"서소문로 51","X_SWIFI_ADRES2":"본관 2F","X_SWIFI_INSTL_FLOOR":"","X_SWIFI_INSTL_TY":"7-1. 공공 - 행정","X_SWIFI_INSTL_MBY":"서울시(AP)","X_SWIFI_SVC_SE":"공공WiFi","X_SWIFI_CMCWR":"수도사업소자가망","X_SWIFI_CNSTC_YEAR":"2014","X_SWIFI_INOUT_DOOR":"실내","X_SWIFI_REMARS3":"","LAT":"37.561924","LNT":"126.96675","WORK_DTTM":"2022-12-16 10:58:08.0"},{"X_SWIFI_MGR_NO":"ARI00003","X_SWIFI_WRDOFC":"서대문구","X_SWIFI_MAIN_NM":"상수도사업본부","X_SWIFI_ADRES1":"서소문로 51","X_SWIFI_ADRES2":"본관 2F","X_SWIFI_INSTL_FLOOR":"","X_SWIFI_INSTL_TY":"7-1. 공공 - 행정","X_SWIFI_INSTL_MBY":"서울시(AP)","X_SWIFI_SVC_SE":"공공WiFi","X_SWIFI_CMCWR":"수도사업소자가망","X_SWIFI_CNSTC_YEAR":"2014","X_SWIFI_INOUT_DOOR":"실내","X_SWIFI_REMARS3":"","LAT":"37.561924","LNT":"126.96675","WORK_DTTM":"2022-12-16 10:58:08.0"},{"X_SWIFI_MGR_NO":"ARI00004","X_SWIFI_WRDOFC":"서대문구","X_SWIFI_MAIN_NM":"상수도사업본부","X_SWIFI_ADRES1":"서소문로 51","X_SWIFI_ADRES2":"본관 2F","X_SWIFI_INSTL_FLOOR":"","X_SWIFI_INSTL_TY":"7-1. 공공 - 행정","X_SWIFI_INSTL_MBY":"서울시(AP)","X_SWIFI_SVC_SE":"공공WiFi","X_SWIFI_CMCWR":"수도사업소자가망","X_SWIFI_CNSTC_YEAR":"2014","X_SWIFI_INOUT_DOOR":"실내","X_SWIFI_REMARS3":"","LAT":"37.561924","LNT":"126.96675","WORK_DTTM":"2022-12-16 10:58:08.0"},{"X_SWIFI_MGR_NO":"ARI00005","X_SWIFI_WRDOFC":"서대문구","X_SWIFI_MAIN_NM":"상수도사업본부","X_SWIFI_ADRES1":"서소문로 51","X_SWIFI_ADRES2":"본관 2F","X_SWIFI_INSTL_FLOOR":"","X_SWIFI_INSTL_TY":"7-1. 공공 - 행정","X_SWIFI_INSTL_MBY":"서울시(AP)","X_SWIFI_SVC_SE":"공공WiFi","X_SWIFI_CMCWR":"수도사업소자가망","X_SWIFI_CNSTC_YEAR":"2014","X_SWIFI_INOUT_DOOR":"실내","X_SWIFI_REMARS3":"","LAT":"37.561924","LNT":"126.96675","WORK_DTTM":"2022-12-16 10:58:08.0"}]}}";

	
	    JsonParser parser = new JsonParser();
	    JsonElement element = parser.parse(json);
	
//	    String name = element.getAsJsonObject().get("TbPublicWifiInfo").getAsJsonObject();
	    JsonElement name = element.getAsJsonObject().get("TbPublicWifiInfo").getAsJsonObject().get("row");
//	    String department = element.getAsJsonObject().get("X_SWIFI_WRDOFC").getAsString();
//	    String number =  element.getAsJsonObject().get("X_SWIFI_MAIN_NM").getAsString();
	    JsonArray arr = (JsonArray)name;
	    
	    
	    System.out.println("name=" + name);
	    System.out.println(arr.get(0));
	    System.out.println(((JsonElement)arr.get(0)).getAsJsonObject().get("X_SWIFI_WRDOFC"));
//	    System.out.println("department=" + department);
//	    System.out.println("number=" + number);
}

}




