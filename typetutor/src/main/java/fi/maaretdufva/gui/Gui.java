package fi.maaretdufva.gui;

import fi.maaretdufva.logic.Game;
import fi.maaretdufva.users.User;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 * This class creates the graphical user interface.
 * <p>
 * This is the most important class for creating the gui. It creates the frames
 * and defines where each segment goes.
 *
 * @author Maaret Dufva
 * @version 0.1.0
 * @since 0.1.0
 */
public class Gui implements Runnable {

    private JFrame frame;

    /**
     * Constructor.
     */
    public Gui() {
    }

    @Override
    public void run() {
        frame = new JFrame("TypeTutor: Hello new user!");
        frame.setPreferredSize(new Dimension(550, 300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        User user = new User("temp");
        Game game = new Game(user);

        // Creates buttons and areas
        JTextField giveUsername = new JTextField();
        JPasswordField givePassword = new JPasswordField();
        JLabel username = new JLabel("Username: ");
        JLabel password = new JLabel("Password: ");

        JButton login = new JButton("Login");
        JButton register = new JButton("Register");

        RegisterListener reglis = new RegisterListener(user, game, frame, register, giveUsername, givePassword, login);
        register.addActionListener(reglis);
        login.addActionListener(reglis);

        JTextArea text = new JTextArea();
        text.setEditable(false);
        text.setFont(new Font("Serif", Font.PLAIN, 18));

        JLabel basicGuide = new JLabel("Type the text below using ten fingers.");
        container.add(basicGuide);

        JTextArea writingArea = new JTextArea(6, 32);
        writingArea.setEditable(true);
        writingArea.setText("Press enter to start");
        writingArea.setFont(new Font("Serif", Font.PLAIN, 16));

        JLabel pointsLabel = new JLabel("Points");
        JLabel points = new JLabel("0");
        JLabel levelLabel = new JLabel("Level");
        JLabel level = new JLabel("0");

        JLabel letterInfo = new JLabel("Letters learned:");
        JLabel letters = new JLabel("<html><font color='#cccccc'>ABCD EFGH IJKL MNOP QRST UVWX YZÅÄÖ ?!.,-</font></html>");

        //Sends to listener
        Listener typedLetter = new Listener(user, game, writingArea, text, points, level, letters);
        writingArea.addKeyListener(typedLetter);

        //Layout: first horizontal, then vertical. 
        GroupLayout layout = new GroupLayout(container);
        container.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(username)
                        .addComponent(password))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(giveUsername)
                        .addComponent(givePassword)
                        .addComponent(basicGuide)
                        .addComponent(text, 300, 300, 300)
                        .addComponent(writingArea)
                        .addComponent(letterInfo)
                        .addComponent(letters))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(register)
                        .addComponent(login)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(pointsLabel)
                                .addComponent(points))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(levelLabel)
                                        .addComponent(level))))
        );

        layout.linkSize(SwingConstants.HORIZONTAL, register, login);
        layout.linkSize(SwingConstants.HORIZONTAL, basicGuide, text, writingArea, letters);

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(username)
                        .addComponent(giveUsername)
                        .addComponent(register))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(password)
                        .addComponent(givePassword)
                        .addComponent(login))
                .addGroup(layout.createSequentialGroup()
                        .addComponent(basicGuide)
                        .addComponent(text)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(writingArea)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(pointsLabel)
                                        .addComponent(points)
                                        .addComponent(levelLabel)
                                        .addComponent(level)))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(letterInfo)
                                        .addComponent(letters))))
        );

        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
