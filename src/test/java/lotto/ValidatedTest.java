package lotto;

import lotto.model.Lotto;
import lotto.util.StringUtil;
import lotto.util.Validated;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ValidatedTest {
    private final Validated validated= new Validated();
    private final String purchase= "1234";
    private ByteArrayOutputStream outputMessage;
    private final Lotto lotto= new Lotto(StringUtil.makeList("1,2,3,4,5,6"));

    @BeforeEach
    void setStream(){
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }
    @AfterEach
    void closeStream(){
        System.setOut(System.out);
    }
    @Test
    @DisplayName("구매 금액의 유효성 검사")
    void validatePurchasePriceTest(){
        validated.validatePurchasePrice(purchase);
        assertAll("purchasePrice",
                ()-> assertFalse(validated.validatePurchasePrice(purchase)),
                ()-> assertThat(outputMessage.toString().contains("[ERROR]")),
                ()-> assertTrue(validated.validatePurchasePrice("8000")),
                ()-> assertFalse(validated.validatePurchasePrice("a1bc")));

    }

    @DisplayName("당첨 번호의 유효성 검사")
    @Test
    void validateWinningNumbersTest(){
        assertAll("WinningNumbers",
                ()-> assertTrue(validated.validateWinnerNumber("1,2,3,4,5,6")),
                ()-> assertFalse(validated.validateWinnerNumber("1,q,2,3,a,3")),
                ()-> assertThat(outputMessage.toString().contains("[ERROR]")),
                ()-> assertFalse(validated.validateWinnerNumber("0,1,2,3,4,46")));
    }

    @DisplayName("보너스 번호의 유효성 검사")
    @Test
    void validateBonusNumberTest(){
        assertAll("bonusNumber",
                ()-> assertTrue(validated.validateBonusNumber("34", lotto)),
                ()-> assertFalse(validated.validateBonusNumber("1", lotto)),
                ()-> assertThat(outputMessage.toString().contains("[ERROR]")),
                ()-> assertFalse(validated.validateBonusNumber("0", lotto))
                );
    }
}
