package ex04_Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MainWrapper {

  /*
   * HashMap
   * 1. Map 인터페이스를 구현한 클래스이다.
   * 2. 객체(Object)/인스턴스(Instance)를 대신할 수 있는 자료구조이다.
   * 3. 용어
   *    1) Entry  : Key + Value를 합쳐서 부르는 말.
   *    2) Key    : 데이터를 식별하는 식별자. (변수명, 혹은 아이디)
   *    3) Value  : 데이터 자체(변수에 저장된 값. Pass)
   * 4. 특징
   *    1) Key    :중복이 불가능하다.(HashSet 구조로 되어있다.)
   *    2) Value  :중복이 가능하다.
   *    3) Key와 Value 모두 Generic 처리한다.
   */
  
  public static void ex01() {
    
    // Map 인터페이스 타입으로 HashMap 선언
    Map<String, String> dict;
    
    // HashMap의 생성
    dict = new HashMap<String, String>();
 
    // Entry 저장(Key, Value)
    dict.put("봄", "spring");
    dict.put("여름", "summer");
    dict.put("가을", "autumn");
    dict.put("겨울", "winter");

    // Value 확인(Key를 전달한다.)
    System.out.println(dict.get("봄"));
    System.out.println(dict.get("여름"));
    System.out.println(dict.get("가을"));
    System.out.println(dict.get("겨울"));

    
    
  
  }  
  
  public static void ex02() {
    
    // HashMap 선언 & 생성 
    Map<String, Object> person = new HashMap<String, Object>();
    // 원하는 값을 전부 적을 수 있다 : Object ( 대부분 String / Integer 타입을 사용한다.)
    
    // Entry 저장 (Key는 변수명으로, Value는 변수 값으로 저장)
    person.put("name", "홍길동");  // put은 수정이라는 뜻을 가지고있다.
    person.put("age", 24);
    person.put("work", "도적");
    
    
    // Entry 수정(기존의 Key를 사용하면 해당 Key의 Value가 수정되는 방식)
    person.put("name", "로라");
    person.put("age", "22");
    person.put("work", "직장인");
    
    // Value 확인 
    System.out.println(person.get("name"));
    System.out.println(person.get("age"));
    System.out.println(person.get("work"));
  }
  
  
  public static void ex03() {
    
    // 반복문으로 돌리기
    Map<String, Object> map = new HashMap<String, Object>();
    
    // Entry 저장
    map.put("top", 10);
    map.put("bottom", 20);
    map.put("left", 30);
    map.put("right", 40);
  
    // 반복자(Iterator)을 이용한 순회 
    // 1. Key만 모두 꺼내서 Set에 저장한다. (keySet 메소드)
    // 2. Set에 반복자(Iterator)를 붙여서 Key를 하나씩 꺼낸다.
    // 3. get() 메소드에 Key를 전달하면 Value가 나온다. 
    
    Set<String> keySet = map.keySet();
    Iterator<String> arm = keySet.iterator(); // arm 부여 -> keySet에 반복자 붙이기.
    
    while(arm.hasNext()) {
      String key = arm.next();  // 값 꺼내기
      Object value = map.get(key);
      System.out.println(key + ": "  + value);
    }
  }
  
  public static void ex04() {
    
    // HashMap 선언 & 생성 
    Map<String, Object> map = new HashMap<String, Object>();
    
    // Entry 추가
    map.put("id", "admin");
    map.put("pw", "1234");
    map.put("role", "DBA");
    
    // 향상 for 문 순회 (Entry 단위로 값을 빼는 entrySet() 메소드 활용)
    for(Map.Entry<String , Object> entry : map.entrySet()) {
      String key = entry.getKey();
      Object value = entry.getValue();
      System.out.println(key + ": "  + value);
          
    }
  }
  
  
  public static void main(String[] args) {
    //ex01();
    //ex02();
    //ex03();
    ex04();
  }

}
