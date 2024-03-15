package intento;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
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
		
		if (args.length!=0) {
			
			try ( 
					BufferedReader br = new BufferedReader(new FileReader("./IntentoLegos2/data/"+args[0]));
				) { 
					try (BufferedWriter writer = new BufferedWriter(new FileWriter ("./IntentoLegos2/data/"+args[1]))) {
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
			}
		else {
			try ( 
				InputStreamReader is= new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(is);
			) { 
				
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
					System.out.println(respuesta);
					line = br.readLine();
				}
			}
			}
		
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