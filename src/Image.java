import java.util.ArrayList;

public class Image {
    public ArrayList<ArrayList<Character>> image;
    public char[] enhancement;

    public Image() {}

    public Image(ArrayList<ArrayList<Character>> image, char[] enhancement) {
        this.image       = image;
        this.enhancement = enhancement;
    }
}
