package racingcar.controller;

import racingcar.domain.Game;
import racingcar.domain.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    Game game;

    public void initGame() {
        game = new Game();
        setRacingCars();
        setRoundNumber();
    }

    private void setRacingCars() {
        try {
            game.setCars(InputView.inputCarNames());
        } catch (IllegalArgumentException e) {
            setRacingCars();
        }
    }

    private void setRoundNumber() {
        try {
            game.setRoundNumber(InputView.inputGameRound());
        } catch (IllegalArgumentException e) {
            setRoundNumber();
        }
    }

    public void playGame() {
        int currentRound = 0;
        OutputView.printResult();
        while (!game.roundNumber().isFinalRoundNumber(currentRound)) {
            game.startGame();
            OutputView.printCurrentRoundResult(game.cars());
            currentRound++;
        }
        OutputView.printWinners(new Winner(game.cars()));
    }
}
