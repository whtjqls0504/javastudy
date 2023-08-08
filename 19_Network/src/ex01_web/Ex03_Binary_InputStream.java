package ex01_web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Ex03_Binary_InputStream {

  public static void main(String[] args) {
// 웹 상의 바이너리 파일 읽기
    
    // 접속할 주소
    String spec = "https://ssl.pstatic.net/melona/libs/1456/1456783/898e76d144db9d4e9b18_20230803175043725.jpg";
    
    // URL 객체 선언
    URL url = null;
    
    // HttpURLConnection 객체 선언
    HttpsURLConnection con = null;  // 서버통신할놈
    
    // 입력스트림 선언 (네이버 배너를 읽는 스트림)
    BufferedInputStream bin = null; // 읽어줄놈
    
    // 출력스트림 선언 (C:/ storage/banner.jpeg 파일을 만드는 스트림)
    BufferedOutputStream bout = null;

    
    try {
      
          // URL 객체 생성
          url = new URL(spec);
          
          // HttpURLConnection 객체 생성
          con = (HttpsURLConnection) url.openConnection();
        
          // 입력스트림 생성
          bin = new BufferedInputStream(con.getInputStream());  // new fileinput이였을 뿐이다.
          
          // 출력할 파일 File 객체
          File dir = new File("C:/storage");
          
          if(dir.exists() == false) {
            dir.mkdirs();
          }
          String contentType = con.getContentType();
          String extName = contentType.substring(contentType.indexOf("/") + 1);
          String fileName = "banner." + extName;    
          File file = new File(dir, fileName);
          
          
          // 출력스트림 생성
          bout = new BufferedOutputStream(new FileOutputStream(file));
    
          
          // 읽은 데이터를 저장할 바이트 배열 
          byte[] b = new byte[1024];  // 1KB씩 읽기
          
          int readByte = 0;
          // 실제로 읽은 바이트 수가 필요하다.
          // 데이터저장할놈. 서버통신할놈한테 데이터 저장해버릴럼
    
          
          // 읽기
          // 쓰기 (byte[] b의 내용을 banner.jpeg 파일로 보내기)
          while((readByte = bin.read(b)) != -1) {
            bout.write(b, 0, readByte);
          }
      
      
          
      // 확인 메시지
      System.out.println(fileName + " 파일 생성 완료");
      
      
    } catch (MalformedURLException e) {
        System.out.println("URL 주소 오류");
    } catch (IOException e) {
        System.out.println("URL 접속 오류");
    } finally {
      try {
        // 생성의 역순으로 닫기 
        if(bout != null) { bout.close(); }
        if(bin != null) { bin.close(); }
        if(con != null) { con.disconnect();}
      } catch (IOException e) {
          e.printStackTrace();
      }
    }

    // 닫는 순서 역순
    

  }

}
