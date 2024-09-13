> 문제 확인 하러 가기 : https://leetcode.com/problems/top-k-frequent-elements/

## 풀이

```java
import java.util.*;

class Number implements Comparable<Number>{
    int value;
    int freq;

    public Number(int value, int freq){
        this.value = value;
        this.freq = freq;
    }

    @Override
    public int compareTo(Number o){
        return o.freq - this.freq;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();  
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        Queue<Number> queue = new PriorityQueue<>();
        for(Integer key : map.keySet()){
            queue.add(new Number(key, map.get(key)));
        }
        
        int[] result = new int[k];

        for(int i=0; i<k; i++){
            result[i] = queue.poll().value;
        }
        return result;
    }
}
```
