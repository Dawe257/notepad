package app;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MenuBarFile extends JMenu {
    private final JMenu menuBarFile;
    private final JMenuItem fileOpen;
    private final JMenuItem fileSave;
    private final JMenuItem fileSaveAs;
    private final JMenuItem exit;
    private Path currentFile;

    public MenuBarFile() {
        menuBarFile = new JMenu("File");
        fileOpen = new JMenuItem("Open");
        fileSave = new JMenuItem("Save");
        fileSaveAs = new JMenuItem("Save As");
        exit = new JMenuItem("Exit");

        // Open
        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
        fileOpen.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
            fileChooser.setFileFilter(filter);
            int returnVal = fileChooser.showSaveDialog(null);
            if (returnVal != JFileChooser.APPROVE_OPTION) return;
            currentFile = fileChooser.getSelectedFile().toPath();
            App.frame.setTitle(currentFile.getFileName().toString() + " - Notepad");
            try {
                byte[] bytes = Files.readAllBytes(currentFile);
                App.textArea.getTextArea().setText(new String(bytes));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        // Save
        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
        fileSave.addActionListener(e -> {
            if (currentFile == null) fileSaveAs.doClick();
            else {
                String text = App.textArea.getTextArea().getText();
                try {
                    Files.write(currentFile, text.getBytes());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Save As
        // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
        fileSaveAs.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
            fileChooser.setFileFilter(filter);
            int returnVal = fileChooser.showSaveDialog(null);
            if (returnVal != JFileChooser.APPROVE_OPTION) return;
            currentFile = fileChooser.getSelectedFile().toPath();
            App.frame.setTitle(currentFile.getFileName().toString() + " - Notepad");
            String text = App.textArea.getTextArea().getText();
            try {
                Files.write(currentFile, text.getBytes());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        exit.addActionListener(e -> {
            App.frame.dispose();
        });

        menuBarFile.add(fileOpen);
        menuBarFile.add(fileSave);
        menuBarFile.add(fileSaveAs);
        menuBarFile.addSeparator();
        menuBarFile.add(exit);
    }

    public JMenu getMenuBarFile() {
        return menuBarFile;
    }
}
