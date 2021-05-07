package leetcode;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 */
public class At11 {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }


    /**
     * 暴力O(n²)就不说了
     * 双指针解法 O(n)
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int res = 0;
        while (l != r) {
            res = Math.max(res, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}