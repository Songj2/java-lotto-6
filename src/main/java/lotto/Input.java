package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.enumModel.Messages;

public class Input {

    //    구매금액 입력
    public String inputPurchasePrice() {
        System.out.println(Messages.INPUT_PURCHASE_PRICE.getMessage());
        return Console.readLine();
    }

    //    당첨번호 입력
    public String inputWinningNumber() {
        System.out.println(Messages.INPUT_WINNING_NUMBER.getMessage());
        return Console.readLine();
    }

    //    보너스번호 입력
    public String bonusNumber() {
        System.out.println(Messages.INPUT_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }


}
