public interface IPlayable {

    void updateGrid(Grid grid);

    default void play(Grid grid)
    {
        while (true)
        {
            updateGrid(grid);
            grid.repaint();
            /** try
            {
                Thread.sleep(50);
            }
            catch (Exception e)
            {
                //do nothing
            } **/
        }
    }

    void play();

    Grid getGrid();
}
