package horseracing.model;

public class Horse {
    private final String name;
    private final int speed;

    public Horse(String name, int speed) {
        validateSpeed(speed);
        this.name = name;
        this.speed = speed;
    }

    private void validateSpeed(int speed) {
        if (speed <= 0) {
            throw new IllegalArgumentException("Speed cannot be 0 or negative");
        }
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
}
