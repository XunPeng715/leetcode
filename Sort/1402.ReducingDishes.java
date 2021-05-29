class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int curr = 0, sum = 0, max = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            sum += satisfaction[i];
            curr += sum;
            max = Math.max(max, curr);
        }
        return max;
    }
}
