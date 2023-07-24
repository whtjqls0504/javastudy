package ex09_Family;

public class Person {

  private String name;
  private int age;
  
  // 생성자 
  public Person() {
 
  }
  
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  
  
  
  // Getter 
  public String getName() {
    return name;
  }
  public int getAge() {
    return age;
  }
  
  
  // Setter
  public void setName(String name) {
    this.name = name;
  }
  public void setAge(int age) {
    this.age = age;
  }
  
  
}
