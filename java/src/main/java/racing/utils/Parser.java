package racing.utils;

public class Parser {
    public static int parseInt(String s){
        if (s == null || s.isEmpty()){
            throw new IllegalArgumentException("파싱할 값이 공백이거나 null입니다.");
        }
        try {
            return Integer.parseInt(s.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }
}
