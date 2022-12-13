package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RequestLineTest {

    @Test
    void create() {
        RequestLine requestLine = new RequestLine("GET /calculate?operand1=11&operator*=null&operand2=55");

        Assertions.assertThat(requestLine).isNotNull();
    }
}
