/*
TALLER 1 - METODOS DE ORDENAMIENTO
En el presente taller se implementan los siguientes metodos de ordenamiento, 
cada uno con una complejidad diferente:
- Selection sort
- Counting sort
- HeapSort
- Bubblesort
- Sort de C++ propio de este lenguaje
Programadores: 
- Santiago Martinez Serna - 230222014
- Santiago Santacruz Cuellar - 230222033
- Laura Sofia Toro Garcia - 230222021
*/

#include<iostream> //cout, cin, endl
using namespace std;
#include<ctime> // time()
#include<cstdlib> // srand(),rand()
#include <bits/stdc++.h>
#include <vector>

int *arreglo, *arr_tmp;
int N;
unsigned t0, t1;
double cant_inter, cant_asig, cant_comp;

void imprimir();
void llenar();
void copiar();
void burbuja();
void menu();
void selectionSort();
void countingSort();
void heapify(std::vector<int>& arr, int n, int i); 
void heapSort();
void stdSort(); 

void menu(){
    int opc;
    cout<<"1. 50.000\n";
    cout<<"2. 100.000\n";
    cout<<"3. 250.000\n";
    cout<<"4. 500.000\n";
    cout<<"5. 1.000.000\n";
    cout<<"6. 10 (para pruebas)\n";
    cout<<"Seleccione un tamano: ";
    cin>>opc;
    switch(opc){
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

    do{
    cout<<"\n1. Burbuja o BubbleSort\n";
    cout<<"2. SelectionSort\n";
    cout<<"3. CountingSort\n";
    cout<<"4. HeapSort\n";
    cout<<"5. Sort de C++\n";
    cout<<"6. INFO PROGRAMADORES\n";
    cout<<"0. Salir\n";
    cout<<"Seleccione un metodo:";
    cin>>opc;

    switch(opc){
        case 1: burbuja(); break;
        case 2: selectionSort(); break;
        case 3: countingSort(); break;
        case 4: heapSort(); break;
        case 5: stdSort(); break;
        case 6: cout<<"\nProgramadores:\n"; 
                cout<<"- Santiago Martinez Serna - 230222014\n";
                cout<<"- Santiago Santacruz Cuellar - 230222033\n";
                cout<<"- Laura Sofia Toro Garcia - 230222021\n\n";
                break;
              

        }
    }while(opc != 0);
}


void copiar(){
    for(int i = 0; i < N; i++){
        arreglo[i] = arr_tmp[i];
    }
}

// Bubblesort - O(n^2)
void burbuja(){
    system("cls");
    copiar();
    //imprimir();
    cant_inter = cant_asig = cant_comp = 0;
    t0 = clock();
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
    t1 = clock();
    double time = (double(t1-t0)/CLOCKS_PER_SEC);
    cout << "Execution Time: " << time << endl;
    cout <<"Cant intercambios: "<<cant_inter<< endl;
    cout <<"Cant asignaciones: "<<cant_asig<< endl;
    cout <<"Cant comparaciones: "<<cant_comp<< endl;
   // system("pause");
    //system("cls");
    // imprimir();
}

// Selection sort - O(n^2)
void selectionSort() {
    system("cls");
    copiar();
    //imprimir();
    cant_inter = cant_asig = cant_comp = 0;
    t0 = clock();

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

    
    t1 = clock();
    double time = static_cast<double>(t1 - t0) / CLOCKS_PER_SEC;
    std::cout << "Execution Time: " << time << std::endl;
    std::cout << "Cant intercambios: " << cant_inter << std::endl;
    std::cout << "Cant asignaciones: " << cant_asig << std::endl;
    std::cout << "Cant comparaciones: " << cant_comp << std::endl;
   // system("pause");
    //system("cls");
    //imprimir();
}

// Counting sort - O(n)
void countingSort() { 

    system("cls");
    copiar();
   // imprimir();
   cant_inter = cant_asig = cant_comp = 0;  
    t0 = clock();

    int maxVal = 10000; // Valor máximo asumido en el arreglo
    int countArray[maxVal + 1] = {0};



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


    t1 = clock();
    double time = static_cast<double>(t1 - t0) / CLOCKS_PER_SEC;
    std::cout << "Execution Time: " << time << std::endl;
    std::cout << "Cant intercambios: " << cant_inter << std::endl;
    std::cout << "Cant asignaciones: " << cant_asig << std::endl;
    std::cout << "Cant comparaciones: " << cant_comp << std::endl;
   // system("pause");
    //imprimir();
}

//Función auxiliar para ajustar un nodo en el heapsort
void heapify(std::vector<int>& arr, int n, int i) {
    int largest = i; // Inicializar el nodo más grande como la raíz
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < n && arr[left] > arr[largest]) {
        largest = left;
    }

    if (right < n && arr[right] > arr[largest]) {
        largest = right;
    }

    if (largest != i) {
        std::swap(arr[i], arr[largest]);
        heapify(arr, n, largest);
        cant_inter++;
        cant_asig += 3;
    }
}

