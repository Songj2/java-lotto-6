package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input= new Input();
        int purchasePrice= input.inputPurchasePrice();
        int lottoCount= purchasePrice/MagicNumbers.LOTTO_PRICE.getValue();
        RandomNumbers randomNumbers= new RandomNumbers();
        List<Lotto> lottoNumbers= randomNumbers.RandomNumbers(lottoCount);
        Output output= new Output();
        output.printPublishedLotto(lottoNumbers);

List<Integer> numbers=input.inputWinningNumber();
SortedList sortedList= new SortedList(numbers);
        Lotto winningNum= new Lotto(sortedList.getList());
        int bonusNumber= input.bonusNumber(winningNum);
        output.printResult(lottoNumbers, winningNum, bonusNumber, purchasePrice);
    }
}
