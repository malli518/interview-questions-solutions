package com.job.search.pratice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import org.json.simple.JSONArray; 
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser; 
public class MovieClass {
	public static void main(String args[]) {
		List<String> sortedTitles = getMovieTitles("spiderman");
		
		System.out.println(sortedTitles);
	}
	
	public static List<String> getMovieTitles(String title) {
		String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=%s";
		url = String.format(url, title);
		
		List<String> result = new ArrayList<String>();
		
		URL obj;
		try {
			obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			int responseCode = con.getResponseCode();
			con.getContent();
			System.out.println("Content :: "+con.getContent().toString());
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);				
			}
			in.close();			
			result=getTitlesArray(response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Collections.sort(result);
		System.out.println("Result "+result);
		String str[] = new String[result.size()];         
        for (int j = 0; j < result.size(); j++) { 
            str[j] = result.get(j); 
            System.out.println("===" +str[j]);
        }  
        
		return result;
	}
	
public static List<String> getTitlesArray(String str) {
		
		List<String> result = new ArrayList<String>();
		
		try {
			// Parse JSON
			Object obj1 = new JSONParser().parse(str); 
			JSONObject jo = (JSONObject) obj1;
			JSONArray data = (JSONArray) jo.get("data");
			
			Iterator<JSONObject> itr = data.iterator();
			
			while(itr.hasNext()) {
				Object item = new JSONParser().parse(itr.next().toString());
				JSONObject itemObj = (JSONObject) item;
				String theTitle = (String) itemObj.get("Title");

				result.add(theTitle);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Collections.sort(result);

		return result;

	}
}
