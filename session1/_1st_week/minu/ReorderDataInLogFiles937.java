package string_processing;

import java.util.Arrays;

class Log implements Comparable<Log> {
    int pos; // 원래 배열상에서의 인덱스
    String origin; // 로그 원본 값
    String id; // identifier
    String word; // identifier 제거한 나머지 문자열
    public Log(String str, int pos){
        // 인덱스 위치 저장
        this.pos = pos;

        // 먼저 문자열 파싱하기전 원본을 저장한다
        this.origin = str;

        // identifier 를 떼어내기 위해 첫번째 공백의 인덱스를 저장
        int firstWhiteSpacePos = str.indexOf(" ");

        // id 에 identifier 저장
        this.id = str.substring(0, firstWhiteSpacePos);

        // identifier 제외한 나머지 문자열 word에 저장
        this.word = str.substring(firstWhiteSpacePos);
    }

    // 숫자 로그인지 아닌지 판별하는 메서드
    public boolean isDigitLogs() {
        // 공백 제거 : 이 과정이 없으면 "2 0" 을 숫자로그로 인식 못함
        String spaceRemoved = word.replaceAll("\\s+", "");
        return spaceRemoved.matches("\\d+");
    }

    @Override
    public int compareTo(Log o){
        // 1. 둘 다 숫자 로그인 경우
        // 상대적 위치로 정렬
        if(this.isDigitLogs() && o.isDigitLogs()){
            return this.pos - o.pos;
        }
        // 2. 현재 Log 가 숫자 로그인 경우
        if (this.isDigitLogs() && !o.isDigitLogs()) {
            return 1;
        }
        // 3. 전달받은 Log 가 숫자 로그인 경우
        if (!this.isDigitLogs() && o.isDigitLogs()) {
            return -1;
        }
        // 4-1. 둘 다 문자열 로그인 경우 - 같은 경우 id로 비교
        if (word.compareTo(o.word) == 0) {
            return id.compareTo(o.id);
        }

        // 4-2. 둘 다 문자열 로그인 경우
        return word.compareTo(o.word);
    }
}
public class ReorderDataInLogFiles937 {
    public String[] reorderLogFiles(String[] words) {
        Log[] logs = new Log[words.length];

        // String[] -> Log[] 로 변환
        for(int i=0; i<words.length; i++){
            logs[i] = new Log(words[i], i);
        }
        // 정렬 기준에 맞춰서 정렬됨
        Arrays.sort(logs);

        // Log[] -> String[] 으로 변환
        String[] output = Arrays.stream(logs).map(s -> s.origin).toArray(String[]::new);
        return output;
    }
}
