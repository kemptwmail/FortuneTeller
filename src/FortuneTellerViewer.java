import javax.swing.*;

public class FortuneTellerViewer
{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FortuneTellerFrame frame = new FortuneTellerFrame();
            frame.setTitle("Fortune Teller");
            frame.setSize(800, 800);
            frame.setDefaultCloseOperation(3);
            frame.setVisible(true);
        });
    }
}