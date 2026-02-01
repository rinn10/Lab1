// package edu.grinnell.csc207.exploration;
import java.util.Scanner;

public class StringExploration {

    /** TODO: fill me in and my docstring! */
    public static String intersperse(String[] strs) {
        String answer="";
        for(int i=0; i<strs.length; i++){
            answer += strs[i];
            if(i!=strs.length-1){
                answer += ",";
            }
        }
        System.out.println(answer);
        return answer;
    }

    /** TODO: fill me in and my docstring! */
    public static String parseName(String fullName) {
        String[] name = fullName.split(",");
        String lastName =name[0];
        String firstName=name[1];
        String middleName=name[2];
    String answer = firstName+" "+middleName+" "+lastName;
    return answer;
}

    public static String fetchString() {
        Scanner scanner = new Scanner(System.in);
        // the nextLine() method returns the next line from the stream
        // that is used to construct the scanner.
        return scanner.nextLine();
    }
    /** TODO: fill me in and my docstring! */
    public static boolean forgivingPrompt(String question) {
        String lowerQ = question.toLowerCase();
        while(true)
        if(lowerQ.charAt(0)=='y'){
            if(lowerQ=="y" || lowerQ=="yes" || lowerQ=="yep"){
                return true;
            }
        } else if(lowerQ.charAt(0)=='n'){
            if(lowerQ=="n" || lowerQ=="no" || lowerQ=="nope"){
                return false;
            }
        }else{
            fetchString();
        }
    }

    // N.B., to run this program, use the following maven command to specify
    // this file as the program entry point rather than the class specified in
    // the pom.xml file:
    //
    // mvn compile exec:java -q "-Dexec.mainClass=edu.grinnell.csc207.exploration.StringExploration"
    public static void main(String[] args) {
        System.out.println(parseName("Hello,my,name"));
        forgivingPrompt("No");
        // intersperse(args);
    }
}

/*
    public static String parseName(String fullName) {
        String lastName ="";
        String firstName ="";
        String middleName ="";
        for(int i=0; i<fullName.length(); i++){
            lastName += fullName.charAt(i);
            if(fullName.charAt(i) == ','){
                firstName += fullName.charAt(i+1);
                if(fullName.charAt(i) == ','){
                    middleName += fullName.charAt(i+1);
            }
        }
    }
    String answer = firstName+middleName+lastName;
    return answer;
} */