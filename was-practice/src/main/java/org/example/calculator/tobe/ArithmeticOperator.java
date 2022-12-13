package org.example.calculator.tobe;

public interface NewArithmeticOperator {

    boolean supports(String operator);
    int calculate(PositiveNumber operand1, PositiveNumber operand2);
}
