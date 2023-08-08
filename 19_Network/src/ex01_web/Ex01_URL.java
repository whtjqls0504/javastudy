package ex01_web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.Buffer;
import java.nio.charset.MalformedInputException;

import javax.net.ssl.HttpsURLConnection;

public class Ex01_URL {

  
  /*
   * URL
   * 1. Uniform Resource Location
   * 2. 정형화된 자원의 경로 표기방법(웹 주소를 의미한다.)
   * 3. 형식
   *     프로토콜://    호스트     :포트/ URLMapping ?파라미터=값&파라미터=값&파라미터=값...
   *        https://search.naver.com:443/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=폭염
   *     1) 프로토콜   : 통신규약, https(secure + http : 보안 처리된 하이퍼텍스트 전송 프로토콜)
   *     2) 호스트     : 서버주소
   *     3) 포트번호   : Well known port → http(80), https(443), ftp(21), ssh(22)
   *     4) URLMapping : 서버경로
   *     5) 파라미터   : 서버로 보내는 데이터
   */

  /*
   * java.net.URL 클래스
   * 1. URL을 관리하는 클래스이다.
   * 2. URL을 분석하여 원하는 정보를 얻어낼 수 있다.
   * 3. URL에 접속할 수 있는 URLConnection을 생성할 수 있다.
   */
  
  
  public static void ex01() {
 
    // URL 정보 분석하기
    String apiURL = "https://search.naver.com:443/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=폭염";
    
    // URL 객체 선언
    URL url = null;
    
    try {
      
      // URL 객체 생성
      url = new URL(apiURL);  // MalformedURLException 발생
      
      // URL 분석
      System.out.println("프로토콜: " + url.getProtocol());
      System.out.println("호스트: " + url.getHost());
      System.out.println("포트번호: " + url.getPort());
      System.out.println("파라미터: " + url.getQuery());
      
    } catch (MalformedURLException e) {
      System.out.println("apiURL 형식 오류");
    }
    
  }
  
  public static void ex012() {
    
    // 접속할 주소
    String spec = "https://www.gdu.co.kr";
    
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
      
    } catch (MalformedURLException e) {
      System.out.println("접속 주소 오류");
    } catch (IOException e) {
      System.out.println("접속 오류");
    }
    
  }  

  
  public static void main(String[] args) {
    ex01();
  }

}