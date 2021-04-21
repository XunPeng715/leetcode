class Node {
    Node prev = null;
    Node next = null;
    int key;
    int value;
    int freq;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        freq = 1;
    }
    
    public Node() {
    }
}

class LFUCache {

    int cap;
    Node head;
    Node tail;
    Map<Integer, Node> map;
    // head  -- tail
    public LFUCache(int capacity) {
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
            node.freq++;
            moveRight(node, tail);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cap == 0) return;
        Map<Integer, Node> map1 = map;
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.freq++;
            node.value = value;
            moveRight(node, tail);
        } else {
            if (map.size() == cap) {
                Node invalid = head.next;
                remove(invalid);
                map.remove(invalid.key);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            Node next = head.next;
            head.next = node;
            node.prev = head;
            node.next = next;
            next.prev = node;
            moveRight(node, tail);            
        }
    }
    
    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public void moveRight(Node node, Node tail) {
        Node next = node.next;
        while (next != tail && next.freq <= node.freq) {
            Node prev = node.prev;
            Node nextNext = next.next;
            prev.next = next;
            next.prev = prev;
            next.next = node;
            node.prev = next;
            node.next = nextNext;
            nextNext.prev = node;
            next = nextNext;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
