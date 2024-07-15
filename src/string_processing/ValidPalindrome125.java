package string_processing;

public class ValidPalindrome125 {
    public boolean isPalindrome(String s) {
        // alphnumeric하지 않은 요소들을 전부 제거하고 최종적으로 담을 변수
        StringBuilder sb = new StringBuilder();

        // 입력받은 문자열을 char 배열로 저장
        char[] arr = s.toCharArray();

        // char배열을 순회하면서 alphanumeric 하지 않은 요소들을 전부 제거
        for(int i=0; i<s.length(); i++){
            char c = arr[i];
            // alphnumeric 하지 않은 경우 그대로 skip
            if(!isAlphanumeric(c)){
                continue;
            }
            // 대문자 -> 소문자
            if(isUpper(c)){
                c+=32;
            }

            // 나머지 alpahnumeric 한 문자들만 sb에 저장
            sb.append(c);
        }

        // 정방향 문자열
        String forward = sb.toString();

        // 역방향 문자열
        String backward = sb.reverse().toString();

        // 서로 순서 바꿔도 같은지 비교해서 같으면 palindrome
        if(forward.equals(backward)){
            return true;
        }
        // 다르면 palindrome
        return false;
    }

    public boolean isAlphanumeric(char c){
        return isNumeric(c) || isUpper(c) || isLower(c);
    }

    public boolean isNumeric(char c){
        return c>='0' && c<='9';
    }

    public boolean isUpper(char c){
        return c>='A' && c<='Z';
    }
    public boolean isLower(char c){
        return c>='a' && c<='z';
    }
}