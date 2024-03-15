package intento;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.HashMap;

//Proyecto realizado por:
//Mateo López   m.lopez112@uniandes.edu.co
//Miguel Castillo   ms.castillo@uniandes.edu.co

public class ProblemaP1  {

	HashMap<Integer, Integer> respuestas = new HashMap<Integer,Integer>();
	static HashMap<Integer, Integer> respstatic = new HashMap<Integer,Integer>();
	private static long startTime;
	public static void main(String[] args) throws Exception {
		ProblemaP1 instancia = new ProblemaP1();
		
		try ( 
				BufferedReader br = new BufferedReader(new FileReader("./IntentoLegos2/data/fichas.in"));
			) { 
				try (BufferedWriter writer = new BufferedWriter(new FileWriter ("./IntentoLegos2/data/fichas.out"))) {
					String line = br.readLine();
					int casos = Integer.parseInt(line);
					line = br.readLine() ;
					for(int i=0;i<=casos && line!=null && line.length()>0 && !"0".equals(line);i++) {
						HashMap<Integer, Integer> respuestas = new HashMap<Integer,Integer>();
						final String [] dataStr = line.split(" ");
						final String[] newArray = new String[dataStr.length - 1];
					    System.arraycopy(dataStr, 1, newArray, 0, newArray.length);
						final int[] numeros = Arrays.stream(newArray).mapToInt(f->Integer.parseInt(f)).toArray();
						startTime = System.currentTimeMillis();
						int respuesta= instancia.m(0,numeros,respuestas);
						
						
						writer.write(String.valueOf(respuesta));
						writer.newLine();
						line = br.readLine();
						
						
					}
					line = br.readLine();
				}
			}
		//int[] u = {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 2, 9, 3, 5, 14, 19, 23, 32};*/
		/*int[] u = {0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,5,
				0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,5,
				0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,5,
				0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,5,
				0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,5,
				0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,5,
				0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,5,
				0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,5,
				0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,100,
				0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,15000,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,5,
				0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,5,
				0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,02,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,150};*/
		//int[]u = {10, 333, 11, 22, 300, 100};
		//int[] u = {0, 3, 5, 7, 10, 5, 9, 6, 1, 7, 10, 4, 4, 0, 5, 1, 5, 9, 3, 2, 2, 0, 10, 10, 3, 7, 4, 2, 7, 9, 1, 0, 8, 1, 7, 6, 7, 4, 4, 10, 0, 8, 4, 3, 3, 0, 0, 4, 3, 4, 5, 0, 10, 7, 0, 8, 4, 8, 3, 1, 6, 2, 2, 8, 8, 1, 2, 1, 9, 1, 3, 4, 5, 2, 1, 6, 3, 7, 1, 3, 6, 8, 7, 4, 8, 1, 10, 4, 2, 2, 3, 5, 4, 10, 8, 0, 5, 3, 7, 7};
		//System.out.println("Longitud:"+u.length);
        //int d = statico(0, u);
		//System.out.println(d);
    }

	public int m (int i, int[] u, HashMap<Integer, Integer> respuestas) {
		long endTime = System.currentTimeMillis() - startTime; 
		if (endTime> 540000) return 0 ;
		else if (respuestas.containsKey(i)) return respuestas.get(i);
		
		if (i == u.length-1 ) {
			return 0;
		}
		
		else if (u[i]>= u[i+1]) {
			int resp = m(i+1, u, respuestas);
			respuestas.put(i, resp);
			return resp;
			}
		else if ( u[i] <u[i+1] && i -1 <0) { 
			u[i+1] --; 
			u[i] ++;
			
			int resp =1+m(i, u,respuestas);
			respuestas.put(i, resp);
			return resp;
		}
		else if ( u[i] <u[i+1] &&  u[i-1] - u[i]>1) { 
			
			u[i] ++;
			int [] d = u.clone();
			d[i+1] --;
			u[i-1] --; 
			//int resp1;
			//int resp2;
			
			int resp = Integer.min(1+m(i, u,respuestas), 1+m(i, d,respuestas));
			respuestas.put(i, resp);
			return resp;
			}
		else if ( u[i] <u[i+1] &  u[i] - u[i-1]<=1) { 
					
			u[i] ++;
			u[i+1] --; 
			
			int resp = 1+m(i-1, u,respuestas) ;
			respuestas.put(i, resp);
			return resp;
			}
		return 0;
}
public static int statico (int i, int[] u) {
		
	//if (respstatic.containsKey(i)) return respstatic.get(i);
	
	if (i == u.length-1 ) {
		return 0;
	}
	
	else if (u[i]>= u[i+1]) {
		int resp = statico(i+1, u);
		respstatic.put(i, resp);
		return resp;
		}
	else if ( u[i] <u[i+1] && i -1 <0) { 
		u[i+1] --; 
		u[i] ++;
		
		int resp =1+statico(i, u);
		respstatic.put(i, resp);
		return resp;
	}
	else if ( u[i] <u[i+1] &&  u[i-1] - u[i]>1) { 
		
		u[i] ++;
		int [] d = u.clone();
		d[i+1] --;
		u[i-1] --; 
		//int resp1;
		//int resp2;
		
		int resp = Integer.min(1+statico(i, u), 1+statico(i, d));
		respstatic.put(i, resp);
		return resp;
		}
	else if ( u[i] <u[i+1] &  u[i] - u[i-1]<=1) { 
				
		u[i] ++;
		u[i+1] --; 
		
		int resp = 1+statico(i-1, u) ;
		respstatic.put(i, resp);
		return resp;
		}
	return 0;
}
		
	

}