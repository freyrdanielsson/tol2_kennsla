import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stack;

class Hanoi {

    private Stack<Integer> left;
    private Stack<Integer> middle;
    private Stack<Integer> right;
    private int n;

    public Hanoi(int n) {
        /*
        Creates a new instance of the Hanoi puzzle, with n disks.
         */
        this.n = n;
        this.left = new Stack<>();
        this.middle = new Stack<>();
        this.right = new Stack<>();

        for (int i = n; 0 < i; i--) {
            this.left.push(i);
        }
        this.displayState();
    }

    private void solve() {
        solve(n, this.left, this.right, this.middle);
    }

    private void solve(int n, Stack<Integer> from, Stack<Integer> to, Stack<Integer> help) {
        /*
        Performs one movement of the Hanoi puzzle
         */
        if (n > 0) {
            this.solve(n - 1, from, help, to);
            Integer disk = from.pop();
            to.push(disk);
            this.displayState();
            this.solve(n - 1, help, to, from);
        }
    }

    private void displayState() {
        StdOut.println("Vinstri : " +  this.left.toString());
        StdOut.println("Miðja   : " +  this.middle.toString());
        StdOut.println("Hægri   : " + this.right.toString());
        StdOut.println("#####################");
    }

    public static void main(String[] args) {
        new Hanoi(3).solve();
    }

}