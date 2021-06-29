class Solution {
    public List<List<Integer>> findRLEArray(int[][] encode1, int[][] encode2) {
        List<List<Integer>> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < encode1.length && j < encode2.length) {
            int product = product = encode1[i][0] * encode2[j][0];
            int count = 0;
            if (encode1[i][1] == encode2[j][1]) {
                count = encode1[i][1];
                i++;
                j++;
            } else if (encode1[i][1] > encode2[j][1]) {
                count = encode2[j][1];
                encode1[i][1] -= encode2[j][1];
                j++;
            } else {
                count = encode1[i][1];
                encode2[j][1] -= encode1[i][1];
                i++;
            }
            if (res.size() > 0 && res.get(res.size() - 1).get(0) == product) {
                count += res.get(res.size() - 1).get(1);
                res.get(res.size() - 1).set(1, count); 
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(product);
                list.add(count);
                res.add(list);
            }
        }
        return res;
    }
}
