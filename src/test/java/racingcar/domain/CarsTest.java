package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CarsTest {
    @DisplayName("이름이_입력되면_구분자_기준으로_각각_객체가_생성된다")
    @Test
    void 이름이_입력되면_구분자_기준으로_각각_객체가_생성된다() {
        String inputName = "pobi,crong,honux";
        List<Car> cars = new Cars(inputName).cars();
        assertAll(
                () -> assertThat(cars.get(0).name()).isEqualTo("pobi"),
                () -> assertThat(cars.get(1).name()).isEqualTo("crong"),
                () -> assertThat(cars.get(2).name()).isEqualTo("honux")
        );
    }

    @DisplayName("빈값이_입력되면_에러를_반환_한다")
    @Test
    void 빈값이_입력되면_에러를_반환_한다() {
        String inputName = "";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Cars(inputName));
    }

    @DisplayName("moveCars_정상_실행")
    @Test
    void moveCars_정상_실행() {
        String inputName = "pobi,crong,honux";
        Cars cars = new Cars(inputName);
        assertThatNoException().isThrownBy(cars::moveCars);
    }
}
