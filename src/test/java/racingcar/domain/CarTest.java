package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @DisplayName("다섯자_이하_한자이상으로_이름이_입력되면_자동차_정상_생성")
    @ParameterizedTest
    @ValueSource(strings = {"car", "0", "abcd", "01234", "aa"})
    void 다섯자_이하로_이름이_입력되면_자동차_정상_생성(String name) {
        assertThatNoException().isThrownBy(() -> new Car(name));
    }

    @DisplayName("다섯자_이상_0이하로_이름이_입력되면_에러_발생")
    @ParameterizedTest
    @ValueSource(strings = {"", "012345"})
    void 다섯자_이상_0이하로_이름이_입력되면_에러_발생(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(name));
    }

    @DisplayName("move함수에_4이상_9이하_값이_들어오면_currentPostion_값_증가")
    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    void move함수에_4이상_9이하_값이_들어오면_currentPostion_값_증가(int number) {
        Car car = new Car("test");
        int expectedValue = car.position() + 1;

        car.move(number);
        assertThat(car.position()).isEqualTo(expectedValue);
    }

    @DisplayName("move함수에_0이상_3이하_값이_들어오면_currentPostion_값_동일")
    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    void move함수에_4이하_값이_들어오면_currentPostion_값_동일(int number) {
        Car car = new Car("test");
        int expectedValue = car.position();

        car.move(number);
        assertThat(car.position()).isEqualTo(expectedValue);
    }
}
