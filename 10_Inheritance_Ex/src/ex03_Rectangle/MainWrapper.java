package ex03_Rectangle;

public class MainWrapper {

  public static void main(String[] args) {

    // 정사각형 만들기
    Square s1  = new Square();
    s1.setWidth(5);
    s1.setHeight(5);
    s1.info();
  
    
    Square s2 = new Square(6);    // 너비가 6, 높이 6인 정사각형이 만들어진다. 
    s2.info();
  }

}
