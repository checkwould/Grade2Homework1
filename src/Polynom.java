import java.util.Arrays;

public class Polynom {
    private int[] array;

    public Polynom(int[] array) {
        this.array = array.clone();
    }

    public Polynom(Polynom polynomTwo) {
        this.array = polynomTwo.getArray();
    }

    public int[] getArray() {
        return this.array.clone();
    }

    public int hashCode() {
        return Arrays.hashCode(array);
    }

    public boolean equals(Polynom polynomTwo) {
        return Arrays.equals(array, polynomTwo.getArray());
    }

    public Polynom multiply(Polynom polynomTwo) {
        int[] arrayTwo = polynomTwo.getArray();
        int[] result = new int[array.length + arrayTwo.length - 1];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < arrayTwo.length; j++) {
                result[i + j] += array[i] * arrayTwo[j];
            }
        }

        return new Polynom(result);
    }

    private int min(int one, int two) {
        return one < two ? one : two;
    }

    private int max(int one, int two) {
        return one > two ? one : two;
    }

    private int[] cut(int[] result) {
        int resultLength = result.length;

        for (int i = result.length - 1; (i >= 0) && (result[i] == 0); i--) {
            resultLength -= 1;
        }

        return Arrays.copyOf(result, resultLength);
    }

    public Polynom subtract(Polynom polynomTwo) {
        int[] arrayTwo = polynomTwo.getArray();
        int[] result = new int[max(array.length, arrayTwo.length)];
        int minimal = min(array.length, arrayTwo.length);

        for (int i = 0; i < minimal; i++) {
            result[i] = array[i] - arrayTwo[i];
        }

        if (array.length < arrayTwo.length) {
            for (int i = minimal; i < arrayTwo.length; i++) {
                result[i] = -arrayTwo[i];
            }
        } else {
            System.arraycopy(array, minimal, result, minimal, array.length - minimal);
        }

        return new Polynom(cut(result));
    }

    public Polynom sum(Polynom polynomTwo) {
        int[] arrayTwo = polynomTwo.getArray();
        int[] result = new int[max(array.length, arrayTwo.length)];
        int minimal = min(array.length, arrayTwo.length);

        for (int i = 0; i < minimal; i++) {
            result[i] = array[i] + arrayTwo[i];
        }

        if (array.length < arrayTwo.length) {
            System.arraycopy(arrayTwo, minimal, result, minimal, arrayTwo.length - minimal);
        } else {
            System.arraycopy(array, minimal, result, minimal, array.length - minimal);
        }

        return new Polynom(cut(result));
    }
}