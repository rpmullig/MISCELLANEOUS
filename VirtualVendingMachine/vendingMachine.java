import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.*;

import java.awt.FlowLayout;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;


 

public class vendingMachine extends JFrame {
	
	private JButton waterButton;
	private JButton rootBeerButton;
	private JButton drPepperButton;
	private JButton pepsiButton;
	private JButton dietPepsiButton;
	private JButton mountainDewButton;



	public vendor_machine v = new vendor_machine();

		
	private JPanel contentPane;
	private JTextField textField;
	private static int [] inventory;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		inventory = textFileReader.fileRead(true);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vendingMachine frame = new vendingMachine();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public vendingMachine() {
		
		
		setTitle("Vending Machine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToggleButton quarterButton = new JToggleButton("Quarter");
		quarterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				v.pay(0.25);
				textField.setText("" + v.paid());
				//if(v.enough() == true) {turnOnButtons();} 
				
			}
		});
		
		
		quarterButton.setBounds(27, 40, 97, 25);
		contentPane.add(quarterButton);
		
		JButton dollarButton = new JButton("Dollar");
		dollarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				v.pay(1.00);
				textField.setText("" + v.paid());
				//if(v.enough() == true) { turnOnButtons(); } 
				
			}
		});
		
		
		dollarButton.setBounds(27, 78, 97, 25);
		contentPane.add(dollarButton);
		
		JButton refundButton = new JButton("Refund");
		refundButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			v.refund();
			textField.setText("" + v.paid());
			}
		});
		refundButton.setBounds(27, 150, 97, 25);
		contentPane.add(refundButton);
		
		JButton pepsiButton = new JButton("Pepsi");
		pepsiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(v.paid() >= 1  && inventory[0] >= 0) { v.buy("Pepsi");textField.setText(""+v.paid());textFileReader.updateFile(0, inventory[0]);} 
			if(inventory[0] <= 0 ) {System.out.println("Out of Stock");}
			inventory = textFileReader.fileRead(false);
			}
		});
		pepsiButton.setEnabled(true);
		pepsiButton.setSelected(true);
		pepsiButton.setBounds(186, 13, 113, 25);
		contentPane.add(pepsiButton);
		
		JButton dietPepsiButton = new JButton("Diet Pepsi");
		dietPepsiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(v.paid() >= 1 && inventory[1] >= 0) { v.buy("Diet Pepsi");textField.setText(""+v.paid()); textFileReader.updateFile(1, inventory[1]); } 
				if(inventory[1] <= 0 ) {System.out.println("Out of Stock");}
				inventory = textFileReader.fileRead(false);
			}
		});
		dietPepsiButton.setEnabled(true);
		
		dietPepsiButton.setBounds(186, 52, 113, 25);
		contentPane.add(dietPepsiButton);
		
		JButton mountainDewButton = new JButton("Mountain Dew");
		mountainDewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(v.paid() >= 1  && inventory[2] >= 0) { v.buy("Mountain Dew");textField.setText(""+v.paid());textFileReader.updateFile(2, inventory[2]);} 
				if(inventory[2] <= 0 ) {System.out.println("Out of Stock");}
				inventory = textFileReader.fileRead(false);
			}
		});
		mountainDewButton.setEnabled(true);
		
		mountainDewButton.setBounds(186, 126, 113, 25);
		contentPane.add(mountainDewButton);
		
		JButton drPepperButton = new JButton("Dr. Pepper");
		drPepperButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(v.paid() >= 1  && inventory[3] >= 0) { v.buy("Dr. Pepper");textField.setText(""+v.paid()); textFileReader.updateFile(3, inventory[3]);} 
				if(inventory[3] <= 0 ) {System.out.println("Out of Stock");}
				inventory = textFileReader.fileRead(false);
			}
		});
		drPepperButton.setEnabled(true);
		
		drPepperButton.setBounds(186, 88, 113, 25);
		contentPane.add(drPepperButton);
		
		JButton rootBeerButton = new JButton("Root Beer");
		rootBeerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(v.paid() >= 1  && inventory[4] >= 0) { v.buy("Root Beer");textField.setText(""+v.paid()); textFileReader.updateFile(4, inventory[4]);} 
				if(inventory[4] <= 0 ) {System.out.println("Out of Stock");}
				inventory = textFileReader.fileRead(false);
			}
		});
		rootBeerButton.setEnabled(true);
		
		rootBeerButton.setBounds(186, 166, 113, 25);
		contentPane.add(rootBeerButton);

		JButton waterButton = new JButton("Water");
		waterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(v.paid() >= 1  && inventory[5] >= 0) { v.buy("Water"); textField.setText(""+v.paid());textFileReader.updateFile(5, inventory[5]);} 
				if(inventory[5] <= 0 ) {System.out.println("Out of Stock");}
				inventory = textFileReader.fileRead(false);
			}
		});
		waterButton.setEnabled(true);
		
		waterButton.setBounds(186, 203, 113, 25);
		contentPane.add(waterButton);
		
		textField = new JTextField();
		textField.setText("$0.00");
		textField.setBounds(27, 116, 97, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnReport = new JButton("Report");
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = textFileReader.getFile();
				reportForm.report(s);
			}
		});
		btnReport.setBounds(323, 150, 97, 25);
		contentPane.add(btnReport);
			
	
	}

public void turnOnButtons() {	

	waterButton.setSelected(false);
	rootBeerButton.setSelected(false);
	drPepperButton.setSelected(false);
	pepsiButton.setSelected(false);
	dietPepsiButton.setSelected(false);
	mountainDewButton.setSelected(false);
	
}

public void turnOffButtons() {
	waterButton.setSelected(true);
	rootBeerButton.setSelected(true);
	drPepperButton.setSelected(true);
	pepsiButton.setSelected(true);
	dietPepsiButton.setSelected(true);
	mountainDewButton.setSelected(true);
	}
}



