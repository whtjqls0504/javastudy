package ex02_List;

import java.util.ArrayList;
import java.util.List;  // 내가 앞으로 List라고 부르면 그것은 java.util의 list이다. 라는 뜻이 포함되어있다. 

public class MainWrapper {

  public static void ex01() {
    
    // ArrayList의 인터페이스 List 타입 선언
    List<String> season;
    
    // ArrayList 생성
    season = new ArrayList<String>();
    
    /// 배열 요소 추가하기
    season.add("여름");
    season.add("가을");
    season.add("겨울");
    season.add(0, "봄"); // index 0 봄 입력
    
    
    // 배열 요소 확인
    System.out.println(season.get(0));
    System.out.println(season.get(1));
    System.out.println(season.get(2));
    System.out.println(season.get(3));

  }
  
  public static void ex02() {
    
    // ArrayList의 선언 & 생성 
    List<String> hobbies = new ArrayList<String>();
 
    // 배열 요소 추가하기 
    hobbies.add("여행");
    hobbies.add("독서");
    hobbies.add("코딩");

    // 배열 길이 확인하기 (저장된 요소의 갯수)
    System.out.println(hobbies.size());
  
    // 배열 길이 관련 (마지막 요소 꺼내기)
    System.out.println(hobbies.get(hobbies.size()-1));
    
    // 배열 for문 적용하기
    for(int i=0; i<hobbies.size(); i++) {
      System.out.println(hobbies.get(i));
    }
  
    
    // 배열 for문 적용하기 (리팩토링 : hobbies.size() 메소드가 여러 번 호출되는 문제 해결)
      for(int i = 0, length = hobbies.size(); i<length; i++) {
        System.out.println(hobbies.get(i));
      }
        // 초기화 블록은 한번밖에 동작하지 않는다. 
  }
  
  
  public static void ex022() {
    List<String> hobbies = new ArrayList<String>();
    
    hobbies.add("심즈");
    hobbies.add("리그오브레전드");
    hobbies.add("발로란트");
    hobbies.add("마인크래프트");
    
    // 배열 길이 
    System.out.println(hobbies.get(0));
    
    System.out.println(hobbies.size());
    
    for(int i=0, length = hobbies.size(); i<length; i++) {
      System.out.println(hobbies.get(i));
    }
  }
  
  
  public static void main(String[] args) {
    //ex01();
    ex022();
  }

}
