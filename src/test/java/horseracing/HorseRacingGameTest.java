package horseracing;

import horseracing.model.Horse;
import horseracing.model.HorseStat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HorseRacingGameTest {
    @Nested
    @DisplayName("Given track length is 10")
    class GivenTrackLengthIs10 {
        @Nested
        @DisplayName("and time elapsed is 2")
        class AndTimeElapsedIs2 {
            @Nested
            @DisplayName("and Horse with name A")
            class AndHorseWithNameA {
                @Test
                void horse_A_should_cover_distance_of_2_units_if_speed_is_1() {
                    List<Horse> horses = Collections.singletonList(new Horse("A", 1));
                    var horseRacingGame = new HorseRacingGame(horses, 10);

                    List<HorseStat> horseStats = horseRacingGame.raceHorses(2);

                    var expected = new HorseStat("A", 2);
                    assertEquals(expected, horseStats.get(0));
                }

                @Test
                void horse_A_should_cover_distance_of_4_units_if_speed_is_2() {
                    List<Horse> horses = Collections.singletonList(new Horse("A", 2));
                    var horseRacingGame = new HorseRacingGame(horses, 10);

                    List<HorseStat> horseStats = horseRacingGame.raceHorses(2);

                    var expected = new HorseStat("A", 4);
                    assertEquals(expected, horseStats.get(0));
                }

                @Test
                void horse_A_should_cover_distance_equal_to_track_length_if_speed_is_6() {
                    List<Horse> horses = Collections.singletonList(new Horse("A", 6));
                    var horseRacingGame = new HorseRacingGame(horses, 10);

                    List<HorseStat> horseStats = horseRacingGame.raceHorses(2);

                    var expected = new HorseStat("A", 10);
                    assertEquals(expected, horseStats.get(0));
                }
            }

            @Nested
            @DisplayName("and two Horses A and B")
            class AndTwoHorses {
                @Test
                void horses_A_and_B_should_cover_distance_8_and_6_respectively() {
                    Horse horseA = new Horse("A", 4);
                    Horse horseB = new Horse("B", 3);
                    List<Horse> horses = Arrays.asList(horseA, horseB);
                    var horseRacingGame = new HorseRacingGame(horses, 10);

                    List<HorseStat> horseStats = horseRacingGame.raceHorses(2);

                    var expected = Arrays.asList(new HorseStat("A", 8),
                            new HorseStat("B", 6));
                    assertEquals(expected, horseStats);
                }
            }
        }
    }
}
