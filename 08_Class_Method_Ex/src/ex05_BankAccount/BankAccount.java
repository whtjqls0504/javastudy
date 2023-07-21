package ex05_BankAccount;

public class BankAccount {

  private Bank bank;
  private String accNo;
  private  long balance;
  
  
 public BankAccount() {
    
  }
  
  public BankAccount(Bank bank, String accNo, long balance) {
    this.bank = bank;
    this.accNo = accNo;
    this.balance = balance;
  }

  // Setter
  
  public void setBank(Bank bank) {
    this.bank = bank;
  }

  public void setAccNo(String accNo) {
    this.accNo = accNo;
  }

  public void setBalance(long balance) {
    this.balance = balance;
  }

  
  
  // Getter
  
  public Bank getBank() {
    return bank;
  }
  
  public String getAccNo() {
    return accNo;
  }
  
  public long getBalance() {
    return balance;
  }

  
  public void info() {
    System.out.println("계좌번회: " + accNo + ", 통장잔액: " + balance + "원");
    System.out.println("개설지점: ");
    bank.info();
  }
  
  // 입금
  
  public void deposit(long money) {
    if(money <= 0) {
      return;
    }
    balance += money;
  }
  
  // 출금?
  public long withdrawal(long money) {
    long retVal = 0;
    if(money> 0 && money <= balance) { // money가 0보다 크다 그리고 money가 balance보다 작을때,
      balance -= money; 
      retVal = money; 
     // 그게 아니라면 요청한 금액만큼 빼주기
     // 그 요청된 금액을 retVal에 넣어주기
    }
    return retVal;
    
  }
  
  public void transfer(BankAccount acc, long money) {
    acc.deposit(withdrawal(money));// 내 통장에서 실제로 출금된 금액 만큼 상대 계좌에 입금.
  }
  
 
  
 

  
}
