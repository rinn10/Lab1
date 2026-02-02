// package edu.grinnell.csc207.barcodes;

public class Barcodes {
    /** TODO: fill in this definition and doc comment! */
    private static int[][] ENCODINGS = {
        {3,2,1,1},
        {2,1,2,2},
        {1,4,1,1},
        {1,1,3,2},
        {1,2,3,1},
        {1,1,1,4},
        {1,3,1,2},
        {1,2,1,3},
        {3,1,1,2}
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
                C += 3*code.charAt(i);
            }
            else{
                C += code.charAt(i);
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
     * !! check code's digit one by one(for loop)
     * If 0, get the first column in ENCODINGS
     * ?? Are squares in black and white working on your PC? 
     */
    public static void printBarcodeRow(String code) {
        String black=  "\033[30m█\033[0m";
        String white=  "\033[37m█\033[0m";
        for(int i=0; i<ENCODINGS.length; i++){
            for(int j=0; j<ENCODINGS[j].length; j++){
                for(int k=0; k<ENCODINGS[i][j]; k++)
                if(j%2==0){
                    System.out.println(white);
                }
                else{
                    System.out.println(black);
                }
            }
        }
    }
    /**
     * TODO: fill in this definition and doc comment!
     * @param args
     */
    public static void main(String[] args) {
        printBarcodeRow("123456789891");
        // System.out.println(printBarcodeRow(computeCheckDigit("123456789891")));
    }
}


/*
    public static void printBarcodeRow(String code) {
        String black=  "\033[30m\033[0m";
        String white=  "\033[37m\033[0m";
        for(int i=0; i<ENCODINGS.length; i++){
            for(int j=0; j<ENCODINGS[j].length; j++){
                for(int k=0; k<ENCODINGS[i][j]; k++)
                if(j%2==0){
                    System.out.println(white);
                }
                else{
                    System.out.println(black);
                }
            }
        }
    }
         */