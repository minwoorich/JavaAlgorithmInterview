> 문제 확인 하러 가기 : https://leetcode.com/problems/valid-parentheses/

## 1. 코드

```java
import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('(', 1);
        map.put(')', 1);
        map.put('{', 2);
        map.put('}', 2);
        map.put('[', 3);
        map.put(']', 3);

        Stack<Character> stack = new Stack<>();
        int len = s.length();
        char[] inputs = s.toCharArray();
        for(int i=0; i<len; i++){
            // 1. 현재괄호 개방 인 경우
            if(isOpened(inputs[i])){
                stack.push(inputs[i]); // 개방 괄호는 무조건 stack에 push
                continue;
            }

            // 2. 현재 괄호가 폐쇄 인 경우
            // 2-1) 스택이 비어있을 경우
            if(stack.isEmpty()){
                return false;
            }
            // 2-2) 서로 같은 타입인 경우 
            if(isSameType(map, stack.peek(), inputs[i])){
                stack.pop(); // 같은 타입이므로 스택에서 괄호를 제거
                continue;
            }
            // 2-3) 서로 다른 타입인 경우
            return false; // 서로 다른 타입이 쌍을 이루게되면 false
        }

        // 3. 순회가 끝나고 스택이 비어있으면 true, 아니면 false
        return stack.isEmpty();
        
    }

    private boolean isOpened(char c){
        char[] opened = {'(','{','['};
        return c==opened[0] || c==opened[1] || c==opened[2];
    }

    private boolean isSameType(Map<Character, Integer> map, char c1, char c2){
        return map.get(c1) == map.get(c2);
    }
}


```
