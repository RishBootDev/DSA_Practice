class NeighborSum {
    HashMap<Integer, int[]> map = new HashMap<>();
    int[][] arr;

    public NeighborSum(int[][] grid) {
        arr = grid;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                map.put(grid[i][j], new int[] { i, j });
    }

    public int adjacentSum(int value) {
        int[] index = map.get(value);
        int sum = 0;
        if (index[0] > 0)
            sum += arr[index[0] - 1][index[1]];
        if (index[1] > 0)
            sum += arr[index[0]][index[1] - 1];
        if (index[0] < (arr.length - 1))
            sum += arr[index[0] + 1][index[1]];
        if (index[1] < arr[0].length - 1)
            sum += arr[index[0]][index[1] + 1];
        return sum;
    }

    public int diagonalSum(int value) {
        int[] index = map.get(value);
        int sum = 0;
        if (index[0] > 0) {
            if (index[1] > 0)
                sum += arr[index[0] - 1][index[1] - 1];
            if (index[1] < arr[0].length - 1)
                sum += arr[index[0] - 1][index[1] + 1];
        }
        if (index[0] < (arr.length - 1)) {
            if (index[1] > 0)
                sum += arr[index[0] + 1][index[1] - 1];
            if (index[1] < arr[0].length - 1)
                sum += arr[index[0] + 1][index[1] + 1];
        }
        return sum;
    }
}