/*
Znajomoœæ wartoœci kolorów wyra¿onych przy u¿yciu palety barw RGB niezbêdna jest w szczególnoœci programistom zajmuj¹cym siê projektowaniem stron internetowych.
Utwórz aplikacjê, która prezentowa³a bêdzie dowolny kolor wyra¿ony za pomoc¹ trzech liczb ca³kowitych z przedzia³u 0..255.
Wartoœci te powinny zostaæ ustalone poprzez zmianê po³o¿enia 3 suwaków, jak pokazano na rysunku poni¿ej.
Wyœwietl w oknie aplikacji kod koloru w wymaganym przez jêzyk HTML zapisie szesnastkowym (np. kolor czerwony: #FF0000).
*/

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class GeneratorKolorow extends JFrame implements ChangeListener {
	private JLabel suwaki, kodKoloru;
	private JSlider r, g, b;;
	private JTextField kolor;
	private JPanel kolorek;
	private int tempR, tempG, tempB;

	GeneratorKolorow() {
		super("Generator kolorów");
		setSize(320, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(null);
		setResizable(false);

		r = new JSlider(0, 255, 0);
		r.setBounds(10, 50, 300, 50);
		r.setMajorTickSpacing(50);
		r.setMinorTickSpacing(5);
		r.setPaintTicks(true);
		r.setPaintLabels(true);
		r.addChangeListener(this);
		add(r);

		g = new JSlider(0, 255, 0);
		g.setBounds(10, 100, 300, 50);
		g.setMajorTickSpacing(50);
		g.setMinorTickSpacing(5);
		g.setPaintTicks(true);
		g.setPaintLabels(true);
		g.addChangeListener(this);
		add(g);

		b = new JSlider(0, 255, 0);
		b.setBounds(10, 150, 300, 50);
		b.setMajorTickSpacing(50);
		b.setMinorTickSpacing(5);
		b.setPaintTicks(true);
		b.setPaintLabels(true);
		b.addChangeListener(this);
		add(b);

		suwaki = new JLabel("Suwaki R-G-B (0-255)");
		suwaki.setBounds(10, 20, 200, 20);
		add(suwaki);

		kodKoloru = new JLabel("Kod koloru: ");
		kodKoloru.setBounds(10, 200, 100, 50);
		add(kodKoloru);

		kolor = new JTextField("#000");
		kolor.setBounds(10, 235, 68, 30);
		kolor.setEditable(false);
		add(kolor);

		kolorek = new JPanel();
		kolorek.setBounds(0, 275, 320, 100);
		kolorek.setBackground(Color.BLACK);
		add(kolorek);
	}

	public void stateChanged(ChangeEvent e) {
		tempR = r.getValue();
		tempG = g.getValue();
		tempB = b.getValue();

		kolor.setText("#" + Integer.toHexString(tempR) + Integer.toHexString(tempG) + Integer.toHexString(tempB));
		Color kolorTla = new Color(tempR, tempG, tempB);
		kolorek.setBackground(kolorTla);
	}

	public static void main(String[] args) {
		GeneratorKolorow aplikacja = new GeneratorKolorow();
		aplikacja.setVisible(true);
	}
}
