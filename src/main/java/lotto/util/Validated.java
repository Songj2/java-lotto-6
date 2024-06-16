package lotto.util;

import lotto.enumModel.Numbers;
import lotto.enumModel.Messages;
import lotto.model.Lotto;

import java.util.List;

public class Validated {
    public Validated() {
    }

//    구매금액 유효성 검사
    public boolean validatePurchasePrice(String purchase) {
        if (!validateNumber(purchase)) {
            return false;
        }
        return validateChanges(Integer.parseInt(purchase));
    }

    private boolean validateNumber(String target) {
        try {
            if (target.matches("^[0-9]+$")) {
                return true;
            }
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println(Messages.ERROR_TYPE_NOT_INTEGER.getMessage());
            return false;
        }
    }

    private boolean validateChanges(int target) {
        try {
            if (target % Numbers.LOTTO_PRICE.getValue() == 0) {
                return true;
            }
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println(Messages.ERROR_HAVE_CHANGES.getMessage());
            return false;
        }
    }

//    당첨번호 유효성 검사
    public boolean validateWinnerNumber(String winnerNumbers) {
        return validateNumbers(winnerNumbers);
    }

    private boolean validateNumbers(String numbers) {
        for (String number : numbers.split(",")) {
            if (!validateNumber(number)) {
                return false;
            }
        }
        return validateRange(StringUtil.makeList(numbers));
    }

    private boolean validateRange(List<Integer> numbers) {
        try {
            rangeCondition(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(Messages.ERROR_RANGE_OVER.getMessage());
            return false;
        }
        return duplicated(numbers);
    }

    private void rangeCondition(List<Integer> numbers){
        for (int number : numbers) {
            if (Numbers.LOTTO_MIN_VALUE.getValue() > number || number > Numbers.LOTTO_MAX_VALUE.getValue()) {
                throw new IllegalArgumentException();
            }
        }
    }

    private boolean duplicated(List<Integer> numbers) {
        try {
            duplicatedCondition(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(Messages.ERROR_DUPLICATED.getMessage());
            return false;
        }
        return validateSize(numbers);
    }

    private void duplicatedCondition(List<Integer> numbers){
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i).equals(numbers.get(i + 1))) {
                throw new IllegalArgumentException();
            }
        }
    }

    private boolean validateSize(List<Integer> winningNumber) {
        try {
            if (winningNumber.size() != Numbers.LOTTO_COUNT.getValue()) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(Messages.ERROR_SIZE_MISS.getMessage());
            return false;
        }
        return true;
    }

//    보너스 번호 유효성 검사
    public boolean validateBonusNumber(String bonus, Lotto winningNumber) {
        if (!validateNumber(bonus)) {
            return false;
        }
        return compareWinningNumber(Integer.parseInt(bonus), winningNumber);
    }

    private boolean compareWinningNumber(int bonus, Lotto winningNumber) {
        try {
            if (winningNumber.getNumbers().contains(bonus)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(Messages.ERROR_DUPLICATED.getMessage());
            return false;
        }
        return true;
    }
}
