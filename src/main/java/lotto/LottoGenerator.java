package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoGenerator {

    private Judge judge;

    public LottoGenerator() {
        this.judge = new Judge();
    }

    public void amountIsNumber(String amount) {
        if(!judge.correctAmount(amount)) {
            LottoManager.terminateByError(Errors.NOT_CORRECT_AMOUNT.getName());
        }
    }

    public List<Lotto> createLottoNumbers(String amount) {
        Notice.BUY_MESSAGE.buy(Integer.parseInt(amount) / 1000);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(amount) / 1000; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    public Lotto generateLotto() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> realLotto = new ArrayList<>();
        for(Integer num : lotto) {
            realLotto.add(num);
        }
        Collections.sort(realLotto);
        return new Lotto(realLotto);
    }

    public Lotto changeToNumber(String numbers) {
        String[] num = numbers.split(",");
        List<Integer> revertNumbers = new ArrayList<>();
        for(String n : num) {
            revertNumbers.add(Integer.parseInt(n));
        }
        return new Lotto(revertNumbers);
    }
}
