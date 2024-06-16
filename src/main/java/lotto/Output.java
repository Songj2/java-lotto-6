package lotto;

import java.util.List;

public class Output {
    public Output(){}
    public void printPublishedLotto(List<Lotto> lottoList){
        System.out.println(lottoList.size()+Messages.OUTPUT_PURCHASE_COUNT.getMessage());
        for (Lotto lotto: lottoList){
            System.out.print("[");
            for (int i=0; i<MagicNumbers.LOTTO_COUNT.getValue()-1; i++){
                System.out.printf("%d, ", lotto.getNumbers().get(i));
            }
            System.out.println(lotto.getNumbers().get(MagicNumbers.LOTTO_COUNT.getValue()-1)+"]");
        }
    }
}
