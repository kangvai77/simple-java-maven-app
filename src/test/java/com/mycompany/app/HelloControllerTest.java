package com.mycompany.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for HelloController, without starting a full Spring context.
 */
class HelloControllerTest {

    @Test
    void testHelloEndpointReturnsMessage() {
        App.HelloController controller = new App.HelloController();
        assertEquals("Hello World!", controller.hello());
    }
}