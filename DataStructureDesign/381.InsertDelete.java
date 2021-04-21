class RandomizedCollection {
    Map<Integer, Integer> indexToNum;
    Map<Integer, Set<Integer>> numToIndex;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        indexToNum = new HashMap<>();
        numToIndex = new HashMap<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        int index = indexToNum.size();
        indexToNum.put(index, val);
        if (!numToIndex.containsKey(val)) {
            numToIndex.put(val, new HashSet<>());
        }
        numToIndex.get(val).add(index);
        return numToIndex.get(val).size() == 1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!numToIndex.containsKey(val)) {
            return false;
        }
        Set<Integer> set = numToIndex.get(val);
        if (set.size() == 0) {
            return false;
        }
        int index = set.iterator().next();
        set.remove(index);
        int size = indexToNum.size();
        int num = indexToNum.get(size - 1);
        numToIndex.get(num).add(index);
        numToIndex.get(num).remove(size - 1);
        indexToNum.put(index, num);
        indexToNum.remove(size - 1);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        Random rand  = new Random();
        int index = rand.nextInt(indexToNum.size());
        return indexToNum.get(index);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
