package lotto;

public enum Messages {
    INPUT_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    OUTPUT_PURCHASE_COUNT("개를 구매했습니다."),
    OUTPUT_WINNING_STATISTICS("당첨 통계\n---"),

    ERROR_TYPE_NOT_INTEGER("[ERROR]숫자만 입력가능합니다."),
    ERROR_HAVE_CHANGES("[ERROR] 로또의 최소 구매 단위는 1,000원 입니다."),
    ERROR_SIZE_MISS("[ERROR] 당첨 숫자는 6개 입니다. "),
    ERROR_DUPLICATED("[ERROR] 중복된 숫자는 입력할 수 없습니다.");

    private final String message;
    Messages(String message) {
        this.message= message;
    }
    public String getMessage(){
        return message;
    }
}
