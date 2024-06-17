package lotto;

import lotto.Controller.ResultController;
import lotto.enumModel.WinningRank;
import lotto.model.Lotto;
import lotto.model.ResultDTO;
import lotto.util.StringUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultControllerTest {
    private final ResultController resultController= new ResultController();
    private final List<Lotto> lottoList= new ArrayList<>();
    private final Lotto winningNumber= new Lotto(StringUtil.makeList("1,2,3,4,5,6"));
    private final int bonus= 7;
    private final int purchase= 5000;
    private Map<String, Integer> result;

    @BeforeEach
    void setData(){
        lottoList.add(new Lotto(StringUtil.makeList("8,21,23,41,42,43")));
        lottoList.add(new Lotto(StringUtil.makeList("3,5,11,16,32,38")));
        lottoList.add(new Lotto(StringUtil.makeList("7,11,16,35,36,44")));
        lottoList.add(new Lotto(StringUtil.makeList("1,8,11,31,41,42")));
        lottoList.add(new Lotto(StringUtil.makeList("1,3,5,14,22,45")));
        result= resultController.resultData(lottoList,winningNumber,bonus);
    }

    @DisplayName("최종 당첨 등수 결과 테스트")
    @Test
    void resultDataTest(){
        assertThat(result).hasSize(5)
                .contains(entry(WinningRank.FIFTH.name(), 1),entry(WinningRank.FOURTH.name(), 0),
                        entry(WinningRank.THIRD.name(), 0), entry(WinningRank.SECOND.name(), 0), entry(WinningRank.FIRST.name(), 0));
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    void callRateOfAmountTest(){
        assertEquals(resultController.calRateOfAmount(result, purchase), 100.0);
    }

}
