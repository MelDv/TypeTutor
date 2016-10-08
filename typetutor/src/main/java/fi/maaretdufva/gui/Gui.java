/*
 * This is the most important class for the graphical user interface.
 * It creates the frames and defines where each segment goes.
 */
package fi.maaretdufva.gui;

import fi.maaretdufva.logic.Game;
import fi.maaretdufva.users.User;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 *
 * @author Maaret 
 */
public class Gui implements Runnable {

    private JFrame frame;

    public Gui() {
    }

    @Override
    public void run() {
        frame = new JFrame("TypeTutor");
        frame.setPreferredSize(new Dimension(450, 250));

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

        JLabel text = new JLabel(game.getTypeThis());
        text.setText(game.getTypeThis());

        JLabel basicGuide = new JLabel("Type the text below using ten fingers.");
        container.add(basicGuide);

        JTextArea writingArea = new JTextArea(6, 32);
        writingArea.setEditable(true);
        container.add(writingArea);
        writingArea.setText("Press enter to start");

        JLabel pointsLabel = new JLabel(" Points");
        container.add(pointsLabel);

        JLabel points = new JLabel("0");
        container.add(points);

        JLabel levelLabel = new JLabel(" Level");
        container.add(levelLabel);

        JLabel level = new JLabel("0");
        container.add(level);

        Listener typedLetter = new Listener(user, writingArea, text, points, level);
        writingArea.addKeyListener(typedLetter);

        //Layout: first horizontal, then vertical. 
        writingArea.setBorder(BorderFactory.createEmptyBorder(2, 1, 1, 1));

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
                                .addComponent(text, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(writingArea, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(test, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(pointsLabel)
                                        .addComponent(points))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(levelLabel)
                                        .addComponent(level))))
        );

        layout.linkSize(SwingConstants.HORIZONTAL, register, login, test);

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(register)
                        .addComponent(login)
                        .addComponent(test))
                .addGroup(layout.createSequentialGroup()
                        .addComponent(basicGuide)
                        .addComponent(text)
                        .addComponent(writingArea))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(pointsLabel)
                                .addComponent(points))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(levelLabel)
                                .addComponent(level)))
        );

        frame.setTitle("TypeTutor");
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public JFrame getFrame() {
        return frame;
    }
}
