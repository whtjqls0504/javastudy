package ex03_Soldier;

/**
 * 
 * @author GDJ
 *
 */

public class Gun {
  
  private int bullet;
  private final int MAX_BULLET = 50;
  
  public Gun(int bullet) {
    this.bullet = bullet > MAX_BULLET ? MAX_BULLET : bullet;   // 조건식을 활용
    
    
  }
   
  public void reload(int bullet) {
    if(this.bullet + bullet > MAX_BULLET) {
      System.out.println(bullet + "발은 장점이 불가능합니다.");
      return;
    }
    this.bullet += bullet;
    System.out.println(bullet + "발이 장전되었습니다. 햔제 " + this.bullet+ "발이 들어있습니다.");
  }
  
  
  public void shoot() {
    if(bullet== 0) {
     System.out.println("헛빵!"); 
     return;
    }
    bullet--;
    System.out.println("빵! 현재" +  bullet + "발이 남았습니다.");
  }
  
  
  
  
}
