package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Tradepoints t = new Tradepoints("1");
        Scanner in = new Scanner(System.in);
        String line;
        String[] commands;
        while(true){
            System.out.println("add - add Trade point");
            System.out.println("remove <index> - remove Trade point");
            System.out.println("print - print Trade points");
            System.out.println("clear - clear list");
            System.out.println("exit - exit program");
            System.out.println("Enter your command:");
            line = in.nextLine();
            commands = line.split("\\s+");
            if(commands[0].equals("add")) {
                System.out.println("Enter order in this way:");
                System.out.println("name#adress#phone1 phone2 ... #specialization#time");
                String[] ord = in.nextLine().split("\\s*#\\s*");
                if(ord.length != 5 || !InputChecker.checkNumbers(ord[2])
                        || InputChecker.checkTime(ord[4]))
                    System.err.println("Wrong params");
                else
                    t.add(ord);
            }
            else if(commands[0].equals("remove") && commands.length == 2) {
                int ind = -1;
                try{
                    ind = Integer.parseInt(commands[1]);
                } catch (Exception e){
                    System.err.println("Wrong params");
                    continue;
                }
                System.out.println(t.remove(ind));
            }
            else if(commands[0].equals("clear"))
                t.clear();
            else if(commands[0].equals("print"))
                System.out.println(t);
            else if(commands[0].equals("exit"))
                break;
        }
    }
}
