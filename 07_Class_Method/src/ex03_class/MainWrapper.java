package ex03_class;

public class MainWrapper {

  public static void main(String[] args) {
    
    // 클래스 이름 = 객체의 타입이다.
    
    // Calculator 객체 선언
    Calculator myCalc;
    
    // Calculator 객체 생성
    myCalc = new Calculator();
    
    // 계산하고자 하는 실수 2개 준비 
    double a = 1.5;
    double b = 1.2;
    
    // 덧셈, 뺄셈, 곱셈, 나눗셈 메소드 호출
    System.out.println(myCalc.addition(a, b));          // 더하기
    System.out.println(myCalc.subtraction(a, b));       // 뺄셈
    System.out.println(myCalc.multiplication(a, b));    // 곱셈
    System.out.println(myCalc.division(a, b));          // 나눗셈
  }

}
