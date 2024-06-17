package lotto;

import lotto.Controller.ResultController;
import lotto.enumModel.Numbers;
import lotto.model.Lotto;
import lotto.model.RandomNumbers;
import lotto.util.StringUtil;
import lotto.util.Validated;

import java.util.List;
import java.util.Map;

public class RunApplication {
    private final Input input = new Input();
    private final Validated validated = new Validated();
    private final Lotto winningNumbers;

    public RunApplication() {
        int purchasePrice = Integer.parseInt(inputPurchasePrice());
        int countOfLotto = purchasePrice / Numbers.LOTTO_PRICE.getValue();
        List<Lotto> lottoList = publishedNumbers(countOfLotto);

        Output output = new Output();
        output.printPublishedLotto(lottoList);
        winningNumbers = new Lotto(StringUtil.makeList(inputWinningNumbers()));

        int bonusNumber = Integer.parseInt(inputBonusNumber());

        ResultController resultController = new ResultController();
        Map<String, Integer> result = resultController.resultData(lottoList, winningNumbers, bonusNumber);
        output.printResult(result, resultController.calRateOfAmount(result, purchasePrice));
    }

    private String inputPurchasePrice() {
        String inputPurchasePrice;
        do {
            inputPurchasePrice = input.inputPurchasePrice();
        } while (!validated.validatePurchasePrice(inputPurchasePrice));
        return inputPurchasePrice;
    }

    private List<Lotto> publishedNumbers(int count) {
        RandomNumbers randomNumbers = new RandomNumbers();
        return randomNumbers.RandomNumbers(count);
    }

    private String inputWinningNumbers() {
        String inputWinningNumbers;
        do {
            inputWinningNumbers = input.inputWinningNumber();
        } while (!validated.validateWinnerNumber(inputWinningNumbers));
        return inputWinningNumbers;
    }

    private String inputBonusNumber() {
        String inputBonusNumber;
        do {
            inputBonusNumber = input.bonusNumber();
        } while (!validated.validateBonusNumber(inputBonusNumber, winningNumbers));
        return inputBonusNumber;
    }

}
