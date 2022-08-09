import java.awt.*;

public class LangtonAnt implements IPlayable {
    private Grid grid;
    private int x;
    private int y;
    private int dirIndex = 0;
    private int size;

    public LangtonAnt(int x, int y, int rows, int columns, int size) {
        this.grid = new Grid(rows, columns, size);
        this.x = x;
        this.y = y;
        this.size = size;
    }

    @Override
    public void updateGrid(Grid grid) {
        if (grid.getCell(x, y).isOff())
        {
            dirIndex += 1;
            grid.turnOnCell(x, y);
            MoveForward();
        }
        else
        {
            dirIndex -= 1;
            grid.turnOffCell(x, y);
            MoveForward();
        }
    }

    private void MoveForward() {
        Direction dir = Direction.values()[dirIndex % 4];
        switch (dir)
        {
            case NORTH:
                y += 1;
                break;

            case EAST:
                x += 1;
                break;
            case SOUTH:
                y -= 1;
                break;
            case WEST:
                x -= 1;
                break;
        }
    }
    @Override
    public void play()
    {
        play(grid);
    }
    @Override
    public Grid getGrid() {
        return grid;
    }
}
