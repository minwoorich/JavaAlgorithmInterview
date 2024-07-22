import java.util.*;
import java.lang.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        // 단어별 출현 횟수 저장용 Map
        HashMap<String, Integer> map = new HashMap<>();

        // 소문자로 변경 -> " !?',;." 특수기호들을 구분자로 사용
        String[] words = paragraph.toLowerCase().split("[!?',;\\.\\-\\s]+");

        
        for(String word: words){
           // 만일 금지 단어라면 카운트 안 함 
           if(contains(word, banned)){
                continue;       
           }
           // 단어 별로 출현 횟수 저장
           map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int max = 0; // 최대 출현 횟수 저장
        String result = ""; // 최대 출현 단어 저장

        // Map 순회
        for(String word : map.keySet()) {
            int count = map.get(word); // count = 출현 횟수

            // 현재 단어 출현 횟수 > 이전 최대값 인 경우
            if(count > max){
                max = count; // max 갱신
                result = word; // result 갱신
            }
        }
        return result;
    }

    private boolean contains(String target, String[] banned){
        for(String s : banned){
            if(s.equals(target)){
                return true;
            }
        }
        return false;
    }
}
