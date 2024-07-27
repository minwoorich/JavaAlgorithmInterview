class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 중첩 배열
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
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
