package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    static final int SINGLE_ROTTO_AMOUNT = 1_000;

    private final int rottoCounts;

    public LottoFactory(int rottoAmounts) {
        this.rottoCounts = rottoAmounts / SINGLE_ROTTO_AMOUNT;
    }

    public List<Lotto> createRottos() {
        return IntStream.range(0, rottoCounts)
                .mapToObj(v -> new Lotto())
                .collect(Collectors.toList());
    }
}
