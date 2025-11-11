package digital.typeb.assignment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/hello-world")
public class HelloController {

    @GetMapping
    public ResponseEntity<Map<String, String>> sayHello(@RequestParam(required = false) String name) {
        if (name == null || name.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Invalid Input"));
        }

        boolean isValid = isFirstHalfAlphabet(name.charAt(0));
        if (isValid) {
            String formattedName = Character.toUpperCase(name.charAt(0)) + name.substring(1);
            return ResponseEntity.ok(Map.of("message", "Hello " + formattedName));
        } else {
            return ResponseEntity.badRequest().body(Map.of("error", "Invalid Input"));
        }
    }

    private boolean isFirstHalfAlphabet(char firstChar) {
        char normalized = Character.toLowerCase(firstChar);
        return normalized >= 'a' && normalized <= 'm';
    }
}
