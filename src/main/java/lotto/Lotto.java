package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        checkDuplicatedNumber(numbers);
    }

    private void isCorrectRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            int num = numbers.get(i);
            if(num < 0 || num > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void checkDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> targetset = new HashSet<>(numbers);
        if(targetset.size() != 6) {
            // 중복되는 숫자가 존재. -> 예외처리
            throw new IllegalArgumentException();
        }
    }

    public void printSortedNumbers() {
        Collections.sort(numbers);
        System.out.println(numbers.toString());
    }
}
