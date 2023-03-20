package problemaf_ea;
import java.util.*;
import java.io.*;
import java.util.Collections;

/**
 *
 * @author Leonor Reis
 */
public class ProblemaF_EA {
    static ArrayList<Integer> P;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Integer> P = new ArrayList<>(); //position of the objects 
        int N, M, objPosition; //N - número de objetos, M - range, objPosition - input
        int numTest = scanner.nextInt(); //number of test cases
        
       
        //ler input 
        for(int i=0; i<numTest; i++) {
            N = scanner.nextInt(); //number of objects to guard
            M = scanner.nextInt(); //number of meters each guard covers

            for (int j = 0; j < N; j++) {
                objPosition = scanner.nextInt();
                P.add(objPosition);
            }
            
            Collections.sort(P);
            System.out.println(Guards(P, M, N));
            P.clear();
        }

        scanner.close();
    }
    
    static public int Guards(List<Integer> P, int M, int N) {
        List<Integer> G = new ArrayList<>(); //guards positions
        int i = 0;

        G.add(P.get(0)+M); //initialize the first guard
                
        for(int j=1; j<N; j++){
            if(P.get(j) > G.get(i)+M){ //guard needed
                G.add(P.get(j)+M);
                i++;
            }
        }

        return G.size();
    }
    
}
