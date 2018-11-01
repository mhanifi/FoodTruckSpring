package FoodTruck;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.*;


public class FoodDAO {
	private static HashMap<String, FoodTruck> foodTruckHash = new HashMap<String, FoodTruck>();

//		foodTruckFinder("37.75212416", "-122.4032299");
	public static List<FoodTruck> foodTruckFinder(String myLat, String myLong){
		try {
			readData();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		HashMap<Double, FoodTruck> distanceMap = new HashMap< Double, FoodTruck>();
		List<Double> distanceList = new LinkedList<Double>();
		List <FoodTruck> nearestTrucks = new ArrayList<FoodTruck>();

		for(String key : foodTruckHash.keySet()){
			double distance = findDistance(myLat, myLong, foodTruckHash.get(key).getLatitude(),
					foodTruckHash.get(key).getLongitude());
			distanceMap.put(distance, foodTruckHash.get(key));
			distanceList.add(distance);
		}
		Collections.sort(distanceList);
		for(int i = 0; i < 5 ; i++){
			nearestTrucks.add(distanceMap.get(distanceList.get(i)));
		}
		return nearestTrucks;
	}

	private static double findDistance(String mylat, String mylong, String trucklat, String trucklong) {
		/** Caclualtes the distance between two points in Km*/
		final int R = 6371; // Radius of the earth
		double distance=0;
		try {
			if(trucklat.trim().equals("") || mylong.trim().equals(""))
				return Double.MAX_VALUE;
			double lat1 = Double.parseDouble(mylat);
			double lon1 = Double.parseDouble(mylong);
			double lat2 = Double.parseDouble(trucklat);
			double lon2 = Double.parseDouble(trucklong);

			double latDistance = Math.toRadians(lat2 - lat1);
			double lonDistance = Math.toRadians(lon2 - lon1);
			double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
					+ Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
					* Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
			double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
			distance = R * c * 1000; // convert to meters

			distance = Math.pow(distance, 2);
		}catch(ArithmeticException e) {
			System.out.println("In the catch Block due to Exception = " + e);
		}

		return Math.sqrt(distance/1000);
	}

	private static void readData() throws IOException, ParseException {
		try {
			URL dumpURL = new URL("https://data.sfgov.org/api/views/rqzj-sfat/rows.csv");
			FoodTruckData(dumpURL);
		} catch (MalformedURLException e) {
			System.out.println("Your URL for your dump data is not working.");
			e.printStackTrace();
		}

	}

	private static void FoodTruckData(URL inputUrl) throws FileNotFoundException, IOException, ParseException{
	/** The method for reading the data from URL*/

		// Get the input stream through URL Connection
		URLConnection con = inputUrl.openConnection();
		InputStream is =con.getInputStream();

		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line = null;

		try {
		 foodTruckHash.clear();
		 br.readLine();
		
		 while ((line = br.readLine()) != null) {
			 FoodTruck food=new FoodTruck();
			 String [] ls = line.split(",");
			 food.setApplicant(ls[1].trim());
			 food.setLocationDescription(ls[4].trim());
			 food.setAddress(ls[5].trim());
			 food.setLot(ls[8].trim());
			 food.setStatus(ls[10].trim());
			 food.setFoodItems(ls[11].trim());
			 food.setLatitude(ls[14].trim());
			 food.setLongitude(ls[15].trim());
			 food.setDayHours(ls[17].trim());

			if (!foodTruckHash.containsKey(food.hashKey())){
				foodTruckHash.put(food.hashKey(), food);
			}
		 }
		} catch(IOException e1) {
			System.err.format("IO Exception",e1);
		} catch(NullPointerException e2){
			System.err.format("null exception",e2);
		}
		
	}


}
