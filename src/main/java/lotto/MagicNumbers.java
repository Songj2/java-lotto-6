package lotto;

public enum MagicNumbers {
    LOTTO_PRICE(1000);

    private final int value;

    MagicNumbers(int value) {
        this.value= value;
    }

    public int getValue() {
        return value;
    }
}
