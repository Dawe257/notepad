package app;

import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.*;

public class App {
    private MenuBar menuBar;
    public static final JFrame frame = new JFrame("Notepad");
    public final static TextArea textArea = new TextArea();

    public void run() {
        javax.swing.SwingUtilities.invokeLater(() -> {
            frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/notes.png")));
            menuBar = new MenuBar();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setPreferredSize(new Dimension(1280, 820));
            frame.setJMenuBar(menuBar.getMenuBar());
            frame.add(textArea.getScroll());

            try {
                UIManager.setLookAndFeel(new FlatDarculaLaf());
                SwingUtilities.updateComponentTreeUI(frame);
            } catch (UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }

            frame.setVisible(true);
            frame.pack();
        });
    }
}
