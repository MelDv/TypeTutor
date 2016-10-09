package fi.maaretdufva.gui;

import fi.maaretdufva.users.AllUsers;
import fi.maaretdufva.users.User;
import java.util.Scanner;

/**
 * This is a test class to be used without the gui.
 *
 * @author Maaret Dufva
 * @version 0.1.0
 * @since 0.1.0
 */
public class Account {

    // This class was for original testing before gui. It will be deleted soon.
    private Scanner reader;
    private User user;
    private AllUsers all;

    public Account() {
        this.reader = new Scanner(System.in);
        this.user = new User("Jaska");
        this.all = new AllUsers();
    }

    public User aloita() {
        while (true) {
            System.out.println("Give TypeTutor a try by typing 'continue' "
                    + "or login with your username.\n"
                    + "If you want to create an account, press enter");
            String text = reader.nextLine();

            if (text.equals("continue")) {
                return user;
            } else if (text.isEmpty()) {
                createUsername();
                break;
            } else if (all.findUser(text)) {
                System.out.println("Welcome back, " + text);
                checkPassword();
                break;
            }

        }
        return user;

    }

    public void createUsername() {
        while (true) {
            System.out.println("Write your username.");
            String username = reader.nextLine();
            if (all.findUser(username)) {
                System.out.println("The username is already in use.");
            } else {
                user.setUsername(username);
                System.out.println("Welcome, " + username + "!");
                break;
            }
        }
        giveInfo();
    }

    public void checkPassword() {
        System.out.println("Type your password: ");
        String password = reader.nextLine();
        if (user.testPassword(password)) {
            return;
        } else {
            System.out.println("Wrong password. Retype your password "
                    + "or go back to the beginning by pressing enter.");
        }
    }

    public void promptCreateAccount() {
        System.out.println("You can continue by registering as a user "
                + "or loging in. Pleasy type your username "
                + "or quit by pressing enter.");
        String answer = reader.nextLine();
        if (answer.isEmpty()) {
            System.out.println("If you want to practice again, press K, or press enter.");
            String newAnswer = reader.nextLine();
            if (newAnswer.isEmpty()) {
                System.out.println("Wellcome back soon!");
                return;
            }
        }
    }

    public boolean emptyInput(String syote) {
        if (syote.isEmpty()) {
            return true;
        }
        return false;
    }

    private void createPassword() {
        // Obviously not finished
        //this.all.addUser(user);
    }

    private void giveInfo() {
        // not finished
        //createPassword();
    }
}
