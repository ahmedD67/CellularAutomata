import javax.swing.*;

public class LangtonAntTest {
    public static void main(String[] args)
    {
        String title = "Langton's Ant";
        LangtonAnt game = new LangtonAnt(70, 70, 125, 125, 5);
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(game.getGrid());
        frame.pack();
        frame.setVisible(true);
        game.play();
    }
}
