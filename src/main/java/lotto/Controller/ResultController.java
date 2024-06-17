package lotto.Controller;

import lotto.enumModel.WinningRank;
import lotto.model.Lotto;
import lotto.model.Matched;
import lotto.model.ResultDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResultController {
    private WinningRank[] ranks = WinningRank.values();

    public ResultController() {
    }

    //    최종 당첨 결과 정보
    public Map<String, Integer> resultData(List<Lotto> lottoNumbers, Lotto winningNumber, int bonus) {
        List<Matched> matchedList = matchedLotto(lottoNumbers, winningNumber, bonus);
        ResultDTO resultDTO = new ResultDTO();
        Map<String, Integer> result = resultDTO.getWinningResult();
        for (Matched matched : matchedList) {
            compareRanks(matched, result);
        }
        return result;
    }

    public double calRateOfAmount(Map<String, Integer> result, int purchase) {
        int amount = 0;
        for (int i = 0; i < ranks.length; i++) {
            int count = result.get(ranks[i].name());
            amount += ranks[i].getReward() * count;
        }
        return (double) amount / purchase * 100;
    }

    //    발행된 숫자와 당첨 번호가 일치한 개수와 보너스 번호 일치 여부 저장
    private List<Matched> matchedLotto(List<Lotto> lottoNumbers, Lotto winningNumber, int bonus) {
        List<Matched> resultList = new ArrayList<>();
        for (Lotto lotto : lottoNumbers) {
            Matched matched = new Matched(matchedLotto(lotto, winningNumber), matchedBonus(lotto, bonus));
            resultList.add(matched);
        }
        return resultList;
    }

    private int matchedLotto(Lotto published, Lotto winning) {
        int count = 0;
        for (int number : published.getNumbers()) {
            if (winning.getNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean matchedBonus(Lotto published, int bonus) {
        if (published.getNumbers().contains(bonus)) {
            return true;
        }
        return false;
    }

    //    당첨 기준과 비교
    private Map<String, Integer> compareRanks(Matched matched, Map<String, Integer> result) {
        for (WinningRank rank : ranks) {
            if ((matched.getMatched() == rank.getMatched()) && compareBonus(matched, rank)) {
                result.replace(rank.name(), result.get(rank.name()) + 1);
                return result;
            }
            if (matched.getMatched() == rank.getMatched()) {
                result.replace(rank.name(), result.get(rank.name()) + 1);
            }
        }
        return result;
    }

    private boolean compareBonus(Matched matched, WinningRank rank) {
        return matched.isBonus() && rank.isBonus();
    }

}
