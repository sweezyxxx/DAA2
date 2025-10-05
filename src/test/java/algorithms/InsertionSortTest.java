package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InsertionSortTest {

    @Test
    public void testSortedArray() {
        InsertionSort sorter = new InsertionSort();
        int[] arr = {5, 3, 8, 1, 2};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 5, 8}, arr);
    }

    @Test
    public void testEmptyArray() {
        InsertionSort sorter = new InsertionSort();
        int[] arr = {};
        sorter.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    public void testSingleElement() {
        InsertionSort sorter = new InsertionSort();
        int[] arr = {42};
        sorter.sort(arr);
        assertArrayEquals(new int[]{42}, arr);
    }
}
