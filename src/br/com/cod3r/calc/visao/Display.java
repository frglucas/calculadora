package br.com.cod3r.calc.visao;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.cod3r.calc.modelo.Memoria;
import br.com.cod3r.calc.modelo.MemoriaObservador;

@SuppressWarnings("serial")
public class Display extends JPanel implements MemoriaObservador{

	private final JLabel label;
	
	public Display() {
		Memoria.getInstancia().adicionarObservador(this);
		
		setBackground(Color.DARK_GRAY);
		label = new JLabel(Memoria.getInstancia().getTextoAtual());
		label.setForeground(Color.LIGHT_GRAY);
		label.setFont(new Font("courier", Font.PLAIN, 35));
		
		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 12));
		add(label);
	}
	
	@Override
	public void valorAlterado(String novoValor) {
		label.setText(novoValor);
	}
}
