> 문제 확인 하러 가기 : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

## 1. 코드
```java
import java.lang.*;

class Solution {
    public int maxProfit(int[] prices) {
        int crnt = prices[0]; // 구매 가격
        int todayProfit = 0; // 오늘 팔면 남는 손익
        int max = 0; // 최대 이익

        for(int i=1; i<prices.length; i++){
            // 만일 새 가격이 내가 샀던 가격보다 쌀 경우 
            if(crnt > prices[i]){
                // 새 가격을 crnt 에 저장
                crnt = prices[i];
            }
            // 오늘 팔면 남는 손익 = 현재가격 - 내가 산 가격
            todayProfit = prices[i] - crnt;

            // 오늘 팔면 남는 손익이 더 클 경우 max 에 저장
            max = (max > todayProfit) ? max : todayProfit;
        }
        return max;
    }
}
```
