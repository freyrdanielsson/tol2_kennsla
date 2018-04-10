package javadot;

import edu.princeton.cs.algs4.*;

public class EuclideanMST {

    // Fastar sem skilgreina mörk kortsins sem á að teikna.
    private double xMin = Double.POSITIVE_INFINITY;
    private double xMax = Double.NEGATIVE_INFINITY;
    private double yMin = Double.POSITIVE_INFINITY;
    private double yMax = Double.NEGATIVE_INFINITY;

    private Point2D[] points; // Skilgreinið þessa breytu í smiðnum.
    private KruskalMST mst; // Skilgreinið þessa breytu í smiðnum. Hér mætti líka nota PrimMST.

    public EuclideanMST(In in) {
        /*
         * Les hnit úr inntaksstraumnum <in> og upphafsstillir tilviksbreyturnar <this.mst> og <this.points>.
         */

        // Hér þarf að skrifa kóða!
        // Sterklega er mælt með því að skrifa hjálparföll.

        // Hugmyndir að hjálparföllum:
        // 1. Fall til að breyta línunum í luxembourg.txt í fylki af Point2D
        // 2. Fall til að búa til fullskipað EdgeWeightedGraph út frá <this.points>, 
        // þar sem þyngd leggjanna er fjarlægðin á milli punktanna.
    }

    private void drawMST() {
        /*
         * Teiknar spanntréð í tilviksbreytunni <this.mst> með hnitin <this.points>.
         * Gerir ráð fyrir að <this.xMax>, <this.xMin>, <this.yMax> og <this.yMin> séu upphafsstillt.
         */
        // Hér þarf að skrifa kóða!
    }

    public void drawPoints() {
        /*
         * Teiknar hnitin í <this.points> á striga.
         * Gerir ráð fyrir að <this.xMin> og <this.yMin> hafi verið upphafsstillt. Sjá initializeCanvas().
         *
         */
        for (Point2D p : points) {
            StdDraw.point(p.x() - xMin, p.y() - yMin);
        }
    }

    public void initializeCanvas() {
        /*
         * Upphafsstillir striga út frá gögnunum í <this.points>.
         * Setur vitræn gildi á <this.xMax>, <this.xMin>, <this.yMax> og <this.yMin>.
         */

        // Útgildin fundin
        for (Point2D point : points) {
            if (point.x() < xMin) {
                xMin = point.x();
            }
            if (xMax < point.x()) {
                xMax = point.x();
            }
            if (point.y() < yMin) {
                yMin = point.y();
            }
            if (yMax < point.y()) {
                yMax = point.y();
            }
        }
        // Ramminn stækkaður aðeins svo allir punktar geti sést
        double xDiff = xMax - xMin;
        double yDiff = yMax - yMin;
        double padding = 0.1; // Stillir hlutfallslega stærð hvíta rýmisins í kringum punktana
        xMin = xMin - xDiff * padding / 2;
        xMax = xMax + xDiff * padding / 2;
        yMin = yMin - yDiff * padding / 2;
        yMax = yMax + yDiff * padding / 2;

        // Striginn sjálfur upphafsstilltur
        StdDraw.setCanvasSize((int) (xMax - xMin), (int) (yMax - yMin));
        StdDraw.setXscale(0, (int) (xMax - xMin));
        StdDraw.setYscale(0, (int) (yMax - yMin));
        StdDraw.setPenRadius(0.01);
    }

    public double getWeight() {
        /*
        Sækir þyngd undirliggjandi spanntrés
        */
        return this.mst.weight();
    }

    public static void main(String[] args) {
        // ATH: Þetta hrynur við keyrslu þar til points og mst tilviksbreyturnar hafa verið skilgreindar.
        EuclideanMST euclideanMST = new EuclideanMST(new In("luxembourg.txt"));

        StdOut.println(euclideanMST.getWeight());

        euclideanMST.initializeCanvas();
        euclideanMST.drawPoints();
        euclideanMST.drawMST();
    }

}