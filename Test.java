import java.util.concurrent.ThreadLocalRandom;

import Algorithms.InsertionSort;
import Algorithms.Mergesort;
import Interfaces.SortingAlgorithm;

public class Test 
{
    public static void main(String[] args) 
    {
        SortingAlgorithm chosenAlgorithm = getSortingAlgorithmFromUser();

        if (checkTime())
        {      
            var maximumElements = 100000;
            for (int i = 100; i <= maximumElements; i*=10)
            {
                var array = prepareArrayNoOutput(i);
                sortAndPrintTime(chosenAlgorithm, array);
            }
        }
        else
        {
            int numbersToSort = getNumbersToSortFromUser();
            var arrayToSort = prepareArray(numbersToSort);
            sortAndPrintResult(chosenAlgorithm, arrayToSort);
        }    
    }

    private static Boolean checkTime()
    {
        System.out.println("What would you want to do? Enter \"1\" for measuring execution time and \"2\" for sorting a random array.");
        while(true)
        {
            String userInput = System.console().readLine();
            switch(userInput)
            {
                case "1":
                    return true;
                case "2":
                    return false;
                default:
                    System.out.println("Please enter one of the provided options.");
                    break;
            }
        }
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

    private static Integer[] prepareArrayNoOutput(int numbersToSort)
    {
        Integer[] arrayToSort = new Integer[numbersToSort];
        for (int i = 0; i <= numbersToSort - 1; i++)
        {
            arrayToSort[i] = ThreadLocalRandom.current().nextInt(0, numbersToSort);
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

    private static void sortAndPrintTime(SortingAlgorithm sortingAlgorithm, Integer[] arrayToSort)
    {
        long startTime = System.nanoTime();
        sortingAlgorithm.sort(arrayToSort);
        long stopTime = System.nanoTime();
        System.out.println("Number of elements: " + arrayToSort.length + " --> Time: " + (stopTime - startTime));
    }
}