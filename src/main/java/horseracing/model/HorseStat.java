package horseracing.model;

import java.util.Objects;

public class HorseStat {
    private final String horseName;
    private final int distanceCovered;

    public HorseStat(String horseName, int distanceCovered) {
        this.horseName = horseName;
        this.distanceCovered = distanceCovered;
    }

    public int getDistanceCovered() {
        return distanceCovered;
    }

    public String getHorseName() {
        return horseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HorseStat horseStat = (HorseStat) o;
        return distanceCovered == horseStat.distanceCovered && horseName.equals(horseStat.horseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horseName, distanceCovered);
    }

    @Override
    public String toString() {
        return horseName + " " + distanceCovered;
    }
}
