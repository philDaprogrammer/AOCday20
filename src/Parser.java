import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
    private final String filename;

    public Parser(String filename) {this.filename = filename;}

    public Solution parse() {
        ArrayList<ArrayList<Character>> input = new ArrayList<>();
        char[] enhancement                    = null;

        try {
            boolean parsingEnhancement = true;
            FileInputStream stream     = new FileInputStream(this.filename);
            Scanner sc                 = new Scanner(stream);

            while (sc.hasNext()) {
                if (parsingEnhancement) {
                    enhancement        = sc.next().toCharArray();
                    parsingEnhancement = false;
                } else {
                    String entry = sc.next();

                    if (!entry.isBlank()) {
                        ArrayList<Character> line = new ArrayList<>();
                        line.add('.');

                        for (Character c : entry.toCharArray()) {
                            line.add(c);
                        }

                        line.add('.');
                        input.add(line);
                    }
                }
            }

            ArrayList<Character> padding = new ArrayList<>();

            for (int i=0; i < input.get(0).size(); ++i) {padding.add('.');}
            input.add(padding);
            input.add(0, padding);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Solution(input, enhancement);
    }
}