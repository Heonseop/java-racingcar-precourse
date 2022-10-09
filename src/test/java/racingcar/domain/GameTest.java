package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class GameTest {
    @DisplayName("객체_생성_성공")
    @Test
    void 객체_생성_성공() {
        String inputName = "pobi,crong,honux";
        int roundNumber = 5;

        assertThatNoException().isThrownBy(() -> new Game(inputName, roundNumber));
    }

    @DisplayName("roundNumber_0_미만이면_에러발생")
    @Test
    void roundNumber_0_미만이면_에러발생() {
        String inputName = "pobi,crong,honux";
        int roundNumber = -1;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Game(inputName, roundNumber));
    }
}