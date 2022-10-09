package racingcar.domain;

public class Game {
    private final Cars cars;
    private final int roundNumber;

    public Game(String inputName, int roundNumber) {
        if (roundNumber < 0) throw new IllegalArgumentException();
        this.cars = new Cars(inputName);
        this.roundNumber = roundNumber;
    }

    public Cars cars() {
        return cars;
    }

    public int roundNumber() {
        return roundNumber;
    }

    public void startGame() {
        cars.moveCars();
    }
}
