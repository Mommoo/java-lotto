package rotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RottoFactory {
    static final int SINGLE_ROTTO_AMOUNT = 1_000;

    private final int rottoCounts;

    public RottoFactory(int rottoAmounts) {
        this.rottoCounts = rottoAmounts / SINGLE_ROTTO_AMOUNT;
    }

    public List<Rotto> createRottos() {
        return IntStream.range(0, rottoCounts)
                .mapToObj(v -> new Rotto())
                .collect(Collectors.toList());
    }
}
