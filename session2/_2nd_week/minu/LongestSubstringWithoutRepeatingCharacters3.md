> 문제 확인 하러 가기: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

## 코드

```java
import java.lang.*;
import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>(); // substring 저장소
        int left = 0; // substring 의 시작 인덱스
        int right = 0; // substring 의 마지막 인덱스+1
        int max = 0; // 최대 길이 저장

        // 문자열 s 를 순회
        // 맵에 문자 하나 하나를 저장 해나감. map = (문자, 현재 인덱스(=right))
        for(char c : s.toCharArray()){
            // 만일 이미 저장(중복)된 문자를 만난 경우, 
            if(map.containsKey(c) && left<=map.get(c)){
                 // 해당 문자가 저장된 인덱스의 다음 칸으로 left 를 갱신
                left = map.get(c)+1;
            } 
            // substring의 최대길이를 갱신 
            max = Math.max(max, right-left+1);

            // 현재 문자와 현재 인덱스 저장
            map.put(c, right);
            // right 은 한 칸 이동
            right++;
        }
        return max;
    }
}
```
