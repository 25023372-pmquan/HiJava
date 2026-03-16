package Shipment;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShipmentApp {
    static ShippingMethodType currentShippingMethodType;
    public static void main(String[] args){
        // panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
        JLabel priceLabel = new JLabel();
        JLabel errorLabel = new JLabel();
        // weightText
        JLabel selectShippingMethodLabel = new JLabel();
        selectShippingMethodLabel.setText("select method shipping");
        mainPanel.add(selectShippingMethodLabel);
        ButtonGroup buttonGroup = new ButtonGroup();
        ShippingMethodType[] shippingMethodTypes = ShippingMethodType.values();
        for(ShippingMethodType shippingMethodType : shippingMethodTypes){
            JRadioButton radioButton = new JRadioButton();
            radioButton.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    currentShippingMethodType = shippingMethodType;
                }
            });
            radioButton.setText(shippingMethodType.getShippingMethodName());
            buttonGroup.add(radioButton);
            mainPanel.add(radioButton);
        }
        // car ship radio button
//        JRadioButton carShippingMethod = new JRadioButton();
//        carShippingMethod.setText("car");
//        mainPanel.add(carShippingMethod);
//
//        JRadioButton shipShippingMethod = new JRadioButton();
//        shipShippingMethod.setText("ship");
//        mainPanel.add(shipShippingMethod);


//        buttonGroup.add(carShippingMethod);
//        buttonGroup.add(shipShippingMethod);

        // weight
        mainPanel.add(new JLabel("weight"));
        JTextField weightTextField = new JTextField();
        weightTextField.setMaximumSize(new Dimension(400,40));
        mainPanel.add(weightTextField);
        // distance
        mainPanel.add(new JLabel("distance"));
        JTextField distanceTextField = new JTextField();
        distanceTextField.setMaximumSize(new Dimension(400,40));
        mainPanel.add(distanceTextField);
        // button
        JButton estimatePriceButton = new JButton();
        estimatePriceButton.setText("estimate price button");
        mainPanel.add(estimatePriceButton);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int weight = 0;
                int distance = 0;
                errorLabel.setText("");
                mainPanel.add(errorLabel);
                try {
                    String weightText = weightTextField.getText();
                    weight = Integer.parseInt(weightText);
                    String distanceText = distanceTextField.getText();
                    distance = Integer.parseInt(distanceText);
                }catch (NumberFormatException exception){
                    errorLabel.setText("only number!!");
                    mainPanel.add(errorLabel);}

//                if(carShippingMethod.isSelected()){
//                   shippingMethod = new CarShippingMethod();
//
//                }
//                else if(shipShippingMethod.isSelected()){
//                    shippingMethod = new ShipShippingMethod();
//
//                }
                ShippingMethod shippingMethod = ShippingMethod.from(currentShippingMethodType);
               String price =  shippingMethod.estimatePrice(weight, distance);
               priceLabel.setText(price);
            }
        };
        estimatePriceButton.addActionListener(listener);
        mainPanel.add(priceLabel);
        mainPanel.add(errorLabel);
        JFrame frame = new JFrame("Shipment Fee");
        frame.setSize(400,400);
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
