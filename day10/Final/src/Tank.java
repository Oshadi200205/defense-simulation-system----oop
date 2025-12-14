import javax.swing.*;
import java.awt.*;

public class Tank implements DefenceController {
    JLabel lblStatus;
    JTextField txtInput;
    JTextArea txtArea;
    JButton btnShoot;
    JButton btnMissile;
    JButton btnRadar;
    JButton btnRotate;

    Tank() {
        JFrame frame = new JFrame("Tank");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 420);
        frame.setLayout(null);

        // Title Label
        lblStatus = new JLabel("Area Not Cleared");
        lblStatus.setFont(new Font("Arial", Font.BOLD, 14));
        lblStatus.setBounds(20, 10, 200, 30);
        frame.add(lblStatus);

        // Buttons (disabled by default)
        btnShoot = new JButton("Shoot");
        btnShoot.setBounds(20, 50, 120, 30);
        frame.add(btnShoot);

        btnMissile = new JButton("Missile Operation");
        btnMissile.setBounds(150, 50, 150, 30);
        frame.add(btnMissile);

        btnRadar = new JButton("Redar Operation");
        btnRadar.setBounds(20, 90, 150, 30);
        frame.add(btnRadar);

        btnRotate = new JButton("Rotate Shooting");
        btnRotate.setBounds(180, 90, 150, 30);
        frame.add(btnRotate);

        // Spinner and Checkbox Controls
        JLabel lblSoldier = new JLabel("Soldier Count:");
        lblSoldier.setBounds(340, 40, 100, 20);
        frame.add(lblSoldier);

        JSpinner spnSoldier = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        spnSoldier.setBounds(440, 40, 50, 20);
        frame.add(spnSoldier);

        JLabel lblAmmo = new JLabel("Ammo Count:");
        lblAmmo.setBounds(340, 70, 100, 20);
        frame.add(lblAmmo);

        JSpinner spnAmmo = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        spnAmmo.setBounds(440, 70, 50, 20);
        frame.add(spnAmmo);

        JCheckBox chkPosition = new JCheckBox("Position");
        chkPosition.setBounds(340, 100, 100, 20);
        frame.add(chkPosition);

        // Text Area
        txtArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(txtArea);
        scrollPane.setBounds(20, 140, 560, 140);
        frame.add(scrollPane);

        // Input + Send Button
        txtInput = new JTextField();
        txtInput.setBounds(20, 300, 480, 30);
        frame.add(txtInput);

        JButton btnSend = new JButton("Send");
        btnSend.setBounds(510, 300, 70, 30);
        frame.add(btnSend);

        // Vertical Slider
        JSlider slider = new JSlider(JSlider.VERTICAL, 0, 100, 100);
        slider.setInverted(true);
        slider.setBounds(590, 20, 30, 320);
        frame.add(slider);

        // Show Frame
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
        txtArea.setText("DefenceSystem :"+message);
    }

    @Override
    public void position(Integer num) {
        if(num>=20){
            btnShoot.doClick();
        } else if (num>=40) {
            btnMissile .doClick();
        }else if(num>=60) {
            btnRadar.doClick();
        }else{btnRotate.doClick();}

    }
}