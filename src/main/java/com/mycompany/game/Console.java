package com.mycompany.game;

import java.util.Scanner;

public class Console {
    public static void write(String msg){
        System.out.print(msg);
    }

    public static void writeln(String msg){
        System.out.println(msg);
    }

    public static Scanner read(){ return new Scanner(System.in);}

    public static int readInt(){
        int column = 0;
        try{
            column = read().nextInt()-1;
        }catch (NumberFormatException e){
            column = Constants.DIMENSION;
        }
        return column;
    }
}
