import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class EditorGUI {
    FileManagement fileMgr = new FileManagement();

    KeyStroke saveBind = KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
    Action saveAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            fileMgr.SaveFile(editorContainer);  //  SaveAs will automatically be called if the current working file is null (new file)
        }
    };

    JFrame frame = new JFrame();
    JMenuBar menuBar = new JMenuBar();

    //  MENU BAR ITEMS
    JMenu fileMenu = new JMenu("File");
    JMenuItem optionsMenu = new JMenuItem("Options");

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
        editorContainer.setFont(editorContainer.getFont().deriveFont(18f)); //  set font size while keeping the same font
        editorContainer.getInputMap().put(saveBind, "saveAction");
        editorContainer.getActionMap().put("saveAction", saveAction);

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
        optionsMenu.addActionListener((ActionEvent e) -> new OptionsWindow());
    }
}
