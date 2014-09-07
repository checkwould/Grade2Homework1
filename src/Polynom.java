/**
 * Created by Яна on 06.09.2014.
 */

public class Polynom {
    private int[] array;

    public Polynom (int[] array) {
        this.array = array.clone();
    }

    public Polynom (Polynom another) {
        this.array = another.getArray();
    }

    public int[] getArray() {
        return this.array.clone();
    }
}
