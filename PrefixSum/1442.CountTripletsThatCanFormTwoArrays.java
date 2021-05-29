class Solution {
    public int countTriplets(int[] arr) {
        int[] xor = new int[arr.length];
        int prev = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            xor[i] = prev ^ arr[i];
            prev = xor[i];
            if (!map.containsKey(prev)) {
                map.put(prev, new ArrayList<>());
            }
            map.get(prev).add(i);
        }
        int count = 0;
        for (int key : map.keySet()) {
            List<Integer> index = map.get(key);
            Collections.sort(index);
            if (key == 0) {
                for (int i = 0; i < index.size(); i++) {
                    count += index.get(i);
                }
            }            
            for (int i = 0; i < index.size(); i++) {
                for (int j = i + 1; j < index.size(); j++) {
                    count += index.get(j) - index.get(i) - 1;
                }
            }
        }
        return count;
    }
}
