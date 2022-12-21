package display;
import java.io.Serializable;

public class Score implements Serializable, Comparable<Score> {
    private String name;
    private int point;
    private int compareP;
    public Score(String name, int point) {
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public int compareTo(Score score) {
        compareP = ((Score) score).getPoint();       
        return compareP - this.point;
    }

    @Override
    public String toString() {
        return this.point + this.name + "";
    }
}
