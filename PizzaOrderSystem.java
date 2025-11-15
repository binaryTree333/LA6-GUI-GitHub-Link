import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaOrderSystem extends JFrame {
    private JPanel mainPanel;
    private JComboBox<String> pizzaSizeChoice;
    private JComboBox<String> pizzaToppingsChoice;
    private JComboBox<String> extraCheeseChoice;
    private JLabel totalLabel;
    private JButton calculateButton;
    private JLabel cheeseLabel;
    private JLabel toppingsLabel;
    private JLabel sizeLabel;

    public PizzaOrderSystem() {
        setContentPane(mainPanel);
        setTitle("Pizza Order System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        pizzaSizeChoice.setName("pizzaSizeChoice");
        pizzaToppingsChoice.setName("pizzaToppingsChoice");
        extraCheeseChoice.setName("extraCheeseChoice");
        totalLabel.setName("totalLabel");
        calculateButton.setName("calculateButton");
        cheeseLabel.setName("cheeseLabel");
        toppingsLabel.setName("toppingsLabel");
        sizeLabel.setName("sizeLabel");

        pizzaSizeChoice.addItem("Small");
        pizzaSizeChoice.addItem("Medium");
        pizzaSizeChoice.addItem("Large");

        pizzaToppingsChoice.addItem("Mushrooms");
        pizzaToppingsChoice.addItem("Pepperoni");
        pizzaToppingsChoice.addItem("Onions");

        extraCheeseChoice.addItem("Yes");
        extraCheeseChoice.addItem("No");

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double total = 0;

                String size = (String) pizzaSizeChoice.getSelectedItem();
                if (size.equals("Small")) total += 10;
                else if (size.equals("Medium")) total += 15;
                else if (size.equals("Large")) total += 20;

                total += 2;

                String cheese = (String) extraCheeseChoice.getSelectedItem();
                if (cheese.equals("Yes")) total += 3;

                totalLabel.setText("Total: $" + total);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new PizzaOrderSystem();
    }
}
