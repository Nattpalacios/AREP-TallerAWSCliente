package edu.escuelaing.arep;

import java.io.*; 

import java.net.*; 
public class URLReader { 
  public static void main(String[] args) throws Exception { 
      int peticiones = Integer.parseInt(args[0]);
      for(int i = 0; i < peticiones; i++) {
    	  HiloURL hilo = new HiloURL();
    	  hilo.run();
      }
      
      
    } 
}