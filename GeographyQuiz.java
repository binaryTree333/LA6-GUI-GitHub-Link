import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeographyQuiz extends JFrame {
    private JPanel rootPanel, panel1, panel2, panel3, panel4;
    private JTextField question1TextField, question2TextField, question3TextField;
    private JLabel scoreLabel1, scoreLabel2, scoreLabel3, scoreLabel4;
    private JButton nextButton1, nextButton2, nextButton3;
    private JButton backButton2, backButton3, backButton4;
    private JLabel questionLabel1, questionLabel2, questionLabel3;
    private int score = 0;

    public GeographyQuiz() {
        setTitle("Geography Quiz");
        setContentPane(rootPanel);
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel1.setName("panel1");
        panel2.setName("panel2");
        panel3.setName("panel3");
        panel4.setName("panel4");



        question1TextField.setName("question1TextField");
        question2TextField.setName("question2TextField");
        question3TextField.setName("question3TextField");

        scoreLabel1.setName("scoreLabel");
        scoreLabel2.setName("scoreLabel");
        scoreLabel3.setName("scoreLabel");
        scoreLabel4.setName("scoreLabel");

        nextButton1.setName("nextButton");
        nextButton2.setName("nextButton");
        nextButton3.setName("nextButton");

        backButton2.setName("backButton");
        backButton3.setName("backButton");
        backButton4.setName("backButton");

        questionLabel1.setText("What is the capital of France?");
        questionLabel2.setText("What is the capital of Japan?");
        questionLabel3.setText("What is the capital of Germany?");

        updateScoreLabels();

        CardLayout cl = (CardLayout) rootPanel.getLayout();

        rootPanel.add(panel1, "panel1");
        rootPanel.add(panel2, "panel2");
        rootPanel.add(panel3, "panel3");
        rootPanel.add(panel4, "panel4");

        cl.show(rootPanel, "panel1");


        nextButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswers();
                cl.show(rootPanel, "panel2");
            }
        });

        nextButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswers();
                cl.show(rootPanel, "panel3");
            }
        });

        nextButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswers();
                cl.show(rootPanel, "panel4");
            }
        });

        // Back buttons
        backButton2.addActionListener(e -> cl.show(rootPanel, "panel1"));
        backButton3.addActionListener(e -> cl.show(rootPanel, "panel2"));
        backButton4.addActionListener(e -> cl.show(rootPanel, "panel3"));
    }

    private void checkAnswers() {
        int tempScore = 0;

        if (question1TextField.getText().trim().equalsIgnoreCase("Paris"))
            tempScore++;
        if (question2TextField.getText().trim().equalsIgnoreCase("Tokyo"))
            tempScore++;
        if (question3TextField.getText().trim().equalsIgnoreCase("Berlin"))
            tempScore++;

        score = tempScore;
        updateScoreLabels();
    }

    private void updateScoreLabels() {
        String text = "Your Score: " + score + "/3";
        scoreLabel1.setText(text);
        scoreLabel2.setText(text);
        scoreLabel3.setText(text);
        scoreLabel4.setText(text);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GeographyQuiz quiz = new GeographyQuiz();
            quiz.setVisible(true);
        });
    }
}
