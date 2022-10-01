package baseball.model;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Player {
    public static final int INPUT_SIZE = 3;
    private static final String ERROR_EXEEDING_INPUT_SIZE = "[ERROR] 최대 세 자릿수까지 입력할 수 있습니다.";
    private static final String ERROR_LESS_THAN_INPUT_SIZE = "[ERROR] 최소 세 자릿수까지 입력해야 합니다.";
    private static final String ERROR_DUPLICATED_INPUT = "[ERROR] 중복된 값을 입력할 수 없습니다.";
    private final List<Integer> numbers = new ArrayList<>();

    public Player(){
        while(numbers.size() < 3){
            int generatedRandomNumber = pickNumberInRange(1, 9);
            if(!numbers.contains(generatedRandomNumber)){
                numbers.add(generatedRandomNumber);
            }
        }
    }

    public Player(String input) {
        tokenizeAndAddInput(input);
    }

    private void tokenizeAndAddInput(String input){
        validate(input);

        for(int i = 0; i < input.length(); i++){
            numbers.add(Character.getNumericValue(input.charAt(i)));
        }
    }

    private void validate(String input){
        for(int i = 0; i < input.length(); i++){
            if(!validateInput(input.charAt(i), input)){
                throw new IllegalArgumentException(ERROR_DUPLICATED_INPUT);
            }
        }

        if (input.length() > INPUT_SIZE) {
            throw new IllegalArgumentException(ERROR_EXEEDING_INPUT_SIZE);
        }

        if(input.length() < INPUT_SIZE){
            throw new IllegalArgumentException(ERROR_LESS_THAN_INPUT_SIZE);
        }
    }

    private boolean validateInput(char input, String fullInput){
        int count = 0;
        for(int i = 0; i < fullInput.length(); i++){
            if(input == fullInput.charAt(i)){
                count++;
            }
        }
        return count <= 1;
    }

    public int getSize(){
        return numbers.size();
    }

    public int getValue(int index){
        return numbers.get(index);
    }
}
