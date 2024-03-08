import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class FileManagement {
    File workingFile;
    public void OpenTextFile(JFrame frame, JTextArea editorContainer) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(true);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Text Documents (*.txt)", "txt"));
        int result = fileChooser.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            workingFile = selectedFile;
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
        if(workingFile == null) {
            SaveFileAs(editorContainer);
            return;
        }
        System.out.println("Saving " + workingFile + "...");

        saveContentToFile(editorContainer.getText(), workingFile);
    }

    public void SaveFileAs(JTextArea editorContainer) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save as:");
        fileChooser.setSelectedFile(new File("Untitled.txt"));

        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            workingFile = fileChooser.getSelectedFile();
            System.out.println("Saving " + workingFile + "...");
            saveContentToFile(editorContainer.getText(), workingFile);
        }
    }

    private void saveContentToFile(String content, File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
            System.out.println("File saved: " + file);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error saving file: " + e);
        }
    }
}
