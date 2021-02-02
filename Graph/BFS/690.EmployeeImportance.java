/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        // return dfs(map.get(id), map);
        return bfs(id, map);
    }
    
    
    public int bfs(int id, Map<Integer, Employee> map) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        int importance = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            Employee e = map.get(curr);
            importance += e.importance;
            for (int sub : e.subordinates) {
                queue.offer(sub);
            }
        }
        return importance;
    }
}
