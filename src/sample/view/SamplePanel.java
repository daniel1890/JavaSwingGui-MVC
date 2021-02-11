package sample.view;

import sample.controller.SampleAppController;
import sample.model.Whatsit;
import sample.model.Widget;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SamplePanel extends JPanel {

    private SampleAppController baseController;
    private  JLabel nameLabel;
    private JLabel descriptionLabel;
    private JLabel weightLabel;
    private JLabel sizeLabel;
    private JTextField nameField;
    private JTextField descriptionField;
    private JTextField sizeField;
    private JTextField weightField;
    private JButton createWidgetButton;
    private JButton createWhatsitButton;
    private SpringLayout baseLayout;

    public SamplePanel(SampleAppController baseController) {
        this.baseController = baseController;

        nameLabel = new JLabel("Type the name of the Whatsit");
        descriptionLabel = new JLabel("Describe the Widget");
        weightLabel = new JLabel("Enter the weight for the Widget");
        sizeLabel = new JLabel("Enter the size of the Whatsit");

        nameField = new JTextField(15);
        descriptionField = new JTextField(15);
        weightField = new JTextField(10);
        sizeField = new JTextField(10);

        createWidgetButton = new JButton("Make a Widget!");
        createWhatsitButton = new JButton("Make a Whatsit!");

        baseLayout = new SpringLayout();

        setupPanel();
        setupLayout();
        setupListener();
    }

    private void setupLayout() {
        baseLayout.putConstraint(SpringLayout.SOUTH, weightLabel, -6, SpringLayout.NORTH, sizeField);
        baseLayout.putConstraint(SpringLayout.NORTH, sizeField, 140, SpringLayout.NORTH, this);
        baseLayout.putConstraint(SpringLayout.SOUTH, descriptionLabel, -6, SpringLayout.NORTH, nameField);
        baseLayout.putConstraint(SpringLayout.SOUTH, nameField, -40, SpringLayout.NORTH, sizeField);
        baseLayout.putConstraint(SpringLayout.SOUTH, sizeLabel, -6, SpringLayout.NORTH, weightField);
        baseLayout.putConstraint(SpringLayout.NORTH, weightField, 0, SpringLayout.NORTH, sizeField);
        baseLayout.putConstraint(SpringLayout.WEST, weightField, 0, SpringLayout.WEST, descriptionField);
        baseLayout.putConstraint(SpringLayout.WEST, sizeLabel, 0, SpringLayout.WEST, descriptionField);
        baseLayout.putConstraint(SpringLayout.SOUTH, nameLabel, -6, SpringLayout.NORTH, descriptionField);
        baseLayout.putConstraint(SpringLayout.NORTH, descriptionField, 0, SpringLayout.NORTH, nameField);
        baseLayout.putConstraint(SpringLayout.WEST, descriptionField, 0, SpringLayout.WEST, nameLabel);
        baseLayout.putConstraint(SpringLayout.EAST, nameLabel, -56, SpringLayout.EAST, this);
        baseLayout.putConstraint(SpringLayout.NORTH, createWhatsitButton, 0, SpringLayout.NORTH, createWidgetButton);
        baseLayout.putConstraint(SpringLayout.WEST, createWhatsitButton, 0, SpringLayout.WEST, descriptionField);
        baseLayout.putConstraint(SpringLayout.WEST, createWidgetButton, 0, SpringLayout.WEST, nameField);
        baseLayout.putConstraint(SpringLayout.SOUTH, createWidgetButton, -27, SpringLayout.SOUTH, this);
        baseLayout.putConstraint(SpringLayout.WEST, weightLabel, 55, SpringLayout.WEST, this);
        baseLayout.putConstraint(SpringLayout.WEST, descriptionLabel, 55, SpringLayout.WEST, this);
        baseLayout.putConstraint(SpringLayout.WEST, sizeField, 55, SpringLayout.WEST, this);
        baseLayout.putConstraint(SpringLayout.WEST, nameField, 55, SpringLayout.WEST, this);
    }

    private void setupPanel() {
    	this.setSize(500, 500);
        this.setLayout(baseLayout);
        this.add(createWhatsitButton);
        this.add(createWidgetButton);
        this.add(descriptionField);
        this.add(nameField);
        this.add(sizeField);
        this.add(weightField);
        this.add(descriptionLabel);
        this.add(nameLabel);
        this.add(sizeLabel);
        this.add(weightLabel);
    }
    
    private boolean checkInteger(String currentInput) {
    	boolean isInteger = false;
    	
    	try {
    		
    		Integer.parseInt(currentInput);
    		isInteger = true;
    		
    	}
    	catch(NumberFormatException currentException) {
    		
    		JOptionPane.showMessageDialog(this, "Please type an integer in the size field");
    		
    	}
    	
    	return isInteger;
    }
    
    private boolean checkDouble(String currentInput) {
    	boolean isDouble = false;
    	
    	try {
    		
    		Double.parseDouble(currentInput);
    		isDouble = true;
    		
    	}
    	catch(NumberFormatException currentException) {
    		
    		JOptionPane.showMessageDialog(this, "Please type a double in the weight field");
    		
    	}
    	
    	return isDouble;
    }

    private void setupListener() {
    	
    	createWidgetButton.addActionListener(new ActionListener() {
    		
    		public void actionPerformed(ActionEvent click) {
    			String description = descriptionField.getText();
    			double currentWeight = 0.0;
    			
    			if (checkDouble(sizeField.getText())) {
    				currentWeight = Double.parseDouble(sizeField.getText());

    				if (baseController.getAppFactory().makeWidget(currentWeight, description)) {
    					JOptionPane.showMessageDialog(baseController.getAppFrame(), "Congrats, you made a widget!");
    					baseController.getAppFactory().makeWidget(currentWeight, description);
    				}
    				else {
    					JOptionPane.showMessageDialog(baseController.getAppFrame(), "Sorry, not enough resources to make a widget!");
    				}
    			}
    		}
    	});
    	
    	createWhatsitButton.addActionListener(new ActionListener() {
    		
    		public void actionPerformed(ActionEvent click) {
    			String name = nameField.getText();
    			int size = 0;
    			
    			if (checkInteger(sizeField.getText())) {
    				size = Integer.parseInt(sizeField.getText());
        			
    				if (baseController.getAppFactory().makeWhatsit(size, name)) {
    					JOptionPane.showMessageDialog(baseController.getAppFrame(), "Congrats, you made a whatsit!");
    					baseController.getAppFactory().makeWhatsit(size, name);
    				}
    				else {
    					JOptionPane.showMessageDialog(baseController.getAppFrame(), "Sorry, not enough resources to make a whatsit!");
    				}
    			}
    		}
    	});
    }
}
