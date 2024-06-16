package lotto;

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

    }
}
