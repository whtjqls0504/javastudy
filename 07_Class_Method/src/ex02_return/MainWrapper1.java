package ex02_return;

import java.util.Arrays;

public class MainWrapper1 {

  /*
   * 반환(return)
   * 1. 메소드의 실행 결과 값을 의미한다.
   * 2. 반환 값이 없는 경우에는 void 키워드를 작성하고, 반환 값이 있는 경우에는 반환값의 타입을 작성한다.
   * 
   */
  
  public static void main(String[] args) {
    System.out.println(getName());  // getter
    System.out.println(getAge() + "세");
    System.out.println(isAlive());
    System.out.println(Arrays.toString(getHobbies())); // String 배열로 사용하기.
  }
  public static String[] getHobbies() {
    String[] hobbies = {"게임", "디자인", "심즈"};
    return hobbies;
  }
  
  
  public static boolean isAlive() {
    boolean isAlive = getAge() <=100;
    return  isAlive;        //연산값. 100과 같거나 이하이다.
  }
  
  
  public static int getAge() {
    int age = 500;
    return age;
    
  }
  public static String getName() {
    String name = "홍길동";
    return name; // 메소드를 호출한 곳으로 반환한다.
  }
  
}
