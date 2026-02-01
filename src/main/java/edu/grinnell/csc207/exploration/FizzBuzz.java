package edu.grinnell.csc207.exploration;

public class FizzBuzz{
    public static void fizzbuzz(int n){
        String output="";
        for(int i=1; i<n+1; i++){
            if(i%3==0 && i%5==0){
                output += "fizzbuzz";
            }
            else if(i%3==0){
                output += "fizz";
            }
            else if(i%5==0){
                output += "buzz";
            }
            else{
                output += i;
            }
        System.out.println(output);
        output="";
        }
    }

    // N.B., to run this program, use the following maven command to specify
    // this file as the program entry point rather than the class specified in
    // the pom.xml file:
    //
    // mvn compile exec:java -q "-Dexec.mainClass=edu.grinnell.csc207.exploration.FizzBuzz"
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        fizzbuzz(n);
    }
}
