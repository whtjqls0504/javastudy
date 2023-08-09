package ex01_connect;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MainWrapper {

  // 1. oracle.jdbc.OracleDrvier 클래스 Load
  public static void ex01() {
    
    try {
      Class.forName("oracle.jdbc.OracleDriver");
        
    }catch (ClassNotFoundException e) {
        System.out.println("OracleDriver 클래스가 없다.");
    }
    
  }

  // 2. (인터페이스)java.sql.Connection 객체 생성 (DB 접속 생성)
  public static void ex02() {
    
    // 접속 정보
    // jdbc:oracle:thin:@호스트이름:포트:sid번호
    // 매번 접속 정보가 필요하다.
    
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String user = "GD";
    String password = "1111";
    
    // Connection 객체 선언 
    Connection con = null;
    
    // Connection 객체 생성
    try { 
      con = DriverManager.getConnection(url, user, password);     
      System.out.println("DB 접속 성공");
    } catch (SQLException e) {
         System.out.println("DB 접속 실패");
    } finally {
      // Connection 객체 소멸
      try {
        if(con!=null) con.close();
      }catch (SQLException e) { // 접속실패 오류
          System.out.println("DB 접속 소멸 실패 ");
      }
    }


  }
  
  // 3. 접속 정보를 별도의 파일(프로퍼티 파일)에 저장 (.gitignore 대비)
  //    1) .gitignore 파일에 db.properties 목록 추가하기
  //    2) git push origin main
  //    3) db.properties 파일 만들기
  
  public static void ex03() {
    // 문자 기반 입력스트림 선언
    BufferedReader reader = null;
    
    try {
      
      // 입력스트림 생성
      reader = new BufferedReader(new FileReader("src/db.properties"));
      
      // 프로퍼티파일 -> 프로퍼티 객체
      Properties properties = new Properties();
      properties.load(reader);  // stream으로 reader 등록?
      
      // 프로퍼티객체의 프로퍼티 가져오기
      String url = properties.getProperty("url");   // getter 사용
      String user = properties.getProperty("user");
      String password = properties.getProperty("password");
      
      // 확인
      System.out.println(url);
      System.out.println(user);
      System.out.println(password);

      
    } catch (IOException e) {
        System.out.println("파일 읽기 실패");
    } finally {
      try {
        if(reader!=null) reader.close();
      }catch (IOException e) {
        e.printStackTrace();
      }
    }
    
  }
  
  // 4. 파이널 버전
  //    Connection 객체를 만들어서 반환하는 getConnection() 메소드 만들기
  
  
  public static Connection getConnection() {

    Connection con = null;

    try (BufferedReader reader = new BufferedReader(new FileReader("src/db.properties"))) {

      Class.forName("oracle.jdbc.OracleDriver");

      Properties p = new Properties();
      p.load(reader);

      con = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"), p.getProperty("password"));

    } catch (Exception e) {
      e.printStackTrace();
    }

    return con;

  }

  public static Connection getConnection2() {

    Connection con = null;
    
    try(BufferedReader reader = new BufferedReader(new FileReader("src/db.properties"))) {
      
      Class.forName("oracle.jdbc.OracleDriver");
      
      Properties p = new Properties();
      p.load(reader);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return con;
    
    
    
  }
  
  
  public static void main(String[] args) throws Exception{
//    ex01();
//    ex02();
//    ex03();
//    Connection con = getConnection();
//    System.out.println("Oracle에 접속되었습니다.");
//    con.close();
    Connection con = getConnection();
    System.out.println("오라클에 접속되었습니다.");
    con.close();
  }

}
