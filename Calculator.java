
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chris
 */
public class Calculator {
    public String[] equation;
    public ArrayList<String> lEquation;
    public void calculate() {        
        while(true) {
            this.equation = Parser.getLine();
            if(this.equation == null) {
                break;
            }
            fillList();
            printList();
            solveEq();
        }        
    }
    //there is a bug
    //needs to read from left to right in situations where there are equal
    //precedented operators
    public void solveEq() {
        while(true) {
            if(lEquation.size() == 1) {
                break;
            }
            int i = findOp();
            if(isMult(i)) {
                String t = multiply(Double.parseDouble(lEquation.get(i - 1)), Double.parseDouble(lEquation.get(i + 1))); 
                lEquation.set((i - 1), t);
                lEquation.remove(i + 1);
                lEquation.remove(i);
                printList();
            } else if(isDiv(i)) {
                String t = divide(Double.parseDouble(lEquation.get(i - 1)), Double.parseDouble(lEquation.get(i + 1))); 
                lEquation.set((i - 1), t);
                lEquation.remove(i + 1);
                lEquation.remove(i);
                printList();
            } else if(isSub(i)) {
                String t = subtract(Double.parseDouble(lEquation.get(i - 1)), Double.parseDouble(lEquation.get(i + 1))); 
                lEquation.set((i - 1), t);
                lEquation.remove(i + 1);
                lEquation.remove(i);
                printList();
            } else if(isAdd(i)) {
                String t = add(Double.parseDouble(lEquation.get(i - 1)), Double.parseDouble(lEquation.get(i + 1))); 
                lEquation.set((i - 1), t);
                lEquation.remove(i + 1);
                lEquation.remove(i);
                printList();
            }
            /*int i = isMult();
            if(i != -1) {
                String t = multiply(Double.parseDouble(lEquation.get(i - 1)), Double.parseDouble(lEquation.get(i + 1))); 
                lEquation.set((i - 1), t);
                lEquation.remove(i + 1);
                lEquation.remove(i);
                //lEquation.trimToSize();
                printList();
                continue;
            }
            i = isDiv();
            if(i != -1) {
                String t = divide(Double.parseDouble(lEquation.get(i - 1)), Double.parseDouble(lEquation.get(i + 1))); 
                lEquation.set((i - 1), t);
                lEquation.remove(i + 1);
                lEquation.remove(i);
                //lEquation.trimToSize();
                printList();
                continue;
            }
            i = isAdd();
            if(i != -1) {
                String t = add(Double.parseDouble(lEquation.get(i - 1)), Double.parseDouble(lEquation.get(i + 1)));
                lEquation.set((i - 1), t);
                lEquation.remove(i + 1);
                lEquation.remove(i);
                //lEquation.trimToSize();
                printList();
                continue;
            }
            i = isSub();
            if(i != -1) {
                String t = subtract(Double.parseDouble(lEquation.get(i - 1)), Double.parseDouble(lEquation.get(i + 1))); 
                lEquation.set((i - 1), t);
                lEquation.remove(i + 1);
                lEquation.remove(i);
                //lEquation.trimToSize();
                printList();
            }*/
        }  
    }
    
    public int findOp() {
        int index = -1;
        for(int i = 0; i < lEquation.size(); i++) {
           if(lEquation.get(i).equals("*") || lEquation.get(i).equals("/")) {
               return i;
           }  
        }
        for(int i = 0; i < lEquation.size(); i++) {
            if(lEquation.get(i).equals("+") || lEquation.get(i).equals("-")) {
               return i;
           }
        }
        //System.out.printf("Found %s at %d\n", lEquation.get(index), index);
        return index;
    }
    
    public boolean isMult(int index) {    
        boolean flag = false;
        if(lEquation.get(index).equals("*")) {
            flag = true;
        }
        return flag;
    }
    
    public boolean isDiv(int index) {
        boolean flag = false;
        if(lEquation.get(index).equals("/")) {
            flag = true;
        }
        return flag;
    }
    
    public boolean isSub(int index) {
        boolean flag = false;
        if(lEquation.get(index).equals("-")) {
            flag = true;
        }
        return flag;
    }
    
    public boolean isAdd(int index) {
        boolean flag = false;
        if(lEquation.get(index).equals("+")) {
            flag = true;
        }
        return flag;
    }
    
    public void fillList() {
        lEquation = new ArrayList<String>();
        for(int i = 0; i < equation.length; i++) {
            lEquation.add(i, equation[i]);
        }
    }
    
    public void printList() {
        for(int i = 0; i < lEquation.size(); i++) {
            System.out.print(lEquation.get(i) + " ");
        }
        System.out.println();
    }
    
    
    
    public String multiply(double l, double r) {
        double x = l * r;
        String answer = Double.toString(x);
        return answer;
    }
    
    public String divide(double l, double r) {
        double x = l / r;
        String answer = Double.toString(x);
        return answer;
    }
    
    public String add(double l, double r) {
        double x = l + r;
        String answer = Double.toString(x);
        return answer;
    }
    
    public String subtract(double l, double r) {
        double x = l - r;
        String answer = Double.toString(x);
        return answer;
    }    
}
