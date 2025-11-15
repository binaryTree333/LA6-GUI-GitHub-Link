import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberCounter extends JFrame {
    private JLabel countLabel;
    private JButton increaseButton;
    private JButton decreaseButton;
    private JPanel MainPanel;
    private int count = 0;

    public NumberCounter() {
        setContentPane(MainPanel);
        setTitle("Number Counter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        countLabel.setName("countLabel");
        increaseButton.setName("increaseButton");
        decreaseButton.setName("decreaseButton");

        countLabel.setText(String.valueOf(count));

        increaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                countLabel.setText(String.valueOf(count));
            }
        });

        decreaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count--;
                countLabel.setText(String.valueOf(count));
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new NumberCounter();
    }
}
