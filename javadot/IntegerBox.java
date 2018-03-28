package javadot;

class IntegerBox implements Comparable<IntegerBox> {

    /*
     * "Kassi" utan um heiltölur.
     * Þessa heiltölukassa má bera saman, en þeir hafa versta mögulega hakkafallið
     */

    private Integer boxed;

    public IntegerBox(Integer toBox) {
        this.boxed = toBox;
    }

    @Override
    public int hashCode() {
        return 42;
    }

    @Override
    public int compareTo(IntegerBox box) {
        return this.boxed.compareTo(box.boxed);
    }
}