package ex02_Soldier;

public class Soldier {

  // 객체 선언
  private Gun gun;
  
  public Soldier(Gun gun) {
    this.gun = gun; // 받아온 총을 필드값으로
    
  }
  
  
  public Soldier(int bullet) {
    gun = new Gun(bullet);
  }
  
  
 public void reload(int bullet) throws RuntimeException {
   gun.reload(bullet);
 }
 
 
 public void shoot() throws RuntimeException {
   gun.shoot();
 }
 
 
 
}
    
  
