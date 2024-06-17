package lotto.enumModel;

public enum WinningRank {
    FIFTH(5000, 3, false, "3개 일치 (5,000원) - "),
    FOURTH(50000, 4, false, "4개 일치 (50,000원) - "),
    THIRD(1500000, 5, false, "5개 일치 (1,500,000원) - "),
    SECOND(30000000, 5, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(2000000000, 6, false, "6개 일치 (2,000,000,000원) - ");

    private final int reward;
    private final int matched;
    private final boolean bonus;
    private final String printMessages;

    WinningRank(int reward, int matched, boolean bonus, String printMessages) {
        this.reward = reward;
        this.matched = matched;
        this.bonus = bonus;
        this.printMessages = printMessages;
    }

    public int getReward() {
        return reward;
    }

    public int getMatched() {
        return matched;
    }

    public boolean isBonus() {
        return bonus;
    }

    public String getPrintMessages() {
        return printMessages;
    }

}
