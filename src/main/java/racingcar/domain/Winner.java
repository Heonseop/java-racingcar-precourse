package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private final Cars cars;
    private List<String> winners;

    public Winner(Cars cars) {
        this.cars = cars;
    }

    public List<String> getWinners() {
        int maxDistance = getMaxDistance();
        winners = new ArrayList<>();
        for (Car car : cars.cars()) {
            setWinner(car, maxDistance);
        }
        return winners;
    }

    private int getMaxDistance() {
        int result = 0;
        for (Car car : cars.cars()) {
            result = Math.max(result, car.position());
        }
        return result;
    }

    private void setWinner(Car car, int maxDistance) {
        if (car.isMaxPosition(maxDistance)) {
            winners.add(car.name());
        }
    }
}
