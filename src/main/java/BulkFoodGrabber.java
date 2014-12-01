import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by jake on 12/1/14.
 */
public class BulkFoodGrabber {
	private final SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
	private Calendar cal;
	private String dateString;
	private FoodGrabber grabber;
	private final String[] courts = new String[]{"ERHT", "FORD", "HILL", "WILY", "WIND"};

	public BulkFoodGrabber(Calendar cal) {
		this.cal = cal;
	}

	public BulkFoodGrabber() {
		cal = Calendar.getInstance();
	}

	public Menu[][] getMenus(int daysPast, int daysFuture) {
		Menu[][] menus = new Menu[daysFuture + daysPast + 1][5];
		cal.add(Calendar.DATE, -daysPast - 1);
		for (int i = 0; i < daysFuture + daysPast + 1; i++) {
			cal.add(Calendar.DATE, 1);
			dateString = format.format(cal.getTime());
			for (int court = 0; court < courts.length; court++) {
				try {
					grabber = new FoodGrabber(new URL(String.format("http://www.housing.purdue.edu/Menus/%s/%s",
							courts[court], dateString)));
					menus[i][court] = grabber.getFood();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return menus;
	}

	public static void main(String[] args) {
		new BulkFoodGrabber().getMenus(1, 1);
	}
}
