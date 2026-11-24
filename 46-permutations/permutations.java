
import java.util.*;

class Solution {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, 0, result);

        return result;
    }

    public void backtrack(int[] nums, int index,
                          List<List<Integer>> result) {

        // Base case
        if (index == nums.length) {

            List<Integer> current = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                current.add(nums[i]);
            }

            result.add(current);
            return;
        }

        for (int i = index; i < nums.length; i++) {

            // Swap
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;

            // Recursive call
            backtrack(nums, index + 1, result);

            // Backtracking: swap back
            temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
    }
}
