import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulario {
    private JPanel root;
    private JTextField lblDisplay;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btnMultiply;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btnDivision;
    private JButton btnSubtraction;
    private JButton btnAdd;
    private JButton btn0;
    private JButton btnDot;
    private JButton btnEqual;
    private JButton btnReset;

    public Formulario() {
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblDisplay.setText("");
            }
        });
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = lblDisplay.getText() + ((JButton)e.getSource()).getText();
                lblDisplay.setText(texto);
            }
        };
        btn5.addActionListener(listener);
        btn7.addActionListener(listener);
        btn9.addActionListener(listener);
        btn1.addActionListener(listener);
        btn2.addActionListener(listener);
        btn3.addActionListener(listener);
        btnDot.addActionListener(listener);
        btn0.addActionListener(listener);
        btn8.addActionListener(listener);
        btn4.addActionListener(listener);
        btn6.addActionListener(listener);
        
        ActionListener listenerOperaciones = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resultado = calcular(lblDisplay.getText());
                lblDisplay.setText(resultado);

                if (e.getSource() != btnEqual) {
                    String texto = lblDisplay.getText() + ((JButton) e.getSource()).getText();
                    lblDisplay.setText(texto);
                }
            }
        };
        btnMultiply.addActionListener(listenerOperaciones);
        btnDivision.addActionListener(listenerOperaciones);
        btnSubtraction.addActionListener(listenerOperaciones);
        btnEqual.addActionListener(listenerOperaciones);
        btnAdd.addActionListener(listenerOperaciones);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Formulario");
        frame.setContentPane(new Formulario().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    public String calcular(String operacion) {
        String resultado;
        String[] ops = operacion.split("[\\+\\-x\\/]");
        if (ops.length == 1) {
            resultado = ops[0];
        } else {
            float v1 = Float.parseFloat(ops[0]);
            float v2 = Float.parseFloat(ops[1]);
            float r;
            if (operacion.contains("+")) {
                r = v1 + v2;
            } else if ( operacion.contains("-")) {
                r = v1 - v2;
            } else if (operacion.contains("x")) {
                r = v1 * v2;
            } else  {
                r = v1 / v2;
            }
            resultado = String.valueOf(r);
        }
        return resultado;
    }
}
