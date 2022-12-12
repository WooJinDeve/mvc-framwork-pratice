package org.example.calculator;

import org.assertj.core.api.Assertions;
import org.example.calculator.newcalculator.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PositiveNumberTest {


    @DisplayName("생성사 0또는 음수를 전달할 때 IllegalArgumentException 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void createTest(int value) {
        Assertions.assertThatCode(() -> new PositiveNumber(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0또는 음수를 전달 할 수 없습니다.");
    }
}
