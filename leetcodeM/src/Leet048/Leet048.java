package Leet048;

public class Leet048 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Leet048 leet048 = new Leet048();
        leet048.rotate(matrix);
    }

    //借助辅助矩阵
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //复制一个二维矩阵
        int[][] tmp = copyMatrix(matrix);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][n - i - 1] = tmp[i][j];
            }
        }
    }

    public int[][] copyMatrix(int[][] matrix) {
        int n = matrix.length;
        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[i][j] = matrix[i][j];
            }
        }
        return tmp;
    }


    //不借助辅助矩阵(原地旋转)
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
    }
}
