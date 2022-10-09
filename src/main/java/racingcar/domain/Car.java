package racingcar.domain;

public class Car {
    String name;

    public Car(String name) {
        if (isNotValidName(name)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    private boolean isNotValidName(String name) {
        int NAME_MAX_LENGTH = 5;
        return (name.isEmpty() || name.length() > NAME_MAX_LENGTH);
    }
}
