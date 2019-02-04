package algorithms;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CoutingSortTest {

    @org.junit.jupiter.api.Test
    public void countingSortTest() {

        CoutingSort coutingSort = new CoutingSort();

        int[] array = {5, 10,1005, 9, -10, 20, 45, -789};
        int[] expectedArray = {-789, -10, 5, 9, 10, 20, 45, 1005};
        assertArrayEquals(expectedArray, coutingSort.countingSort(array));

    }
}