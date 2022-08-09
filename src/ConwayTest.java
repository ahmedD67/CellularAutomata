import javax.swing.*;

public class ConwayTest {
    public static void main(String[] args)
    {
        String title = "Conway's Game of Life";
        Conway game = new Conway(18, 18, 20);
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(game.getGrid());
        frame.pack();
        frame.setVisible(true);
        game.play();
    }
}
