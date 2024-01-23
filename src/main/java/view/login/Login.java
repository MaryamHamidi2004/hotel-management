package view.login;

import util.enums.HotelStatus;
import model.User;
import repo.Repository;
import service.CustomerService;
import service.HotelService;
import service.ManagerService;
import service.WorkerService;
import view.Base;
import view.menu.CustomerMenu;
import view.menu.ManagerMenu;
import view.menu.WorkerMenu;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Login extends Base {

    private JTextField usernameTxt;
    private JTextField passwordTxt;
    private JButton loginButton;
    private JButton signUpButton;

    public Login(){
        super("login");
        this.setName("Login");
        usernameTxt = new JTextField();
        JLabel usernameLabel = new JLabel("username:");
        passwordTxt = new JPasswordField();
        JLabel passwordLabel = new JLabel("password:");
        loginButton = new JButton("login");
        signUpButton = new JButton("signUp");
        loginButton.addActionListener(e -> login());
        signUpButton.addActionListener(e -> signUp());

        panel.add(usernameLabel);
        panel.add(usernameTxt);
        panel.add(passwordLabel);
        panel.add(passwordTxt);
        panel.add(loginButton);
        panel.add(signUpButton);

        usernameLabel.setBounds(20, 20, 70, 30);
        usernameTxt.setBounds(90, 20, 100, 30);
        passwordLabel.setBounds(270, 20, 80, 30);
        passwordTxt.setBounds(350, 20, 100, 30);
        loginButton.setBounds(100, 110, 100, 30);
        signUpButton.setBounds(300, 110, 100, 30);


        panel.revalidate();
        panel.repaint();
    }

    private void login(){
        User user;
        user = ManagerService.getInstance().login(usernameTxt.getText(), passwordTxt.getText());
        if (Objects.isNull(user) & HotelService.getInstance().find().getStatus().equals(HotelStatus.OPEN)){
            user = WorkerService.getInstance().login(usernameTxt.getText(), passwordTxt.getText());
            if (Objects.isNull(user)){
                user = CustomerService.getInstance().login(usernameTxt.getText(), passwordTxt.getText());
                if (!Objects.isNull(user)){
                    Repository.currentPerson = user;
                    this.dispose();
                    new CustomerMenu();
                }
            }else {
                Repository.currentPerson = user;
                this.dispose();
                new WorkerMenu();
            }
        }else {
            Repository.currentPerson = user;
            this.dispose();
            new ManagerMenu();
        }
    }

    private void signUp(){
        this.dispose();
        Frame current = Repository.getFrames().get("SignUp");
        if (!Objects.isNull(current))
            current.dispose();
        new SignUp();
    }
}
