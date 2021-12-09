/*
* This program solves
* the Tower of Hanoi riddle.
*
* @author  Jonathan Pasco-Arnone
* @version 1.0
* @since   2021-12-08
*/

import java.util.Scanner;

/**
* This is the program that solves the Tower of Hanoi riddle.
*/
final class Tower {
    /**
    * Prevent instantiation
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    */
    private Tower() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * This function completes the riddle.
    *
    * @param nOfDisks the number of disks
    * @param startPeg the start peg
    * @param endPeg the end peg
    */
    static void hanoi(final int nOfDisks, final int startPeg,
                             final int endPeg) {
        // This function calculates where the disks should be placed in
        final int pegNumber = 6;
        final String toPeg = " to peg ";
        if (nOfDisks == 1) {
            System.out.println("Move disk 1 from peg " + startPeg + toPeg
                               + endPeg);
        } else {
            hanoi(nOfDisks - 1, startPeg, pegNumber - startPeg - endPeg);
            System.out.println("Move disk " + nOfDisks + " from peg "
                + startPeg + toPeg + endPeg);
            hanoi(nOfDisks - 1, pegNumber - startPeg - endPeg, endPeg);
        }
    }

    /**
    * This is the main function.
    *
    * @param args this will not be used
    */
    public static void main(final String[] args) {
        final int startPeg = 1;
        final int endPeg = 3;

        System.out.println("Tower of Hanoi");

        // input
        final Scanner userInput = new Scanner(System.in);
        System.out.print("\nHow many disks do you want?: ");

        try {
            final int nOfDisks = userInput.nextInt();
            System.out.println();
            if (nOfDisks > 0) {
                // process
                hanoi(nOfDisks, startPeg, endPeg);
            } else {
                System.out.println("\nPlease enter a positive integer");
            }
        } catch (java.util.InputMismatchException ex) {
            System.err.print("\nThis is not an integer");
        }
    }
}
