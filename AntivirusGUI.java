import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AntivirusGUI extends JFrame {
    private JButton scanButton;
    private JTextArea logArea;

    public AntivirusGUI() {
        setTitle("Antivirus Program");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Create UI components
        scanButton = new JButton("Scan");
        logArea = new JTextArea();
        logArea.setEditable(false);

        // Add components to the frame
        add(scanButton, BorderLayout.NORTH);
        add(new JScrollPane(logArea), BorderLayout.CENTER);

        // Add action listener for scan button
        scanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scanDirectory("/path/to/directory"); // give path to directory accordingly which is
                                                     // to scan
            }
        });
    }

    private void scanDirectory(String dirPath) {
        // Implement directory scanning logic here
        // Update the log area with scan results
        logArea.append("Scanning directory: " + dirPath + "\n");
        // ...
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AntivirusGUI gui = new AntivirusGUI();
                gui.setVisible(true);
            }
        });
    }
}