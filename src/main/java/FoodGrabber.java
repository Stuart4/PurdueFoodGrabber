import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by jake on 11/22/14.
 */
public class FoodGrabber {
	Document doc;
	public FoodGrabber(URL url) throws IOException{
		doc = Jsoup.connect(url.toString()).get();
	}

	public Menu getFood() {
		Menu menu = new Menu();
		Elements meals = doc.select("div.location-meal-container");
		for (Element mealElement : meals) {
			Meal meal = new Meal();
			meal.setName(mealElement.id());
			Element hours = mealElement.select("div.hours").first();
			if (hours.text().equals("Not Serving")) {
				meal.setServing(false);
			} else {
				meal.setServing(true);
				meal.setHours(hours.text());
			}
			Elements mealLocations = meals.select("th.station-name");
			for (Element mealLocationElement : mealLocations) {
				MealLocation mealLocation = new MealLocation();
				mealLocation.setName(mealLocationElement.text());
				Elements menuItems = mealLocations.select("tr.menu-item");
				for (Element menuItemElement : menuItems) {
					MenuItem menuItem = new MenuItem();
					if (menuItemElement.select("td.veg").isEmpty()){
						menuItem.setVegetarian(false);
					} else {
						menuItem.setVegetarian(true);
					}
					menuItem.setName(menuItemElement.text());
					mealLocation.add(menuItem);
				}
				meal.add(mealLocation);
			}
			menu.add(meal);
		}
		return menu;
	}
}
