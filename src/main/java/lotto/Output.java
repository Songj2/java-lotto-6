package lotto;

import java.util.List;
import java.util.Map;

public class Output {
    public Output() {
    }

    public void printPublishedLotto(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + Messages.OUTPUT_PURCHASE_COUNT.getMessage());
        for (Lotto lotto : lottoList) {
            System.out.print("[");
            for (int i = 0; i < MagicNumbers.LOTTO_COUNT.getValue() - 1; i++) {
                System.out.printf("%d, ", lotto.getNumbers().get(i));
            }
            System.out.println(lotto.getNumbers().get(MagicNumbers.LOTTO_COUNT.getValue() - 1) + "]");
        }
    }

    public void printResult(List<Lotto> lottoList, Lotto winningNumber, int bonus, int purchase) {
        System.out.println(Messages.OUTPUT_WINNING_STATISTICS.getMessage());
        Controller controller = new Controller();
        List<Matched> matcheds = controller.matchedNumber(lottoList, winningNumber, bonus);

        WinningRankDTO winningRankDTO = new WinningRankDTO();
        Map<String, Integer> result = winningRankDTO.getWinningResult();
        WinningRank[] rank = WinningRank.values();
        for (Matched matched : matcheds) {
            for (WinningRank rank1 : rank) {
                if (matched.getMatched() == rank1.getMatched()) {
                    if (rank1.isBonus() && matched.isBonus()) {
                        result.replace(rank1.name(), result.get(rank1.name()) + 1);
                    }
                    else {
                        result.replace(rank1.name(), result.get(rank1.name()) + 1);
                    }
                    break;
                }
            }
        }

        int amount=0;
        for (int i= 0; i<rank.length; i++){
            int count= result.get(rank[i].name());
            System.out.println(rank[i].getMatchedCount()+count+"개");
            amount+= rank[i].getReward()*count;
        }
        double rateAmount= (double)amount/ purchase*100;
        System.out.printf("총 수익률은 %.1f%%입니다.", rateAmount);
    }
}
