package ex09_Eatable;

public class AppleMango extends Food implements Eatable {

  public AppleMango(String name) {
    super(name);  // food에 전달! 슈퍼 클래스의 public Food(String name) {  } 생성자 호출
  }
}
