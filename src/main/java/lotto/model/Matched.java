package lotto.model;

public class Matched {
    private int matched;
    private boolean bonus;

    public Matched(int count, boolean bonus) {
        this.matched = count;
        this.bonus = bonus;
    }

    public int getMatched() {
        return matched;
    }

    public boolean isBonus() {
        return bonus;
    }
}
