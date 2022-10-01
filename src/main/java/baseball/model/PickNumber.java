package baseball.model;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class PickNumber {
    public static final int INPUT_SIZE = 3;
    private static final String ERROR_EXEEDING_INPUT_SIZE = "[ERROR] 최대 세 자릿수까지 입력할 수 있습니다.";
    private static final String ERROR_LESS_THAN_INPUT_SIZE = "[ERROR] 최소 세 자릿수까지 입력해야 합니다.";
    private final List<Integer> numbers = new ArrayList<>();

    public PickNumber(){
        while(numbers.size() < 3){
            int generatedRandomNumber = pickNumberInRange(1, 9);
            if(!numbers.contains(generatedRandomNumber)){
                numbers.add(generatedRandomNumber);
            }
        }
    }

    public PickNumber(String input) {
        tokenizeAndAddInput(input);
    }

    private void tokenizeAndAddInput(String input){
        validateInputSize(input);

        for(int i = 0; i < input.length(); i++){
            numbers.add(Character.getNumericValue(input.charAt(i)));
        }
    }

    private void validateInputSize(String input){
        if (input.length() > INPUT_SIZE) {
            throw new IllegalArgumentException(ERROR_EXEEDING_INPUT_SIZE);
        }

        if(input.length() < INPUT_SIZE){
            throw new IllegalArgumentException(ERROR_LESS_THAN_INPUT_SIZE);
        }
    }

    public int getSize(){
        return numbers.size();
    }

    public boolean contains(int value){
        return numbers.contains(value);
    }

    public int getValue(int index){
        return numbers.get(index);
    }
}
