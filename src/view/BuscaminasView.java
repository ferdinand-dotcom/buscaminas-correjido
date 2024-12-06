package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BuscaminasView {
	private JFrame frame;
	private JButton[][] botones;
	private JTextArea textArea;
	private static final int FILAS = 10;
	private static final int COLUMNAS = 10;

	// Constructor que inicializa la interfaz gráfica del juego
	public BuscaminasView() {
		frame = new JFrame("Buscaminas");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		JPanel panelTablero = new JPanel();
		panelTablero.setLayout(new GridLayout(FILAS, COLUMNAS));
		frame.add(panelTablero, BorderLayout.CENTER);

		botones = new JButton[FILAS][COLUMNAS];
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				botones[i][j] = new JButton("■");
				botones[i][j].setFont(new Font("Arial", Font.PLAIN, 20));
				botones[i][j].setFocusPainted(false);
				botones[i][j].setBackground(Color.LIGHT_GRAY);
				panelTablero.add(botones[i][j]);
			}
		}

		textArea = new JTextArea(3, 30);
		textArea.setEditable(false);
		frame.add(new JScrollPane(textArea), BorderLayout.SOUTH);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	// Método para establecer el ActionListener de un botón específico
	public void setButtonActionListener(int fila, int columna, ActionListener listener) {
		botones[fila][columna].addActionListener(listener);
	}

	// Método para actualizar el texto y color de un botón específico
	public void actualizarBoton(int fila, int columna, String texto, Color color) {
		botones[fila][columna].setText(texto);
		botones[fila][columna].setBackground(color);
		botones[fila][columna].setEnabled(false);
	}

	// Método para mostrar un mensaje en el área de texto
	public void mostrarMensaje(String mensaje) {
		textArea.setText(mensaje);
	}

	// Método para obtener la matriz de botones
	public JButton[][] getBotones() {
		return botones;
	}
}
