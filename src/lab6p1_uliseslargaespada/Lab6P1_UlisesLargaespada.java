/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6p1_uliseslargaespada;

import java.util.Arrays;
import java.util.Scanner;

import java.util.Random;

/**
 *
 * @author ularg
 */
public class Lab6P1_UlisesLargaespada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Llamar al menu principal
        mainMenu();
    }
    
    // Metodo para el menu inicial
    public static void mainMenu() {
        System.out.println("-- Bienvenido al programa resolver el Lab 6 --");
        
        // Initialize scanner
        Scanner entry = new Scanner(System.in);
        
        // Ask for the name
        System.out.println("Como te llamas?");
        System.out.print("Ingresa tu nombre: ");
        
        String nombre = entry.nextLine();
        
        System.out.println("Bienvenido " + nombre + ", espero disfrutes los ejercicios!");
        System.out.println();
        
        // Iniciar menu repetitivo
        do {
            System.out.println("Elija que juego desea jugar: ");
            System.out.println("1 - El juego de la vida");
            System.out.println("2 - Piedra, Papale, o ...");
            System.out.println("3 - Blink-182");
            System.out.println("4 - Salir");
            
            int option = entry.nextInt();
            
            switch (option) {
                case 1 -> juegoDeLaVida();
                
                case 2 -> piedraPapalTijera();
                
                case 3 -> blink182();
                
                case 4 -> System.out.println("Gracias por usar el este programa, feliz dia!");
                
                default -> System.out.println("Elija una opcion de las anteriores");
            }
            
            // Salir del programa 
            if (option == 4) {
                break;
            }
        } while(true);
    }
    
    // Metodo para el menu el juego de la vida
    public static void juegoDeLaVida() {
        
    }
    
    // Metodo para el menu del juego piedra papel o tijera
    public static void piedraPapalTijera() {
        // Initialize scanner
        Scanner entry = new Scanner(System.in);
        
        // Iniciar matriz con resultados
        int[][] matrizTablero ={
            {7, 0, 2, 0, 4},
            {0, 7, 1, 3, 1},
            {2, 1, 7, 2, 4},
            {0, 3, 2, 7, 3},
            {4, 1, 4, 3, 7},
        };
        
        System.out.println("Bienvenido al ejercicio de piedra, papel, tijera, lizard o spock");
        System.out.println("En este juego jugara contra la maquina");
        
        // Mostrar opciones
        System.out.println("Elija el numero de la opcion que escogera: ");
        System.out.println("0 - Tijera");
        System.out.println("1 - Papel");
        System.out.println("2 - Roca");
        System.out.println("3 - Lizard");
        System.out.println("4 - Spock");
        
        // Pedir entrada
        int user = entry.nextInt();
        mostrarEleccion(user, 1);
        
        int maquina = new Random().nextInt(5);
        mostrarEleccion(maquina, 2);
        
        // Almacenar resultado
        int result = matrizTablero[user][maquina];
        
        // Comparar resultado
        compararEntradas(user, maquina, result);
        
        System.out.println();
    }
    
    // Metodo para comparar entradas
    public static void compararEntradas(int user, int maq, int result) {
        if(result == maq) {
            System.out.println("La maquina gana!");
        } else if (result == user) {
            System.out.println("EL jugador gana!");
        } else {
            System.out.println("Fue un empate!");
        }
    }
    
    // MEtodo para mostrar que escogio cada usuario
    public static void mostrarEleccion(int option, int userNum) {
        String user = "";
        
        if(userNum == 1) {
            user += "Usuario";
        } else if(userNum == 2){
            user += "Maquina";
        }
        
        switch(option) {
            case 0 -> System.out.println(user + " escogio tijeras");
            case 1 -> System.out.println(user + " escogio papel");
            case 2 -> System.out.println(user + " escogio roca");
            case 3 -> System.out.println(user + " escogio lizard");
            case 4 -> System.out.println(user + " escogio spock");
        }
        
        System.out.println();
    }
    
    // Metodo para el juego blink 182
    public static void blink182() {
        // Initialize scanner
        Scanner entry = new Scanner(System.in);
        
        System.out.println("Bienvenido al ejercicio de Blink-182");
        System.out.println("En este ejercicio crearemos una mariz y la rellenaremos de numeros aleatorios");
        
        // Solicitar entradas
        System.out.print("Ingrese el numero de filas de su matriz: ");
        int rows = entry.nextInt();
        
        System.out.print("Ingrese el numero de columnas de su matriz: ");
        int cols = entry.nextInt();
        
        // Llamar a crear matriz
        int[][] matrizBlink = generarMatriz(rows, cols);
        String[][] matrizBlinkLetras = generarMatrizLetras(matrizBlink, rows, cols);
        
        // Llamar a imprimir la matriz
        System.out.println("Esta es su matriz final con numeros");
        imprimirMatriz(matrizBlink);
        
        System.out.println();
        
        System.out.println("Esta es su matriz final con letras");
        imprimirMatrizLetras(matrizBlinkLetras);
        
        System.out.println();
        System.out.println("Muchas gracias por jugar!");
        System.out.println();
    }
    
    // Metodo para crear una matriz con dadas las filas y columnas
    public static int[][] generarMatriz(int rows, int cols) {
        int[][] matrizFinal = new int[rows][cols];
        int random;
        
        // Rellenar espacios de matriz
        for(int i = 0; i < rows; i += 1) {
            for(int j = 0; j < cols; j += 1) {
                random = new Random().nextInt((122 - 97) + 1) + 97;
                matrizFinal[i][j] = random;
            }
        }
        
        return matrizFinal;
    }
    
    // Metodo para transformar los numeros random de la matriz en letras
    public static String[][] generarMatrizLetras(int[][] matrizFinal, int rows, int cols) {
        String[][] matrizLetras = new String[rows][cols];
        
        // Rellenar espacios de matriz
        for(int i = 0; i < matrizFinal.length; i += 1) {
            for(int j = 0; j < matrizFinal[i].length; j += 1) {
                int num = matrizFinal[i][j];
                char letra = (char) num;
                String LetraS = Character.toString(letra);
                matrizLetras[i][j] = LetraS;
            }
        }
        
        return matrizLetras;
    }
    
    // Metodo para imprimir matriz
    public static void imprimirMatriz(int[][] matrizFinal){
        // For para msotrar tablero
        for(int row = 0; row < matrizFinal.length; row += 1) {
            System.out.println("");
            for(int col = 0; col < matrizFinal[row].length; col += 1) {
                if(col == matrizFinal[row].length - 1) {
                    System.out.print(" " + matrizFinal[row][col]);
                } else {
                    System.out.print(" " + matrizFinal[row][col] + " -");
                }
            }
        }        
        System.out.println();
    }
    
    // Metodo para imprimir matriz
    public static void imprimirMatrizLetras(String[][] matrizFinal){
        // For para msotrar tablero
        for(int row = 0; row < matrizFinal.length; row += 1) {
            System.out.println("");
            for(int col = 0; col < matrizFinal[row].length; col += 1) {
                if(col == matrizFinal[row].length - 1) {
                    System.out.print(" " + matrizFinal[row][col]);
                } else {
                    System.out.print(" " + matrizFinal[row][col] + " -");
                }
            }
        }        
        System.out.println();
    }
    
}
