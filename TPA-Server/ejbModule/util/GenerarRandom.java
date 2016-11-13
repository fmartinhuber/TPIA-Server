package util;

import java.util.Random;

public class GenerarRandom {
	private static GenerarRandom instancia = null;
	
	   protected GenerarRandom() {
	      
	   }
	   
	   public static GenerarRandom getinstancia() {
	      if(instancia == null) {
	         instancia = new GenerarRandom();
	      }
	      return instancia;
	   }

	   public String generarRandom (int cant){
		   char[] caracteres = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
		   StringBuilder sb = new StringBuilder();
		   Random random = new Random();
		   for (int i=0; i<cant; i++) {
		       char c = caracteres[random.nextInt(caracteres.length)];
		       sb.append(c);
		   }
		   String output = sb.toString();
		   
		   return output;
	   }
}
