
import java.util.Scanner;

public class knapsackzeroone {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int weight[] = new int[n];
        int profit[] = new int[n];

        for (int i = 0; i < n; i++) {

            System.out.print("Enter weight of item " + (i + 1) + ": ");
            weight[i] = sc.nextInt();

            System.out.print("Enter profit of item " + (i + 1) + ": ");
            profit[i] = sc.nextInt();
        }

        System.out.print("Enter knapsack capacity: ");
        int W = sc.nextInt();

        int dp[][] = new int[n + 1][W + 1];

        // Dynamic Programming
        for (int i = 1; i <= n; i++) {

            for (int w = 0; w <= W; w++) {

                if (weight[i - 1] <= w) {

                    dp[i][w] = Math.max(
                        profit[i - 1] + dp[i - 1][w - weight[i - 1]],
                        dp[i - 1][w]
                    );

                } else {

                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println(
            "Maximum Profit: " + dp[n][W]
        );

        sc.close();
    }
}

/*
Approach: Dynamic Programming

Time Complexity: O(n * W)
Space Complexity: O(n * W)
Why?
- A 2D DP table is created with (n+1) rows
  and (W+1) columns.
- The outer loop runs n times.
- The inner loop runs W+1 times.
- Each cell is calculated in constant time.
- Therefore, time complexity is O(n * W).
- The DP table stores approximately n * W values,
  so space complexity is O(n * W).

Where:
n = Number of items.
W = Maximum knapsack capacity.
Explanation:
- Uses a 2D DP table to store maximum profit.
- Each item can either be selected completely or rejected.
- An item cannot be divided into fractions.
- Uses the maximum of two choices:
  1. Include the current item.
  2. Exclude the current item.

Objective:
To maximize total profit without exceeding the capacity.

Where:
n = Number of items
W = Maximum knapsack capacity
*/
