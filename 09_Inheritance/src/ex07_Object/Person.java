package ex07_Object;

import java.util.Objects;

/*
 * 
 * 자바는 부모가 없는 클래스가 없다. 모든클래스는 슈퍼 클래스가 존재하는데 
 * java.lang.(패키지 이름)Object 클래스
 * 
 * 1. 모든 클래스의 최상위 슈퍼 클래스이다.
 * 2. 별도의 슈퍼 클래스를 명시하지 않는 클래스들은(extends가 없는 클래스) 모 Object 클래스이다.
 * 3. 모든 것을 저장 할 수 있는 java의 만능 타입이다.
 * 4. Object 타입으로 저장하면 Object 클래스의 메소드만 호출 할 수 있다. 이를 해결하기 위해서 "반드시" 캐스팅을 해야한다.
 */

/*
 *  ┌--------------┐
 *  │  Object      │ 슈퍼 클래스
 *  │--------------│
 *  │  equals()    │ 두 객체의 참조값을 비교해서 같으면 true, 아니면 false 반환
 *  │  getClass()  │ 어떤 클래스인지 반환
 *  │  hashCode()  │ int 타입의 해시코드값, Object 클래스는 객체의 참조값을 해시코드값으로 사용함
 *  │  toString()  │ "클래스이름@참조값" 형식의 문자열을 반환
 *  │  notify()    │ 스레드(thread) 관련 메소드
 *  │  wait()      │ 스레드(thread) 관련 메소드
 *  └--------------┘
 *          ▲
 *          │
 *          │
 *  ┌--------------┐
 *  │  Person      │ 서브 클래스
 *  │--------------│
 *  │  @Override   │
 *  │  equals()    │ 이름과 나이가 같으면 true, 아니면 false 반환 (하드코딩하지 않고, 자동완성한다.)
 *  │              │
 *  │  @Override   │
 *  │  toString()  │ 이름과 나이를 확인할 수 있는 문자열 반환 (하드코딩하지 않고, 자동완성한다.)
 *  └--------------┘
 */

public class Person {

  private String name;
  private int age;
  
  // new Person()
  public Person() {
    
  }
  
  // new Person("홍길동", 20)
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  
  
  
  @Override
  public int hashCode() {
    return Objects.hash(age, name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)  // p1.equals(p1) 이 경우는 if문 1번을 통해 처리하라.
      return true;
    if (obj == null)  // p1.equals(null) 이런 경우는 false값으로
      return false;
    if (getClass() != obj.getClass()) // p1.equals(s1)  전혀 다른값으로 비교하고 있다.
      return false;
    Person other = (Person) obj;
    return age == other.age && Objects.equals(name, other.name);
  }


  @Override
  public String toString() {
    return "Person [name=" + name + ", age=" + age + "]";
  }
  

  // Getter Setter
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
  
}

