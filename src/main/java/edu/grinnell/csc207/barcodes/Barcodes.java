// package edu.grinnell.csc207.barcodes;

public class Barcodes {
    /** TODO: fill in this definition and doc comment! */
    private static int[][] ENCODINGS = {
        // TODO: fill me in!
    };


    /**
     * TODO: fill in this definition and doc comment!
     */
    public static boolean isValidCode(String code) {
        if(code.length()==12)
            {
            for(int i=0; i<code.length(); i++)
                {
                if(!Character.isDigit(code.charAt(i)))
                    {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * TODO: fill in this definition and doc comment!
     */
    public static int computeCheckDigit(String code) {
        if(isValidCode(code)){
        int C=0;
        for(int i=0; i<code.length(); i++){
            if(i%2==0){
                C *= 3*code.charAt(i);
            }
            else{
                C *= code.charAt(i);
            }
        }
        C %= 10;
        int answer=10-C;
        return answer;
    }
    return -1;
    }

    /**
     * TODO: fill in this definition and doc comment!
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(computeCheckDigit("123456789891"));
    }
}