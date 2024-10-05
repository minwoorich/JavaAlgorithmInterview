> 문제 확인 하러 가기 : https://leetcode.com/problems/permutations/submissions/1412147693/

```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); // 모든 순열들을 담는 리스트
        List<Integer> list = new ArrayList<>(); // 각 순열들을 담는 임시 리스트
        dfs(result, list, nums);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> list, int[] nums){
        // 모든 숫자들을 다 사용 한 경우
        if(list.size() == nums.length){
            // result 에 순열리스트를 저장
            // 새로운 리스트를 만들어서 add() 해야지 안그러면 에러 발생
            result.add(list.stream().collect(Collectors.toList()));
            return;
        }

        // nums 의 모든 숫자들을 순회
        for(int i=0; i<nums.length; i++){
            // 이미 순열에 값이 포함되어있으면 skip
            if(list.contains(nums[i])){
                continue;
            }
            // 순열리스트에 현재 값 저장
            list.add(nums[i]);
            dfs(result, list, nums);
            // 끝났으면 다시 순열리스트 마지막 값을 제거
            // 다음 값 받을 준비
            list.remove(list.size()-1);
        }
    }
}
```
