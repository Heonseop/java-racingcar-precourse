package racingcar.domain;

import racingcar.message.ErrorMessage;

public class Car {
    public static final int NAME_MAX_LENGTH = 5;
    public static final int MOVE_MIN_NUMBER = 4;
    public static final int MOVE_DISTANCE = 1;

    private final String name;
    private final Position position;

    public Car(String name) {
        if (isNotValidName(name)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_CAR_NAMES);
        }
        this.name = name;
        this.position = new Position(0);
    }

    private boolean isNotValidName(String name) {
        return (name.isEmpty() || name.length() > NAME_MAX_LENGTH);
    }

    public void move(int randomValue) {
        if (randomValue >= MOVE_MIN_NUMBER) {
            this.position.plus(MOVE_DISTANCE);
        }
    }

    public String name() {
        return this.name;
    }

    public Position position() {
        return this.position;
    }
}
