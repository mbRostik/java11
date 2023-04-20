import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Lab11 extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextArea resultTextArea;

    public Lab11() {
        super("Tablucia fynkcii");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel inputPanel = new JPanel();
        JLabel aLabel = new JLabel("Vvedit A: ");
        JTextField aTextField = new JTextField(10);
        JButton calculateButton = new JButton("Calculate");

        inputPanel.add(aLabel);
        inputPanel.add(aTextField);
        inputPanel.add(calculateButton);

        resultTextArea = new JTextArea(15, 40);
        JScrollPane scrollPane = new JScrollPane(resultTextArea);

        Container c = getContentPane();
        c.add(inputPanel, BorderLayout.NORTH);
        c.add(scrollPane, BorderLayout.CENTER);

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double a = Double.parseDouble(aTextField.getText());
                calculateTable(a);
            }
        });
    }

    private void calculateTable(double a) {
        resultTextArea.setText("");
        resultTextArea.append("X\tY\n");
        for (double x = 0; x <= 10; x += 0.5) {
            double y = a * Math.sqrt(x) * Math.sin(a * x);
            resultTextArea.append(String.format("%.2f\t%.4f\n", x, y));
        }
    }

    public static void main(String[] args) {
        Lab11 functionTable = new Lab11();
        functionTable.setVisible(true);
    }

}
