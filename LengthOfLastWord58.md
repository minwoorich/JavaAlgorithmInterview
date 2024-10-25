> 문제 확인 하러 가기 : https://leetcode.com/problems/length-of-last-word/

```java
class Solution {
    public int lengthOfLastWord(String s) {
        String[] str = s.split(" ");
        return str[str.length-1].length();
    }
}
```
