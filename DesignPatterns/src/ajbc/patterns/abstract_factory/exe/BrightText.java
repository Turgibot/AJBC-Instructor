package ajbc.patterns.abstract_factory.exe;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BrightText implements Text {
	JPanel panel = new JPanel();
    JFrame frame = new JFrame();
    JButton button;
	@Override
	public void render() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Bright Text - Dark Theme");
        label.setOpaque(true);
        label.setBackground(new Color(0, 0, 0));
        label.setForeground(new Color(255, 255, 255));
        label.setFont(new Font("", Font.BOLD, 44));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.getContentPane().add(panel);
        panel.add(label);
        onClick();
        panel.add(button);

        frame.setSize(550, 150);
        frame.setVisible(true);
        onClick();
	}

	@Override
	public void onClick() {
		button = new JButton("Exit");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                System.exit(0);
            }
        });
	}

}
