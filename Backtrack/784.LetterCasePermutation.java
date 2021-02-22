class Solution {
    public List<String> letterCasePermutation(String S) {
        char[] arr = S.toCharArray();
        List<String> res = new ArrayList<>();
        dfs(res, arr, 0);
        return res;
    }
    
    public void dfs(List<String> res, char[] arr, int start) {
        while (start < arr.length && Character.isDigit(arr[start])) {
            start++;
        }
        if (start == arr.length) {
            res.add(new String(arr));
            return;
        }
        char tmp = arr[start];
        arr[start] = Character.toUpperCase(tmp);        
        dfs(res, arr, start + 1);
        arr[start] = Character.toLowerCase(tmp);
        dfs(res, arr, start + 1);
        arr[start] = tmp;
    }
}
