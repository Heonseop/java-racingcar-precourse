package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winner;
import racingcar.message.OutputMessage;

public class OutputView {
    public static void printResult() {
        System.out.println(OutputMessage.OUTPUT_GAME_RESULT);
    }

    public static void printWinners(Winner winner) {
        System.out.print(OutputMessage.OUTPUT_WINNERS);
        System.out.println(String.join(", ", winner.getWinners()));
    }

    public static void printCurrentRoundResult(Cars cars) {
        for (Car car : cars.cars()) {
            printCurrentResultAboutCar(car);
        }
        System.out.println();
    }

    private static void printCurrentResultAboutCar(Car car) {
        StringBuilder builder = new StringBuilder();
        builder.append(car.name());
        builder.append(" : ");
        for (int i = 0; i < car.position(); i++) {
            builder.append("-");
        }
        System.out.println(builder);
    }
}
