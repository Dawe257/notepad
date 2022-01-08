package app;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;

public class MenuBarView extends JMenu {
    private final JMenu menuBarView;
    private final JMenu changeTheme;
    private final JMenuItem darkTheme;
    private final JMenuItem lightTheme;

    public MenuBarView() {
        menuBarView = new JMenu("View");
        changeTheme = new JMenu("Change theme");

        darkTheme = new JMenuItem("Dark");
        lightTheme = new JMenuItem("Light");

        darkTheme.addActionListener(e -> {
            try {
                UIManager.setLookAndFeel(new FlatDarculaLaf());
                SwingUtilities.updateComponentTreeUI(App.frame);
            } catch (UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }
        });
        lightTheme.addActionListener(e -> {
            try {
                UIManager.setLookAndFeel(new FlatLightLaf());
                SwingUtilities.updateComponentTreeUI(App.frame);
            } catch (UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }
        });

        changeTheme.add(darkTheme);
        changeTheme.add(lightTheme);

        menuBarView.add(changeTheme);
    }

    public JMenu getMenuBarView() {
        return menuBarView;
    }
}
