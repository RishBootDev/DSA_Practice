class Solution {
   
   public boolean canReorderDoubled(int[] arr) {

    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
        map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }
  
    Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);

    Arrays.sort(nums,(a, b) -> Integer.compare(Math.abs(a), Math.abs(b)));
    for (int i = 0; i < nums.length; i++) {

        if (map.get(nums[i]) == 0) continue;

        int doubled = 2 * nums[i];

        if (map.getOrDefault(doubled, 0) == 0) {
            return false;
        }

        map.put(nums[i], map.get(nums[i]) - 1);
        map.put(doubled, map.get(doubled) - 1);
    }

    return true;
}
}