class Solution {
    public String largestNumber(int[] nums) {
        List<String> strs = new ArrayList<>();
        for (int num : nums) {
            strs.add(Integer.toString(num));
        }
        Collections.sort(strs, (m, n) -> {
            return (n + m).compareTo(m + n);
        });
        if (strs.get(0).equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        return sb.toString();
    }
}
