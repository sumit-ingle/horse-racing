package horseracing.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HorseTest {
    @Test
    void should_throw_exception_if_speed_is_0() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Horse("A", 0), "Speed cannot be 0 or negative");
    }

    @Test
    void should_throw_exception_if_speed_is_minus_1() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Horse("A", -1), "Speed cannot be 0 or negative");
    }
}