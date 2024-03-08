import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileManagement {
    public void OpenTextFile(JFrame frame, JTextArea editorContainer) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(true);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Text Documents (*.txt)", "txt"));
        int result = fileChooser.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                editorContainer.read(reader, null);
                reader.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "File could not be read", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void SaveFile(JTextArea editorContainer) {
        System.out.println("IMPLEMENT ME PLEASE (FileManagement.SaveFile)");
    }

    public void SaveFileAs(JTextArea editorContainer) {
        System.out.println("IMPLEMENT ME PLEASE (FileManagement.SaveFileAs)");
    }
}
