package FoodTruck;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {
	@RequestMapping(path="/mylocation", method = RequestMethod.GET)
	public List<FoodTruck> foodT(@RequestParam(value="lat", defaultValue="0") String latitude,@RequestParam(value="lon", defaultValue="0") String longitude) throws IOException, IOException, ParseException{
		List<FoodTruck> food=new ArrayList<FoodTruck>(FoodDAO.foodTruckFinder(latitude, longitude));
			
		return food;
	}
	
}
