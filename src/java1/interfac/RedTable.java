package java1.interfac;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;



public class RedTable {
	public static ImageIcon image;
	public static JFrame frame;

	// this.EXIT_ON_CLOSE;
	RedTable() {
		image = new ImageIcon(getClass().getResource("2.jpg"));
	}

	public void stvor() {
		frame = new JFrame();
		frame.setTitle("Туристичне агенство");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		Font font = new Font("TimesRoman", Font.BOLD, 16);
		JLabel label = new JLabel();
		label.setLayout(new GridBagLayout());
		label.setVisible(true);
		label.setIcon(image);
		frame.add(label);
		frame.setVisible(true);

		TableModalRed tmq2 = new TableModalRed();
		JTable table = new JTable(tmq2);

		JScrollPane tableScrollPane = new JScrollPane(table);
		tmq2.addData();
		int shur=0;
		if((19 + tmq2.getRowCount() * 24)>550){
			shur = 550;
		}
		else{
			shur=19 + tmq2.getRowCount() * 24;
		}
		tableScrollPane.setPreferredSize(new Dimension(780, shur));
		System.out.println(tmq2.getRowCount());
		tableScrollPane.setBackground(Color.BLUE);
		table.setFont(font);
		table.setRowHeight(24);
		ListSelectionModel modal = table.getSelectionModel();

		label.add(tableScrollPane, new GridBagConstraints(0, 0, 4, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

	}




}
