package ex01_web;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Ex02_HttpURLConnection {

  public static void main(String[] args) {
    
    // 접속할 주소
    String spec = "https://ssl.pstatic.net/melona/libs/1456/1456783/898e76d144db9d4e9b18_20230803175043725.jpg";
    
    //
    URL url = null;
    
    // HttpURLConnection 객체 선언
    HttpsURLConnection con = null;
    
    try {
      // URL 객체 생성(MalformedURLException발생)
      url = new URL(spec);
      
      // HttpURLconnection 객체 생성 (IOException 발생)
      con = (HttpsURLConnection)url.openConnection();
      
      /*
       * HTTP 응답코드
       * 1. 200 : 정상
       * 2. 4XX : 잘못된 요청 (클라이언트의 잘못된 요청)
       * 3. 5XX : 서버 오류 (잘못된 개발) 
       */
      
      // 접속 여부 확인 
      int responseCode = con.getResponseCode(); // 응답코드
      System.out.println("접속여부: " + (responseCode == HttpsURLConnection.HTTP_OK));

      // 요청 헤더(User-Agent) 무엇으로 접속했는가?
      String userAgent = con.getRequestProperty("User-Agent"); 
      System.out.println("User-Agent" + userAgent);
      
      
      // 요청 헤더(Referer) : 이전 주소가 무엇인가.
      String referer = con.getRequestProperty("Referer");
      System.out.println("Referer: " + referer);
      
      // 요청 헤더(Content-Type) :  어떤 타입인가?
      String contentType = con.getContentType();
      System.out.println("Content-Type: "  + contentType);
      
      // 컨텐트 크기 : 크기가 얼마인가?
      int contentLength = con.getContentLength();
      System.out.println("Content-Length: " + contentLength);
      
  
      /*
       * 요청메소드
       * 1. GET   : 주소(URL)을 이용한 데이터 전송
       * 2. POST  : 본문(Body)을 이용한 데이터 전송
       */
      
      // 요청 메소드 : 어떤 방식으로 요청했는가?
      String requestMethod = con.getRequestMethod();
      System.out.println("requestMethod: " + requestMethod);
      
      // 접속 해제 
      con.disconnect();

    } catch (MalformedURLException e) {
      System.out.println("접속 주소 오류");
    } catch (IOException e) {
      System.out.println("접속 오류");
    }
    

  }

}
