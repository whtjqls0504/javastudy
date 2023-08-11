package ex04_Lotto;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Lotto {
  
  /**
   * 로또 구매<br>
   * 로또 구매를 위해서 사용자로부터 money를 입력 받는 메소드<br>
   * 로또 구매 비용은 최소 1000, 최대 100000이다.<br>
   * @return money 사용자가 입력한 로또 구매 비용에서 1000 미만 단위는 버리고 반환. ex) 5999 입력 시 5000 반환
   * @return 0 로또 구매 실패 시 반환
   */
  public int buyLotto() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Lotto를 얼마나 구입하시겠습니까?(최대 10만원) >>> ");
    int money = sc.nextInt();
    sc.close();
    if(money <1000 || money>100000) {
      System.out.println(money + "원 Lotto 구매는 불가능합니다.");

      return 0;
    }
    
    // 나누지만 몫을 구하기 위함이다. 
    // ex) 5999 / 1000 -> 5
    return money / 1000 * 10000;
        

  }
  
  /**
   * 로또 번호 생성<br>
   * 로또 구매 비용만큼 로또 번호를 생성하는 메소드<br>
   * 5게임씩 끊어서 생성된 로또 번호를 출력한다.<br>
   * @param money 로또 구매 비용
   */
  public void generateLotto(int money) {
    // 로또 구매 용지 : 5게임 기록
    /*
     *  row=1 1 2 3 4 5 6
     *  row=2 3 2 1 4 6 5
     *  row=3 6 5 4 3 7 9
     *  row=4 9 8 6 4 5 3
     *  row=5 8 3 4 5 1 2
     */
    
    // 즉, 금액에 따라서 연산을 돌릴 수 있다.
    // 구매금액이 5000원 이상이라면 행은 최대 5개 money를 1000으로 나누면?
    // while문 말고 if문 사용 가능여부 확인 필요.
    
    while(money > 0) {
      int row = (money >= 5000) ? 5 : money / 1000;
      int [][] lotto = new int[row][6];   // 행은 row. 열은 6개
      
      for(int i=0; i<lotto.length; i++) {
        // 6개의 랜덤숫자 만들기
        SecureRandom secureRandom  = new SecureRandom();
        Set<Integer> set = new HashSet<Integer>();
        while(set.size() != 6) {
          set.add(secureRandom.nextInt(45) + 1);  // 45 숫자중 하나가 랜덤으로 나온다. 
        }
        
        // set에 저장된 공 6개를 꺼낼 수 있는 팔
        Iterator<Integer> arm = set.iterator();
       
        for(int j=0; j<lotto[i].length; j++) {
         lotto[i][j] = arm.next();  // 중복을 삭제해주는 Set를 준비하자.
         
         
       } 
      } 
      for(int i=0; i<lotto.length; i++) {
        System.out.print(String.format("%02d",i + 1));
        for(int j=0; j<lotto[i].length; j++) {
          System.out.print(String.format("%4d", lotto[i][j]));
        }
        System.out.println();
      }
      
      System.out.println("------------------------------");
      
      // lotto[i]는 1차원 배열. // money는 5000원씩 마이너스(-) 된다. s
      money -= 5000;  
      
    }
   
    
  }
  
}
