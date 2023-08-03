package ex02_OutputStream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MainWrapper {

  /*
   * java.io.OutputStream 클래스
   * 1. 바이트 기반의 출력 스트림이다.
   * 2. 출력 단위
   *    1) int
   *    2) byte[] // 배열타입으로 출력 가능
   *    // 
   */
  
  public static void ex01() {
    
    // 디렉터리를 File 객체로 만들기 
    File dir = new File("C:/storage");
    if(!dir.exists()) {
      dir.mkdir();  // 스토리지에 파일이 없으면 만들어라.
    }
    
    // 파일을 File 객체로 만들기
    File file = new File(dir, "ex01.dat"); // 저장장소 : c:/storage -> ex01.dat 파일
    
    // 파일출력스트림 선언
    FileOutputStream fout = null;
    
    
    try {
        
        // 파일출력스트림 생성 (반드시 예외 처리가 필요한 코드)
        fout = new FileOutputStream(file);  // 출력스트림의 목적지가. 파일
          
        // 출력할 데이터(파일로 보낼 데이터)
        int c = 'A';                  // int
        String s = "pple";          
        byte[] b = s.getBytes();      // byte[] : String을 byte[]로 변환

        // 출력(파일로 데이터 보내기)
        fout.write(c);
        fout.write(b);  // c b에 있는 값들을 file로 

    } catch (IOException e) {
      e.printStackTrace(); // 예외처리
    } finally { 
      try {
        if(fout != null) {
          fout.close();   // 출력스트림은 반드시 닫아줘야 함 (반드시 예외 처리가 필요한 코드)
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    
    }  
    System.out.println(file.getPath() + " 파일 크기 : " + file.length() + "바이트");

 }
  
  public static void ex02() {
    
    // C:\storage\ex02.dat 파일로 안녕하세요 보내기, 파일 크기 확인하기
    File dir = new File("C:/storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    File file = new File(dir, "ex02.dat");
    
    FileOutputStream fout = null;
    
    try {
      fout = new FileOutputStream(file);
      
      String s = "안녕하세요";
      byte[] b = s.getBytes("UTF-8");

      fout.write(b);
       
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(fout!=null) {
          fout.close();
        }
      } catch (IOException e) {
         e.printStackTrace();
      }
      
    }
    System.out.println(file.getPath() + " 파일 크기: " + file.length() + "바이트");
  }
  
  public static void ex03() {
    
    
    // 2줄로 안녕하세요 \n 반갑습니다.  
    File dir = new File("C:/storage");
    if(!dir.exists()) {
      dir.mkdirs();
    } 
    
    File file = new File(dir, "ex03.dat");
    
    // 버퍼출력 스트림 선언
    BufferedOutputStream bout = null;
    
    try {
      // 버퍼출력스트림 생성(반드시 예외처리 필요한 코드이다.)
      bout = new BufferedOutputStream(new FileOutputStream(file));
    
      String s1 ="안녕하세요";
      String s2 ="반갑습니다";
      int c = '\n';

      bout.write(s1.getBytes("UTF-8"));
      bout.write(c);
      bout.write(s2.getBytes(StandardCharsets.UTF_8));  // getByte("UTF-8")과 동일하다
      
      
    } catch (IOException e) {
          e.printStackTrace();
    } finally {
      try {
        if (bout!=null) {
          bout.close();
        }
      } catch (IOException  e) {
        e.printStackTrace();
      }
    }
        
    System.out.println(file.getPath() + " 파일 크기 : " + file.length());
    
  }

  /*
   *   java.io.BufferedOutputStream 클래스
   *  1. 내부 버퍼를 가지고 있는 출력스트림이다.
   *  2. 많은 데이터를 한 번에 출력하기 때문에 속도 향상을 위해서 사용한다.
   *  3. 보조스트림이므로 메인스트림과 함께 사용한다. (fileoutputStream)
   */
  
  public static void main(String[] args) {
    ex03();
  }

}
