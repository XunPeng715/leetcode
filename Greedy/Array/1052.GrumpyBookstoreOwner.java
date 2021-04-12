class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int satisfied = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                satisfied += customers[i];
            }
        }
        int diff = 0;
        for (int i = 0; i < X; i++) {
            if (grumpy[i] == 1) {
                diff += customers[i];
            }
        }
        int max = diff;
        for (int i = X; i < customers.length; i++) {
            if (grumpy[i - X] == 1) {
                diff -= customers[i - X];
            }
            if (grumpy[i] == 1) {
                diff += customers[i];
            }
            max = Math.max(max, diff);
        }
        return satisfied + max;
    }
}
