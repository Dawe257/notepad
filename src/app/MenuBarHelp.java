package app;

import javax.swing.*;
import java.awt.*;

public class MenuBarHelp extends JMenu {
    private final JMenu menuBarHelp;

    public MenuBarHelp() {
        Image scaledImage = App.frame.getIconImage().getScaledInstance(70, 70,  Image.SCALE_FAST);
        menuBarHelp = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");
        about.addActionListener(e -> {
            JOptionPane.showMessageDialog(App.frame,
                    "Notepad\nhttps://github.com/Dawe257",
                    "About program",
                    JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon(scaledImage));
        });
        menuBarHelp.add(about);
    }

    public JMenu getMenuBarHelp() {
        return menuBarHelp;
    }
}
