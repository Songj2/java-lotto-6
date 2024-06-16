package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private MagicNumbers magicNumbers;

    public int inputPurchasePrice() {
        String purchase;
        boolean validate;
        do {
            System.out.println(Messages.INPUT_PURCHASE_PRICE.getMessage());
            purchase = Console.readLine();
            validate = validatePurchasePrice(purchase);
        } while (!validate);

        return Integer.parseInt(purchase);
    }

    private boolean validatePurchasePrice(String purchase) {
        if (!validateNum(purchase)) {
            return false;
        }
        if (!validateChanges(Integer.parseInt(purchase))) {
            return false;
        }
        return true;
    }

    private boolean validateNum(String target) {
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
            if (target % MagicNumbers.LOTTO_PRICE.getValue() == 0) {
                return true;
            }
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println(Messages.ERROR_HAVE_CHANGES.getMessage());
            return false;
        }
    }

    public List<Integer> inputWinningNumber() {
        String winnerNumber;
        boolean validate;
        do {
            System.out.println(Messages.INPUT_WINNING_NUMBER.getMessage());
            winnerNumber = Console.readLine();
            validate = validateWinnerNumber(winnerNumber);
        } while (!validate);
        return splitString(winnerNumber) ;
    }

    private boolean validateWinnerNumber(String winnerNumbers) {
        if (!validateNumbers(winnerNumbers)) {
            return false;
        }
        List<Integer> winningNumbers= splitString(winnerNumbers);
        if (!validateRange(winningNumbers)){
            return false;
        }
        if (!duplicated(winningNumbers)) {
            return false;
        }
        if (!validateSize(winningNumbers)){
            return false;
        }
        return true;
    }

    private List<Integer> splitString(String numbers) {
        List<Integer> list = new ArrayList<>();

        if (validateNumbers(numbers)) {
            for (String number : numbers.split(",")) {
                list.add(Integer.parseInt(number));
            }
        }
        return list;
    }

    private boolean validateNumbers(String numbers) {
        for (String number : numbers.split(",")) {
            if (!validateNum(number)) {
                return false;
            }
        }
        return true;
    }

    private boolean validateRange(List<Integer> numbers){
        try {
            for (int number : numbers) {
                if (1 > number || number > 45) {
                    throw new IllegalArgumentException();
                }
            }
        }catch (IllegalArgumentException e){
            System.out.println(Messages.ERROR_RANGE_OVER.getMessage());
            return false;
        }
        return true;
    }
    private boolean duplicated(List<Integer> numbers) {
        try {
            for (int i = 0; i < numbers.size() - 1; i++) {
                if (numbers.get(i).equals(numbers.get(i + 1))) {
                    throw new IllegalArgumentException();
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(Messages.ERROR_DUPLICATED.getMessage());
            return false;
        }
        return true;
    }

    private boolean validateSize(List<Integer> winningNumber){
        try {
            if (winningNumber.size()!= MagicNumbers.LOTTO_COUNT.getValue()){
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            System.out.println(Messages.ERROR_SIZE_MISS.getMessage());
            return false;
        }
        return true;
    }

    public int bonusNumber(Lotto winningLotto){
        String bonusNumber;
        boolean validate;
        do{
            System.out.println(Messages.INPUT_BONUS_NUMBER.getMessage());
            bonusNumber= Console.readLine();

            validate=validateBonusNumber(bonusNumber, winningLotto);
        }while (!validate);
        return Integer.parseInt(bonusNumber);
    }

    private boolean validateBonusNumber(String bonus, Lotto winningNumber){
        if (!validateNum(bonus)){
            return false;
        }
        int bonusNum= Integer.parseInt(bonus);
        if (!compareWinningNumber(bonusNum, winningNumber)){
            return false;
        }
        return true;
    }

    private boolean compareWinningNumber(int bonus, Lotto winningNumber){
        try {
            if (winningNumber.getNumbers().contains(bonus)) {
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            System.out.println(Messages.ERROR_DUPLICATED.getMessage());
            return false;
        }
        return true;
    }
}
