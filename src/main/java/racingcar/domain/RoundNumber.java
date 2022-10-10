package racingcar.domain;

import java.util.Objects;
import racingcar.message.ErrorMessage;

public class RoundNumber {
    private static final int MIN_NUM = 0;
    private final int num;

    public RoundNumber(String num) {
        try {
            this.num = Integer.parseInt(num);
            if (this.num <= MIN_NUM) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_ROUND_NUMBER_NOT_VALID);
        }
    }

    public int getNum() {
        return num;
    }

    public boolean isFinalRoundNumber(int num) {
        return this.num == num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RoundNumber that = (RoundNumber) o;
        return num == that.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}