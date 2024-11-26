package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Integer> numbers;

    public Player() {
        this.numbers = new ArrayList<>();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void savePlayerNumber(String numberString) {
        clear(); // 초기화
        validInputSize(numberString);   // 입력 값의 자릿수 검증

        for (char number : numberString.toCharArray()) {
            validNumber(number);
            numbers.add(Character.getNumericValue(number));
        }
    }

    private void validInputSize(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("1부터 9까지 서로 다른 3자리 수가 아닙니다.");
        }
    }

    private void validNumber(char number) {
        // 1~9까지 숫자가 아닌 경우
        if (Character.getNumericValue(number) < 1) {
            throw new IllegalArgumentException("1부터 9까지 서로 다른 3자리 수가 아닙니다.");
        }
        if (Character.getNumericValue(number) > 9) {
            throw new IllegalArgumentException("1부터 9까지 서로 다른 3자리 수가 아닙니다.");
        }
        // 중복된 숫자인 경우
        if (numbers.contains(Character.getNumericValue(number))) {
            throw new IllegalArgumentException("1부터 9까지 서로 다른 3자리 수가 아닙니다.");
        }
    }

    private void clear() {
        numbers.clear();
    }
}
