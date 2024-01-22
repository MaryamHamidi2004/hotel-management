package menu;

import javax.swing.*;

public class ManagerMenu extends JFrame{

    private JPanel panel;

    public ManagerMenu(){
        super("manager menu");
        JPanel panel = new JPanel();
        panel.setSize(500, 200);
        panel.setLayout(null);
//        JLabel label = new JLabel(String.join(" ", "we lcome", Repository.currentPerson.getFirstName(), "!!"));
//        label.setBounds(190, 20, 120, 30);
//        panel.add(label);
        this.panel = panel;
        this.add(panel);
        this.setSize(500, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        JButton roomsButton = new JButton();
        roomsButton.setText("Rooms");
        roomsButton.setBounds(30, 60, 120, 30);
        this.panel.add(roomsButton);
        JButton workersButton = new JButton();
        workersButton.setText("Workers");
        workersButton.setBounds(180, 60, 120, 30);
        this.panel.add(workersButton);
        JButton reservationsButton = new JButton();
        reservationsButton.setText("Reservations");
        reservationsButton.setBounds(330, 60, 120, 30);
        this.panel.add(reservationsButton);
        JButton logoutButton = new JButton();
        logoutButton.setText("Logout");
        logoutButton.setBounds(180, 100, 120, 30);
        this.panel.add(logoutButton);
    }
}
