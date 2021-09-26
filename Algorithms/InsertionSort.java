package Algorithms;

import Interfaces.SortingAlgorithm;

public class InsertionSort implements SortingAlgorithm
{
    public void sort(Comparable[] arrayToSort)
    {
        for (int i = 0; i < arrayToSort.length; i++)
        {
            for (int j = i; j > 0; j--)
            {
                if (arrayToSort[j].compareTo(arrayToSort[j - 1]) < 0)
                {
                    swap(arrayToSort, j, j - 1);
                }
                else { break; }
            }
        }
    }

    private void swap(Comparable[] arrayToSwap, int indexOfFirstElement, int indexOfSecondElement)
    {
        var temp = arrayToSwap[indexOfFirstElement];
        arrayToSwap[indexOfFirstElement] = arrayToSwap[indexOfSecondElement];
        arrayToSwap[indexOfSecondElement] = temp;
    }
}