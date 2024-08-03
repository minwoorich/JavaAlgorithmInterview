import java.lang.*;
import java.util.*;

class Solution {
    public int arrayPairSum(int[] nums) {
        
        int len = nums.length; // 배열 길이 미리 저장

        // 배열 오름차순 정렬
        Arrays.sort(nums);
       
        int sum = 0; // 결과 저장 변수

        // 숫자 쌍 개수(=길이/2 ) 만큼 반복
        for(int i=0; i<len/2; i++){
            // 2칸씩 건너 띄어야함으로 2를 곱해줌. (2*i)
            // 앞,뒤로 숫자쌍을 만들었으므로 +1 만큼 차이 (2*i , 2*i+1)
            sum+=Math.min(nums[2*i], nums[2*i+1]);
        }

        return sum;
    }
}
