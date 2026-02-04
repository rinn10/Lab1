package edu.grinnell.csc207.barcodes;

public class Barcodes {

    /**
     * Module encodings for UPC-A digits 0–9.
     *
     * Each sub-array represents the run-length encoding of a digit
     * on the LEFT side of a UPC-A barcode. Runs alternate starting
     * with white modules.
     */
    private static int[][] ENCODINGS = {
            { 3, 2, 1, 1 },
            { 2, 2, 2, 1 },
            { 2, 1, 2, 2 },
            { 1, 4, 1, 1 },
            { 1, 1, 3, 2 },
            { 1, 2, 3, 1 },
            { 1, 1, 1, 4 },
            { 1, 3, 1, 2 },
            { 1, 2, 1, 3 },
            { 3, 1, 1, 2 }
    };

    /**
     * Determines whether a string is a valid UPC-A code.
     *
     * A valid UPC-A code is exactly 12 characters long and
     * contains only digit characters
     *
     * @param code the string to validate
     * @return true if the string is a valid UPC-A code, false otherwise
     */

    public static boolean isValidCode(String code) {
        if (code.length() == 12) {
            for (int i = 0; i < code.length(); i++) {
                if (!Character.isDigit(code.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Computes the expected UPC-A check digit for a given code.
     * Assumes the provided code is a valid UPC-A string.
     * 
     * @param code a valid UPC-A code
     * @return the expected check digit, or -1 if the code is invalid
     */
    public static int computeCheckDigit(String code) {
        if (isValidCode(code)) {
            int C = 0;
            for (int i = 0; i < code.length() - 1; i++) {
                int code_num = code.charAt(i) - '0';
                if (i % 2 == 0) {
                    C += 3 * code_num;
                } else {
                    C += code_num;
                }
            }
            C %= 10;
            if (C == 0) {
                return 0;
            } else {
                return 10 - C;
            }
        }
        return -1;
    }

    /**
     * Prints a single row of a UPC-A barcode to the console.
     *
     * The barcode consists of:
     * - A left quiet zone
     * - A start guard (BWB)
     * - The first six digits (left side encoding)
     * - A middle guard (WBWBW)
     * - The last six digits (right side encoding, inverted colors)
     * - An end guard (BWB)
     * - A right quiet zone
     *
     * @param code a valid UPC-A code
     */

    public static void printBarcodeRow(String code) {
        String black = "\033[30m█\033[0m";
        String white = "\033[37m█\033[0m";

        for (int i = 0; i < 9; i++)
            System.out.print(white);

        System.out.print(black);
        System.out.print(white);
        System.out.print(black);

        for (int i = 0; i < 6; i++) {
            int digit = code.charAt(i) - '0';
            boolean blackNow = false;

            for (int j = 0; j < ENCODINGS[digit].length; j++) {
                for (int k = 0; k < ENCODINGS[digit][j]; k++) {
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

        for (int i = 6; i < 12; i++) {
            int digit = code.charAt(i) - '0';
            boolean blackNow = true;

            for (int j = 0; j < ENCODINGS[digit].length; j++) {
                for (int k = 0; k < ENCODINGS[digit][j]; k++) {
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
     * Entry point for the barcode program.
     *
     * Expects two command-line arguments:
     *
     * Performs input validation and prints appropriate error
     * messages if the arguments are invalid. If valid, prints
     * one row of the barcode.
     *
     * @param args command-line arguments
     */

    public static void main(String[] args) {
        if (args.length != 2)
            System.out.println("Usage: barcode <upc-a code> <height>");
        else if (!isValidCode(args[0]))
            System.out.println("Code must be a string of 12 digits.");
        else if (Integer.parseInt(args[1]) < 0)
            System.out.println("Height must be a positive integer.");
        else
            printBarcodeRow(args[0]);
    }
}