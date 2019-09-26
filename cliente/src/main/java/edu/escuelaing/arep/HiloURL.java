package edu.escuelaing.arep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class HiloURL extends Thread{
	
	public void run() {
		try{
			URL url = new URL("https://primerproyectoarep.herokuapp.com/recursosWeb/operaciones.html"); 
		
	      try (BufferedReader reader = new BufferedReader(
	          new InputStreamReader(url.openStream()))) { 
	            String inputLine = null; 
	            while ((inputLine = reader.readLine()) != null) { 
	                  System.out.println(inputLine); 
	             } 
	       } catch (IOException x) { 
	               System.err.println(x); 
	       } 
		}catch (MalformedURLException e) {
			e.printStackTrace();
		} 
	}

}
