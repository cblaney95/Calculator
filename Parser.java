
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
    public static final String DELIM = "((?<=\\*)|"
                + "(?=\\*))|((?<=/)|(?=/))|((?<=\\+)|(?=\\+))|"
                + "((?<=-)|(?=-))";
    public static String[] getLine() {        
        Scanner input = new Scanner(System.in);        
        String[] arr;
        String line = "";
        try {
            System.out.println("Enter an equation (or exit):");
            line = input.nextLine();
            if(line.equals("exit")) {
                return null;
            }
            while(!checkLine(line)) {
                System.out.println("Enter an equation (or exit):");
                line = input.nextLine();
                if(line.equals("exit")) {
                    return null;
                }
            }
        } catch(NullPointerException e) {
            System.out.println("Null pointer exception");
        }
        line = line.replaceAll("\\s", "");
        arr = line.split(DELIM);
        return arr;
    }
    
    public static boolean checkLine(String line) {
        boolean flag = false;
        for(int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == '+' || line.charAt(i) == '-'
                    || line.charAt(i) == '*' || line.charAt(i) == '/') {
                flag = true;
            }
        }
        return flag;
    }
}
