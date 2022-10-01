package baseball;

import baseball.controller.BaseballController;
import baseball.model.Player;
import baseball.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballController baseballController = new BaseballController(new InputView(new Player()));
        baseballController.run();
    }

}
