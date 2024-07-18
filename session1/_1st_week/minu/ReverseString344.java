package string_processing;

public class ReverseString344 {
    public void reverseString(char[] s) {
        // 입력 배열 s의 길이
        int len = s.length;

        // ex) len = 10인 경우,
        // 0 <-> 9
        // 1 <-> 8
        // 2 <-> 7
        // 3 <-> 6
        // 4 <-> 5
        // 번째 원소 끼리 서로 자리 교환
        for(int i=0; i<len/2; i++){
            char temp = s[i];
            s[i] = s[len-1-i];
            s[len-1-i] = temp;
        }
    }
}
