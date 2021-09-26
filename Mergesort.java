
public class Mergesort
{
    public static void sort (Comparable[] arrayToSort)
    {
        Comparable[] auxiliary = new Comparable[arrayToSort.length];
        sort(arrayToSort, auxiliary, 0, arrayToSort.length - 1);
    }

    private static void sort (Comparable[] arrayToSort, Comparable[] auxiliary, int lowLeft, int highRight)
    {
        if (lowLeft >= highRight) { return; }
        int middle = lowLeft + (highRight - lowLeft)/2;
        sort(arrayToSort, auxiliary, lowLeft, middle);
        sort(arrayToSort, auxiliary, middle + 1, highRight);
        merge(arrayToSort, auxiliary, lowLeft, middle, highRight);
    }

    private static void merge (Comparable[] arrayToSort, Comparable[] auxiliary, int lowLeft, int middle, int highRight)
    {
        for (int i = lowLeft; i <= highRight; i++)
            auxiliary[i] = arrayToSort[i];

        int lefti = lowLeft;
        int righti = middle + 1;
        for (int sortedi = lowLeft; sortedi <= highRight; sortedi++)
        {
            if (lefti > middle) { arrayToSort[sortedi] = auxiliary[righti++]; }
            else if (righti > highRight) { arrayToSort[sortedi] = auxiliary[lefti++]; }
            else if (auxiliary[righti].compareTo(auxiliary[lefti]) > 0) { arrayToSort[sortedi] = auxiliary[righti++]; }
            else { arrayToSort[sortedi] = auxiliary[lefti++]; }
        }
    }
}