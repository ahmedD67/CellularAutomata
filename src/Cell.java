import java.awt.*;

public class Cell {
    private int x;
    private int y;
    private int size;
    private int state;

    public boolean isOn()
    {
        return (state == 1);
    }
    public boolean isOff()
    {
        return (state == 0);
    }
    public void turnOn()
    {
        state = 1;
    }
    public void turnOff()
    {
        state = 0;
    }

    public Cell(int x, int y, int size) {
        this.state = 0;
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public static final Color[] colors = {Color.WHITE, Color.BLACK};
    public void draw(Graphics g)
    {
        g.setColor(colors[state]);
        g.fillRect(x+1, y+1, size - 1, size - 1);
        g.setColor(Color.LIGHT_GRAY);
        g.drawRect(x,y,size,size);
    }
}
