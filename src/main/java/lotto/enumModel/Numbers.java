package lotto.enumModel;

public enum Numbers {
    LOTTO_PRICE(1000),
    LOTTO_COUNT(6),
    LOTTO_MIN_VALUE(1),
    LOTTO_MAX_VALUE(45);
    private final int value;

    Numbers(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
