import java.util.concurrent.ThreadLocalRandom;
import java.io.*;

public class Test 
{
    public static void main(String[] args) 
    {
        int numbersToSort = 0;
        System.out.println("How many integers do you want to sort?");
        while(true)
        {
            try
            {
                String userInput = System.console().readLine();
                numbersToSort = Integer.parseInt(userInput);
                if (numbersToSort <= 0) { System.out.println("Please input a positive integer!"); }
                else { break; }
            }
            catch (Exception e)
            {
                System.out.println("Please input a valid integer!");
            }
        }
        Integer[] arrayToSort = new Integer[numbersToSort];
        System.out.println("*** TO BE SORTED: ***");
        for (int i = 0; i <= numbersToSort - 1; i++)
        {
            arrayToSort[i] = ThreadLocalRandom.current().nextInt(0, numbersToSort);
            System.out.print(arrayToSort[i] + " ");
        }
        Mergesort.sort(arrayToSort);
        System.out.println();
        System.out.println("*** SORTED: ***");
        for (int i = 0; i <= numbersToSort - 1; i++)
        {
            System.out.print(arrayToSort[i] + " ");
        }
        System.out.println();
    }
}