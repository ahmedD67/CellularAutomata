import java.awt.*;
import java.awt.color.ICC_ColorSpace;

public class Grid extends Canvas {
    private Cell[][] grid;
    private int rows;
    private int columns;


    public Grid(int rows, int columns, int size) {
        this.grid = new Cell[rows][columns];
        this.rows = rows;
        this.columns = columns;
        for (int r = 0; r < rows; r++)
        {
            int x = r * size;
            for (int c = 0; c < columns; c++)
            {
                int y = c * size;
                grid[r][c] = new Cell(x, y, size);
            }
        }
        setSize(columns * size, rows * size);
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    // counts the number of active neighbors to each cell
    public int[][] nieghborsGrid()
    {
        int[][] countGrid = new int[rows][columns];
        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < columns; c++)
            {
                countGrid[r][c] = countNeighbors(r, c);
            }
        }
        return countGrid;
    }

    private int countNeighbors(int r, int c)
    {
        int count = 0;
        for (int i = r-1; i < r + 2; i++)
        {
            for (int j = c-1; j < c + 2; j++)
            {
                try
                {
                    count += grid[i][j].isOn() ? 1 : 0;
                }
                catch (Exception e)
                {
                    // do nothing
                }
            }
        }
        if (getCell(r, c).isOn()) { return count - 1; }
        else { return count; }
    }

    public void turnOnCell(int r, int c)
    {
        grid[r][c].turnOn();
    }
    public void turnOffCell(int r, int c)
    {
        grid[r][c].turnOff();
    }

    public Cell getCell(int r, int c)
    {
        return grid[r][c];
    }

    public String toString()
    {
        StringBuilder output = new StringBuilder();
        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < columns; c++)
            {
                if (grid[r][c].isOn())
                {
                    output.append("X");
                }
                else
                {
                    output.append(" ");
                }
            }
            output.append("\n");
        }
        return output.toString();
    }

    public void draw(Graphics g)
    {
        for (Cell[] row : grid)
        {
            for (Cell cell : row)
            {
                cell.draw(g);
            }
        }
    }
    public void paint(Graphics g)
    {
        draw(g);
    }
}
