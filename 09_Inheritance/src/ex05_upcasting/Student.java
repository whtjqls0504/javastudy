package ex05_upcasting;

// Student is a Person.
// 서브 클래스(자식) is a 슈퍼클래스(부모)
public class Student extends Person {

  private String school;  // 학교 이름
  
  
  // new Student()
  public Student() {
    // 반드시 슈퍼 클래스의 생성자 호출이 있어야 하기 때문에, 
    // 개발자가 슈퍼 클래스의 생성자를 호출하지 않으면 Java가 직접 슈퍼 클래스의 생성자를 호출한다.
    // Java가 호출하는 슈퍼 클래스의 생성자는 "디폴트 생성자"만 가능하다.
    super();  // 개발자가 작성하지 않아도 자동으로 호출되는 슈퍼 클래스의 디폴트 생성자.
  }
  
  
  // new Student("홍길동", "가산대학교")
  public Student(String name, String school) {
    // new Person("홍길동") 호출을 위한 코드
    super(name);
    this.school = school;
  }


  // Getter Setter 생성 > Source에서
  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  // return하지 않는 Study 메소드 생성
  @Override
  public void study() {
    System.out.println("공부");
  }
  
  @Override       
  // 오버라이드 에너테이션. 슈퍼 클래스의 인포메이션을 다시 만든 오버라이드라고 표기해놓는다.
  public void info() {
    System.out.println("이름 :" + getName()); // name은 Person에서 Private 되어있기 때문에 getter을 불러오는 것.
    System.out.println("학교 :" + school);
  }
  
  
  

}
