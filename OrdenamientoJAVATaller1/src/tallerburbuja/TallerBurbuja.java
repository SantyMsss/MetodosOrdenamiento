/* Talle Metodos de Ordenamiento en java 

En el presente taller se implementan los siguientes metodos de ordenamiento, 
cada uno con una complejidad diferente:
- Selection sort
- Counting sort
- HeapSort
- Bubblesort
- Array.Sort propio de este lenguaje

NOTA///////////////////////////////////////////////////////////////////////////
EN CASO DE QUERER IMPRIMIR LOS VALORES DEL ARREGLO DESORDENADO Y POSTERIORMENTE
ORDENADO, DESCOMENTAR LAS LINEAS QUE CONTIENEN LA PALABRA "imprimir" EN EL CODIGO

Porgramadores 
Santiago Martinez Serna
Laura Sofia Toro
Santiago Santacruz Cuellar


*/
package tallerburbuja;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;

public class TallerBurbuja 
{
        int N;
        int arreglo[], arr_tmp[];
        double cant_inter, cant_asig, cant_comp;
      
        Scanner in = new Scanner(System.in);
           
        /**
         * 
         */
        void Menu(){
            
            int opc;
            System.out.println("1. 50.000");
            System.out.println("2. 100.000");
            System.out.println("3. 250.000");
            System.out.println("4. 500.000");
            System.out.println("5. 1.000.000");
            System.out.println("6. 10 (para pruebas)");
            System.out.println("Seleccione un tamano: ");
            opc = in.nextInt();
            switch(opc) {
                case 1: N = 50000;
                        arreglo = new int[N];
                        arr_tmp = new int[N];
                        llenar();
                        break;
                case 2: N = 100000;
                        arreglo = new int[N];
                        arr_tmp = new int[N];
                        llenar();
                        break;
                case 3: N = 250000;
                        arreglo = new int[N];
                        arr_tmp = new int[N];
                        llenar();
                        break;
                case 4: N = 500000;
                        arreglo = new int[N];
                        arr_tmp = new int[N];
                        llenar();
                        break;
                case 5: N = 1000000;
                        arreglo = new int[N];
                        arr_tmp = new int[N];
                        llenar();
                        break;
                case 6: N = 10;
                        arreglo = new int[N];
                        arr_tmp = new int[N];
                        llenar();
                        break;
                
        
            }
        
            do {
                System.out.println("\n1. Burbuja o BubbleSort");
                System.out.println("2. SelectionSort");
                System.out.println("3. CountingSort");
                System.out.println("4. HeapSort");
                System.out.println("5. ArraysSort"); 
                System.out.println("6. INFO PROGRAMADORES");
                System.out.println("0. Salir");
                System.out.println("Seleccione un metodo:");
                int ord = in.nextInt();
            
                switch(ord) {
                    case 1: burbuja(); break;
                    case 2: selectionSort(); break;
                    case 3: countingSort(); break;
                    case 4: heapSort(); break;
                    case 5: ArraysSort(); break;
                    case 6: 
                        System.out.println("\nProgramadores:\n"); 
                        System.out.println("- Santiago Martinez Serna");
                        System.out.println("- Santiago Santacruz Cuellar");
                        System.out.println("- Laura Sofia Toro Garcia ");
                        break;
                    case 0: 
                        System.out.println("Saliendo...");
                        return;  
                    default: 
                        System.out.println("Opcion no valida");
                        break;
                }
            } while(true); 
            
    }
        
        
        public static void crear(int tam){
        FileWriter fw = null;
        boolean error = false;
        
        try {
            fw = new FileWriter(
               "C:\\Users\\USER\\Desktop\\datos_"  + tam + ".txt");       
        } catch (Exception e) {
            error = true;
            System.out.println("Error al crear el documento");
        }
        if(!error){
            for (int i = 0; i < tam; i++) {
                int ale = 1 + (int)(Math.random() * 10000);
                try {
                    fw.write(ale + "\r\n");
                } catch (Exception e) {
                    System.out.println("Error al guardar en el documento");
                    break;
                }
            }
            try {
                fw.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar el documento");
            }
        }
    }
    

