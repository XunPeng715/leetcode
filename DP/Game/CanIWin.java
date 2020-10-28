class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal)
            return false;
        if (desiredTotal <= maxChoosableInteger) 
            return true;
        Map<String, Boolean> memo = new HashMap<>();
        return dfs(new boolean[maxChoosableInteger + 1], maxChoosableInteger, desiredTotal, memo);
    }
    
    public boolean dfs(boolean[] used, int max, int target, Map<String, Boolean> memo) {
        if (target <= 0) {
            return false;
        }
        String key = Arrays.toString(used);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        for (int i = 1; i <= max; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            boolean prevRes = dfs(used, max, target - i, memo);
            used[i] = false;
            if (prevRes == false) {
                memo.put(key, true);
                return true;
            }
        }
        memo.put(key, false);
        return false;
    }
}  
