package horseracing;

import horseracing.model.Horse;
import horseracing.model.HorseStat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        readInputAndProcess();
    }

    private static void readInputAndProcess() {
        List<Horse> horses = readHorseDetails();
        int trackLength = readTrackLength();
        int elapsedTime = readElapsedTime();

        HorseRacingGame horseRacingGame = new HorseRacingGame(horses, trackLength);
        List<HorseStat> horseStats = horseRacingGame.raceHorses(elapsedTime);
        horseStats.forEach(out::println);
    }

    private static int readElapsedTime() {
        Scanner sc = getScanner();
        out.println("Please enter the elapsed time:");
        return sc.nextInt();
    }

    private static int readTrackLength() {
        Scanner sc = getScanner();
        out.println("Please enter the track length:");
        return sc.nextInt();
    }

    private static List<Horse> readHorseDetails() {
        int horseCount = readHorseCount();
        Scanner scanner = getScanner();
        out.println("Please enter the name and speed for each horse separated by space");
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < horseCount; i++) {
            String[] horseNameSpeed = scanner.nextLine().split("\\s+");
            var horseName = horseNameSpeed[0];
            int horseSpeed = Integer.parseInt(horseNameSpeed[1]);
            horses.add(new Horse(horseName, horseSpeed));
        }
        return horses;
    }

    private static int readHorseCount() {
        out.println("Please enter the number of horses:");
        Scanner sc = getScanner();
        return sc.nextInt();
    }

    private static Scanner getScanner() {
        return new Scanner(System.in);
    }
}
