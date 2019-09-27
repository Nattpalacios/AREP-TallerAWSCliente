package edu.escuelaing.arep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;

public class HiloURL extends Thread{
	
	AtomicInteger nA;
	
	public HiloURL(AtomicInteger noAceptado) {
		nA = noAceptado;
	}
	
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
	    	   nA.getAndIncrement();
	    	   System.err.println(x); 
	       } 
		}catch (MalformedURLException e) {
			nA.getAndIncrement();
			e.printStackTrace();
		} 
	}

}
