import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FormDangKi extends JFrame {
    private final JTextField tenField;
    private final JTextField emailField;
    private final JPasswordField matKhauField;
    private final JLabel thongBaoLabel;
    private final JTextArea ketQuaArea;

    public FormDangKi() {
        setTitle("Form Đăng ký");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // căn giữa màn hình
        setLayout(new BorderLayout(10, 10));

        JPanel formPanel = new JPanel(new GridLayout(6, 1, 5, 5));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        formPanel.add(new JLabel("Tên:"));
        tenField = new JTextField();
        formPanel.add(tenField);

        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        formPanel.add(emailField);

        formPanel.add(new JLabel("Mật khẩu:"));
        matKhauField = new JPasswordField();
        formPanel.add(matKhauField);

        JButton dangKyButton = new JButton("Đăng ký");
        dangKyButton.addActionListener(this::xuLyDangKy);

        thongBaoLabel = new JLabel();
        thongBaoLabel.setForeground(Color.RED);

        ketQuaArea = new JTextArea(5, 30);
        ketQuaArea.setEditable(false);
        ketQuaArea.setLineWrap(true);
        ketQuaArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(ketQuaArea);

        JPanel topPanel = new JPanel(new BorderLayout(5, 5));
        topPanel.add(formPanel, BorderLayout.CENTER);
        topPanel.add(dangKyButton, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);
        add(thongBaoLabel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);
    }

    private void xuLyDangKy(ActionEvent e) {
        String ten = tenField.getText().trim();
        String email = emailField.getText().trim();
        String matKhau = new String(matKhauField.getPassword()).trim();

        if (ten.isEmpty() || email.isEmpty() || matKhau.isEmpty()) {
            thongBaoLabel.setText("Vui lòng điền đầy đủ thông tin!");
            ketQuaArea.setText("");
        } else {
            thongBaoLabel.setText(""); // Xóa thông báo lỗi
            ketQuaArea.setText("Thông tin đăng ký:\n");
            ketQuaArea.append("Tên: " + ten + "\n");
            ketQuaArea.append("Email: " + email + "\n");
            ketQuaArea.append("Mật khẩu: " + matKhau);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FormDangKi app = new FormDangKi();
            app.setVisible(true);
        });
    }
}