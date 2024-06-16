package lotto;

import lotto.Controller.ResultController;
import lotto.enumModel.Numbers;
import lotto.model.Lotto;
import lotto.model.RandomNumbers;
import lotto.util.ListUtil;
import lotto.util.StringUtil;
import lotto.util.Validated;

import java.util.List;
import java.util.Map;

public class RunApplication {
    private final Input input = new Input();
    private final Validated validated = new Validated();
    private final Lotto winningNumbers;

    public RunApplication() {
        int purchasePrice = inputPurchasePrice();
        int countOfLotto = purchasePrice / Numbers.LOTTO_PRICE.getValue();
        List<Lotto> lottoList = publishedNumbers(countOfLotto);
        Output output = new Output();
        output.printPublishedLotto(lottoList);
        winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber();
        ResultController resultController = new ResultController();
        Map<String, Integer> result = resultController.resultData(lottoList, winningNumbers, bonusNumber);
        output.printResult(result, resultController.calRateOfAmount(result, purchasePrice));
    }

    private int inputPurchasePrice() {
        String inputPurchasePrice;
        do {
            inputPurchasePrice = input.inputPurchasePrice();
        } while (!validated.validatePurchasePrice(inputPurchasePrice));
        return Integer.parseInt(inputPurchasePrice);
    }

    private List<Lotto> publishedNumbers(int count) {
        RandomNumbers randomNumbers = new RandomNumbers();
        return randomNumbers.RandomNumbers(count);
    }

    private Lotto inputWinningNumbers() {
        String inputWinningNumbers;
        do {
            inputWinningNumbers = input.inputWinningNumber();
        } while (!validated.validateWinnerNumber(inputWinningNumbers));
        return new Lotto(ListUtil.sort(StringUtil.makeList(inputWinningNumbers)));
    }

    private int inputBonusNumber() {
        String inputBonusNumber;
        do {
            inputBonusNumber = input.bonusNumber();
        } while (!validated.validateBonusNumber(inputBonusNumber, winningNumbers));
        return Integer.parseInt(inputBonusNumber);
    }

}
