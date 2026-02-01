//package edu.grinnell.csc207.exploration;

public class StringExploration {

    /** TODO: fill me in and my docstring! */
    public static String intersperse(String[] strs) {
        return null;
    }

    /** TODO: fill me in and my docstring! */
    public static String parseName(String fullName) {
        return fullName;
    }

    /** TODO: fill me in and my docstring! */
    public static boolean forgivingPrompt(String question) {
        return false;
    }

    // N.B., to run this program, use the following maven command to specify
    // this file as the program entry point rather than the class specified in
    // the pom.xml file:
    //
    // mvn compile exec:java -q "-Dexec.mainClass=edu.grinnell.csc207.exploration.StringExploration"
    public static void main(String[] args) {
        String s1 = "hello world!";
        String s2 = "hello world!";
        System.out.println(s1.equals(s2));     // A

        String s3 = s1.substring(0, 5);
        String s4 = s2.substring(0, 5);
        System.out.println(s3.equals(s4));     // B

        String s5 = new String(new char[] { 'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd', '!' });
        System.out.println(s5.equals(s1));     // C
    }
}
