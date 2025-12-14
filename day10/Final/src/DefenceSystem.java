import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DefenceSystem {
    JTextArea areaTopRight;
    JButton collectBtn;
    JCheckBox areaClear;
    JLabel soldierLabel;
    JLabel fuelLabel;
    JLabel ammoLabel;

    Controller controller;

    DefenceSystem(Controller controller){
        this.controller = controller;

        JFrame frame = new JFrame("Defence Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(null);

        // Dropdown
        String[] defences = {"Select Defence", "Infantry", "Air", "Naval"};
        JComboBox<String> defenceBox = new JComboBox<>(defences);
        defenceBox.setBounds(20, 20, 150, 30);
        frame.add(defenceBox);

        // Button - Collect Information
        collectBtn = new JButton("Collect Information");
        collectBtn.setBounds(180, 20, 180, 30);
        frame.add(collectBtn);

        // Checkbox - Area Clear
        areaClear = new JCheckBox("Area Clear");
        areaClear.setBounds(400, 20, 120, 30);
        frame.add(areaClear);

        //Add action listener
        areaClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(areaClear.isSelected()){
                    controller.setArea(true);
                }else{
                    controller.setArea(false);
                }
            }
        });

        // Labels
        soldierLabel = new JLabel("Soldier Count");
        soldierLabel.setBounds(20, 70, 100, 20);
        frame.add(soldierLabel);

        fuelLabel = new JLabel("Fuel Amount");
        fuelLabel.setBounds(20, 100, 100, 20);
        frame.add(fuelLabel);

        ammoLabel = new JLabel("Ammo Amount");
        ammoLabel.setBounds(20, 130, 100, 20);
        frame.add(ammoLabel);

        JLabel positionLabel = new JLabel("Position");
        positionLabel.setBounds(20, 160, 100, 20);
        frame.add(positionLabel);

        // Slider for Position
        JSlider positionSlider = new JSlider(0, 100, 0);
        positionSlider.setBounds(80, 160, 300, 40);
        positionSlider.setPaintTicks(true);
        positionSlider.setPaintLabels(true);
        positionSlider.setMajorTickSpacing(20);
        frame.add(positionSlider);

        // get slider value
        positionSlider.addChangeListener(e ->  {
            controller.setOption(positionSlider.getValue());
        });

        // Text areas with scroll
        areaTopRight = new JTextArea();
        JScrollPane scrollTopRight = new JScrollPane(areaTopRight);
        scrollTopRight.setBounds(350, 70, 200, 80);
        frame.add(scrollTopRight);

        JTextArea areaBottomLeft = new JTextArea();
        JScrollPane scrollBottomLeft = new JScrollPane(areaBottomLeft);
        scrollBottomLeft.setBounds(20, 220, 250, 80);
        frame.add(scrollBottomLeft);

        JTextArea areaBottomRight = new JTextArea();
        JScrollPane scrollBottomRight = new JScrollPane(areaBottomRight);
        scrollBottomRight.setBounds(300, 220, 250, 80);
        frame.add(scrollBottomRight);

        // Checkbox - Send Private
        JCheckBox sendPrivate = new JCheckBox("Send Private");
        sendPrivate.setBounds(350, 160, 120, 30);
        frame.add(sendPrivate);

        // Send button
        JButton sendBtn = new JButton("Send");
        sendBtn.setBounds(470, 160, 80, 30);
        frame.add(sendBtn);

        //get text
        sendBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.setMessage(areaTopRight.getText());
            }
        });

        frame.setVisible(true);
    }
}