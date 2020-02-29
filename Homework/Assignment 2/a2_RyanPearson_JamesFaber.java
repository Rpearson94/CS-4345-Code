/*
  Assignment 2
  CS 4345 Spring 2020
  Ryan Pearson
  James Faber
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class a2_RyanPearson_JamesFaber {
  public static void main(final String[] args) throws Exception {
    final BlockingQueue<Integer> matrixQueue = new ArrayBlockingQueue<Integer>(1024);
    try {
      final File input = new File(args[0]);
      final Scanner fileReader = new Scanner(input);
      while (fileReader.hasNext()) {
        final int data = fileReader.nextInt();
        // System.out.println(data);
      }
      fileReader.close();
    } catch (final FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}