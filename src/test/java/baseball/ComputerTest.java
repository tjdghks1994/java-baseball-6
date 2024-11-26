package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    @DisplayName("1~9까지 서로 다른 3자리 숫자를 생성한다.")
    @Test
    void createNumber() {
        // given
        Computer computer = new Computer();
        List<Integer> numbers = computer.getNumbers();

        // when
        computer.createNumber();

        // then
        assertThat(numbers.size()).isEqualTo(3);
        assertThat(new HashSet<>(numbers).size()).isEqualTo(numbers.size());
    }

//    @DisplayName("1~9까지 서로 다른 3자리 숫자를 생성한 뒤, 재생성을 할 수 없습니다.")
//    @Test
//    void unableReCreateNumber() {
//        // given
//        Computer computer = new Computer();
//        computer.createNumber();
//
//        // when & then
//        assertThatThrownBy(() -> computer.createNumber())
//                .isInstanceOf(IllegalCallerException.class)
//                .hasMessage("한 번 생성된 랜덤 3자리 숫자를 재생성 할 수 없습니다.");
//    }
//
//    @DisplayName("컴퓨터의 3자리 숫자를 삭제합니다.")
//    @Test
//    void clearNumber() {
//        // given
//        Computer computer = new Computer();
//        computer.createNumber();
//
//        // when
//        computer.clearNumber();
//
//        // then
//        assertThat(computer.getNumbers().size()).isEqualTo(0);
//    }
}