package ex06_GameUnit;

public class Marine extends GameUnit {

  private final int POWER = 5;  // 공격력
  
// new Marine("마린")
  
  public Marine(String name) {
    super(name);
  }
  
  @Override
  public void attack(GameUnit other) {  // unit1.attack(unit2)
    System.out.println(getName() + "의 공격!");
    if(POWER >= other.getHp())  {// 내 힘(power)와 다른사람의 hp가 같을 수 있다. 
      other.setHp(0);
    }
    other.setHp(other.getHp() - POWER);
  }
  
  }
