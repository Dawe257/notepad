package app;

import javax.swing.*;

public class MenuBar extends JMenuBar {
    private final JMenuBar menuBar;

    public MenuBar() {
        this.menuBar = new JMenuBar();

        JMenu file = new MenuBarFile().getMenuBarFile();
        JMenu view = new MenuBarView().getMenuBarView();
        JMenu help = new MenuBarHelp().getMenuBarHelp();
        menuBar.add(file);
        menuBar.add(view);
        menuBar.add(help);
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }
}
