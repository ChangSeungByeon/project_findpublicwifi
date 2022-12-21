package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

//import org.mariadb.jdbc.Statement;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

//import db.Member;



public class Service {
	
	String url = "jdbc:mariadb://localhost:3306/WIFI?autoReconnect=true";
    String dbuUserId = "testuser";
    String dbPassword = "HighSec1911!WI";
	
	
	
		public Boolean dbDelete_all(String dbName) {
		
		// JDBC 설정을 위해 필요한 것
//      1. ip(domain)
//      2. port
//      3. 계정
//      4. 패스워드
//      5. 인스턴스



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
      Statement stmt = null;
      ResultSet rs = null;
      
      try {
    	      	  
          connection = DriverManager.getConnection(url, dbuUserId, dbPassword); // 드라이브 매니저 호출
          
          stmt = connection.createStatement();
          stmt.addBatch("SET FOREIGN_KEY_CHECKS = 0");
          stmt.addBatch("TRUNCATE TABLE " + dbName);
          stmt.addBatch("SET FOREIGN_KEY_CHECKS = 1");
          stmt.executeBatch();
          
          
          return true;
          
        
//          
//          if(affected > 0){
//              System.out.println("삭제 성공");
//          }else{
//              System.out.println("삭제 실패"); // 삭제할 내용이 없는 경우에도 실패로 뜬다.
//              return false;
//          }


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
              if (stmt != null && !stmt.isClosed()) {
            	  stmt.close();
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
	
	
	public Boolean dbDelete_WIFILIST() {
		return dbDelete_all("WIFILIST");
    }
		
	public Boolean dbDelete_DISTANCE() {
		return dbDelete_all("DISTANCE");
    }
	
	public Boolean dbDelete_DISTANCE(int ID_USER) {
		

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
        PreparedStatement preparedStatement_1 = null;
        ResultSet rs = null;
        
       

        try {
            connection = DriverManager.getConnection(url, dbuUserId, dbPassword);

            String sql_1 = "DELETE FROM DISTANCE WHERE ID_USER = ?";

            preparedStatement_1 = connection.prepareStatement(sql_1);
            preparedStatement_1.setInt(1, ID_USER);
            int affected_1= preparedStatement_1.executeUpdate();

   

            if(affected_1> 0){
                System.out.println("DISTANCE 삭제 성공");
                return true;
            }else{
                System.out.println("DISTANCE 삭제 실패");
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
                if (preparedStatement_1 != null && !preparedStatement_1.isClosed()) {
                    preparedStatement_1.close();
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
	
	
	
	public Boolean dbDelete_MEMBER(int ID_USER) {
		

	
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
	    PreparedStatement preparedStatement_1 = null;
	    PreparedStatement preparedStatement_2 = null;
	    ResultSet rs = null;
	    
	
	
	    try {
	    	
	    	dbDelete_DISTANCE(ID_USER);
	    	
	    	
	        connection = DriverManager.getConnection(url, dbuUserId, dbPassword);
	
	        String sql_1 = "DELETE FROM MEMBER WHERE ID_USER = ?";
	
	        preparedStatement_1 = connection.prepareStatement(sql_1);
	        preparedStatement_1.setInt(1, ID_USER);
	        int affected_1= preparedStatement_1.executeUpdate();
	        
	        
	      
	
	
	        if(affected_1> 0){
	            System.out.println("MEMBER 삭제 성공");
	            return true;
	        }else{
	            System.out.println("MEMBER 삭제 실패");
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
	            if (preparedStatement_1 != null && !preparedStatement_1.isClosed()) {
	                preparedStatement_1.close();
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

	public Boolean dbInsert_WIFILIST(Member_Wifi mw) {
		
	

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
            preparedStatement.setDouble(14, mw.getY());
            preparedStatement.setDouble(15, mw.getX());
            preparedStatement.setString(16, mw.getREGST_DATE());


            int affected= preparedStatement.executeUpdate();

            if(affected > 0){
//                System.out.println("저장 성공");
                return true;
            }else{
//                System.out.println("저장 실패");
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
		
		// TODO API 이용해서 json 으로 파일 가져와서 객체로 바꿔주기 
		// TODO 여기서 dbInsert_WIFILIST 이용해서 DB에 추가해주기 
		
		API api = new API();
		
		int numDatum = api.getDatalength();
		int numLimitRqst = 1000;
		int startIndex = 1;  
		int endIndex = numLimitRqst < numDatum ? numLimitRqst : numDatum ;
		
		System.out.println("총 데이터 수: " + numDatum);
		
		JsonParser parser = new JsonParser();
		
		try {
		
			while(true){
				
				System.out.println("데이터 구간: " + startIndex + " ~ " + endIndex);
				
				
				String data = api.datatostring(startIndex, endIndex);
				JsonElement element = parser.parse(data);
				JsonArray arr = (JsonArray)element.getAsJsonObject().get("TbPublicWifiInfo").getAsJsonObject().get("row");
				Gson gson = new Gson();
				
				for(int i = 0 ; i <= endIndex-startIndex;i++) {
					
					
					String json = arr.get(i).toString();
					
					Member_Wifi mw = gson.fromJson(json, Member_Wifi.class);
					
					dbInsert_WIFILIST(mw);
					
					
				}
				
				// 데이터 등록하기 
				
				
				
				if(endIndex == numDatum) {
					break;
				}
				
				
				if(endIndex + numLimitRqst < numDatum) {
					startIndex += 1000;
					endIndex += 1000;
					
				}else if(endIndex + numLimitRqst >= numDatum){
					startIndex += 1000;
					endIndex = numDatum;
				}
				
				
				
			}
		
		}catch(Exception e) {
			
			e.printStackTrace();
			System.out.println("데이터 컬렉션 실패 ");
			return -1;
			
		}
		
        
        return numDatum;
    
		
	}
    public Boolean dbInsert_MEMBER(double LAT, double LNT) {
		
	
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
	    
	
	
	    try {
	        connection = DriverManager.getConnection(url, dbuUserId, dbPassword);
	
	        String sql = "INSERT INTO MEMBER (X, Y, REGST_DATE) VALUES (?,?,NOW())";
	
	        preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setDouble(1, LAT);
	        preparedStatement.setDouble(2, LNT);
	
	
	        int affected= preparedStatement.executeUpdate();
	
	        if(affected > 0){
	            System.out.println("dbInsert_MEMBER 저장 성공");
	            return true;
	        }else{
	            System.out.println("dbInsert_MEMBER 저장 실패");
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
	
	public Boolean dbInsert_DISTANCE(double LAT, double LNT) {
		
		if(dbInsert_MEMBER(LAT,LNT) == false) {
			System.out.println("dbInsert_DISTANCE 저장 실패");
		}
		
		int ID_USER = dbSelect_MEMBER_last();
		
		TreeMap<Double, String> tm = new TreeMap<>();
//		
		Distance ds = new Distance(LAT, LNT);

		
	
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
	    
	
	
	    try {
	        connection = DriverManager.getConnection(url, dbuUserId, dbPassword);
	
	        String sql = "SELECT * FROM WIFILIST";
	
	        preparedStatement = connection.prepareStatement(sql);
	        
	        rs = preparedStatement.executeQuery();
	        
	        
	        while (rs.next()) {
                String name = rs.getString("ID_WIFI");
                double x = rs.getDouble("X");
                double y = rs.getDouble("Y");
                
                double dis = ds.distance(x,y);
                
                
	        	if(tm.size() < 20) {
	    			tm.put(dis, name);
	    		}else {
	    			if(tm.lastKey() < dis) {
	    				continue;
	    			}else {
	    				tm.remove(tm.lastKey());
	    				tm.put(dis, name);
//	    				System.out.println(name);
	    			}
	    		}
            }
	        
	        for (double i : tm.keySet()) {
	        	dbInsert_DISTANCE_each(ID_USER,tm.get(i),i);
	        }
	        
	        
	        
	        return true;
	        
	        
	        
	        

	
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


	public Boolean dbInsert_DISTANCE_each(int ID_USER, String ID_WIFI, double DIS) {
		
		DIS = Double.parseDouble(String.format("%.4f",DIS));
		
	
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
	    
	
	
	    try {
	        connection = DriverManager.getConnection(url, dbuUserId, dbPassword);
	
	        String sql = "INSERT INTO DISTANCE VALUES (?,?,?)";
	
	        preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setInt(1, ID_USER);
	        preparedStatement.setString(2, ID_WIFI);
	        preparedStatement.setDouble(3, DIS);
	
	
	        int affected= preparedStatement.executeUpdate();
	
	        if(affected > 0){
	            System.out.println("dbInsert_DISTANCE_each 저장 성공");
	            return true;
	        }else{
	            System.out.println("dbInsert_DISTANCE_each 저장 실패");
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


	public int dbSelect_DISTANCE_same(double LAT, double LNT) {
		

	
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
	    PreparedStatement preparedStatement_2 = null;
	    ResultSet rs = null;
	    ResultSet rs_2 = null;
	    
	
	
	    try {
	        connection = DriverManager.getConnection(url, dbuUserId, dbPassword);
	
	        String sql = "SELECT ID_USER FROM MEMBER WHERE X = ? and Y = ? order by ID_USER  desc limit 1";
	
	        preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setDouble(1,LAT);
	        preparedStatement.setDouble(2,LNT);
	        
	
	        rs = preparedStatement.executeQuery();
	        
	        if(rs.next() == false) {
	        	return -1;
	        }
	
	        else{
	        	
	        	int ID_USER = rs.getInt("ID_USER");
	        	
	        	sql = "SELECT ID_USER FROM DISTANCE WHERE ID_USER = ? order by ID_USER  desc limit 1";
	        	
		        preparedStatement_2 = connection.prepareStatement(sql);
		        preparedStatement_2.setInt(1,ID_USER);
		        
		        rs_2 = preparedStatement_2.executeQuery();
		        
		        if(rs_2.next() == false) {
		        	return -1;
		        }else {
		        	return rs_2.getInt("ID_USER");
		        }
	        	
	        	
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
	            if (rs_2 != null && !rs_2.isClosed()) {
	                rs_2.close();
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
	        	if (preparedStatement_2 != null && !preparedStatement_2.isClosed()) {
	        		preparedStatement_2.close();
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
	
	public List<Member_Member> dbSelect_MEMBER() {
		
		List<Member_Member> list = new ArrayList<>();
		
		
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
	    
	
	
	    try {
	        connection = DriverManager.getConnection(url, dbuUserId, dbPassword);
	
	        String sql = "SELECT * FROM MEMBER order by ID_USER desc";
	
	        preparedStatement = connection.prepareStatement(sql);
	
	        rs = preparedStatement.executeQuery();
	        
	        while(rs.next()) {
	        	Member_Member mb = new Member_Member();
	        	mb.setID_USER(rs.getInt("ID_USER"));
	        	mb.setX(rs.getDouble("X"));
	        	mb.setY(rs.getDouble("Y"));
	        	mb.setREGST_DATE(rs.getString("REGST_DATE"));
	        	
	        	list.add(mb);
	        }
	
	        return list;
	
	
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


	public int dbSelect_MEMBER_last() {
		
	
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
	    
	
	
	    try {
	        connection = DriverManager.getConnection(url, dbuUserId, dbPassword);
	
	        String sql = "SELECT ID_USER FROM MEMBER WHERE ID_USER = (SELECT MAX(ID_USER) FROM `MEMBER`)";
	
	        preparedStatement = connection.prepareStatement(sql);
	
	        rs = preparedStatement.executeQuery();
	        
	        if(rs.next() == false) {
	        	return 0;
	        }
	
	        return rs.getInt("ID_USER");
	
	
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
	
	public List<Member_listed> dbSelect_DISTANCE(double LAT, double LNT) {
		
//		받은 LAT, LNT 값하고 같은 MEMBER 가 있고, DISTANCE 가 있다면 조인해서 가져오기 
//		없다면 dbInsert_MEMBER() 로 입력, dbSelect_MEMBER_last() 로 ID_USER 받아와서 
//		조인해서 가져오기 
//		
//		조인하는 경우 일단 값이 ID_USER 인 애들을 DISTANCE 에서 가져오고 
//		포
		
		List<Member_listed> list = new ArrayList<>();
		
		int ID_USER = dbSelect_DISTANCE_same(LAT,LNT);
		
		if(ID_USER == -1) {
			
			dbInsert_DISTANCE(LAT,LNT);
			ID_USER = dbSelect_MEMBER_last();
			
		}else {
			
			dbInsert_MEMBER(LAT,LNT);
		}
		
		
	
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
	    
	
	
	    try {
	        connection = DriverManager.getConnection(url, dbuUserId, dbPassword);
	
	        String sql = "SELECT d.DIS, w.* FROM DISTANCE d JOIN WIFILIST w ON d.ID_WIFI = w.ID_WIFI WHERE d.ID_USER = ?";
	
	        preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setInt(1,ID_USER);
	
	        rs = preparedStatement.executeQuery();
	        
	        while(rs.next() == true) {
	        	
	        	double DIS = rs.getDouble("DIS");
	        	String ID_WIFI = rs.getString("ID_WIFI");
	        	String GU = rs.getString("GU");
	        	String NAME= rs.getString("NAME");
	        	String ADDRESS_STREET= rs.getString("ADDRESS_STREET");
	        	String ADDRESS_SPECIFIC= rs.getString("ADDRESS_SPECIFIC");
	        	String FLOOR= rs.getString("FLOOR");
	        	String INSTALL_TYPE= rs.getString("INSTALL_TYPE");
	        	String INSTALL_TEAM= rs.getString("INSTALL_TEAM");
	        	String SERVICE_TYPE= rs.getString("SERVICE_TYPE");
	        	String MANG= rs.getString("MANG");
	        	String REGST_YEAR= rs.getString("REGST_YEAR");
	        	String IN_OUT= rs.getString("IN_OUT");
	        	String CIRCUM= rs.getString("CIRCUM");
	        	double Y= rs.getDouble("Y");
	        	double X= rs.getDouble("X");
	        	String RESGT_DATE= rs.getString("RESGT_DATE");
	        	
	        	Member_listed ml = new Member_listed();
	        	
	        	ml.setDIS(DIS);
	        	ml.setID_WIFI(ID_WIFI);
	        	ml.setGU(GU);
	        	ml.setNAME(NAME);
	        	ml.setADDRESS_STREET(ADDRESS_STREET);
	        	ml.setADDRESS_SPECIFIC(ADDRESS_SPECIFIC);
	        	ml.setFLOOR(FLOOR);
	        	ml.setINSTALL_TYPE(INSTALL_TYPE);
	        	ml.setINSTALL_TEAM(INSTALL_TEAM);
	        	ml.setSERVICE_TYPE(SERVICE_TYPE);
	        	ml.setMANG(MANG);
	        	ml.setREGST_YEAR(REGST_YEAR);
	        	ml.setIN_OUT(IN_OUT);
	        	ml.setCIRCUM(CIRCUM);
	        	ml.setY(Y);
	        	ml.setX(X);
	        	ml.setREGST_DATE(RESGT_DATE);
	        	
	        	System.out.println(ID_WIFI);
	        	
	        	list.add(ml);
	        	
	        	
	        }
	
	        return list;
	
	
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

}
