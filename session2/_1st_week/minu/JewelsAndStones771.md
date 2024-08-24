> 문제 확인 하러 가기: https://leetcode.com/problems/jewels-and-stones/

## 풀이

```java
import java.util.*;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<>(); // map : 쥬얼리 종류별로 담아두는 해쉬맵 
        char[] jewelsArr = jewels.toCharArray();
        // 쥬얼리 종류별로 map 채우기 (value는 아무값이나 들어가도 상관 X)
        for(char c : jewelsArr){
            map.put(c, 0);
        }

        int count = 0; // 내가 갖고 있는 쥬얼리 수 저장하는 변수
        // stones 순회하면서 
        for(char s : stones.toCharArray()){
            // 쥬얼리 map 에 해당 stone 이 들어있으면 count++
            if(map.containsKey(s)){
                count++;
            }
        }
        return count;
    }
}
```
