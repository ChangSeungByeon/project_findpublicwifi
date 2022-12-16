package DB;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class Member_Wifi {
	@SerializedName("X_SWIFI_MGR_NO")
	private String ID_WIFI;
	@SerializedName("X_SWIFI_WRDOFC")
	private String GU;
	@SerializedName("X_SWIFI_MAIN_NM")
	private String NAME;
	@SerializedName("X_SWIFI_ADRES1")
	private String ADDRESS_STREET;
	@SerializedName("X_SWIFI_ADRES2")
	private String ADDRESS_SPECIFIC;
	@SerializedName("X_SWIFI_INSTL_FLOOR")
	private String FLOOR;
	@SerializedName("X_SWIFI_INSTL_TY")
	private String INSTALL_TYPE;
	@SerializedName("X_SWIFI_INSTL_MBY")
	private String INSTALL_TEAM;
	@SerializedName("X_SWIFI_SVC_SE")
	private String SERVICE_TYPE;
	@SerializedName("X_SWIFI_CMCWR")
	private String MANG;
	@SerializedName("X_SWIFI_CNSTC_YEAR")
	private String REGST_YEAR;
	@SerializedName("X_SWIFI_INOUT_DOOR")
	private String IN_OUT;
	@SerializedName("X_SWIFI_REMARS3")
	private String CIRCUM;
	@SerializedName("LAT")
	private float Y;
	@SerializedName("LNT")
	private float X;
	@SerializedName("WORK_DTTM")
	private String REGST_DATE;
	
	public String getID_WIFI() {
		return ID_WIFI;
	}
	public void setID_WIFI(String iD_WIFI) {
		ID_WIFI = iD_WIFI;
	}
	public String getGU() {
		return GU;
	}
	public void setGU(String gU) {
		GU = gU;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getADDRESS_STREET() {
		return ADDRESS_STREET;
	}
	public void setADDRESS_STREET(String aDDRESS_STREET) {
		ADDRESS_STREET = aDDRESS_STREET;
	}
	public String getADDRESS_SPECIFIC() {
		return ADDRESS_SPECIFIC;
	}
	public void setADDRESS_SPECIFIC(String aDDRESS_SPECIFIC) {
		ADDRESS_SPECIFIC = aDDRESS_SPECIFIC;
	}
	public String getFLOOR() {
		return FLOOR;
	}
	public void setFLOOR(String fLOOR) {
		FLOOR = fLOOR;
	}
	public String getINSTALL_TYPE() {
		return INSTALL_TYPE;
	}
	public void setINSTALL_TYPE(String iNSTALL_TYPE) {
		INSTALL_TYPE = iNSTALL_TYPE;
	}
	public String getINSTALL_TEAM() {
		return INSTALL_TEAM;
	}
	public void setINSTALL_TEAM(String iNSTALL_TEAM) {
		INSTALL_TEAM = iNSTALL_TEAM;
	}
	public String getSERVICE_TYPE() {
		return SERVICE_TYPE;
	}
	public void setSERVICE_TYPE(String sERVICE_TYPE) {
		SERVICE_TYPE = sERVICE_TYPE;
	}
	public String getMANG() {
		return MANG;
	}
	public void setMANG(String mANG) {
		MANG = mANG;
	}
	public String getREGST_YEAR() {
		return REGST_YEAR;
	}
	public void setREGST_YEAR(String rEGST_YEAR) {
		REGST_YEAR = rEGST_YEAR;
	}
	public String getIN_OUT() {
		return IN_OUT;
	}
	public void setIN_OUT(String iN_OUT) {
		IN_OUT = iN_OUT;
	}
	public String getCIRCUM() {
		return CIRCUM;
	}
	public void setCIRCUM(String cIRCUM) {
		CIRCUM = cIRCUM;
	}
	public float getY() {
		return Y;
	}
	public void setY(float y) {
		Y = y;
	}
	public float getX() {
		return X;
	}
	public void setX(float x) {
		X = x;
	}
	public String getREGST_DATE() {
		return REGST_DATE;
	}
	public void setREGST_DATE(String rEGST_DATE) {
		REGST_DATE = rEGST_DATE;
	}
	
	public boolean dbInsert_Itself() {
		
		Gson gson = new Gson();
		 
        String json = ;
        Member_Wifi mw = gson.fromJson(json, Member_Wifi.class);
        
        
//        System.out.println(animal);
// 
//        String reJson = gson.toJson(animal);
//        System.out.println(reJson);
		
		
		
		
		
		
		
	}

	

}
