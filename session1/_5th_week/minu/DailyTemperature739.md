> 문제 확인 하러 가기 : https://leetcode.com/problems/daily-temperatures/description/

```java
import java.util.*;

class Solution{
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque(); 
        int len = temperatures.length;
        int[] answer = new int[len]; // 결과 저장 
        
        for (int i = 0; i < len; i++) {
            // stack.isEmpty() 반드시 추가 
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // 현재 온도가 스택에 있는 온도보다 높다면 
                // answer 배열 갱신
                int last = stack.pop();
                answer[last] = i - last;
            }
            // 현재 인덱스 삽입
            stack.push(i);
        }
        return answer;
    }
}

```
