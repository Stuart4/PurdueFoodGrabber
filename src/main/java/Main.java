import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try {
            FoodGrabber grabber = new FoodGrabber(new URL("http://www.housing.purdue.edu/Menus/ERHT"));
            Menu foods = grabber.getFood();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
