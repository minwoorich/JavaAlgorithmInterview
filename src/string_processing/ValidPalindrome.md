> 문제 확인 하러 가기 : https://leetcode.com/problems/valid-palindrome/description/

## 1. 코드
```java
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
```

## 2. 설명

사실 이번 문제는 그리 어려운 문제는 아니였다. 문제 제한 조건이 까다로운것도 아니였고 다양한 문자열 내장함수를 알아야하는것도 아니였다. 그냥 문제를 읽고 떠올린 그 풀이 방식 그대로 풀면 끝이였다. 다만, 어이없는 부분에서 살짝 억까를 당했었는데

<img src="https://velog.velcdn.com/images/minwoorich/post/7e7c8870-d261-4ba5-860d-bed6c8af8eb7/image.png" style="margin:0;width:"/>

<img src="https://velog.velcdn.com/images/minwoorich/post/7142a920-b2b4-40d5-b064-ffb141643434/image.png" style="margin:0;width:"/>

``StringBuilder`` 를 위와 같이 static 필드로 선언해서 사용했을 경우, 계속 채점에서 틀렸다는 결과를 받았다. 컴파일에러도 아니고 채점에서 틀렸다고 하니 나는 당연히 로직에서 뭔가 잘못된게 있나 싶었다.

<img src="https://velog.velcdn.com/images/minwoorich/post/f62e8608-056e-4e63-90d2-18ca900238de/image.png" style="margin:0;width:"/>
<img src="https://velog.velcdn.com/images/minwoorich/post/afdf12ca-4179-4a83-bd18-6b21177510ca/image.png" style="margin:0;width:"/>

진짜 1시간을 뚫어져라 쳐다보다가 "설마,,!" 하는 생각이 들어 ``static`` 으로 선언한 필드를 그냥 로컬 변수로 바꾸니깐 아니나 다를까 테스트 통과를 할 수 있었다. 너무 억울해서 인텔리제이에서도 코드를 돌려봤는데 static으로 선언하건 말건 상관없이 통과했다.

아마 릿코드가 채점을 할 때 테스트 케이스가 서로 완전 독립적이지 않은가보다. 프로그래머스 풀 때는 자주 static 으로 선언해서 풀었고 또 문제도 없었는데,,,쩝,,

아무튼 이번에는 문제 자체의 이슈보단 좀 외적인 부분에서 시간을 많이 잡아먹었다. 

