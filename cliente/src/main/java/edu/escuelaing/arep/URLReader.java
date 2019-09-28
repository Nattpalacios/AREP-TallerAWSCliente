package edu.escuelaing.arep;

import java.io.*; 

import java.net.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger; 
public class URLReader { 
	

	private static AtomicInteger noAceptados;

	public static void main(String[] args) throws Exception { 
		int peticiones = Integer.parseInt(args[0]);
		noAceptados = new AtomicInteger();
		double tiempoInicial = System.currentTimeMillis();
		ArrayList<HiloURL> solicitudes = new ArrayList<HiloURL>();
		for(int i = 0; i < peticiones; i++) {
			solicitudes.add(new HiloURL(noAceptados));
		}
		for(int i = 0; i < solicitudes.size(); i++) {
			//solicitudes.get(i).run();
			solicitudes.get(i).start();			
		}
        for(int x = 0; x < solicitudes.size(); x++) {
        	solicitudes.get(x).join();
        }
		
		double tiempoFinal = System.currentTimeMillis();
		System.err.println("Recibiendo " + peticiones + " solicitudes, el servidor se tarda " + (tiempoFinal - tiempoInicial) + " milisegundos en responder.");
		System.err.println("El n�mero de solicitudes que NO fueron existosas es: " + noAceptados.get());
    } 
}