package ex06_Member;

public class Member {

  private String name;  // 이름
  private Contact contact;  // 연락처
  
  
  //  Setter
  public void setName(String name) {
    this.name = name;
  }
  
  public void setContact(Contact contact) {
    this.contact = contact;
  }

  
  // Getter
  public String getName() {
    return name;
  }
  
  public Contact getContact() {
    return contact;
  }
  
}
