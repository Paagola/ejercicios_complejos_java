import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

public class prueba {

    public static void main(String[] args) {

    }

    public static class RotatingFlower extends JPanel implements ActionListener {
        private double angle = 0.0; // ángulo de rotación en radianes
        private Timer timer;

        // Constructor: crea el timer con el retardo pedido por el usuario
        public RotatingFlower(int delayMs) {
            // Asegúrate de que el panel repinte continuamente
            timer = new Timer(delayMs, this);
            timer.start();
            setBackground(Color.WHITE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Configurar Graphics2D
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            int w = getWidth();
            int h = getHeight();

            // Trasladar al centro del panel
            g2.translate(w / 2, h / 2);

            // Guardamos la transformacion inicial
            AffineTransform base = g2.getTransform();

            // Rotación global de la flor
            g2.rotate(angle);

            // Dibujar pétalos usando un bucle (sin arrays)
            int petals = 8;
            for (int i = 0; i < petals; i++) {
                // Cada pétalo lo rotamos alrededor del centro según i
                AffineTransform beforePetal = g2.getTransform();
                double petalAngle = i * (2 * Math.PI / petals);
                g2.rotate(petalAngle);

                // Pétalo: una elipse desplazada hacia la derecha del centro
                g2.setColor(new Color(255, 140, 0)); // color cálido para pétalos
                g2.fillOval(80, -25, 120, 50);

                // Restaurar la transformacion para el siguiente pétalo
                g2.setTransform(beforePetal);
            }

            // Restauramos la rotación global y dibujamos el centro de la flor
            g2.setTransform(base);
            g2.translate(w / 2, h / 2); // volver a centrar
            g2.setColor(new Color(220, 180, 0));
            g2.fillOval(w / 2 - 20, h / 2 - 20, 40, 40); // no será visible; alternativa más clara abajo

            // Mejor: dibujar el centro relativo al origen (centro)
            g2.setTransform(base);
            g2.translate(w / 2, h / 2);
            g2.setColor(new Color(220, 180, 0));
            g2.fillOval(-30, -30, 60, 60);

            // Nota: colocamos la transformacion final limpia
            g2.setTransform(base);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Avanzar la rotación (en radianes)
            angle += Math.toRadians(5); // pequeños pasos; la velocidad real viene del timer
            // Mantener el ángulo en un rango razonable (no estrictamente necesario)
            if (angle > Math.PI * 2) {
                angle -= Math.PI * 2;
            }
            repaint();
        }

        // Programa principal
        public static void main(String[] args) {
            // Pedimos al usuario la velocidad (en ms entre frames) usando un diálogo
            String input = JOptionPane.showInputDialog(
                    null,
                    "Introduce el retardo entre frames en milisegundos (ej. 40). Valor por defecto 40:",
                    "Velocidad de rotación",
                    JOptionPane.QUESTION_MESSAGE);

            int delay;
            try {
                if (input == null || input.trim().isEmpty()) {
                    delay = 40; // valor por defecto si pulsa cancelar o deja vacío
                } else {
                    delay = Integer.parseInt(input.trim());
                    if (delay < 5) { // evitar valores demasiado bajos que bloqueen CPU
                        JOptionPane.showMessageDialog(null,
                                "Demasiado rápido. Se usará el mínimo de 5 ms.",
                                "Aviso",
                                JOptionPane.WARNING_MESSAGE);
                        delay = 5;
                    }
                }
            } catch (NumberFormatException ex) {
                // Manejo de excepción: si no es número, usamos el valor por defecto
                JOptionPane.showMessageDialog(null,
                        "Entrada inválida. Se usará el valor por defecto (40 ms).",
                        "Error de formato",
                        JOptionPane.ERROR_MESSAGE);
                delay = 40;
            } catch (Exception ex) {
                // Cualquier otra excepción inesperada
                JOptionPane.showMessageDialog(null,
                        "Se produjo un error inesperado. Se usará el valor por defecto (40 ms).",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                delay = 40;
            }

            final int finalDelay = delay;

            // Ejecutar la GUI en el hilo de dispatch de Swing
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JFrame frame = new JFrame("Flor Rotatoria");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    RotatingFlower panel = new RotatingFlower(finalDelay);
                    frame.getContentPane().add(panel);
                    frame.setSize(700, 700);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
            });
        }
    }
}
