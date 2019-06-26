package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoFactoryTest {

    @DisplayName("로또 금액에 맞는 로또 리스트 개수가 나와야 한다.")
    @ParameterizedTest
    @ValueSource(ints={1_000, 5_000, 14_000, 30_000})
    public void testRottosSize(int rottoAmounts) {
        LottoFactory lottoFactory = new LottoFactory(rottoAmounts);
        List<Lotto> lottos = lottoFactory.createRottos();

        int rottoCounts = rottoAmounts / LottoFactory.SINGLE_ROTTO_AMOUNT;
        assertThat(lottos).hasSize(rottoCounts);
    }
}
