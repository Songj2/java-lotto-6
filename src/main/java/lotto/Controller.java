package lotto;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    public Controller(){}

    public List<Matched> matchedNumber(List<Lotto> lottoNumbers, Lotto winningNumber, int bonus){
        List<Matched> resultList= new ArrayList<>();
        for (Lotto lotto: lottoNumbers){
            Matched matched= new Matched(matchedNumber(lotto, winningNumber), matchedBonus(lotto, bonus));
            resultList.add(matched);
        }
        return resultList;
    }

    private int matchedNumber(Lotto published, Lotto winning){
        int count=0;
        for (int number: published.getNumbers()){
            if (winning.getNumbers().contains(number)){
                count++;
            }
        }
        return count;
    }

    private boolean matchedBonus(Lotto published, int bonus){
        if (published.getNumbers().contains(bonus)){
            return true;
        }
        return false;
    }

}
