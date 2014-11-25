import java.io.IOException;
import java.net.URL;

/*This file is part of PurdueFoodGrabber.

		PurdueFoodGrabber is free software: you can redistribute it and/or modify
		it under the terms of the GNU General Public License as published by
		the Free Software Foundation, either version 3 of the License, or
		(at your option) any later version.

		PurdueFoodGrabber is distributed in the hope that it will be useful,
		but WITHOUT ANY WARRANTY; without even the implied warranty of
		MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
		GNU General Public License for more details.

		You should have received a copy of the GNU General Public License
		along with PurdueFoodGrabber.  If not, see <http://www.gnu.org/licenses/>. */

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
