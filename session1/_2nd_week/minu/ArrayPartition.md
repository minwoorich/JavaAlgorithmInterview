> 문제 확인 하러 가기 : https://leetcode.com/problems/array-partition/description/

## 1. 정답

```java
import java.lang.*;
import java.util.*;

class Solution {
    public int arrayPairSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        int sum = 0;
        for(int i=0; i<len/2; i++){
            sum+=Math.min(nums[2*i], nums[2*i+1]);
        }

        return sum;
    }
}
```

## 2. 풀이
이 문제는 브루트 포스로는 절대 통과 할 수 없는 문제다. 물론 난 그것도 모르고 순열 조합처럼 푼답시고 dfs, bfs, 쌩 브루트포스 별의 별 반복문과 재귀 코드를 시도했었고 처참히 깨졌다. 

무지성 반복문 밖에 돌릴 줄 모르던 본인은 결국 장막을 들춰봤고(hint를 까봤고), 떡 하니 이문제는 브루트 포스를 쓰지 말라고 적혀있는것을 보았다.
문제는 그 힌트만으로는 전혀 도움이 되지않아 ``hint`` 를 한번 더 들춰봤고 

> "Did you observe that- Minimum element gets add into the result in sacrifice of maximum element."
> 최소값이 최대값 대신 결과에 들어가는것을 확인하셨나요? 

라는 내용을 확인 할 수 있었다.

이걸 본 순간 "아 이건 그리디 다" 를 깨달았다. 문제는 그리디의 경우 솔직히 딱 정해진 포맷이 없다. 그냥 가장 이득이 될 만한 패턴을 찾아서 문제를 풀어야하기 때문에 좀 어렵다. (난 그렇게 생각한다)

앞에서 언급한 힌트의 핵심은

> 최대값이 들어가야하는데 ``min()`` 함수 때문에 계속 최소값이 들어가게 되는것을 알아차렸느냐?! 

라는 것이다.

### 끼리끼리 패턴
계속해서 ``min()`` 에 의해 큰 수 들이 작은 수 대신 희생되는것을 막기위해서는 어떻게 해야할까?

정답은 **끼리끼리 비교** 하는 것이다. 

좀 더 정확히 말하면, 짝을 지을 때 최대한 서로 간의 차이가 적은 애들끼리 묶어놓는것이 최대 결과값을 도출 해낼 수 있다는 것이다. 

그러기 위해서는 자연스레 배열을 먼저 **정렬** 을 해놓는 것이다.

그래야지 고만 고만한 애들끼리 짝을 지을 수 있고, 차이가 큰 수끼리의 비교로 인한 최대값 희생이 줄어들 수 있는것이다. 


