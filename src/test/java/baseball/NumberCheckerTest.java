package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

class NumberCheckerTest {

    private Computer computer;
    private Player player;

    @DisplayName("플레이어 3자리 숫자와 컴퓨터의 3자리 숫자를 비교하여 야구 게임의 결과를 반환한다.")
    @TestFactory
    Stream<DynamicTest> getBaseballGameResult() {
        // given
        computer = mock(Computer.class);
        player = mock(Player.class);
        NumberChecker numberChecker = new NumberChecker(computer);

        return Stream.of(
                DynamicTest.dynamicTest(
                        "플레이어가 컴퓨터의 3자리 숫자를 모두 틀리면 낫싱 을 반환한다.", () -> {
                            // given
                            given(computer.getNumbers()).willReturn(List.of(1, 2, 3));
                            given(player.getNumbers()).willReturn(List.of(4, 5, 6));

                            // when
                            String result = numberChecker.getBaseballGameResult(player);

                            // then
                            assertThat(result).isEqualTo("낫싱");
                        }),
                DynamicTest.dynamicTest(
                        "플레이어가 컴퓨터의 숫자 중 3개의 숫자는 모두 맞췄지만 위치가 틀려 3볼을 반환한다.", () -> {
                            // given
                            given(computer.getNumbers()).willReturn(List.of(5, 3, 8));
                            given(player.getNumbers()).willReturn(List.of(8, 5, 3));

                            // when
                            String result = numberChecker.getBaseballGameResult(player);

                            // then
                            assertThat(result).isEqualTo("3볼");
                        }),
                DynamicTest.dynamicTest(
                        "플레이어가 컴퓨터의 숫자 중 3개의 숫자는 모두 맞췄지만 2개는 위치가 틀려 2볼 1스트라이크를 반환한다.", () -> {
                            // given
                            given(computer.getNumbers()).willReturn(List.of(3, 4, 5));
                            given(player.getNumbers()).willReturn(List.of(5, 4, 3));

                            // when
                            String result = numberChecker.getBaseballGameResult(player);

                            // then
                            assertThat(result).isEqualTo("2볼 1스트라이크");
                        }),
                DynamicTest.dynamicTest(
                        "플레이어가 컴퓨터의 숫자 중 1개의 숫자를 정확히 맞춰 1스트라이크를 반환한다.", () -> {
                            // given
                            given(computer.getNumbers()).willReturn(List.of(3, 4, 5));
                            given(player.getNumbers()).willReturn(List.of(3, 2, 1));

                            // when
                            String result = numberChecker.getBaseballGameResult(player);

                            // then
                            assertThat(result).isEqualTo("1스트라이크");
                        })
        );
    }
}