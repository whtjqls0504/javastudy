package ex02_Computer;

public class Notebook extends Computer {

  private int battery;
  
  // new Notebook("gram", 70)에 의해서 호출되는 생성자
  /*
  public Notebook() {
    System.out.println("Notebook() 호출");
  }
  
  public Notebook(int battery) {
    this.battery = battery;
    System.out.println("Notebook(int battery) 호출");
  }
  */
  
  public Notebook(String model, int battery) {
    super(model);
    this.battery = battery;
  }

  
  // Getter
  public int getBattery() {
    return battery;
  }
  
  
  // Setter
  public void setBattery(int battery) {
    this.battery = battery;
  }
  
  
  
  
  
  
  
}
