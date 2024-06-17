package lotto;

import lotto.enumModel.Numbers;
import lotto.enumModel.Messages;
import lotto.enumModel.WinningRank;
import lotto.model.Lotto;

import java.util.List;
import java.util.Map;

public class Output {
    public Output() {
    }

    //    발행된 로또 번호 출력
    public void printPublishedLotto(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + Messages.OUTPUT_PURCHASE_COUNT.getMessage());
        for (Lotto lotto : lottoList) {
            System.out.print("[");
            for (int i = 0; i < Numbers.LOTTO_COUNT.getValue() - 1; i++) {
                System.out.printf("%d, ", lotto.getNumbers().get(i));
            }
            System.out.println(lotto.getNumbers().get(Numbers.LOTTO_COUNT.getValue() - 1) + "]");
        }
    }

    //    최종 결과 출력
    public void printResult(Map<String, Integer> result, double rateOfAmount) {
        System.out.println(Messages.OUTPUT_WINNING_STATISTICS.getMessage());
        WinningRank[] ranks = WinningRank.values();
        for (int i = 0; i < ranks.length; i++) {
            System.out.println(ranks[i].getPrintMessages() + result.get(ranks[i].name()) + "개");
        }
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfAmount);
    }
}
