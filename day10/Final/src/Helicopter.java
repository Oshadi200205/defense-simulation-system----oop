import javax.swing.*;
import java.awt.*;

public class Helicopter implements DefenceController {
    JLabel lblStatus;
    JButton btnShoot;
    JButton btnMissile;
    JButton btnLaser;
    JLabel lblSoldier;
    JSpinner spinnerSoldier;
    JLabel lblAmmo;
    JSpinner spinnerAmmo;
    JCheckBox chkPosition;
    JTextArea textArea;
    JTextField txtInput;
    JButton btnSend;
    JSlider slider;

    Helicopter (){
        JFrame frame = new JFrame("Helicopter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(null);

        lblStatus = new JLabel("Area Not Cleared");
        lblStatus.setFont(new Font("Arial", Font.BOLD, 14));
        lblStatus.setBounds(20, 10, 150, 30);
        frame.add(lblStatus);

        btnShoot = new JButton("Shoot");
        btnShoot.setBounds(20, 50, 100, 30);
        frame.add(btnShoot);

        btnMissile = new JButton("Missile Operation");
        btnMissile.setBounds(130, 50, 150, 30);
        frame.add(btnMissile);

        btnLaser = new JButton("Laser Operation");
        btnLaser.setBounds(20, 90, 150, 30);
        frame.add(btnLaser);

        lblSoldier = new JLabel("Soldier Count:");
        lblSoldier.setBounds(300, 40, 100, 20);
        frame.add(lblSoldier);

        spinnerSoldier = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        spinnerSoldier.setBounds(400, 40, 50, 20);
        frame.add(spinnerSoldier);

        lblAmmo = new JLabel("Ammo Count:");
        lblAmmo.setBounds(300, 70, 100, 20);
        frame.add(lblAmmo);

        spinnerAmmo = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        spinnerAmmo.setBounds(400, 70, 50, 20);
        frame.add(spinnerAmmo);

        chkPosition = new JCheckBox("Position");
        chkPosition.setBounds(300, 100, 100, 20);
        frame.add(chkPosition);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(20, 130, 530, 120);
        frame.add(scrollPane);

        txtInput = new JTextField();
        txtInput.setBounds(20, 270, 450, 30);
        frame.add(txtInput);

        btnSend = new JButton("Send");
        btnSend.setBounds(480, 270, 70, 30);
        frame.add(btnSend);

        slider = new JSlider(JSlider.VERTICAL, 0, 100, 100);
        slider.setBounds(560, 20, 20, 300);
        slider.setInverted(true);
        frame.add(slider);

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
        textArea.setText("DefenceSystem :"+message);
    }

    @Override
    public void position(Integer num) {
        if(num>=20){
            btnShoot.doClick();
        } else if (num>=40) {
            btnMissile.doClick();
        }else{
            btnLaser.doClick();
        }
    }
}