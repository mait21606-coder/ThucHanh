import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

class SanPham {
    int id;
    String name;
    int price;

    public SanPham(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class GioHang extends JFrame {
    private final JLabel gioHangLabel;
    private final java.util.List<SanPham> cart = new ArrayList<>();
    private final java.util.List<SanPham> products = new ArrayList<>();

    public GioHang() {
        setTitle("Giỏ hàng");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        products.add(new SanPham(1, "Bút chì", 5000));
        products.add(new SanPham(2, "Máy tính", 200000));
        products.add(new SanPham(3, "Sách", 30000));

        gioHangLabel = new JLabel("Giỏ hàng: 0 sản phẩm, tổng tiền: 0");
        gioHangLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gioHangLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(gioHangLabel, BorderLayout.NORTH);

        JPanel productPanel = new JPanel();
        productPanel.setLayout(new BoxLayout(productPanel, BoxLayout.Y_AXIS));
        productPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (SanPham sp : products) {
            JPanel spPanel = new JPanel(new BorderLayout(5, 5));
            spPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

            JLabel nameLabel = new JLabel(sp.name + " - Giá: " + sp.price + "đ");
            JButton addButton = new JButton("Thêm vào giỏ");

            addButton.addActionListener((ActionEvent e) -> {
                cart.add(sp);
                capNhatGioHang();
            });

            spPanel.add(nameLabel, BorderLayout.CENTER);
            spPanel.add(addButton, BorderLayout.EAST);

            productPanel.add(spPanel);
        }

        JScrollPane scrollPane = new JScrollPane(productPanel);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void capNhatGioHang() {
        int soLuong = cart.size();
        int tongTien = cart.stream().mapToInt(sp -> sp.price).sum();
        gioHangLabel.setText("Giỏ hàng: " + soLuong + " sản phẩm, tổng tiền: " + tongTien + "đ");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GioHang app = new GioHang();
            app.setVisible(true);
        });
    }
}
