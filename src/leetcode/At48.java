package leetcode;

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

import java.util.Arrays;

/**
 * 给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * <p>
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * 示例 3：
 * <p>
 * 输入：matrix = [[1]]
 * 输出：[[1]]
 * 示例 4：
 * <p>
 * 输入：matrix = [[1,2],[3,4]]
 * 输出：[[3,1],[4,2]]
 */
public class At48 {

    public static void main(String[] args) {
        int[][] matrix = {{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}};
        Arrays.stream(matrix).forEach(item -> {
            Arrays.stream(item).forEach(iz -> {
                System.out.printf("\t%d", iz);
            });
            System.out.println();
        });

        new At48().rotate2(matrix);
        System.out.println();

        Arrays.stream(matrix).forEach(item -> {
            Arrays.stream(item).forEach(iz -> {
                System.out.printf("\t%d", iz);
            });
            System.out.println();
        });


    }

    /**
     * 感觉这题和思维有关，外层循环为圈数，而圈数= 单个数组长度/2。
     * 所以说还是双层循环喽？
     * <p>
     * 画了张图，出来了，所以说是数学题/思维题喽？
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        if (len < 2) return;
        len--;
        for (int i = 0; i < len / 2; i++) {
            for (int j = i; j < len - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[len - j][i];
                matrix[len - j][i] = matrix[len - i][len - j];
                matrix[len - i][len - j] = matrix[j][len - i];
                matrix[j][len - i] = tmp;
            }
        }
    }

    /**
     * 翻转的写法，先水平翻转，再左上和右下的对角线翻转
     *
     * @param matrix
     */
    public void rotate2(int[][] matrix) {
        int len = matrix.length;
        if (len < 2) return;
        for (int i = 0; i < len / 2; i++) {
            for (int j = 0; j < len; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[len - i - 1][j];
                matrix[len - i - 1][j] = tmp;
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

    }


}
