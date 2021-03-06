package com.robotz.view.dialog;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.robotz.view.EditorJFrame;

public abstract class AddDialog extends JDialog {
	
	private static final long serialVersionUID = 1L;
	
	protected JButton acceptButton = new JButton("Ok");
	protected JButton cancelButton = new JButton("Cancel");
	
	protected JPanel mainPanel = new JPanel();
	protected GridBagConstraints c = new GridBagConstraints();
	
	protected JTextField variableTextField = new JTextField(20);
	protected JTextField xPositionTextField = new JTextField(20);
	protected JTextField yPositionTextField = new JTextField(20);
	protected JComboBox directionField = new JComboBox();

	protected boolean dialogResult;
	
	public AddDialog(EditorJFrame frmMain) {
		setVisible(false);
		setModal(true);
		mainPanel.setLayout(new GridBagLayout());
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		initComponent();
		setTitle();
		setLayout(new BorderLayout());
		add(mainPanel, BorderLayout.CENTER);
		acceptButton.setEnabled(false);
		pack();
		initListener();
		setLocationRelativeTo(frmMain);
	}

	private void initListener() {
		acceptButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dialogResult = true;
				setVisible(false);
			}
			
		});
		
		cancelButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dialogResult = false;
				setVisible(false);
			}
			
		});
		
		xPositionTextField.getDocument().addDocumentListener(new DocumentListener(){

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				checkInput();
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				checkInput();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				checkInput();
			}
			
		});
		
		yPositionTextField.getDocument().addDocumentListener(new DocumentListener(){

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				checkInput();
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				checkInput();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				checkInput();
			}
			
		});
		
		variableTextField.getDocument().addDocumentListener(new DocumentListener(){

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				checkInput();
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				checkInput();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				checkInput();
			}
			
		});
		
		directionField.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				checkInput();
			}
			
		});
	}
	
	protected abstract void checkInput();
	
	protected abstract void setTitle();
	
	protected abstract void initComponent();
	
	public abstract String[] getResult();
	
	public boolean showDialog() {
		setVisible(true);
		return dialogResult;
	}

}
