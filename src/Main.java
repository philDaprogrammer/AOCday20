public class Main {
    public static void main(String args[]) {
        Parser parser     = new Parser("input1.txt");
        Solution solution = parser.parse();
        solution.solve();
    }
}