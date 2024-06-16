package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumbers {
    public RandomNumbers(){}

    public List<Lotto>  RandomNumbers(int num){
        List<Lotto> lottoNumbers= new ArrayList<>();
        for (int i=0; i<num; i++){
            Lotto lotto= new Lotto(randomNumber());
            lottoNumbers.add(lotto);
        }
        return lottoNumbers;
    }

    private List<Integer> randomNumber(){
        return Randoms.pickUniqueNumbersInRange(1, 45, MagicNumbers.LOTTO_COUNT.getValue());
    }
}
