package ex07_Car;

public class Driver {
  
    private String name;        // 이름
    private int career;         // 운전경력
    private boolean bestDriver; // 최고의운전수인가 
    // 기준 career가 10년 이상이면 true
    
    
    // Getter
    public String getName() {
      return name;
    }

    public int getCareer() {
      return career;
    }

    public boolean isBestDriver() {
      return bestDriver;
    }

    
    // Setter
    public void setName(String name) {
      this.name = name;
    }
    
    public void setCareer(int career) {
      this.career = career;
      setBestDriver(career >= 10);
    }
    
    private void setBestDriver(boolean bestDriver) {
      this.bestDriver = bestDriver;
    }

    
}
