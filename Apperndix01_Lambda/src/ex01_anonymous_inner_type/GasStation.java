package ex01_anonymous_inner_type;

public class GasStation {
  
  private int totalOil; // 주유소가 갖고 있는 전체 기름
  private int payPerLiter;  // 리터당 요금
  private int earning;
  
  
  public GasStation() {
    // TODO Auto-generated constructor stub
  }

  
  public void sellOil(String model, int oil) {
    
    
    // Car 인터페이스를 구현한 별도 클래스를 만들고, 해당 클래스 객체를 만들고, addOil() 호출
    // Car's addOil()
    // Car은 인터페이스이기 때문에 new Car가 불가능하다.
  
    // Car car 지역변수(객체) 선언 (sellOil 메소드 호출 시 생성되고, sellOil 메소드 종료 시 소멸된다.)
    Car car;
    
    // car 지역변수(객체) 생성  -> 이것이 람다이다.
    car = new Car() {
      
      @Override
      public void addoil() {
        // TODO Auto-generated method stub
          totalOil -= oil;
          earning += oil * payPerLiter; 
          System.out.println(model + " " + oil + "L 주유 완료");
      }
    };
   
    // Car car 지역변수(객체)의 addOil() 메소드 호출
    car.addoil();
    
  }
  
  
  
  
  public int getTotalOil() {
    return totalOil;
  }

  public void setTotalOil(int totalOil) {
    this.totalOil = totalOil;
  }

  public int getPayPerLiter() {
    return payPerLiter;
  }

  public void setPayPerLiter(int payPerLiter) {
    this.payPerLiter = payPerLiter;
  }

  public int getEarning() {
    return earning;
  }

  public void setEarning(int earning) {
    this.earning = earning;
  }
  
  

}