    public void llenar(){
        FileReader fr = null;
        boolean error = false;
        try {
            fr = new FileReader(
               "C:\\Users\\USER\\Desktop\\datos_" + N + ".txt");
        } catch (Exception e) {
            System.out.println("Error al leer el archivo datos_" + N + ".txt");
            error = true;
        }
        if(!error){
            BufferedReader br = new BufferedReader(fr);
            String numero;
            int i = 0;
            try {
                while((numero = br.readLine()) != null){
                    arreglo[i] = Integer.parseInt(numero);
                    arr_tmp[i] = arreglo[i];
                    i++;
                }
            } catch (Exception e) {
                System.out.println("Error al leer el archivo");
            }
            try {
                fr.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar el archivo");
            }
        }
    }
    public void burbuja(){
    copiar();
    long InicioTiempo = System.currentTimeMillis();
    //imprimir();
    cant_inter = cant_asig = cant_comp = 0;
    cant_asig++; //int i=1
    cant_comp++; //i<N
    for (int i=1; i<N; i++){
         cant_asig++; //int j=0
         cant_comp++; //j<N - 1
         for (int j=0 ; j<N - 1; j++){
              cant_comp++; //arreglo[j] > arreglo[j+1]
              if (arreglo[j] > arreglo[j+1]){
                   int temp = arreglo[j];
                   arreglo[j] = arreglo[j+1];
                   arreglo[j+1] = temp;
                   cant_inter++;
                   cant_asig+=3;
              }
           cant_asig++;//j++
           cant_comp++; //j<N - 1
         }//fin del bucle interno
         cant_asig++;//i++
         cant_comp++; //i<N
    }//fin del bucle externo
    
        long FinalTiempo = System.currentTimeMillis();
        double TiempoTotal = (InicioTiempo - FinalTiempo) / 1000.0;
    
    
        System.out.println("\nTiempo de ejecucion de Burbuja: " + TiempoTotal + " ms");
        System.out.println( "\n");
        System.out.println( cant_inter + " Intercambios \n");
        System.out.println( cant_asig + " Asignaciones \n");
        System.out.println( cant_comp + " Comparaciones \n");
    //imprimir();
}
       
    
    public void selectionSort(){
         copiar();
    long InicioTiempo = System.currentTimeMillis();
   // imprimir();
    cant_inter = cant_asig = cant_comp = 0;
   
    for (int i = 0; i < N - 1; ++i) {
        int minIndex = i;   
        for (int j = i + 1; j < N; ++j) {
            ++cant_comp; // Comparación (arreglo[j] < arreglo[minIndex])
            if (arreglo[j] < arreglo[minIndex]) {
                minIndex = j;
            }
        }
        if (minIndex != i) {
            int temp = arreglo[i];
            arreglo[i] = arreglo[minIndex];
            arreglo[minIndex] = temp;
            cant_inter++;
            cant_asig += 3;
        }
        cant_asig += 2; // i++ y minIndex != i
        cant_comp += 2; // i < N - 1 y minIndex != i
    }
        long FinalTiempo = System.currentTimeMillis();
        double TiempoTotal = (InicioTiempo - FinalTiempo) / 1000.0;
    
    
        System.out.println("\nTiempo de ejecucion de selectionSort: " + TiempoTotal + " ms");
        System.out.println( "\n");
        System.out.println( cant_inter + " Intercambios \n");
        System.out.println( cant_asig + " Asignaciones \n");
        System.out.println( cant_comp + " Comparaciones \n");

    
   
   // imprimir();
        
    }
      public void countingSort(){
        
    copiar();
    long InicioTiempo = System.currentTimeMillis();
   // imprimir();
    cant_inter = cant_asig = cant_comp = 0;

    int maxVal = 1000000; // Valor máximo asumido en el arreglo
    int[] countArray = new int[maxVal + 1];
    for (int i = 0; i < N; ++i) {
        ++countArray[arreglo[i]];
        ++cant_asig; // ++countArray[arreglo[i]]
    }

    int index = 0;
    for (int i = 0; i <= maxVal; ++i) {
        while (countArray[i] > 0) {
            arreglo[index++] = i;
            --countArray[i];
            ++cant_asig; // arreglo[index++] = i
            ++cant_inter;
        }
    }
    
        long FinalTiempo = System.currentTimeMillis();
        double TiempoTotal = (InicioTiempo - FinalTiempo) / 1000.0;
    
    
        System.out.println("\nTiempo de ejecucion de countingSort: " + TiempoTotal + " ms");
        System.out.println( "\n");
        System.out.println( cant_inter + " Intercambios \n");
        System.out.println( cant_asig + " Asignaciones \n");
        System.out.println( cant_comp + " Comparaciones \n");

 
    //imprimir();
    }
    public void heapSort() {
        copiar();
       long InicioTiempo = System.currentTimeMillis();
       // imprimir();
        cant_inter = cant_asig = cant_comp = 0;

        for (int i = N / 2 - 1; i >= 0; --i) {
            heapify(arreglo, N, i);
            cant_asig += 2; // i y llamada a heapify
            cant_comp++; // i >= 0
        }

        for (int i = N - 1; i >= 0; --i) {
            int temp = arreglo[0];
            arreglo[0] = arreglo[i];
            arreglo[i] = temp;
            heapify(arreglo, i, 0);
            cant_inter++;
            cant_asig += 4; // i, temp, arreglo[i], llamada a heapify
            cant_comp++; // i >= 0
        }

        long FinalTiempo = System.currentTimeMillis();
        double TiempoTotal = (InicioTiempo - FinalTiempo) / 1000.0;
    
    
        System.out.println("\nTiempo de ejecucion de heapSort: " + TiempoTotal + " ms");
        System.out.println("\n");
        System.out.println(cant_inter + " Intercambios \n");
        System.out.println(cant_asig + " Asignaciones \n");
        System.out.println(cant_comp + " Comparaciones \n");

       // imprimir();
    }
// SUB CLASE DE HEAPSORT
    public void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    void copiar(){
        for(int i = 0; i < N; i++){
            arreglo[i] = arr_tmp[i];
        }
    }
    
   public void ArraysSort() {
        copiar();
        long InicioTiempo = System.currentTimeMillis();
       // imprimir();
        cant_inter = cant_asig = cant_comp = 0;

        Arrays.sort(arreglo); 
        long FinalTiempo = System.currentTimeMillis();
        double TiempoTotal = (InicioTiempo - FinalTiempo) / 1000.0;
    
    
        System.out.println("\nTiempo de ejecucion de ArraysSort: " + TiempoTotal + " ms");
        System.out.println("\nArreglo ordenado con Arrays.sort:\n");
       // imprimir();
    }
    
    public void imprimir(){
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println(arreglo[i]);
        }
    }
   
   
            
    public static void main(String[] args) {
        TallerBurbuja.crear(1);
       //TallerBurbuja ad = new TallerBurbuja();
        
        //ad.Menu();
        //ad.llenar();    
        //ad.imprimir();
      }

 
}
