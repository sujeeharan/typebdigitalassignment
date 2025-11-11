package digital.typeb.assignment;

import digital.typeb.assignment.controller.HelloController;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloControllerTest {
    private final HelloController controller = new HelloController();

    @Test
    void shouldReturnHelloMessage_WhenNameInFirstHalf() {
        ResponseEntity<Map<String, String>> response = controller.sayHello("alice");

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Hello Alice", response.getBody().get("message"));
    }

    @Test
    void shouldReturnBadRequest_WhenNameInSecondHalf() {
        ResponseEntity<Map<String, String>> response = controller.sayHello("zara");

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Invalid Input", response.getBody().get("error"));
    }

    @Test
    void shouldReturnBadRequest_WhenNameIsMissing() {
        ResponseEntity<Map<String, String>> response = controller.sayHello(null);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Invalid Input", response.getBody().get("error"));
    }

    @Test
    void shouldReturnBadRequest_WhenNameIsEmpty() {
        ResponseEntity<Map<String, String>> response = controller.sayHello("   ");

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Invalid Input", response.getBody().get("error"));
    }
}
