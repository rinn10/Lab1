package edu.grinnell.csc207.exploration;
import java.util.Scanner;
 
public class StringExploration {
 
    /**
     * Returns each element of the array passed as a parameter 
     * separated by a comma
     * @param strs, a string array
     * @return a string with the elements of the array combined 
     */
    public static String intersperse(String[] strs) {
        String answer="";
        for(int i=0; i<strs.length; i++){
            answer += strs[i];
            if(i!=strs.length-1){
                answer += ",";
            }
        }
        return answer;
    }
 
    /**
     * Returns a string with the correct order of the name entered
     * @param fullName, a person's last, first and middle name
     * respectively separated by a comma
     * @return a string with the name reordered
     */
    public static String parseName(String fullName) {
        String[] name = fullName.split(",");
        String lastName =name[0];
        String firstName=name[1];
        String middleName=name[2];
    String answer = firstName+" "+middleName+" "+lastName;
    return answer;
}

    public static String fetchString()
    {
        Scanner scanner = new Scanner(System.in);
        // the nextLine() method returns the next line from the stream
        // that is used to construct the scanner.
        return scanner.nextLine();
    }
 

    /**
     * Returns a boolean, true when the answer is yes/no or an
     * accepted variant of yes/no. if the answer is invalid, 
     * we can re-enter until its valid
     * @param question, a string which is the "prompt"
     * @return a boolean value which is true when answer is yes 
     * and false when its no
     */
    public static boolean forgivingPrompt(String question)
    {
        System.out.println(question);
        String answer =fetchString();
        String lowerQ = answer.toLowerCase();
        while(true)
        {
        if(lowerQ.equals("y") || lowerQ.equals("yes") || lowerQ.equals("yep"))
            {
            return true;
            }
       else if (lowerQ.equals("n") || lowerQ.equals("no") || lowerQ.equals("nope"))
        {
            return false;
        }
       else
        {
            System.out.println("Please enter valid strings!");
             answer =fetchString();
             lowerQ = answer.toLowerCase();
       }
    }
}
 
    // N.B., to run this program, use the following maven command to specify
    // this file as the program entry point rather than the class specified in
    // the pom.xml file:
    //
    // mvn compile exec:java -q "-Dexec.mainClass=edu.grinnell.csc207.exploration.StringExploration"
    public static void main(String[] args) 
    {
        System.out.println(intersperse(new String[] { "ab", "cd", "ef" }));
        System.out.println(parseName("Osera,Peter,Michael"));
        System.out.println(forgivingPrompt("Do you like dogs?"));

    }
}