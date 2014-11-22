import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by jake on 11/22/14.
 */
public class Menu {
	private ArrayList<Meal> meals = new ArrayList<Meal>();

	public void add(Meal meal) {
		meals.add(meal);
	}

	public Meal[] getMeals() {
		return meals.toArray(new Meal[meals.size()]);
	}
}
class Meal {
	private String name;
	private boolean isServing;
	private String hours;
	private ArrayList<MealLocation> mealLocations = new ArrayList<MealLocation>();

	public void add(MealLocation location) {
		mealLocations.add(location);
	}

	public void setHours (String hours) {
		this.hours = hours;
		isServing = true;
	}

	public void setServing(boolean serving) {
		isServing = serving;
		if (!serving) {
			hours = null;
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public boolean getIsServing() {
		return isServing;
	}

	public String getHours() {
		return hours;
	}

	public MealLocation[] getMealLocations() {
		return mealLocations.toArray(new MealLocation[mealLocations.size()]);
	}
}
class MealLocation {
	private String name;
	private LinkedList<MenuItem> menuItems = new LinkedList<MenuItem>();

	public void setName(String name) {
		this.name = name;
	}

	public void add(MenuItem item) {
		menuItems.add(item);
	}

	public MenuItem[] getMenuItems() {
		return menuItems.toArray(new MenuItem[menuItems.size()]);
	}
}
class MenuItem {
	private String name;
	private boolean isVegetarian;

	public void setVegetarian(boolean vegetarian) {
		isVegetarian = vegetarian;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getIsVegetarian() {
		return isVegetarian;
	}

	public String getName() {
		return name;
	}
}
