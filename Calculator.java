

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
    private double answer;
    private double[] equation = new double[3];
    
    public void calculate() {
        while(true) {
            this.equation = Parser.getLine();
            if(this.equation == null) {
                break;
            } else {
                switch((int)(equation[1])) {
                    //addition
                    case 0:
                        addition();
                        break;
                    //subtraction
                    case 1:
                        subtraction();
                        break;
                    //multiplication
                    case 2:
                        multiplication();
                        break;
                    //division
                    case 3:
                        division();
                        break;
                }
                display();
            }
        }
    }
    //this can be improved with significant figures
    public void display() {
        String operator =" ";               
        switch((int)(equation[1])) {
            case 0:
                operator = "+";
                break;
            case 1:
                operator = "-";
                break;
            case 2:
                operator = "*";
                break;
            case 3:
                operator = "/";
                break;
        }
        String line = Double.toString(equation[0]) + operator + Double.toString(equation[2]) + " = " + Double.toString(answer);
        System.out.println(line);
                
    }
    
    public void addition() {
        this.answer = (equation[0] + equation[2]);
    }
    
    public void subtraction() {
        this.answer = (equation[0] - equation[2]);
    }
    
    public void multiplication() {
        this.answer = (equation[0] * equation[2]);
    }
    
    public void division() {
        this.answer = (equation[0] / equation[2]);
    }
    
    
}
