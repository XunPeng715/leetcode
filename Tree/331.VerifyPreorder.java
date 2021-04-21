class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] arr = preorder.split(",");
        return helper(arr, 0) == arr.length - 1;
    }
    
    public int helper(String[] arr, int start) {
        if (start >= arr.length) {
            return -1;
        }
        if (arr[start].equals("#")) {
            return start;
        }
        int leftEnd = helper(arr, start + 1);
        if (leftEnd == -1) {
            return -1;
        }
        int rightEnd = helper(arr, leftEnd + 1);
        if (rightEnd == -1) {
            return -1;
        }
        return rightEnd;
    }
}
