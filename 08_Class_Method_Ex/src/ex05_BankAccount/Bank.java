package ex05_BankAccount;

public class Bank {

  private String name;
  private String tel;
  
  public Bank() {
  }
  
  public Bank(String name, String tel) {
    this.name = name;
    this.tel = tel;
  }
  
  //  Setter
  // 반환타입 =  void 
  // 이름은 언제나 set + 
  // 타입은 private 값과 같아야함.

  public void setName(String name) {
      this.name = name; 
  }
  
  public void setTel(String tel) {
      this.tel = tel;
  }
  
 
  // Getter
  
  public String getName() {
    return name; 
  }
  
  public String getTel() {
    return tel;
  }
  
  
  public void info() {
    System.out.println(name + "(" + tel + ")");
  }
  
 
}
