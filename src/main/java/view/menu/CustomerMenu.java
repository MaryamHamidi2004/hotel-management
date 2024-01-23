package menu;

import javax.swing.*;

public class CustomerMenu extends JFrame{

    private JPanel panel;

    public CustomerMenu(){
        super("customer menu");
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
        roomsButton.setText("Reserve a room");
        roomsButton.setBounds(30, 60, 150, 30);
        this.panel.add(roomsButton);
        JButton reservationsButton = new JButton();
        reservationsButton.setText("Check out");
        reservationsButton.setBounds(300, 60, 150, 30);
        this.panel.add(reservationsButton);
        JButton logoutButton = new JButton();
        logoutButton.setText("Logout");
        logoutButton.setBounds(180, 100, 120, 30);
        this.panel.add(logoutButton);
    }
}
