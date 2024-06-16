package lotto.model;

import lotto.enumModel.WinningRank;

import java.util.HashMap;
import java.util.Map;

public class ResultDTO {
    private final Map<String, Integer> winningResult = new HashMap<>();

    public ResultDTO() {
        winningResult.put(WinningRank.FIFTH.name(), 0);
        winningResult.put(WinningRank.FOURTH.name(), 0);
        winningResult.put(WinningRank.THIRD.name(), 0);
        winningResult.put(WinningRank.SECOND.name(), 0);
        winningResult.put(WinningRank.FIRST.name(), 0);
    }

    public Map<String, Integer> getWinningResult() {
        return winningResult;
    }
}
