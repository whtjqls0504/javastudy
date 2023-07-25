package ex03_Rectangle;

// 정사각형은 사각형이다.

public class Square extends Rectangle{

  // new Square()
  public Square() {
    super();
  }
  
  // new Square(6)
  public Square(int width) {
    super(width, width);  // new Rectangle(6, 6)
  
  }
  
  
}
