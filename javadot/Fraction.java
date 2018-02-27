public class Fraction implements Comparable<Fraction> {
    private int num;
    private int den;


    Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        this.num = numerator;
        this.den = denominator;
        this.reduce(); // Látum öll brot vera fullstytt
    }

    public Fraction plus(Fraction f) {
        return new Fraction(this.num * f.den + f.num * this.den, this.den * f.den);
    }

    public Fraction minus(Fraction f) {
        return new Fraction(this.num * f.den - f.num * this.den, this.den * f.den);
    }

    public Fraction times(Fraction f) {
        return new Fraction(this.num * f.num, this.den * f.den);
    }

    public Fraction divides(Fraction f) {
        return new Fraction(this.num * f.den, this.den * f.num);
    }

    public boolean equals(Fraction f) {
        // Hér þarf að skrifa kóða
        return f != null && this.num * f.den == this.den * f.num;
    }

    @Override
    public int compareTo(Fraction f) {
        // Hér þarf að skrifa kóða
        int difference = this.num * f.den - this.den * f.num; // Getur valdið villum með mjög stórum tölum, hunsað
        if (difference < 0) {
            return -1;  // Ath hvaða mínustala sem er er lögleg skv. interface-inu
        } else if (difference > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        if (this.num != 0) {
            return this.num + "/" + this.den;
        } else {
            return "0";
        }
    }

    private void reduce() {
        /*
        Styttir brotið svo að teljarinn og nefnarinn séu af lágmarksstærð
        */
        int divisor = gcd(this.num, this.den);
        this.num /= divisor;
        this.den /= divisor;
    }

    private static int gcd(int a, int b) {
        /*
        Finnur stærsta samdeili heiltalnanna n1 og n2
        */
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void main(String args[]) {
        Fraction p = new Fraction(1, 2);
        Fraction r = new Fraction(-1, -2);
        Fraction q = new Fraction(2, 6);
        Fraction s = new Fraction(1, 4);
        Fraction t = new Fraction(2, 4);

        // Prófum hvort .equals aðferðin sé sjálfhverf (þarf að vera satt)
        System.out.println("p.equals(p): " + p.equals(p));
        // Prófum hvort .equals aðferðin sé samhverf (þarf að vera eins)
        System.out.println("p.equals(r): " + p.equals(r));
        System.out.println("r.equals(p): " + r.equals(p));
        // Prófum hvort .equals aðferðin sé gegnvirk (allt þarf að vera eins)
        System.out.println("p.equals(r): " + p.equals(r));
        System.out.println("r.equals(t): " + r.equals(t));
        System.out.println("p.equals(t): " + p.equals(t));
        // Prófum hvort .equals aðferðin hafni samanburði við null (þarf að vera false):
        System.out.println("t.equals(null): " + t.equals(null));

        // Prófum hvort .compareTo sé sjálfhverf (þarf að vera 0)
        System.out.println("q.compareTo(q): " + q.compareTo(q));

        // Prófum hvort .compareTo sé andsamhverf (þarf að vera mismunandi)
        System.out.println("r.compareTo(q): " + r.compareTo(q));
        System.out.println("q.compareTo(r): " + q.compareTo(r));

        // Prófum hvort .compareTo sé gegnvirk (allt þarf að vera eins)
        System.out.println("r.compareTo(q): " + r.compareTo(q));
        System.out.println("q.compareTo(s): " + q.compareTo(s));
        System.out.println("r.compareTo(s): " + r.compareTo(s));

    }


}
