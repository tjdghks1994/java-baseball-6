package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @DisplayName("1부터 9까지 서로 다른 3자리의 수를 저장한다.")
    @Test
    void savePlayerNumber() {
        // given
        Player player = new Player();
        String number = "123";

        // when
        player.savePlayerNumber(number);

        // then
        assertThat(player.getNumbers().size()).isEqualTo(3);
        assertThat(player.getNumbers()).contains(1, 2, 3);
    }

    @DisplayName("연속해서 3자리 숫자를 저장하면, 이전에 저장된 3자리 숫자는 사라지고 현재 3자리 숫자만 저장한다.")
    @Test
    void savePlayerNumberAndPrevNumberClear() {
        // given
        Player player = new Player();
        String number1 = "123";
        String number2 = "732";
        player.savePlayerNumber(number1);

        // when
        player.savePlayerNumber(number2);

        // then
        assertThat(player.getNumbers().size()).isEqualTo(3);
        assertThat(player.getNumbers()).contains(7,3,2);
    }

    @DisplayName("1부터 9까지 서로 다른 3자리의 수가 아니라면 저장할 수 없다.")
    @MethodSource("providerStringNumber")
    @ParameterizedTest
    void savePlayerNumberFail(String number) {
        // given
        Player player = new Player();

        // when & then
        assertThatThrownBy(() -> player.savePlayerNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1부터 9까지 서로 다른 3자리 수가 아닙니다.");
    }

    private static Stream<String> providerStringNumber() {
        return Stream.of(
                new String("112"),
                new String("999"),
                new String("901"),
                new String("ab1"),
                new String("12"),
                new String("1")
        );
    }

}