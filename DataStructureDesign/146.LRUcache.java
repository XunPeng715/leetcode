class Node {
    Node prev = null;
    Node next = null;
    int key;
    int val;
    public Node(int k, int v) {
        key = k;
        val = v;
    }
    
    public Node() {
        
    }
}

class LRUCache {
    // head  tail (most recent used)
    Node head = null;
    Node tail = null;
    int cap;
    Map<Integer, Node> map; 
    public LRUCache(int capacity) {
        cap = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            update(node, tail);
            return map.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            remove(node);
            update(node, tail);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            update(node, tail);
            if (map.size() > cap) {
                Node invalid = head.next;
                remove(invalid);
                map.remove(invalid.key);
            }
        }
    }
    
    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public void update(Node node, Node tail) {
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
