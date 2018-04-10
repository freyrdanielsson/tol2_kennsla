package javadot;

import edu.princeton.cs.algs4.*;

public class EuclideanMST {

    // Fastar sem skilgreina mörk kortsins sem á að teikna.
    private double xMin = Double.POSITIVE_INFINITY;
    private double xMax = Double.NEGATIVE_INFINITY;
    private double yMin = Double.POSITIVE_INFINITY;
    private double yMax = Double.NEGATIVE_INFINITY;

    private Point2D[] points; // Skilgreinið þessa breytu í smiðnum
    private KruskalMST mst; // Skilgreinið þessa breytu í smiðnum. Hér mætti líka nota PrimMST

    public EuclideanMST(In in) {
        /*
         * Les hnit úr inntaksstraumnum <in> og upphafsstillir tilviksbreyturnar <this.mst> og <this.points>.
         */
        this.points = linesToPoints(in.readAllLines());
        this.mst = new KruskalMST(getEdgeWeightedGraph());
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

        StdDraw.setCanvasSize((int) (xMax - xMin), (int) (yMax - yMin));
        StdDraw.setXscale(0, (int) (xMax - xMin));
        StdDraw.setYscale(0, (int) (yMax - yMin));
        StdDraw.setPenRadius(0.01);
    }

    public double getWeight() {
        return this.mst.weight();
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

    private Point2D[] linesToPoints(String[] lines) {
        /*
         * Býr til fylki af punktum út frá fylki af strengjum (<lines>) sem
         * skilgreina hnit á sniði sem sjá má í luxembourg.txt.
         */
        SET<Point2D> points = new SET<>();
        for (String line : lines) {
            String[] splitLine = line.split(" ");
            double x = Double.parseDouble(splitLine[2]);
            double y = Double.parseDouble(splitLine[1]);
            points.add(new Point2D(x, y));
        }
        int i = 0;
        Point2D[] pointsArray = new Point2D[points.size()];
        for (Point2D point : points) {
            pointsArray[i] = point;
            i++;
        }
        return pointsArray;
    }

    private void drawMST() {
        /*
         * Teiknar spanntréð í tilviksbreytunni <this.mst> með hnitin <this.points>.
         * Gerir ráð fyrir að <this.xMax>, <this.xMin>, <this.yMax> og <this.yMin> séu upphafsstillt.
         */
        int v, w;
        Point2D p1, p2;
        for (Edge edge : mst.edges()) {
            v = edge.either();
            w = edge.other(v);
            p1 = points[v];
            p2 = points[w];
            StdDraw.line(p1.x() - xMin, p1.y() - yMin, p2.x() - xMin, p2.y() - yMin);
        }
    }

    private EdgeWeightedGraph getEdgeWeightedGraph() {
        /*
         * Býr til EWG út frá points tilviksbreytunni
         */
        EdgeWeightedGraph ewg = new EdgeWeightedGraph(points.length);
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    ewg.addEdge(new Edge(i, j, points[i].distanceTo(points[j])));
                }
            }
        }
        return ewg;
    }

    public static void main(String[] args) {
        EuclideanMST euclideanMST = new EuclideanMST(new In("javadot/luxembourg.txt"));

        StdOut.println(euclideanMST.getWeight());

        euclideanMST.initializeCanvas();
        euclideanMST.drawPoints();
        euclideanMST.drawMST();
    }


}