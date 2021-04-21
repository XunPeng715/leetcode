class Node {
    String key;
    int count;
    Node prev;
    Node next;
    public Node(String key) {
        this.key = key;
        count = 1;
        prev = null;
        next = null;
    }
}
class AllOne {

    /** Initialize your data structure here. */
    Node head;
    Node tail;
    Map<String, Node> map;
    public AllOne() {
        map = new HashMap<>();
        head = new Node("head");
        tail = new Node("tail");
        head.next  = tail;
        tail.prev = head;        
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.count++;
            moveRight(node, tail);
        } else {
            Node node = new Node(key);
            Node next = head.next;
            head.next = node;
            node.next = next;
            next.prev = node;
            node.prev = head;
            map.put(key, node);
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        Node node = map.get(key);
        if (node.count == 1) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev =prev;
            map.remove(key);
        } else {
            node.count--;
            moveLeft(node, head);
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (map.size() == 0) {
            return "";
        }
        return tail.prev.key;
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (map.size() == 0) {
            return "";
        }
        return head.next.key;
    }
    
    public void moveRight(Node node, Node tail) {
        Node next = node.next;
        while (next != tail && node.count > next.count) {
            Node nextNext = next.next;
            Node prev = node.prev;
            prev.next = next;
            next.prev = prev;
            next.next = node;
            node.prev = next;
            node.next = nextNext;
            nextNext.prev = node;
            next = nextNext;
        }
    }
    
    public void moveLeft(Node node, Node head) {
        Node prev = node.prev;
        while (prev != head && node.count < prev.count) {
            Node next = node.next;
            Node prevPrev = prev.prev;
            prevPrev.next = node;
            node.prev = prevPrev;
            node.next = prev;
            prev.prev = node;
            prev.next = next;
            next.prev = prev;
            prev = prevPrev;
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
