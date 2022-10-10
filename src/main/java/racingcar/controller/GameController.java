package racingcar.controller;

import racingcar.domain.Game;
import racingcar.view.InputView;

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
}
