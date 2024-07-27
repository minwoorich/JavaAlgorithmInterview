> 문제 확인 하러 가기 : https://leetcode.com/problems/two-sum/description/

## 1. 풀이

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 2중 for문을 돌면서 
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){ // 같은 숫자를 더하면 안되므로 j=i+1 
                // 두수의 합이 target 값이랑 같으면 해당 인덱스 배열을 반환
                if(nums[i]+nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        // 아니면 null 반환
        return null;
    }
}
```

## 2. 알게 된 점

기초적인 문제라 주석으로 대체
