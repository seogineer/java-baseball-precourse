package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PickNumberTest {
    @Test
    @DisplayName("컴퓨터 임의 숫자 생성")
    void generate(){
        PickNumber computer = new PickNumber();
        assertEquals(3, computer.getSize());
    }

    @Test
    @DisplayName("플레이어 입력")
    void input(){
        PickNumber player = new PickNumber("123");
        assertEquals(3, player.getSize());
        assertEquals(1, player.getValue(0));
        assertEquals(2, player.getValue(1));
        assertEquals(3, player.getValue(2));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("값 검증")
    void validateSet(int param){
        PickNumber pickNumber = new PickNumber("123");
        assertTrue(pickNumber.contains(param));
    }

    @Test
    @DisplayName("예외 처리")
    void validateInputSize(){
        assertThatThrownBy(() -> {
            PickNumber pickNumber = new PickNumber("1234");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 최대 세 자릿수까지 입력할 수 있습니다.");
    }
}
