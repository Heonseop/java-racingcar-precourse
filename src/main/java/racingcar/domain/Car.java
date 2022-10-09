package racingcar.domain;

public class Car {
    public static final int NAME_MAX_LENGTH = 5;
    public static final int MOVE_MIN_NUMBER = 4;
    private final String name;
    private int position;

    public Car(String name) {
        if (isNotValidName(name)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    private boolean isNotValidName(String name) {
        return (name.isEmpty() || name.length() > NAME_MAX_LENGTH);
    }

    public void move(int randomValue) {
        if (randomValue >= MOVE_MIN_NUMBER) {
            this.position++;
        }
    }

    public String name() {
        return this.name;
    }

    public int position() {
        return this.position;
    }
}
