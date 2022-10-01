package baseball.controller;

import baseball.view.InputView;

public class BaseballController {
    private final InputView inputView;

    public BaseballController(InputView inputView){
        this.inputView = inputView;
    }

    public void run(){
        inputView.printInputView();
    }
}
