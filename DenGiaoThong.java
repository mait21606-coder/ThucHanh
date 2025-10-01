import javax.swing.*;
import java.awt.*;

public class DenGiaoThong extends JFrame {
    private int currentLight = 0;
    private final JPanel redLight = new JPanel();
    private final JPanel yellowLight = new JPanel();
    private final JPanel greenLight = new JPanel();

    private final Timer autoSwitchTimer;

    public DenGiaoThong() {
        setTitle("Đèn Giao Thông");
        setSize(200, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel lightPanel = new JPanel();
        lightPanel.setLayout(new GridLayout(3, 1, 10, 10));
        lightPanel.setBackground(Color.DARK_GRAY);
        lightPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        setupLightPanel(redLight, Color.RED);
        setupLightPanel(greenLight, Color.GREEN);
        setupLightPanel(yellowLight, Color.YELLOW);

        lightPanel.add(redLight);
        lightPanel.add(greenLight);
        lightPanel.add(yellowLight);

        JButton switchButton = new JButton("Chuyển đèn");
        switchButton.addActionListener(e -> switchLight());

        add(lightPanel, BorderLayout.CENTER);
        add(switchButton, BorderLayout.SOUTH);

        updateLights();

        autoSwitchTimer = new Timer(2000, e -> switchLight());
        autoSwitchTimer.start();
    }

    private void setupLightPanel(JPanel panel, Color color) {
        panel.setBackground(Color.BLACK);
        panel.setPreferredSize(new Dimension(50, 50));
        panel.setOpaque(true);
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
    }

    private void switchLight() {
        currentLight = (currentLight + 1) % 3;
        updateLights();
    }

    private void updateLights() {
        redLight.setBackground(currentLight == 0 ? Color.RED : Color.BLACK);
        greenLight.setBackground(currentLight == 1 ? Color.GREEN : Color.BLACK);
        yellowLight.setBackground(currentLight == 2 ? Color.YELLOW : Color.BLACK);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DenGiaoThong frame = new DenGiaoThong();
            frame.setVisible(true);
        });
    }
}
