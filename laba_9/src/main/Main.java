package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line;
        String[] commands;
        MyContainer c = new MyContainer("1.data");
        while(true){
            System.out.println("Enter your command:");
            line = in.nextLine();
            commands = line.split("\\s+");
            if(commands[0].equals("add") && commands.length == 2)
                c.add(commands[1]);
            else if(commands[0].equals("remove") && commands.length == 2)
                System.out.println(c.remove(commands[1]));
            else if(commands[0].equals("sort"))
                c.sort();
            else if(commands[0].equals("clear"))
                c.clear();
            else if(commands[0].equals("print"))
                System.out.println(c);
            else if(commands[0].equals("exit"))
                break;
        }
    }
}
