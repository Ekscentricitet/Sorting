import java.util.concurrent.ThreadLocalRandom;

import Algorithms.InsertionSort;
import Algorithms.Mergesort;
import Interfaces.SortingAlgorithm;

public class Test 
{
    public static void main(String[] args) 
    {
        int numbersToSort = getNumbersToSortFromUser();
        SortingAlgorithm chosenAlgorithm = getSortingAlgorithmFromUser();
        var arrayToSort = prepareArray(numbersToSort);
        sortAndPrintResult(chosenAlgorithm, arrayToSort);
    }

    private static int getNumbersToSortFromUser()
    {
        System.out.println("How many integers do you want to sort?");
        while(true)
        {
            int numbersToSort = 0;
            try
            {
                String userInput = System.console().readLine();
                numbersToSort = Integer.parseInt(userInput);
                if (numbersToSort <= 0) { System.out.println("Please input a positive integer!"); }
                else 
                { return numbersToSort; }
            }
            catch (Exception e)
            {
                System.out.println("Please input a valid integer!");
            }
        }
    }

    private static SortingAlgorithm getSortingAlgorithmFromUser()
    {
        SortingAlgorithm chosenAlgorithm = null;
        System.out.println("Which algorithm to use? Enter \"1\" for Mergesort and \"2\" for InsertionSort.");
        while(true)
        {
            String userInput = System.console().readLine();
            switch(userInput)
            {
                case "1":
                    chosenAlgorithm = new Mergesort();
                    break;
                case "2":
                    chosenAlgorithm = new InsertionSort();
                    break;
                default:
                    System.out.println("Please enter one of the provided options.");
                    break;
            }
            if (chosenAlgorithm != null) { return chosenAlgorithm; }
        }
    }

    private static Integer[] prepareArray(int numbersToSort)
    {
        int lowerBoundForPrinting = 1000;
        Integer[] arrayToSort = new Integer[numbersToSort];
        if (numbersToSort < lowerBoundForPrinting)
        {
            System.out.println("*** TO BE SORTED: ***");
        }

        for (int i = 0; i <= numbersToSort - 1; i++)
        {
            arrayToSort[i] = ThreadLocalRandom.current().nextInt(0, numbersToSort);
            if (numbersToSort < lowerBoundForPrinting)
            {
                System.out.print(arrayToSort[i] + " ");
            }
        }
        return arrayToSort;
    }

    private static void sortAndPrintResult(SortingAlgorithm sortingAlgorithm, Integer[] arrayToSort)
    {
        System.out.println("*** Sorting... ***");
        sortingAlgorithm.sort(arrayToSort);
        System.out.println();
        System.out.println("*** SORTED: ***");
        for (int i = 0; i <= arrayToSort.length - 1; i++)
        {
            System.out.print(arrayToSort[i] + " ");
        }
        System.out.println();
    }
}