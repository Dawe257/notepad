package app;

import javax.swing.*;
import java.awt.*;

public class TextArea {
    private final JTextArea textArea;
    private final JScrollPane scroll;

    public TextArea() {
        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        textArea.setEditable(true);
        scroll = new JScrollPane(textArea);
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public JTextArea getTextArea() {
        return textArea;
    }
}
