package calculadora;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class VCalculadora {
    public static void main(String[] args) {
        Ensamblar vCalc = new Ensamblar();
        vCalc.setVisible(true);
    }
}

class Ensamblar extends JFrame {
    int suma;
    int acumula;

    public Ensamblar() {
        super("Calculadora");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Creación panel del TExto numérico y botón

        JPanel jpnl1 = new JPanel(),
                jpnl2 = new JPanel();
        JLabel lblresul = new JLabel("0", SwingConstants.RIGHT);

        JButton btnresul = new JButton("RESULTADO");
        ArrayList<JButton> tecla = new ArrayList<JButton>();
        String etiquetaBoton[] =

                { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "C", "0", ".", "+" };

        int iresul = 0;
        // Montaje del primer Jpanel
        jpnl1.setLayout(new GridLayout(2, 1, 3, 3));
        jpnl1.add(lblresul);
        jpnl1.add(btnresul);
        btnresul.addActionListener(new ClickNumer(btnresul,

                lblresul));

        // Creación de los botones en el ArrayList
        for (int iconta = 0; iconta <= 15; iconta++) {
            tecla.add(new

            JButton(String.valueOf(etiquetaBoton[iconta])));

            tecla.get(iconta).addActionListener(new

            ClickNumer(tecla.get(iconta), lblresul));

        }
        // Montaje del segundo panel
        jpnl2.setLayout(new GridLayout(4, 4, 3, 3));
        for (int iconta = 0; iconta <= 15; iconta++)
            jpnl2.add(tecla.get(iconta));
        getContentPane().add(jpnl1, BorderLayout.NORTH);
        getContentPane().add(jpnl2, BorderLayout.SOUTH);
    }

    class ClickNumer implements ActionListener {
        JButton bt;
        JLabel lb;
        String btnOpera = "/*-+.C";

        public ClickNumer(JButton boton, JLabel display) {
            bt = boton;
            lb = display;
        }

        public void actionPerformed(ActionEvent e) {
            switch (bt.getText()) {
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                    suma = Integer.valueOf(lb.getText()

                            + bt.getText());

                    lb.setText(String.valueOf(suma));
                    break;
                case "C":
                    lb.setText("0");
                    suma = 0;
                    break;
                case "+":

                    acumula =

                            Integer.valueOf(lb.getText());

                    lb.setText("0");
                    break;
                case "RESULTADO":
                    acumula = acumula +

                            Integer.valueOf(lb.getText());
                    lb.setText(String.valueOf(acumula));

                    break;

            }
        }
    }
}
