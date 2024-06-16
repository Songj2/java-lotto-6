package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private MagicNumbers magicNumbers;

    public int inputPurchasePrice() {
        String purchase;
        boolean validate;
        do {
            System.out.println(Messages.INPUT_PURCHASE_PRICE.getMessage());
            purchase = Console.readLine();
            validate=validate(purchase);
        } while (!validate);

        return Integer.parseInt(purchase);
    }

    private boolean validate(String purchase) {
        return validateNum(purchase) && validateChanges(Integer.parseInt(purchase));
    }

    private boolean validateNum(String target) {
        try {
            if (target.matches("^[0-9]+$")) {
                return true;
            }
            throw new IllegalArgumentException();
        }catch (IllegalArgumentException e){
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
        }catch (IllegalArgumentException e){
            System.out.println(Messages.ERROR_HAVE_CHANGES.getMessage());
            return false;
        }
    }
}
