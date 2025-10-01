import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class DanhSachCongViec extends JFrame {
    private final JTextField inputField;
    private final JPanel listPanel;
    private final ArrayList<String> congViecList;

    public DanhSachCongViec() {
        setTitle("Danh sách công việc");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        congViecList = new ArrayList<>();

        setLayout(new BorderLayout(10, 10));
        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputField = new JTextField();
        JButton addButton = new JButton("Thêm");

        addButton.addActionListener(e -> themCongViec());

        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        add(inputPanel, BorderLayout.NORTH);

        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(listPanel);

        add(scrollPane, BorderLayout.CENTER);
    }

    private void themCongViec() {
        String congViec = inputField.getText().trim();
        if (!congViec.isEmpty()) {
            congViecList.add(congViec);
            inputField.setText("");
            capNhatDanhSach();
        }
    }

    private void xoaCongViec(int index) {
        congViecList.remove(index);
        capNhatDanhSach();
    }

    private void capNhatDanhSach() {
        listPanel.removeAll();

        for (int i = 0; i < congViecList.size(); i++) {
            String task = congViecList.get(i);
            int index = i;

            JPanel taskPanel = new JPanel(new BorderLayout(5, 5));
            taskPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

            JLabel taskLabel = new JLabel(task);
            JButton deleteButton = new JButton("Xóa");

            deleteButton.addActionListener((ActionEvent e) -> xoaCongViec(index));

            taskPanel.add(taskLabel, BorderLayout.CENTER);
            taskPanel.add(deleteButton, BorderLayout.EAST);

            listPanel.add(taskPanel);
        }

        listPanel.revalidate();
        listPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DanhSachCongViec app = new DanhSachCongViec();
            app.setVisible(true);
        });
    }
}