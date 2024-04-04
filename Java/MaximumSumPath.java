// Q2:Find maximum sum path involving elements of given arrays. Given two sorted arrays of integers, find a maximum sum path involving elements of both arrays whose sum is maximum. We can start from either array, but we can switch between arrays only through its common elements.

public class MaximumSumPath {
    public static int findMaximumSumPath(int[] X, int[] Y) {
        int m = X.length;
        int n = Y.length;
        
        int i = 0, j = 0; 
        int sumX = 0, sumY = 0;
        int result = 0;
        

        while (i < m && j < n) {

            if (X[i] < Y[j]) {
                sumX += X[i++];
            }

            else if (X[i] > Y[j]) {
                sumY += Y[j++];
            }

            else {
                result += Math.max(sumX, sumY);
                result += X[i];
                sumX = 0;
                sumY = 0;
                i++;
                j++;
            }
        }
        
        while (i < m) {
            sumX += X[i++];
        }
        while (j < n) {
            sumY += Y[j++];
        }
        
        result += Math.max(sumX, sumY);
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] X = {3, 6, 7, 8, 10, 12, 15, 18, 100};
        int[] Y = {1, 2, 3, 5, 7, 9, 10, 11, 15, 16, 18, 25, 50};
        
        int maxSum = findMaximumSumPath(X, Y);
        System.out.println("The maximum sum path is: " + maxSum);
    }
}
