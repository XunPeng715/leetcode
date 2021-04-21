class RandomizedSet {

    /** Initialize your data structure here. */
    Map<Integer, Integer> indexToVal;
    Map<Integer, Integer> valToIndex;
    public RandomizedSet() {
        indexToVal = new HashMap<>();
        valToIndex = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valToIndex.containsKey(val))
            return false;
        int size = indexToVal.size();
        indexToVal.put(size, val);
        valToIndex.put(val, size);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!valToIndex.containsKey(val)) {
            return false;
        }
        int index = valToIndex.get(val);
        valToIndex.remove(val);
        indexToVal.remove(index);
        if (index == indexToVal.size())
            return true;
        int tmpVal = indexToVal.get(indexToVal.size());
        indexToVal.remove(indexToVal.size());
        indexToVal.put(index, tmpVal);
        valToIndex.put(tmpVal, index);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random ran = new Random();
        int index = ran.nextInt(indexToVal.size());
        return indexToVal.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
