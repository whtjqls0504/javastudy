package naver.api;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import netscape.javascript.JSObject;

public class NaverApiSearchBook {
  
  private static final String CLIENT_ID = "dxLQ_GbhqsM3QHNFLIB3";  
  private static final String CLIENT_SECRET = "CsMJ8FIn4F";
  
  private void generateImage(String spec) {
    
    URL url = null;
    HttpURLConnection con = null;
    BufferedInputStream bin = null;
    BufferedOutputStream bout = null;
    
    try {
        
      
      // 파라미터 String spec에는 다운로드 받을 이미지 파일의 URL이 전달된다.
      // 해당 URL의 이미지 파일을 다운로드 받는다.
      
      
      url = new URL(spec);
      con = (HttpURLConnection) url.openConnection();
      NaverApiSearchBook apiSearchBook = new NaverApiSearchBook();
      apiSearchBook.getSearchList();
      
      
      StringBuilder sb = new StringBuilder();
      sb.append(spec);
      
      JSONObject obj = new JSONObject(sb.toString());
      JSONArray items = obj.getJSONArray("items");
      for(int i=0, length = items.length(); i<length; i++) {
        JSONObject item = items.getJSONObject(i);
        System.out.println((i+1) + "d");
        System.out.println("title" + ": " + item.getString("title"));
        System.out.println("link"  + ": " + item.getDouble("link"));
        
      }
      int responseCode = con.getResponseCode();
      if(responseCode != HttpURLConnection.HTTP_OK) {
        

        File file = new File("C:/download/log/log.txt");
        throw new RuntimeException(file + " 파일에 로그가 작성되었습니다.");  
      }
      
      bin = new BufferedInputStream(con.getInputStream());
      
      // download로 내보내기. exists하지 않으면 다시 만들기
      File dir = new File("C:/download");
      if(dir.exists() == false) {
        dir.mkdirs();
      }
      
      File file = new File(dir, System.currentTimeMillis() + ".jpg");
      bout = new BufferedOutputStream(new FileOutputStream(file));
      
      byte[] b = new byte[1024];   // 읽어들이는 파일 
      int readByte = 0;
      
      while((readByte = bin.read(b)) != -1) {
        bout.write(b, 0, readByte);
      } 
      
      System.out.println(file.getPath() + " 파일 다운로드 완료");
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if(bout != null) bout.close();
        if(bin != null) bin.close();
        if(con != null) con.disconnect();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
  }
  
  public void getSearchList() {
    
    URL url = null;
    HttpURLConnection con = null;
    BufferedReader reader = null;
    
    try {
      
      // 책 검색 OpenAPI를 사용해서 응답 결과 중 이미지(image) 결과만 추출하여
      // generateImage 메소드에 전달한다.
      // 10번의 generateImage 메소드 호출이 필요하다.

      
      
      // 예외 발생 시 로그파일을 만든다.
      Scanner sc = new Scanner(System.in);
      System.out.print("책 관련 검색어를 입력하세요 >>> ");
      String value = sc.next();
      
      String spec = "https://openapi.naver.com/v1/search/book.json";
      String display = "10";
      String start ="1";
      String sort = "sim";
      String d_titl = "d_titl";
      String d_isbn = "d_isbn "; 
          
      
      // URL, con객체 생성
      url = new URL(spec);
      con = (HttpURLConnection) url.openConnection();
      
      // 클라이언트 아이디와 비밀번호
      con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
      con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
      
      //
      String query = "자바";
      StringBuilder sbUrl = new StringBuilder();
      sbUrl.append(spec);
      sbUrl.append("?query=").append(URLEncoder.encode(query, "UTF-8"));
      sbUrl.append("&display=").append(display); // 인코딩 한다고 하여 달라지는건 없다.
      sbUrl.append("&start=").append(start); 
      sbUrl.append("&sort=").append(sort); 
      sbUrl.append("&d_titl").append(d_titl);
      sbUrl.append("&d_isbn").append(d_isbn);
      

      //HTTP 메서드 =  GET
      con.setRequestMethod("GET");
      
      reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
      StringBuilder sb = new StringBuilder();
      String line = null;
      while((line = reader.readLine()) != null) {
        sb.append(line);
      }
      
  
    } catch (Exception e) {

      LocalDateTime now = LocalDateTime.now();  // 
      DateTimeFormatter dtf  = DateTimeFormatter.ofPattern("yyyy-MM-dd a h:mm:ss");
      String time = dtf.format(now);
      
   // 예외 메세지 
      String message = e.getMessage();  
      
      // 예외 클래스
      String clazz = e.getClass().getName();
      
      // File 객체 
      File dir = new File("C:/download");
      if(dir.exists() == false) {
        dir.mkdirs();
      }
      File file = new File(dir, "log.txt");
      System.out.println(file.getPath() + " 파일 생성 완료");
    
      
      
    } finally {
      try {
        if(reader != null) reader.close();
        if(con != null) con.disconnect();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
  }
  
}