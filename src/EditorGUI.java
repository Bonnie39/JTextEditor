import java.awt.*;
import javax.swing.*;

public class EditorGUI {
    FileManagement fileMgr = new FileManagement();

    JFrame frame = new JFrame();
    JMenuBar menuBar = new JMenuBar();

    //  MENU BAR ITEMS
    JMenu fileMenu = new JMenu("File");
    JMenu optionsMenu = new JMenu("Options");

    //  FILE SUB-OPTIONS
    JMenuItem save = new JMenuItem("Save");
    JMenuItem saveAs = new JMenuItem("Save as...");
    JMenuItem open = new JMenuItem("Open");

    //  TEXT EDITOR
    JTextArea editorContainer = new JTextArea(10, 10);

    EditorGUI() {
        //  DEFINE MENU BAR
        fileMenu.add(open);
        fileMenu.add(save);
        fileMenu.add(saveAs);

        //optionsMenu.add();    //  TODO: OPTIONS MENU

        menuBar.add(fileMenu);
        menuBar.add(optionsMenu);

        //  DEFINE FRAME
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(256, 256));
        frame.setSize(720, 480);
        frame.setTitle("JTextEdit");
        frame.setJMenuBar(menuBar);
        frame.setLayout(new BorderLayout());

        // TEXT EDITOR CONFIG
        editorContainer.setLineWrap(true);
        editorContainer.setWrapStyleWord(true);

        // Wrap the text area in a JScrollPane
        JScrollPane editorScrollPane = new JScrollPane(editorContainer);
        editorScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        editorScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        frame.add(editorScrollPane, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        open.addActionListener(e -> fileMgr.OpenTextFile(frame, editorContainer));
        save.addActionListener(e -> fileMgr.SaveFile(editorContainer));
        saveAs.addActionListener(e -> fileMgr.SaveFileAs(editorContainer));
    }
}
