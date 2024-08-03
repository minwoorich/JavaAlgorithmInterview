> 문제 확인 하러 가기 : https://leetcode.com/problems/product-of-array-except-self/description/

## 1. 코드 

```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length; // 배열 길이
        int ans[] = new int[len]; // 반환 할 배열

        // ans[] 배열을 1로 초기화 해놓는다
        Arrays.fill(ans, 1); 
        
        int current = 1; // 임시적으로 누적곱을 저장해놓을 변수
        // 1. 왼쪽->오른쪽 누적곱을 계산하는 반복문
        for(int i=0; i<len; i++){
            // ans[] 의 각 인덱스에 현재 자기 인덱스 기준 왼쪽 배열(prefix) 원소들에 대한 누적곱이 저장이 된다.
            ans[i] = ans[i] * current;
            // 누적곱 갱신
            current = current * nums[i];
        }

        // 다시 임시 누적곱 변수를 1로 초기화
        current = 1;

        // 2. 왼쪽 <-- 오른쪽 방향으로 누적곱을 계산하는 반복문
        for(int i=len-1; i>=0; i--){
            // ans[] 의 각 인덱스에 현재 자기 인덱스 기준 오른쪽 배열(suffix) 원소들에 대한 누적곱이 저장이 된다.
            ans[i] = ans[i] * current;
            // 누적곱 갱신
            current = current * nums[i];
        }
        return ans;
    }
}
```

