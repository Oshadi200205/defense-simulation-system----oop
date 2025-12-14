import javax.swing.*;
import java.awt.*;

public class Submarine implements DefenceController {
   JLabel lblStatus;
   JTextArea displayArea;
   JTextField inputField;
   JButton shootButton;
   JButton sonarButton;
   JButton tomahawkButton;
   JButton tridentButton;

   Submarine() {
        JFrame frame = new JFrame("Submarine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        lblStatus  = new JLabel("Area Not Cleared");
        lblStatus.setFont(new Font("Arial", Font.BOLD, 14));
        lblStatus.setBounds(20, 10, 200, 30);
        frame.add(lblStatus);

        shootButton = new JButton("Shoot");
        shootButton.setBounds(20, 40, 150, 30);
        frame.add(shootButton);

        sonarButton = new JButton("Sonar Operation");
        sonarButton.setBounds(180, 40, 150, 30);
        frame.add(sonarButton);

        tomahawkButton = new JButton("Tomahawk Mi...");
        tomahawkButton.setBounds(20, 80, 150, 30);
        frame.add(tomahawkButton);

        tridentButton = new JButton("Trident-2 Missile");
        tridentButton.setBounds(180, 80, 150, 30);
        frame.add(tridentButton);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBounds(20, 120, 450, 150);
        frame.add(scrollPane);

        inputField = new JTextField();
        inputField.setBounds(20, 280, 370, 30);
        frame.add(inputField);

        JButton sendButton = new JButton("Send");
        sendButton.setBounds(400, 280, 70, 30);
        frame.add(sendButton);

        JLabel soldierLabel = new JLabel("Soldier Count:");
        soldierLabel.setBounds(500, 40, 100, 20);
        frame.add(soldierLabel);

        JSpinner soldierSpinner = new JSpinner();
        soldierSpinner.setBounds(600, 40, 50, 20);
        frame.add(soldierSpinner);

        JLabel ammoLabel = new JLabel("Ammo Count:");
        ammoLabel.setBounds(500, 70, 100, 20);
        frame.add(ammoLabel);

        JSpinner ammoSpinner = new JSpinner();
        ammoSpinner.setBounds(600, 70, 50, 20);
        frame.add(ammoSpinner);

        JCheckBox positionCheck = new JCheckBox("Position");
        positionCheck.setBounds(500, 100, 100, 20);
        frame.add(positionCheck);

        JLabel energyLabel = new JLabel("Energy");
        energyLabel.setBounds(500, 130, 100, 20);
        frame.add(energyLabel);

        JSlider energySlider = new JSlider(JSlider.VERTICAL, 0, 100, 100);
        energySlider.setBounds(500, 150, 40, 150);
        energySlider.setMajorTickSpacing(20);
        energySlider.setPaintTicks(true);
        frame.add(energySlider);

        JLabel oxygenLabel = new JLabel("Oxygen");
        oxygenLabel.setBounds(560, 130, 100, 20);
        frame.add(oxygenLabel);

        JSlider oxygenSlider = new JSlider(JSlider.VERTICAL, 0, 100, 100);
        oxygenSlider.setBounds(560, 150, 40, 150);
        oxygenSlider.setMajorTickSpacing(20);
        oxygenSlider.setPaintTicks(true);
        frame.add(oxygenSlider);

        frame.setVisible(true);
    }

   @Override
   public void isAreaClear(Boolean isClear) {
      if(isClear){
         lblStatus.setText("Area Is Cleared");
      }else lblStatus.setText("Area Not Cleared");

   }

   @Override
   public void messagePassing(String message) {
      displayArea.setText("DefenceSystem :"+message);
   }

   @Override
   public void position(Integer num) {
      if(num>=20){
         shootButton.doClick();
      } else if (num>=40) {
         sonarButton.doClick();
      }else if(num>=60) {
         tomahawkButton.doClick();
      }else{tridentButton.doClick();}
   }
}