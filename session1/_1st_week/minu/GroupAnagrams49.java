
import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length; // 입력 배열 길이
        
        List<List<String>> result = new ArrayList<>(); // 바깥쪽 List
        boolean[] grouped = new boolean[len]; // 이미 그룹핑 된 문자열인지 아닌지 기록하는 배열

        for(int i=0; i<len; i++){
            String current = strs[i]; // 현재 문자열
            // 만약 i 번째 원소가 이미 그룹핑된 단어라면 다음 원소로 바로 skip
            if(grouped[i]){
                continue;
            }
            // 그렇지 않다면 그룹핑 시키기
            grouped[i] = true;

            List<String> group = new ArrayList<>(); // 안쪽 List

            // 그룹에 시작 문자열 추가
            group.add(current);

            // 결과 리스트에 미리 그룹 추가해놓기
            result.add(group);
            
            for(int j=i+1; j<len; j++){
                String other = strs[j]; // 다음 문자열

                // 만약 두 문자열이 애너그램이라면
                if(isAnagram(current, other)){
                    // other 문자열은 그룹핑 되었음을 기록
                    grouped[j]=true;

                    // group 에 other 추가
                    group.add(other);
                }
            }
        }
        return result;
    }

    private boolean isAnagram(String str1, String str2){
        // 만약 두 문자열 길이가 다르면 anagram 이 될 수 없음으로 false 반환
        if(str1.length() != str2.length()){
            return false;
        }

        // 두 문자열을 배열에 담아 사전순으로 정렬
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // 사전순으로 정렬된 두 배열이 하나라도 문자가 다르면 false 반환
        for(int i=0; i<arr1.length; i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }

        // 모두 같으면 true 반환
        return true;
    }
}
