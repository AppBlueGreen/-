package Test3D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseSelectView extends JPanel {
    private Main main;

    public CourseSelectView(Main main) {
        this.main = main;
        setLayout(new BorderLayout());

        // 「ステージを選択して、Start Gameを押してください」のラベル (上部配置)
        JLabel courseLabel = new JLabel("ステージを選択して、Start Gameを押してください", JLabel.CENTER);
        courseLabel.setFont(new Font("MS Gothic", Font.BOLD, 26));
        add(courseLabel, BorderLayout.NORTH);

        // 画像の読み込みとリサイズ
        ImageIcon buttonIcon1 = resizeIcon(new ImageIcon("nishi.png"), 300, 200);
        ImageIcon buttonIcon2 = resizeIcon(new ImageIcon("higashi.png"), 300, 200);

        // ボタンの作成
        JButton startButton = createImageButton(buttonIcon1);
        JButton exitButton = createImageButton(buttonIcon2);

        // ボタンのクリックイベント
        startButton.addActionListener(e -> main.showGameView()); // ゲーム開始
        exitButton.addActionListener(e -> System.exit(0)); // 終了

        JPanel startPanel = createButtonWithLabel(startButton, "西地区");
        JPanel exitPanel = createButtonWithLabel(exitButton, "東地区");

        // ボタンを横並びにするパネル
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 40)); // 間隔 50px
        buttonPanel.setOpaque(false);
        buttonPanel.add(startPanel);
        buttonPanel.add(exitPanel);

        // ボタンパネルを中央配置
        add(buttonPanel, BorderLayout.CENTER);
    }

    private JPanel createButtonWithLabel(JButton button, String text) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setOpaque(false);

        JLabel label = new JLabel(text, JLabel.CENTER);
        label.setFont(new Font("MS Gothic", Font.PLAIN, 18));

        panel.add(button, BorderLayout.CENTER);
        panel.add(label, BorderLayout.SOUTH);
        return panel;
    }
    private JButton createImageButton(ImageIcon icon) {
        JButton button = new JButton(icon);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        return button;
    }
    private ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
}
