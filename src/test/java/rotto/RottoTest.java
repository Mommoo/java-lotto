package rotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class RottoTest {
    private static final int ROTTO_NUMBER_DIGIT = 6;

    private Rotto rotto;

    @BeforeEach
    public void setUp() {
        this.rotto = new Rotto();
    }

    @DisplayName("로또 숫자 개수는 6자리이며, 중복이 없어야 한다.")
    @Test
    public void testNumberCountsAndIsDistinct() {
        List<Integer> rottoNumbers = rotto.getNumbers();
        Set<Integer> rottoNumbersSet = new HashSet<>(rottoNumbers);

        assertThat(rottoNumbersSet).hasSize(ROTTO_NUMBER_DIGIT);
    }

    @DisplayName("로또 숫자 검색이 반드시 6개가 나와야 한다.")
    @Test
    public void testSearchRottoNumbers() {
        List<Integer> rottoNumbers = rotto.getNumbers();
        int matchCount = rotto.computeCountOfNumberExist(rottoNumbers);

        assertThat(matchCount).isEqualTo(ROTTO_NUMBER_DIGIT);
    }
}
