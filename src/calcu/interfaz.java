package calcu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class interfaz {
    private JPanel Plantilla;
    private JPanel pantalla;
    private JPanel botones;
    private JButton a7Button;
    private JButton a4Button;
    private JButton a1Button;
    private JButton a8Button;
    private JButton a5Button;
    private JButton a2Button;
    private JButton PUNTO;
    private JButton a9Button;
    private JButton a6Button;
    private JButton a3Button;

    private JButton RESETEO;
    private JButton DIVIDIR;
    private JButton RESTAR;
    private JButton IGUAL;

    private JButton MULTIPLICAR;
    private JButton SUMAR;
    private JButton a0Button;
    private JLabel RESPUESTA;


    private  String ans;


    public interfaz() {

        ActionListener listenerNumeros = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //para los numeros
                String texto = RESPUESTA.getText() + ((JButton) e.getSource()).getText();
                RESPUESTA.setText(texto);
            }
        };
        a7Button.addActionListener(listenerNumeros);
        a4Button.addActionListener(listenerNumeros);
        a1Button.addActionListener(listenerNumeros);
        a8Button.addActionListener(listenerNumeros);
        a5Button.addActionListener(listenerNumeros);
        a2Button.addActionListener(listenerNumeros);
        a9Button.addActionListener(listenerNumeros);
        a6Button.addActionListener(listenerNumeros);
        a3Button.addActionListener(listenerNumeros);
        PUNTO.addActionListener(listenerNumeros);
        a0Button.addActionListener(listenerNumeros);
        ActionListener listenerOperaciones = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // para las operaciones
                String resultado=calculoOperaciones(RESPUESTA.getText());
                RESPUESTA.setText(resultado);
                if (e.getSource() != IGUAL) {
                    String texto = RESPUESTA.getText() + ((JButton) e.getSource()).getText();
                    RESPUESTA.setText(texto);
                }
            }
        };
        DIVIDIR.addActionListener(listenerOperaciones);
        RESTAR.addActionListener(listenerOperaciones);
        IGUAL.addActionListener(listenerOperaciones);
        MULTIPLICAR.addActionListener(listenerOperaciones);
        SUMAR.addActionListener(listenerOperaciones);
        RESETEO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RESPUESTA.setText("");

            }
        });



    }

    public String calculoOperaciones(String operacion) {
        String respuesta;
        String[] Operaciones = operacion.split("[\\+\\-X\\/]");
        if (Operaciones.length == 1) {
            respuesta = Operaciones[0];
        } else {
            float v1 = Float.parseFloat(Operaciones[0]);
            float v2 = Float.parseFloat(Operaciones[1]);
            float r;
            if (operacion.contains("+"))
                r = v1 + v2;
            else if (operacion.contains("-"))
                r = v1 - v2;
            else if (operacion.contains("X"))
                r = v1 * v2;
            else
                r = v1 / v2;
            respuesta = String.valueOf(r);
        }
        return respuesta;
    }
    public static void main(String[] args) {
        JFrame miCalculadora = new JFrame("interfaz");
        miCalculadora.setContentPane(new interfaz().Plantilla);
        miCalculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miCalculadora.pack();
        miCalculadora.setVisible(true);
    }



    }


