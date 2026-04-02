import java.util.Scanner;

class Solution {

    static final int TEST_CASE_COUNT = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = 1; t <= TEST_CASE_COUNT; t++) {
            int n = sc.nextInt();

            int[] heights = new int[n];
            for (int i = 0; i < n; i++) {
                heights[i] = sc.nextInt();
            }

            System.out.printf("#%d %d%n", t, solveTestCase(n, heights));
        }
    }

    static int solveTestCase(int n, int[] heights) {
        int ans = 0;

        for (int i = 2; i < n - 2; i++) {
            int maxHeightOfAdjacents = heights[i - 2];
            if (heights[i - 1] > maxHeightOfAdjacents) {
                maxHeightOfAdjacents = heights[i - 1];
            }
            if (heights[i + 1] > maxHeightOfAdjacents) {
                maxHeightOfAdjacents = heights[i + 1];
            }
            if (heights[i + 2] > maxHeightOfAdjacents) {
                maxHeightOfAdjacents = heights[i + 2];
            }

            ans += Math.max(heights[i] - maxHeightOfAdjacents, 0);
        }

        return ans;
    }
}
