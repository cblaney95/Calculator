
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chris
 */
public class Parser {
    public static double[] getLine() {
        Scanner input = new Scanner(System.in);
        double[] arr = new double[3];
        String line;
        try {
            System.out.println("Enter an equation:");
            line = input.nextLine();
            if(line.equals("exit")) {
                return null;
            } else {
                while(!checkLine(line)) {
                    try {
                        //System.out.println("The format of the equation is incorrect");            
                        System.out.println("Enter an equation:");
                        line = input.nextLine();
                        if(line.equals("exit")) {
                            return null;
                        }
                    } catch(NumberFormatException e) {
                        System.out.println("The format of the equation is incorrect");            
 
                    }
                }
                arr = parseEq(line);
            }
        } catch(NumberFormatException e) {
            System.out.println("The format of the equation is incorrect");            
        }        
        return arr;
    }
    
    public static boolean checkLine(String line) {
        boolean flag = false;
        String[] arr = line.split(" ");
        try{
            if(arr[1].equals("+") || arr[1].equals("-") || 
                    arr[1].equals("*") || arr[1].equals("/")) {
                flag = true;
            } else {
                System.out.println("The format of the equation is incorrect");
            }
            
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("The format of the equation is incorrect");
        }
        return flag;
    }
    
    public static double[] parseEq(String line) {
        double[] equation = new double[3];
        String[] arr = line.split(" ");
        equation[0] = Double.parseDouble(arr[0]);
        switch(arr[1]) {
            case "+":
                equation[1] = 0;
                break;
            case "-":
                equation[1] = 1;
                break;
            case "*":
                equation[1] = 2;
                break;
            case "/":
                equation[1] = 3;
                break;            
        }
        equation[2] = Double.parseDouble(arr[2]);
        return equation;
    }

}
