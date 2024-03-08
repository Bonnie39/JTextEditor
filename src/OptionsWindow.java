import javax.swing.*;
import java.awt.*;

public class OptionsWindow {
    JFrame optionsFrame = new JFrame();

    OptionsWindow() {
        SwingUtilities.invokeLater(() -> {
            optionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            optionsFrame.setMinimumSize(new Dimension(256, 256));
            optionsFrame.setSize(720, 480);
            optionsFrame.setTitle("JTextEdit Options");
            optionsFrame.setLayout(new BorderLayout());
            optionsFrame.setVisible(true);
        });
    }
}
