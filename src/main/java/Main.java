import java.io.IOException;
import java.net.URL;

/**
 * Created by Jacob Stuart on 11/22/14.
 */
public class Main {

    public static void main(String[] args) {
        try {
            FoodGrabber grabber = new FoodGrabber(new URL("http://www.housing.purdue.edu/Menus/ERHT"));
            Menu foods = grabber.getFood();
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
