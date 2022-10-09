package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class RoundNumberTest {

    @DisplayName("라운드_숫자_정상_입력")
    @ParameterizedTest
    @CsvSource(value = {"1", "10", "1000"}, delimiter = ':')
    void 라운드_숫자_정상_입력(String roundNumber) {
        assertThatNoException().isThrownBy(() -> {
            new RoundNumber(roundNumber);
        });
    }

    @DisplayName("라운드_숫자_아니면_에러")
    @ParameterizedTest
    @CsvSource(value = {",", "a", "a1"}, delimiter = ':')
    void 라운드_숫자_아니면_에러(String roundNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RoundNumber(roundNumber));
    }


    @DisplayName("라운드_숫자_0_미만이면_에러")
    @ParameterizedTest
    @CsvSource(value = {"-1", "0", "-1000"}, delimiter = ':')
    void 라운드_숫자_0_미만이면_에러(String roundNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RoundNumber(roundNumber));
    }
}