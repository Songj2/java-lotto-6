package lotto;

public enum Messages {
    INPUT_PURCHASE_PRICE("구입금액을 입력해 주세요."),

    OUTPUT_PURCHASE_COUNT("개를 구매했습니다."),

    ERROR_TYPE_NOT_INTEGER("[ERROR]숫자를 입력해주세요."),
    ERROR_HAVE_CHANGES("[ERROR] 로또의 최소 구매 단위는 1,000원 입니다.");

    private final String message;
    Messages(String message) {
        this.message= message;
    }
    public String getMessage(){
        return message;
    }
}