// Heapsort - (n log n)
void heapSort() {

    system("cls");
    copiar();
   // imprimir(); // Imprimir el arreglo desordenado
    std::vector<int> vec(arr_tmp, arr_tmp + N); // Cambio "arreglo" por "arr_tmp" aquí

    cant_inter = cant_asig = cant_comp = 0;
    t0 = clock();

    for (int i = N / 2 - 1; i >= 0; --i) {
        heapify(vec, N, i);
        cant_asig += 2; // i y llamada a heapify
        cant_comp++; // i >= 0  
    }

    for (int i = N - 1; i >= 0; --i) {
        std::swap(vec[0], vec[i]);
        heapify(vec, i, 0);
        cant_inter++;
        cant_asig += 4; // i, swap, vec[i], llamada a heapify
        cant_comp++; // i >= 0
    }

    t1 = clock();
    double time = static_cast<double>(t1 - t0) / CLOCKS_PER_SEC;
    std::cout << "Execution Time: " << time << std::endl;
    std::cout << "Cant intercambios: " << cant_inter << std::endl;
    std::cout << "Cant asignaciones: " << cant_asig << std::endl;
    std::cout << "Cant comparaciones: " << cant_comp << std::endl;
   /*system("pause");
    // Imprimir el arreglo ordenado
    for(int i = 0; i < N; i++){
        cout << "[" << i << "] = " << vec[i] << endl; // Cambio "arreglo" por "vec" aquí
    }*/
   
   
}

void stdSort() {
    system("cls");
    copiar();
    //imprimir(); // Imprimir el arreglo desordenado  
    std::vector<int> vec(arreglo, arreglo + N);

    cant_asig = cant_comp = 0;
    t0 = clock();

    std::sort(vec.begin(), vec.end(), [&](int a, int b) {
        ++cant_comp; // Comparación a < b
        return a < b;
    });

    t1 = clock();
    double time = static_cast<double>(t1 - t0) / CLOCKS_PER_SEC;
    std::cout << "Execution Time: " << time << std::endl;
    std::cout << "Cant intercambios: " << 0 << std::endl; // No hay intercambios en el sort
    std::cout << "Cant asignaciones: " << cant_asig << std::endl;
    std::cout << "Cant comparaciones: " << cant_comp << std::endl;
  /*  system("pause");
    // Imprimir el arreglo ordenado
    for(int i = 0; i < N; i++){
        cout << "[" << i << "] = " << vec[i] << endl; // 
    }*/
}


void imprimir(){
    for(int i = 0; i < N; i++){
       cout<<"["<<i<<"] = "<<arreglo[i]<<endl;
    }
}


void llenar(){
    ifstream archivo("C:\\Users\\USER\\Desktop\\datos_"+to_string(N)+".txt", // CAMBIAR LA RUTA DEPENDIENDO DEL PC
                     ios::in);
    if(!archivo){
        cout<<"Error en tratar de abrir el archivo datos_"+to_string(N)+".txt"<<endl<<endl;
    }else{
        string numero;
        int i = 0;
        while(getline(archivo, numero)){
            arreglo[i] = stoi(numero);
            arr_tmp[i] = arreglo[i];
            i++;
        }
        archivo.close();
    }
}

int main(){

    menu();
    return 0;

}



