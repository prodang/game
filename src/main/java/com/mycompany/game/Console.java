package com.mycompany.game;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Console {

    private static Console console = new Console();

    private Console(){
        //empty to Singleton
    }

    public static Console getInstance(){
        return console;
    }

    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public void write(String msg){
        System.out.print(msg);
    }

    public  void writeln(String msg){
        System.out.println(msg);
    }

    public String read(){
        String input;
        do{
            Console.getInstance().write(Constants.GET_COLOR);
            try {
                input = this.bufferedReader.readLine();
            } catch (Exception e) {
                input = "";
            }
        }while(!(input.equalsIgnoreCase("R")||input.equalsIgnoreCase("B")));
        return input;
    }

    public int readInt(){
        int column;
        do{
            Console.getInstance().write(Constants.GET_COLUMN);
            try {
                column = Integer.parseInt(this.bufferedReader.readLine());
            } catch (Exception e) {
                column = -1;
            }
        }while(!(column >= 1 && column <= Constants.DIMENSION));
        return column;
    }
}
