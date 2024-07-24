> 문제 확인 하러 가기 : https://leetcode.com/problems/group-anagrams/description/

## 1. 코드

```java
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
```

## 2. 풀이

솔직히 그럴싸한 알고리즘을 쓰진 않았고 약간 구현 문제 풀듯이 풀었다. 큰 틀은 입력 배열을 순회하면서 서로 모두 비교하면서 애너그램인지 아닌지 판별하는 것이다.

### 1️⃣ 첫번째 사이클
``["eat","tea","tan","ate","nat","bat"]``
0) ["eat"]
1) ``eat`` ``tea`` 비교 -> 애너그램 O -> ["eat", "tea"]
2) ``eat`` ``tan`` 비교 -> 애너그램 X
3) ``eat`` ``ate`` 비교 -> 애너그램 O -> ["eat", "tea", "ate"]
4) ``eat`` ``nat`` 비교 -> 애너그램 X
5) ``eat`` ``bat`` 비교 -> 애너그램 X

#### 첫번째 그룹 [["eat", "tea", "ate" ]]

### 2️⃣ 두번째 사이클
``["eat","tea","tan","ate","nat","bat"]``
0) ["tan"] ( "tea" 는 이미 그룹핑이 되었으므로 건너 뜀)
1) ``tan`` ``nat`` 비교 -> 애너그램 O -> ["tan", "nat"]
2) ``tan`` ``bat`` 비교 -> 애너그램 X
#### 두번째 그룹 [["eat", "tea", "ate"], ["tan", "nat"]]

### 3️⃣ 세번째 사이클
``["eat","tea","tan","ate","nat","bat"]``
0) ["bat"] 
#### 세번째 그룹 [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]

