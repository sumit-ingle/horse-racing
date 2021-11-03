package horseracing;

import horseracing.model.Horse;
import horseracing.model.HorseStat;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HorseRacingGame {
    private final List<Horse> horses;
    private final int trackLength;

    public HorseRacingGame(List<Horse> horses, int trackLength) {
        this.horses = horses;
        this.trackLength = trackLength;
    }

    public List<HorseStat> raceHorses(int timeElapsed) {
        return horses.stream().map(horse -> {
            int maxDistanceHorseCanCover = timeElapsed * horse.getSpeed();
            int distanceCovered = Math.min(maxDistanceHorseCanCover, trackLength);
            return new HorseStat(horse.getName(), distanceCovered);
        }).collect(Collectors.toList());
    }
}