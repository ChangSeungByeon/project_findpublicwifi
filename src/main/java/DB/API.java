package DB;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class API {
//
//	TODO API 로부터 자료 받기 
//	TODO 하나씩 열로 반환하기 
//	TODO 하나씩 객체 만들기
//	TODO 디비에 추가하기
	
	public int getDatalength() {
		String tempData = datatostring(1,1);
		
	    JsonParser parser = new JsonParser();
	    JsonElement element = parser.parse(tempData);
	
	    int result = Integer.parseInt(element.getAsJsonObject().get("TbPublicWifiInfo").getAsJsonObject().get("list_total_count").getAsString());

	    return result;
		
		
	}
	
	
	public String datatostring(int start, int end)  {
		
		BufferedReader rd = null;
		HttpURLConnection conn = null;
		String result;
		
		
		try {
		
		/*URL*/
			StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088");
			urlBuilder.append("/" + URLEncoder.encode("6252465a58636b6432387952614f6c","UTF-8") ); /*인증키 (sample사용시에는 호출시 제한됩니다.)*/
			urlBuilder.append("/" + URLEncoder.encode("json","UTF-8") ); /*요청파일타입 (xml,xmlf,xls,json) */
			urlBuilder.append("/" + URLEncoder.encode("TbPublicWifiInfo","UTF-8")); /*서비스명 (대소문자 구분 필수입니다.)*/
			urlBuilder.append("/" + URLEncoder.encode(start+"","UTF-8")); /*요청시작위치 (sample인증키 사용시 5이내 숫자)*/
			urlBuilder.append("/" + URLEncoder.encode(end+"","UTF-8")); /*요청종료위치(sample인증키 사용시 5이상 숫자 선택 안 됨)*/
			// 상위 5개는 필수적으로 순서바꾸지 않고 호출해야 합니다.
			// 서비스별 추가 요청 인자이며 자세한 내용은 각 서비스별 '요청인자'부분에 자세히 나와 있습니다.
			urlBuilder.append("/" + URLEncoder.encode("20220301","UTF-8")); /* 서비스별 추가 요청인자들*/
			URL url = new URL(urlBuilder.toString());
			 
			
			
			conn = (HttpURLConnection) url.openConnection(); 
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/xml"); 
			System.out.println("Response code: " + conn.getResponseCode()); /* 연결
			자체에 대한 확인이 필요하므로 추가합니다.*/ 
			
			
			// 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream())); 
				}
			
			StringBuilder sb = new StringBuilder(); 
			String line;
			
			while ((line = rd.readLine()) != null) {
//				System.out.println(line);
				sb.append(line); 
				}
			
			result = sb.toString();
			
			
		}catch(IOException e) {
			throw new RuntimeException(e);
		}finally {
			
			try {
				if(rd!=null) {
					rd.close();
				}
			}catch(IOException e) {
				throw new RuntimeException(e);
				
			}
			
			try {
				if(conn!=null) {
					conn.disconnect();
				}
			}catch(Exception e) {
				throw new RuntimeException(e);
				
			}

		}
		
		
		return result;
		
		
	}
	
	
}
