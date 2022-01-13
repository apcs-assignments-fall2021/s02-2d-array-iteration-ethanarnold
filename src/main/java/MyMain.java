public class MyMain {
    // Returns the String that shows up latest alphabetically
    // in a normal 1D String array
    // You can assume that the array will not be empty
    // and that all Strings are lowercase
    // Hint: recall how the compareTo() method works:
    //      int x = "apple".compareTo("banana"); // x is negative
    //      int y = "banana".compareTo("apple"); // y is positive
    public static String findLastWord(String[] arr) {
        String res = arr[0];
        for (String x : arr) {
            if (res.compareTo(x) < 0) res = x;
        }
        return res;
    }

    // Given a 2D array, return an 1D array of the last word
    // in each row in the array
    // You can assume that the matrix will not be empty
    // Hint: use the previous method to help yourself!
    public static String[] findLastWord2D(String[][] mat) {
        String[] res = new String[mat.length];
        for(int row = 0; row < mat.length; row++) {
            res[row] = mat[row][mat[0].length-1];
        }
        return res;
    }

    // Given a 2D array and some column index col
    // finds the number of Strings in the specified column
    // of the 2D array that contain the word "apple"
    // For example, if col = 0, you should only look through
    // the values in column 0 of the array; likewise, if
    // col = 2, you should only look through the values in column 2

    // Hint: remember how the indexOf() method works?
    // alternatively, consider the contains() method
    public static int appleCounter(String[][] mat, int col) {
        int count = 0;
        for(int row = 0; row < mat.length; row++) {
            if(mat[row][col].contains("apple")) count++;
        }
        return count;
    }

    // Given a 2D array, return the column number corresponding
    // to the column that contains the most Strings containing
    // the word "apple"

    // Hint: use your previous method!
    // Hint 2: you might need to loop through the columns!
    public static int findMostAppleColumn(String[][] mat) {
        int res = 0;
        int count = 0;
        for (int col = 0; col < mat[0].length; col++) {
            if(appleCounter(mat, col) > count) {
                res = col;
                count = appleCounter(mat, col);
            }
        }
        return res;
    }


    // Creates Pascal's Triangle, with a height of n
    // The first row of numbers has a single number, 1
    // Each subsequent row has one more number than the previous row
    // The first and last numbers of every row are 1
    // All other numbers’ values are calculated by adding together the two numbers above that number

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

    // Hint: fill in the first column and first diagonal with 1's
    //       and then go through and calculate the rest of the values
    //       from top to bottom

    public static int[][] pascal(int height) {
        int[][] pascal = new int[height][height];
        pascal[0][0] = 1;
        for (int row = 1; row < height; row++) {
            pascal[row][0] = 1;
            for (int col = 1; col < height; col++) {
                pascal[row][col] = pascal[row-1][col] + pascal[row-1][col-1];
            }
        }
        return pascal;
    }

    //booyah

    // Methods for the homework:

    // Checks if a 2D array is a magic square or not
    // You can assume that the 2D array mat will be square
    // A 2D array is a magic square if:
    // There is some set value x such that:
    // * all rows sum to x
    // * all columns sum to x
    // * both diagonals sum to x

    // Hint 1: you might first want to add up the values in the
    // first row/col and save that value to compare with later.
    // Then, you should check each rows, check each column, and
    // check each diagonal

    // Hint 2: you probably want to break this down into many parts.
    // You should have two loops to check the row sums. Then two more
    // loops to check the column sums. Finally, it might help to have
    // one for loop for each diagonal

    // Hint 3: when thinking the diagonals, consider the following
    // * do you see any pattern for the row and col indexes for a diagonal?
    // * can you use a for loop that goes through that pattern?
    public static boolean isMagic(int[][] mat) {
        int magic = sum(mat[0]);
        /* rows */
        for (int row = 0; row < mat.length; row++) {
            if(!(magicRow(mat, row, magic))) return false;
        }
        /* columns */
        for (int col = 0; col < mat[0].length; col++) {
            if(!(magicCol(mat, col, magic))) return false;
        }
        /*diagonals*/
        if (!(magicDiagonals(mat, magic))) return false;

        return true;
    }
    //returns true if the sum of all elements in a given row "row" of a 2d array "mat" is equal to an int magic
    public static boolean magicRow(int[][] mat, int row, int magic) {
        int sum = 0;
        for (int anInt : mat[row]) {
            sum += anInt;
        }
        return (sum == magic);
    }
    //returns true if the sum of all elements in a given col "col" of a 2d array "mat" is equal to an int magic
    public static boolean magicCol(int[][] mat, int col, int magic) {
        int sum = 0;
        for (int row = 0; row < mat.length; row++) {
            sum += mat[row][col];
        }
        return (sum == magic);
    }
    //returns true if diagonals are magical
    public static boolean magicDiagonals(int[][] mat, int magic) {
        int sum1 = 0;
        int sum2 = 0;
        int col1 = 0;
        int col2 = mat[0].length - 1;
        for (int[] ints : mat) {
            sum1 += ints[col1];
            sum2 += ints[col2];
            col1++;
            col2--;
        }
        return (sum1 == magic && sum2 == magic);
    }
    //gives sum of an array
    public static int sum(int[] arr) {
        int sum = 0;
        for (int x : arr) {
            sum += x;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] mat = {
                { 1, 23, 16,  4, 21},
                {15, 14,  7, 18, 11},
                {24, 17, 13,  9,  2},
                {21,  8, 19, 12,  6},
                { 5,  3, 10, 22, 25}};

        System.out.println(magicDiagonals(mat, 65));
        System.out.println(magicCol(mat, 1, 65));
        System.out.println(magicRow(mat, 0, 65));
        System.out.println(sum(mat[0]));
    }

}




