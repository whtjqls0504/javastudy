package ex01_weather;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainWrapper {

  public static void main(String[] args) {
    
    // 1시간마다 갱신되는 전국 날씨 정보
    String spec = "http://www.kma.go.kr/XML/weather/sfc_web_map.xml";

    // C:/storage/sfc_web_map.xml 파일로 저장하기
    
    URL url = null;
    
    // 서버통신할놈 객체선언
    HttpURLConnection con  = null;
    
    // 읽어줄 놈 선언 (전국 날씨 정보를 읽는 슽릠)
    BufferedReader br = null;
    
    BufferedWriter bw = null;
    
    try {
      
      // URL 링크
      url = new URL(spec);

      // HttpURLConnection 객체 생성
      con = (HttpURLConnection)url.openConnection();
      
      // 입력스트림 생성(전국 날씨 정보를 읽는 스트림)
      br = new BufferedReader(new InputStreamReader(con.getInputStream()));
      
      // 출력스트림 생성
      bw = new BufferedWriter(new FileWriter("C:/storage/sfc_web_map.xml"));
      
      // 입력된 문자열을 저장할 변수 
      String line = null;
      
      // 입력된 문자열을 누적할 StringBuilder 객체 생성
      StringBuilder sb = new StringBuilder();
      
      // 반복문 : 읽은 내용이 null이 아니면 계속 읽어서 파일로 보낸다.
      while((line = br.readLine()) != null) {
        bw.write(line);
        bw.newLine();
      }
      
      // 메시지 
      System.out.println("파일 생성 완료");
      
      
    }catch (MalformedURLException e) {
      System.out.println(e.getMessage());
    }catch (IOException e) {
      System.out.println(e.getMessage());
    }finally {
      try {
        if(bw != null) bw.close();
        if(br != null) br.close(); 
        if(con !=null) con.disconnect();

      } catch (IOException e) {
          System.out.println(e.getMessage());
      }
      
    }
    
    
    
    
  }

}