class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length == 0 || indexDiff <= 0) {
            return false;
        }

        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            Long num = (long) nums[i];

            // 检查是否有符合条件的数字在滑动窗口内
            Long floor = set.floor(num);
            if (floor != null && num - floor <= valueDiff) {
                return true;
            }

            Long ceiling = set.ceiling(num);
            if (ceiling != null && ceiling - num <= valueDiff) {
                return true;
            }

            // 添加当前元素到滑动窗口
            set.add(num);

            // 保持滑动窗口的大小不超过 indexDiff
            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }

        return false;
    }
}