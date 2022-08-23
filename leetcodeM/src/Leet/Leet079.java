package Leet;

public class Leet079 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    int[] dx = new int[]{-1, 0, 1, 0}, dy = new int[]{0, 1, 0, -1};

    boolean dfs(char[][] board, String word, int u, int x, int y) {
        if (board[x][y] != word.charAt(u)) return false;
        if (u == word.length() - 1) return true;
        char t = board[x][y];
        board[x][y] = '.';
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            if (a < 0 || a >= board.length || b < 0 || b >= board[0].length || board[a][b] == '.') continue;
            if (dfs(board, word, u + 1, a, b)) return true;
        }
        board[x][y] = t;
        return false;
    }
}
