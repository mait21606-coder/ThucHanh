import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class DemKiTu {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(DemKiTu::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Bộ đếm ký tự");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Bộ đếm ký tự");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titleLabel, BorderLayout.NORTH);

        JTextArea textArea = new JTextArea(5, 30);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JLabel charCountLabel = new JLabel("Số ký tự: 0");
        charCountLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(charCountLabel, BorderLayout.SOUTH);

        textArea.getDocument().addDocumentListener(new DocumentListener() {
            private void updateCharCount() {
                int length = textArea.getText().length();
                charCountLabel.setText("Số ký tự: " + length);
                if (length > 100) {
                    charCountLabel.setForeground(Color.RED);
                    charCountLabel.setText("Số ký tự: " + length + " (Vượt quá giới hạn 100 ký tự!)");
                } else {
                    charCountLabel.setForeground(Color.BLACK);
                }
            }

            public void insertUpdate(DocumentEvent e) {
                updateCharCount();
            }

            public void removeUpdate(DocumentEvent e) {
                updateCharCount();
            }

            public void changedUpdate(DocumentEvent e) {
                updateCharCount();
            }
        });

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}