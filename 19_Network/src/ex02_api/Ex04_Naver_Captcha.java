package ex02_api;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

import org.json.JSONObject;

public class Ex04_Naver_Captcha {

  private static final String CLIENT_ID = "dxLQ_GbhqsM3QHNFLIB3";  
  private static final String CLIENT_SECRET = "CsMJ8FIn4F";
  
  private static String getKey() {
  
    URL url = null;
    HttpURLConnection con = null;
    BufferedReader reader = null;
    String result = null;
    
    try {
      String spec = "https://openapi.naver.com/v1/captcha/nkey?code=0";
      url = new URL(spec);
      con = (HttpURLConnection) url.openConnection();
      
      con.setRequestMethod("GET");
      con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
      con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
      
      int responseCode = con.getResponseCode();
      if(responseCode != HttpURLConnection.HTTP_OK) {
        throw new RuntimeException(responseCode + " 발생");
      }
      
      reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
      
      StringBuilder sb = new StringBuilder();
      String line = null;
      while((line = reader.readLine()) != null) {
        sb.append(line);
      }
      System.out.println(sb.toString());
      
      JSONObject obj = new JSONObject(sb.toString());
      result = obj.getString("key");
      
      
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if(reader != null) reader.close();
        if(con != null) con.disconnect();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
    return result;
    
  }
  
  // 이미지 요청
  private static String getImage() {
  
    URL url = null;
    
    HttpURLConnection con = null;
    BufferedInputStream bin = null;
    BufferedOutputStream bout = null;
    String key = null;
    try {
      key =getKey();
      String spec = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + key;
      
      url = new URL(spec);
      con = (HttpURLConnection) url.openConnection();
      
      con.setRequestMethod("GET");
      con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
      con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
    
      int responseCode = con.getResponseCode();
      if(responseCode != HttpURLConnection.HTTP_OK) {
        throw new RuntimeException(responseCode + " 발생");
      }
      
      bin = new BufferedInputStream(con.getInputStream());
      File dir = new File("C:/storage");
      if(dir.exists() == false) {
        dir.mkdirs();
      }
      File file = new File(dir, System.currentTimeMillis() + ".jpg"); // 중복만 발생하지 않는다면 계속 실행
      bout = new BufferedOutputStream(new FileOutputStream(file));
      
      byte[] b = new byte[1024];
      int readByte = 0;     // 실제로 읽은 Byte 수가 필요하다.
    
      while((readByte = bin.read(b)) != -1) {
        bout.write(b, 0, readByte);   // b에서 0부터 readByte(읽은바이트)까지
      }
    
      System.out.println(file.getPath() + " 파일 생성 완료");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if(bout != null) bout.close();
        if(bin != null) bin.close();
        if(con != null) con.disconnect();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
    return key;
    
}
  
  // 이미지 내보내기
  private static void validInput() {
    
    URL url = null;
    HttpURLConnection con = null;
    BufferedReader reader = null;
    
      try {
        
      String key = getImage();
      Scanner sc = new Scanner(System.in);
      System.out.println("입력 >> ");
      String value = sc.next();
      String spec ="https://openapi.naver.com/v1/captcha/nkey?code=1&key=" + key + "&value=" + value;//image와 key를 동시에
      
      url = new URL(spec);
      con = (HttpURLConnection) url.openConnection();
      
      con.setRequestMethod("GET"); // GET HTTP 메서드
      
      // 클라이언트 아이디와 비밀번호
      con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
      con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
    
      int responseCode = con.getResponseCode();
      if(responseCode != 200) {
        throw new RuntimeException(responseCode + " 발생");      
      }
  
      reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
      
      StringBuilder sb = new StringBuilder();
      String line = null;
      while((line = reader.readLine()) != null) {
        sb.append(line);
      }
      JSONObject obj = new JSONObject(sb.toString());
      
      System.out.println("응답시간: " + obj.getDouble("responseTime"));
      if(obj.getBoolean("result")) {
          System.out.println("맞습니다.");
      } else {
        System.out.println("틀립니다.");
      }
    
    }catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if(reader != null) reader.close();
        if(con != null) con.disconnect();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
    
  }
  
  public static void main(String[] args) {
      //String key = getKey();
      //System.out.println("캡차키: " + key);
      //getImage();
      validInput();
    

  }

}
