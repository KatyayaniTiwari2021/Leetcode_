import java.util.*;

class Solution {

    static int[] rd = {-1, 1, 0, 0};
    static int[] cd = {0, 0, -1, 1};

    class pair {
        int prow;
        int pcol;
        int row;
        int col;

        pair(int prow, int pcol, int row, int col) {
            this.prow = prow;
            this.pcol = pcol;
            this.row = row;
            this.col = col;
        }
    }

    public boolean containsCycle(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] isvisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (!isvisited[i][j]) {

                    Queue<pair> q1 = new LinkedList<>();

                    q1.add(new pair(-1, -1, i, j));

                    isvisited[i][j] = true;
                    
                    char ch = grid[i][j];

                    while (!q1.isEmpty()) {

                        pair curr = q1.poll();
                        int row = curr.row;
                        int col = curr.col;

                        for (int k = 0; k < 4; k++) {

                            int nrow = row + rd[k];
                            int ncol = col + cd[k];

                            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                                    && grid[nrow][ncol] == ch) {

                                if (!isvisited[nrow][ncol]) {

                                    isvisited[nrow][ncol] = true;
                                    q1.add(new pair(row, col, nrow, ncol));
                                }
                                else if (nrow != curr.prow || ncol != curr.pcol) {

                                    return true; 
                                }
                            }
                        }
                    }
                }
            }
        }

        return false;
    }
}