package edu.grinnell.csc207.barcodes;

public class Barcodes {
    /** TODO: fill in this definition and doc comment! */
    private static int[][] ENCODINGS = {
        {3,2,1,1},
        {2,2,2,1},
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
        for(int i=0; i<code.length()-1; i++){
            int code_num =code.charAt(i) - '0';
            if(i%2==0){
              C += 3*code_num;
            }
            else{
                C += code_num;
            }
        }
        C %= 10;
        if(C==0){
            return 0;
        } else{
        return 10-C;
        }
    }
    return -1;
}

    /**
     * TODO: fill in this definition and doc comment!
     * !! check code's digit one by one(for loop)
     * If 0, get the first column in ENCODINGS
     * ?? Are squares in black and white working on your PC? 
     */


    public static void printBarcodeRow(String code) 
    {
    String black = "\033[30m█\033[0m";
    String white = "\033[37m█\033[0m";
  
    for (int i = 0; i < 9; i++) 
	    System.out.print(white);

    System.out.print(black);
    System.out.print(white);
    System.out.print(black);

    for (int i = 0; i < 6; i++) 
        {
        int digit = code.charAt(i) - '0';
        boolean blackNow = false;

        for (int j = 0; j < ENCODINGS[digit].length; j++) 
            {
            for (int k = 0; k < ENCODINGS[digit][j]; k++) 
                {
                if (blackNow) 
			        System.out.print(black);
                else 
			        System.out.print(white);
            }
            blackNow = !blackNow;
        }
    }

    System.out.print(white);
    System.out.print(black);
    System.out.print(white);
    System.out.print(black);
    System.out.print(white);

    for (int i = 6; i < 12; i++) 
    {
        int digit = code.charAt(i) - '0';
        boolean blackNow = true;

        for (int j = 0; j < ENCODINGS[digit].length; j++) 
            {
            for (int k = 0; k < ENCODINGS[digit][j]; k++) 
                {
                if (blackNow) 
			        System.out.print(black);
                else 
			        System.out.print(white);
            }
            blackNow = !blackNow;
        }
    }

    System.out.print(black);
    System.out.print(white);
    System.out.print(black);

    for (int i = 0; i < 9; i++) 
	    System.out.print(white);

    System.out.println();
}


    /**
     * TODO: fill in this definition and doc comment!
     * @param args
     */
    public static void main(String[] args) {
        if(args.length!=2)
            System.out.println("Usage: barcode <upc-a code> <height>");
        else if(!isValidCode(args[0]))
            System.out.println("Code must be a string of 12 digits.");
        else if(Integer.parseInt(args[1])<0)
            System.out.println("Height must be a positive integer.");
        else
            printBarcodeRow(args[0]);
    }}