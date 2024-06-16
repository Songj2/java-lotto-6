package lotto;

import java.util.HashMap;
import java.util.Map;

public class WinningRankDTO {
    private Map<String, Integer> winningResult= new HashMap<>();
    public WinningRankDTO(){
        winningResult.put(WinningRank.FIFTH.name(), 0);
        winningResult.put(WinningRank.FOURTH.name(), 0);
        winningResult.put(WinningRank.THIRD.name(), 0);
        winningResult.put(WinningRank.SECOND.name(), 0);
        winningResult.put(WinningRank.FIRST.name(), 0);
    }

    public Map<String, Integer> getWinningResult(){
        return winningResult;
    }
    public void setWinningResult(Map<String, Integer> winningResult) {
        this.winningResult = winningResult;
    }
}
