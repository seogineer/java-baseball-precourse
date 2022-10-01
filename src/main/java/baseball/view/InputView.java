package baseball.view;

import baseball.model.Player;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private final List<Player> playerList = new ArrayList<>();

    public InputView(Player computer){
        playerList.add(computer);
    }

    public List<Player> printInputView(){
        System.out.print("숫자를 입력해주세요 : ");
        inputValue(readLine());
        return playerList;
    }

    public void inputValue(String input){
        playerList.add(new Player(input));
    }
}
