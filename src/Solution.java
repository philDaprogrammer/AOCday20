import java.util.ArrayList;


public class Solution {
    private ArrayList<ArrayList<Character>> image;
    private final char [] enhancement;

    public Solution(ArrayList<ArrayList<Character>> image, char[] enhancement) {
        this.image        = image;
        this.enhancement = enhancement;
    }

    public void solve() {
        for (int i=0; i < 1; i++) {
            this.image = getNewImage(this.image);
            dumpSol(image);
        }
        System.out.println("Light pixels: " + countPixels());
    }

    private int countPixels() {
        int sum = 0;

        for (ArrayList<Character> row  : this.image) {
            for (Character c : row) {
                if (c == '#') sum++;
            }
        }

        return sum;
    }

    private ArrayList<ArrayList<Character>> getNewImage(ArrayList<ArrayList<Character>> image) {
        ArrayList<ArrayList<Character>> newImage = new ArrayList<>();

        for (int i=0; i < image.size(); ++i) {
            ArrayList<Character> entry = new ArrayList<>();

            for (int j=0; j < image.get(0).size(); ++j) { entry.add('.'); }
            newImage.add(entry);
        }

        for (int i=0; i < image.size(); ++i)
            for (int j = 0; j < image.get(i).size(); ++j)
                newImage.get(i).set(j, this.enhancement[getBinaryEnt(i, j)]);

        for (ArrayList<Character> characters : newImage) { // add the next set of "infinite space"
            characters.add(0, '.');
            characters.add('.');
        }

        ArrayList<Character> padding = new ArrayList<>();

        for (int i=0; i < newImage.get(0).size(); ++i) { padding.add('.'); }

        newImage.add(0, padding);
        newImage.add(padding);

        return newImage;
    }

    private void dumpSol(ArrayList<ArrayList<Character>> newImage) {
         for (ArrayList<Character> arr : newImage)
             System.out.println(arr);
         System.out.println();
    }

    public int getBinaryEnt(int row, int column) {
        ArrayList<Character> bitSequence = new ArrayList<>();
        int sum = 0;

        if (inBounds(row-1, column-1)) { bitSequence.add(this.image.get(row-1).get(column-1)); }
        else { bitSequence.add('.'); }

        if (inBounds(row-1, column)) { bitSequence.add(this.image.get(row-1).get(column)); }
        else { bitSequence.add('.'); }

        if (inBounds(row-1, column+1)) { bitSequence.add(this.image.get(row-1).get(column+1)); }
        else { bitSequence.add('.'); }

        if (inBounds(row, column-1)) { bitSequence.add(this.image.get(row).get(column-1)); }
        else { bitSequence.add('.'); }

        if (inBounds(row, column)) { bitSequence.add(this.image.get(row).get(column)); }
        else { bitSequence.add('.'); }

        if (inBounds(row, column+1)) { bitSequence.add(this.image.get(row).get(column+1)); }
        else { bitSequence.add('.'); }

        if (inBounds(row+1, column-1)) { bitSequence.add(this.image.get(row+1).get(column-1)); }
        else { bitSequence.add('.'); }

        if (inBounds(row+1, column)) { bitSequence.add(this.image.get(row+1).get(column)); }
        else { bitSequence.add('.'); }

        if (inBounds(row+1, column+1)) { bitSequence.add(this.image.get(row+1).get(column+1)); }
        else { bitSequence.add('.'); }

        for (int i=0; i < bitSequence.size(); ++i) {
            if (bitSequence.get(i) == '#') {
                sum += Math.pow(2, bitSequence.size() - 1 - i);
            }
        }

        return sum;
    }

    public boolean inBounds(int row, int column) {
        return (((row < this.image.size()) && (row >= 0))
                && ((column < this.image.get(0).size()) && (column >= 0)));
    }
}