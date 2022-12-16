package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;



public class Service {
	
	public Boolean dbDelete_all(String dbName) {
		
		// JDBC 설정을 위해 필요한 것
//      1. ip(domain)
//      2. port
//      3. 계정
//      4. 패스워드
//      5. 인스턴스
  	String url = "jdbc:mariadb://localhost:3306/WIFI";
      String dbuUserId = "testuser";
      String dbPassword = "HighSec1911!WI";


      // 1. 드라이버 로드
      // 2. 커넥션 객체 생성
      // 3. Statement 객체 생성
      // 4. 쿼리 실행
      // 5. 결과 수행
      // 6. 객체 연결 해제 (close)

      try {
          Class.forName("org.mariadb.jdbc.Driver");
      } catch (ClassNotFoundException e) {
          throw new RuntimeException(e);
      }

      Connection connection = null;
      PreparedStatement preparedStatement = null;
      ResultSet rs = null;
      
      
      boolean result = true;

      try {
          connection = DriverManager.getConnection(url, dbuUserId, dbPassword); // 드라이브 매니저 호출

          String sql = "TRUNCATE ?";

          preparedStatement = connection.prepareStatement(sql);
          preparedStatement.setString(1, dbName);

          int affected = preparedStatement.executeUpdate();
          
          if(affected > 0){
              System.out.println("삭제 성공");
          }else{
              System.out.println("삭제 실패"); // 삭제할 내용이 없는 경우에도 실패로 뜬다.
              result = false;
          }


      } catch (SQLException e) {
          throw new RuntimeException(e);
      } finally {
          // finally 안에 아래와 같이 종료 상황을 넣는 이유는
          // 위 try(38행에서 시작하는) 부분에서 아래의 내용을 넣은 경우
          // 만일 도중에 rs closed 에서 오류가 발생하면
          // 다른 커넥션 close 구문을 실행되지 않는다.(필수적으로 닫아줘야하나 닫지 않음)
          // 따라서 finally 에서 아래와 같이 넣어주고 진행시킨다.


          try {
              if (rs != null && !rs.isClosed()) {
                  rs.close();
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
          try {
              if (preparedStatement != null && !preparedStatement.isClosed()) {
                  preparedStatement.close();
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
          try {
              if (connection != null && !connection.isClosed()) {
                  connection.close();
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
      
      
      return result;
		
	}
	
	
	public Boolean dbDelete_WIFILIST() {
		return dbDelete_all("WIFILIST");
    }
		
	public Boolean dbDelete_DISTANCE() {
		return dbDelete_all("DISTANCE");
    }
	
	public Boolean dbInsert_WIFILIST(Member_Wifi mw) {
		
		String url = "jdbc:mariadb://localhost:3306/WIFI";
        String dbuUserId = "testuser";
        String dbPassword = "HighSec1911!WI";

        // 1. 드라이버 로드
        // 2. 커넥션 객체 생성
        // 3. Statement 객체 생성
        // 4. 쿼리 실행
        // 5. 결과 수행
        // 6. 객체 연결 해제 (close)

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        
        
        boolean marketing = true;


        try {
            connection = DriverManager.getConnection(url, dbuUserId, dbPassword);

            String sql = "INSERT INTO WIFILIST VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, mw.getID_WIFI());
            preparedStatement.setString(2, mw.getGU());
            preparedStatement.setString(3, mw.getNAME());
            preparedStatement.setString(4, mw.getADDRESS_STREET());
            preparedStatement.setString(5, mw.getADDRESS_SPECIFIC());
            preparedStatement.setString(6, mw.getFLOOR());
            preparedStatement.setString(7, mw.getINSTALL_TYPE());
            preparedStatement.setString(8, mw.getINSTALL_TEAM());
            preparedStatement.setString(9, mw.getSERVICE_TYPE());
            preparedStatement.setString(10, mw.getMANG());
            preparedStatement.setString(11, mw.getREGST_YEAR());
            preparedStatement.setString(12, mw.getIN_OUT());
            preparedStatement.setString(13, mw.getCIRCUM());
            preparedStatement.setFloat(14, mw.getY());
            preparedStatement.setFloat(15, mw.getX());
            preparedStatement.setString(16, mw.getREGST_DATE());


            int affected= preparedStatement.executeUpdate();

            if(affected > 0){
                System.out.println("저장 성공");
                return true;
            }else{
                System.out.println("저장 실패");
                return false;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // finally 안에 아래와 같이 종료 상황을 넣는 이유는
            // 위 try(38행에서 시작하는) 부분에서 아래의 내용을 넣은 경우
            // 만일 도중에 rs closed 에서 오류가 발생하면
            // 다른 커넥션 close 구문을 실행되지 않는다.(필수적으로 닫아줘야하나 닫지 않음)
            // 따라서 finally 에서 아래와 같이 넣어주고 진행시킨다.


            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        
    
		
	}
		
	
	public int dbInsert_WIFILIST_API() {
		
		if(!(dbDelete_WIFILIST() & dbDelete_DISTANCE())) {
			
			return -1;
			
		}
    	

        // JDBC 설정을 위해 필요한 것
//        1. ip(domain)
//        2. port
//        3. 계정
//        4. 패스워드
//        5. 인스턴스
        String url = "jdbc:mariadb://localhost:3306/WIFI";
        String dbuUserId = "testuser";
        String dbPassword = "HighSec1911!WI";

        // 1. 드라이버 로드
        // 2. 커넥션 객체 생성
        // 3. Statement 객체 생성
        // 4. 쿼리 실행
        // 5. 결과 수행
        // 6. 객체 연결 해제 (close)

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        
        
        boolean marketing = true;


        try {
            connection = DriverManager.getConnection(url, dbuUserId, dbPassword); // 드라이브 매니저 호출

            String sql = " select * from zerobase_member " +
                    " where marketing_yn = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, marketing); // 1부터 시작한다.
//            preparedStatement.setString(2,genre); // 어떤 조건에 대입하는 경우 ('=' 뒤에 들어가는 경우) 사용 가능하지 해당 케이스는 사용 불가

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String mobile_no = rs.getString("mobile_no");
                String password = rs.getString("password");
                boolean marketing_yn = rs.getBoolean("marketing_yn");
                String register_date = rs.getString("register_date");
                
                Member member = new Member();
                member.setEmail(email);
                member.setName(name);
                member.setMobile_no(mobile_no);
                member.setPassword(password);
                member.setMarketing_yn(marketing_yn);
                
                memberList.add(member);
                

                System.out.println(name + ", " + email + ", " + mobile_no + ", " + password + ", " + marketing_yn + ", " + register_date);
                
                
                Gson gson = new Gson();
                Member_Wifi mw = gson.fromJson(json, Member_Wifi.class);
                dbInsert_WIFILIST(mw);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // finally 안에 아래와 같이 종료 상황을 넣는 이유는
            // 위 try(38행에서 시작하는) 부분에서 아래의 내용을 넣은 경우
            // 만일 도중에 rs closed 에서 오류가 발생하면
            // 다른 커넥션 close 구문을 실행되지 않는다.(필수적으로 닫아줘야하나 닫지 않음)
            // 따라서 finally 에서 아래와 같이 넣어주고 진행시킨다.


            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        
        return memberList;
    
		
	}

}
