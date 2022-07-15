import java.io.File;
import java.util.Random;
import java.io.IOException;
import java.io.FileWriter; 
import java.io.BufferedWriter;

public class deepDepressionExt{
    public static int asc(int V1) {
        V1 %= 100;
        V1 += 48;
        return V1;
    }
    public static int ascA(int V1) {
        V1 /= 10;
        V1 += 48;
        return V1;
    }
    public static int ascB(int V1) {
        V1 %= 10;
        V1 += 48;
        return V1;
    }
    public static void main(String[] args){
        if(((args.length) == 0) || (((args.length)%2) != 0) || ((args.length)) < 4){
            System.out.println("Erro: parametros incorretos");
            System.exit(0);
        }
        int x = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);
        if(x != y){
            System.out.println("Erro: c1 != l2");
            System.exit(0);
        }

        File arq = new File("./matriz.txt");
        
        Random random = new Random();
        
        try{
            if (!arq.exists()) {
                arq.createNewFile();
            }

            FileWriter fw = new FileWriter(arq, true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            int aux[] = new int[args.length];
            
            for(int i = 0; i < args.length; i++){
                aux[i] = Integer.parseInt(args[i]);
            }
            int h = 0;
            int matriz[][];
            int matriz1[][];
            if(aux[h] >= aux[h+1]){
                matriz = new int[aux[h]][aux[h]];
                
            }else{
                matriz = new int[aux[h+1]][aux[h+1]];
            }
            if(aux[h+2] >= aux[h+3]){
                matriz1 = new int[aux[h+2]][aux[h+2]];
            }else{
                matriz1 = new int[aux[h+3]][aux[h+3]];
            }
            int j = 0;
            for(int i = 0; i < aux[j]; i++){
                for(int k = 0; k < aux[j+1]; k++){
                    matriz[i][k] = random.nextInt(9);
                }
            }
            for(int i = 0; i < matriz.length; i++){
                for(int k = 0; k < matriz[0].length; k++){
                    bw.write(ascA(matriz[i][k]));
                    bw.write(ascB(matriz[i][k]));
                    bw.write(" ");
                }
                bw.newLine();
            }bw.newLine();

            j = 2;
            for(int i = 0; i < aux[j]; i++){
                for(int k = 0; k < aux[j+1]; k++){
                    matriz1[i][k] = random.nextInt(9);
                }
            }
            
            for(int i = 0; i < matriz1.length; i++){
                for(int k = 0; k < matriz1[0].length; k++){
                    bw.write(ascA(matriz1[i][k]));
                    bw.write(ascB(matriz1[i][k]));
                    bw.write(" ");
                }
                bw.newLine();
            }bw.newLine();

            int w = Integer.parseInt(args[0]);
            int q = Integer.parseInt(args[3]);
            j = 0;
            int matrizR[][] = new int[matriz.length][matriz1[0].length];
            //if((q+w) > (x+y)){
                for(int i = 0; i < matriz.length; i++){
                    for(int k = 0; k < matriz1.length; k++){
                        for(int l = 0; l < matriz[0].length; l++){
                            matrizR[i][k] += (matriz[i][l])*(matriz1[l][k]);
                        }
                    }
                }
            /*}else{
                for(int i = 0; i < matriz1.length; i++){
                    for(int k = 0; k < matriz.length; k++){
                        for(int l = 0; l < matriz1[0].length; l++){
                            matrizR[i][k] += (matriz1[i][l])*(matriz[l][k]);
                        }
                    }
                }
            }*/
            for(int i = 0; i < matrizR.length; i++){
                for(int k = 0; k < matrizR[0].length; k++){
                    bw.write(ascA(matrizR[i][k]));
                    bw.write(ascB(matrizR[i][k]));
                    bw.write(" ");
                }
                bw.newLine();
            }bw.newLine();

            bw.close();
            fw.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }   
    }
}