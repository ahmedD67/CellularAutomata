public class Conway implements IPlayable {
    private Grid grid;

    public Conway(int rows, int columns, int size) {
        this.grid = new Grid(rows, columns, size);
        grid.turnOnCell(2,4);
        grid.turnOnCell(2,5);
        grid.turnOnCell(2,6);
        grid.turnOnCell(2,10);
        grid.turnOnCell(2,11);
        grid.turnOnCell(2,12);
        grid.turnOnCell(7,4);
        grid.turnOnCell(7,5);
        grid.turnOnCell(7,6);
        grid.turnOnCell(7,10);
        grid.turnOnCell(7,11);
        grid.turnOnCell(7,12);
        grid.turnOnCell(9,4);
        grid.turnOnCell(9,5);
        grid.turnOnCell(9,6);
        grid.turnOnCell(9,10);
        grid.turnOnCell(9,11);
        grid.turnOnCell(9,12);
        grid.turnOnCell(14,4);
        grid.turnOnCell(14,5);
        grid.turnOnCell(14,6);
        grid.turnOnCell(14,10);
        grid.turnOnCell(14,11);
        grid.turnOnCell(14,12);
        grid.turnOnCell(4,2);
        grid.turnOnCell(5,2);
        grid.turnOnCell(6,2);
        grid.turnOnCell(10,2);
        grid.turnOnCell(11,2);
        grid.turnOnCell(12,2);
        grid.turnOnCell(4,7);
        grid.turnOnCell(5,7);
        grid.turnOnCell(6,7);
        grid.turnOnCell(10,7);
        grid.turnOnCell(11,7);
        grid.turnOnCell(12,7);
        grid.turnOnCell(4,9);
        grid.turnOnCell(5,9);
        grid.turnOnCell(6,9);
        grid.turnOnCell(10,9);
        grid.turnOnCell(11,9);
        grid.turnOnCell(12,9);
        grid.turnOnCell(4,14);
        grid.turnOnCell(5,14);
        grid.turnOnCell(6,14);
        grid.turnOnCell(10,14);
        grid.turnOnCell(11,14);
        grid.turnOnCell(12,14);
    }

    @Override
    public void play()
    {
        while (true)
        {
            updateGrid(grid);
            grid.repaint();
            try
            {
                Thread.sleep(500);
            }
            catch (Exception e)
            {
                //do nothing
            }
        }
    }

    public void updateGrid(Grid grid) {
        int rows = grid.getRows();
        int columns = grid.getColumns();
        int[][] counts = grid.nieghborsGrid();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (grid.getCell(r, c).isOn()) {
                    if (counts[r][c] < 2 || counts[r][c] > 3) {
                        grid.turnOffCell(r, c);
                    }
                } else {
                    if (counts[r][c] == 3) {
                        grid.turnOnCell(r, c);
                    }
                }
            }
        }
    }

    public void test() {
        int[][] count = grid.nieghborsGrid();
        for (int r = 0; r < grid.getRows(); r++)
        {
            for (int c = 0; c < grid.getColumns(); c++)
            {
                System.out.print(count[r][c]);
            }
            System.out.println("");
        }
    }

    @Override
    public Grid getGrid()
    {
        return grid;
    }
}
