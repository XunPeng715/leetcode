class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < arr.length - 1 && arr[i] <= arr[i + 1]) {
            i++;
        }
        if (i == arr.length - 1) return 0;
        while (j > 0 && arr[j] >= arr[j - 1]) {
            j--;
        }
        // [0, i] [j, arr.length - 1]
        int min = Math.min(arr.length - i - 1, j);
        int leftEnd = i;
        i = 0;
        while (i <= leftEnd && j < arr.length) {
            if (arr[i] <= arr[j]) {
                min = Math.min(min, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        return min;
    }
}
