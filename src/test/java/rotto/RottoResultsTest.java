package rotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RottoResultsTest {
    private List<Rotto> rottos = createRottos();
    private RottoResults rottoResults = new RottoResults("1,2,3,4,5,6", rottos);

    private static List<Rotto> createRottos() {
        RottoFactory rottoFactory = new RottoFactory(14_000);
        return rottoFactory.createRottos();
    }

    @DisplayName("인자가 1~6이 아닌 경우 예외를 발생합니다.")
    @ParameterizedTest
    @ValueSource(ints={-1,0,7,8})
    public void testInvokeException(int fitCount) {
        assertThatThrownBy(()-> rottoResults.countLotteryOf(fitCount))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @DisplayName("수익률이 일치해야 합니다.")
    @Test
    public void testIncomeRate() {
        Rotto rotto = rottos.get(0);
        List<Integer> rottoNumbers = rotto.getNumbers();

        String lotteryNumbersString = rottoNumbers.get(0) +",46,46,46,46,46";
        RottoResults rottoResults = new RottoResults(lotteryNumbersString, Collections.singletonList(rotto));

        double expectedIncomeRate = getExpectedIncomeRate(1, 3);
        assertThat(rottoResults.getIncomeRate()).isEqualTo(expectedIncomeRate);
    }

    private double getExpectedIncomeRate(int countOfLotto, int fitCount) {
        float purchaseAmounts = RottoFactory.SINGLE_ROTTO_AMOUNT * countOfLotto;

        RottoAmount rottoAmount = RottoAmount.getByFitCount(fitCount);
        float rottoAmountValue = rottoAmount.getAmount();

        float expectedIncomeRate =  rottoAmountValue / purchaseAmounts;
        String expectedIncomeRateString = String.format("%.2f", expectedIncomeRate);

        return Double.parseDouble(expectedIncomeRateString);
    }
}
