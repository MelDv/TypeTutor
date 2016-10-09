package fi.maaretdufva.gui;

import fi.maaretdufva.logic.Game;
import fi.maaretdufva.users.User;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
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
        frame = new JFrame("TypeTutor");
        frame.setPreferredSize(new Dimension(600, 300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        User user = new User("TestUser");
        Game game = new Game(user);

        // Creates buttons and areas
        JButton register = new JButton("Register");
        register.addActionListener(new RegisterListener());

        JButton login = new JButton("Login");
        JButton test = new JButton("Test");

        JTextArea text = new JTextArea();
        text.setEditable(false);
        text.setFont(new Font("Serif", Font.PLAIN, 18));
        text.setText(game.getTypeThis());

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

        //These don't work with a listener yet
        JLabel letterInfo = new JLabel("Letters learned:");
        JLabel letters = new JLabel("-");

        //Sends to listener
        Listener typedLetter = new Listener(user, writingArea, text, points, level);
        writingArea.addKeyListener(typedLetter);

        //Layout: first horizontal, then vertical. 
        writingArea.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 20));

        GroupLayout layout = new GroupLayout(container);
        container.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(register)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(login)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(basicGuide)
                                .addComponent(text, 300, 300, 300)
                                .addComponent(writingArea)
                                .addComponent(letterInfo)
                                .addComponent(letters)))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(test)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(pointsLabel)
                                .addComponent(points))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(levelLabel)
                                        .addComponent(level))))
        );

        layout.linkSize(SwingConstants.HORIZONTAL, register, login, test);
        layout.linkSize(SwingConstants.HORIZONTAL, basicGuide, text, writingArea, letters);

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(register)
                        .addComponent(login)
                        .addComponent(test))
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

        frame.setTitle("TypeTutor");
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public JFrame getFrame() {
        return frame;
    }
}
