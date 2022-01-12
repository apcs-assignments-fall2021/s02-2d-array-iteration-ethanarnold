import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTests {
    @Test
    public void testFindLastWord() {
        String[] arr1 = {"apple", "banana", "orange"};
        String[] arr2 = {"orange", "apple", "banana"};
        String[] arr3 = {"aardvark", "apple", "acai"};
        String[] arr4 = {"hello", "world", "computer", "science", "java"};

        assertEquals("orange", MyMain.findLastWord(arr1),"The last word in " + Arrays.toString(arr1) + " should be: " + "orange");
        assertEquals("orange", MyMain.findLastWord(arr2),"The last word in " + Arrays.toString(arr2) + " should be: " + "orange");
        assertEquals("apple", MyMain.findLastWord(arr3),"The last word in " + Arrays.toString(arr3) + " should be: " + "orange");
        assertEquals("world", MyMain.findLastWord(arr4),"The last word in " + Arrays.toString(arr4) + " should be: " + "world");
    }

    @Test
    public void testFindLastWord2D() {
        String[][] mat1 = {  {"apple", "banana", "orange"},
                             {"kiwi", "grapefruit", "fig"},
                             {"lemon", "lime", "pomelo"}
        };

        String[] arr1 = {"orange", "kiwi", "pomelo"};

        assertEquals(Arrays.toString(arr1), Arrays.toString(MyMain.findLastWord2D(mat1)),"The last words in \n" + Arrays.deepToString(mat1) + "\nshould be: " + Arrays.toString(arr1));
    }

    @Test
    public void testAppleCounter() {
        String[][] mat1 = {  {"apple", "banana", "fig"},
                             {"kiwi", "pineapple", "applesauce"},
                             {"crabapple", "lime", "pomelo"}
        };

        assertEquals(2, MyMain.appleCounter(mat1, 0),"The number of apple words in col 0 of \n" + Arrays.deepToString(mat1) + "\nshould be: " + 2);
        assertEquals(1, MyMain.appleCounter(mat1, 1),"The number of apple words in col 1 of \n" + Arrays.deepToString(mat1) + "\nshould be: " + 1);
        assertEquals(1, MyMain.appleCounter(mat1, 2),"The number of apple words in col 2 of \n" + Arrays.deepToString(mat1) + "\nshould be: " + 1);
    }

    @Test
    public void findMostAppleColumn() {
        String[][] mat1 = {  {"apple", "banana", "fig"},
                {"kiwi", "pineapple", "applesauce"},
                {"crabapple", "lime", "pomelo"}
        };

        String[][] mat2 = {  {"apple", "banana", "fig"},
                {"kiwi", "pineapple", "applesauce"},
                {"crabapple", "lime", "pomelo"},
                {"orange", "lime", "apples"},
                {"orange", "lime", "twoapples"}
        };

        assertEquals(0, MyMain.findMostAppleColumn(mat1),"The column with the most apple words in \n" + Arrays.deepToString(mat1) + "\nshould be: " + 0);
        assertEquals(2, MyMain.findMostAppleColumn(mat2),"The column with the most apple words in \n" + Arrays.deepToString(mat2) + "\nshould be: " + 2);
    }

    @Test
    public void testPascal() {
        // Here are some examples:
        // pascalTriangle(2) =>
        // 1  0
        // 1  1

        // pascalTriangle(6) =>
        // 1  0  0  0  0  0
        // 1  1  0  0  0  0
        // 1  2  1  0  0  0
        // 1  3  3  1  0  0
        // 1  4  6  4  1  0
        // 1  5  10 10 5  1

        int[][] m1 = {
                {1, 0},
                {1, 1}};

        int[][] m2 = {
                {1, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0},
                {1, 2, 1, 0, 0, 0},
                {1, 3, 3, 1, 0, 0},
                {1, 4, 6, 4, 1, 0},
                {1, 5, 10, 10, 5, 1}};

        assertEquals(Arrays.deepToString(m1), Arrays.deepToString(MyMain.pascal(2)),"A pascal triangle of height 2 should look like" + Arrays.deepToString(m1));
        assertEquals(Arrays.deepToString(m2), Arrays.deepToString(MyMain.pascal(6)),"A pascal triangle of height 6 should look like" + Arrays.deepToString(m2));
    }


    @Test
    public void testIsMagic() {
        int[][] m1 = {
                {4, 9, 2},
                {3, 5, 7},
                {8, 1, 6}};


        int[][] m2 = {
                { 2, 16, 13,  3},
                {11,  5,  8, 10},
                { 7,  9, 12,  6},
                {14,  4,  1, 15}};

        int[][] m3 = {
                { 1, 23, 16,  4, 21},
                {15, 14,  7, 18, 11},
                {24, 17, 13,  9,  2},
                {20,  8, 19, 12,  6},
                { 5,  3, 10, 22, 25}};

        // rows all same total, but not cols
        int[][] m4 = {
                {100, 101, 99, 100},
                {98,  99,  100, 103},
                {106, 94, 103, 97},
                {100, 100, 100, 100}
        };

        // rows and cols all same total, but not diagonals
        int[][] m5 = {
                {1, 2, 3, 4},
                {2, 3, 4, 1},
                {3, 4, 1, 2},
                {4, 1, 2, 3}
        };

        int[][] m6 = {
                {42, 37, 23, -5,  9},
                {11,  6, 22, 12, 13},
                {14,  5, 17, 13, 20},
                {1,   4, 27,  7, 32},
                {6,  2,  38,  1, 44} };

        int[][] m7 = {
                {37, 23, -5,  9, 42},
                { 6, 22, 12, 13, 11},
                { 5, 17, 13, 20, 14},
                { 4, 27,  7, 32,  1},
                {2,  38,  1, 44,  6} };

        assertEquals(true, MyMain.isMagic(m1),"Testing whether the array:\n" + Arrays.deepToString(m1) + "\n is magic should be: " + true);
        assertEquals(true, MyMain.isMagic(m2),"Testing whether the array:\n" + Arrays.deepToString(m2) + "\n is magic should be: " + true);
        assertEquals(true, MyMain.isMagic(m3),"Testing whether the array:\n" + Arrays.deepToString(m3) + "\n is magic should be: " + true);
        assertEquals(false, MyMain.isMagic(m6),"Testing whether the array:\n" + Arrays.deepToString(m6) + "\n is magic should be: " + false);
        assertEquals(false, MyMain.isMagic(m7),"Testing whether the array:\n" + Arrays.deepToString(m7) + "\n is magic should be: " + false);
        assertEquals(false, MyMain.isMagic(m4),"Testing whether the array:\n" + Arrays.deepToString(m4) + "\n is magic should be: " + false);
        assertEquals(false, MyMain.isMagic(m5),"Testing whether the array:\n" + Arrays.deepToString(m5) + "\n is magic should be: " + false);
    }
}
