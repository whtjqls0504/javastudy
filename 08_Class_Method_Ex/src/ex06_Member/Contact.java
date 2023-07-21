package ex06_Member;

public class Contact {

  private String homeTel;   // 집전화
  private String mobile;    // 휴대전화
  private Address address;  // 주소 
  

  //Setter
  public void setHomeTel(String homeTel) {
    this.homeTel = homeTel;
  }
  
  public void setMobile(String mobile) {
    this.mobile = mobile;
  }
  
  public void setAddress(Address address) {
    this.address = address;
  }
  
  
  // Getter
  public String getHomeTel() {
    return homeTel;
  }
  
  public String getMobile() {
    return mobile;
  }
 
  public Address getAddress() {
    return address;
  }
  
  
  
}
