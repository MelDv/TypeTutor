/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.maaretdufva.gui;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import static java.awt.GridBagConstraints.RELATIVE;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Maaret Dufva
 */
public class Gui implements Runnable {

    private JFrame frame;

    public Gui() {
    }

    @Override
    public void run() {
        frame = new JFrame("TypeTutor");
        frame.setPreferredSize(new Dimension(1000, 700));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container pane) {
        JButton button;
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        button = new JButton("Rekisteröidy");
        c.weightx = 0.1;
        c.gridx = 0;
        c.gridy = 0;
        pane.add(button, c);

        button = new JButton("Kirjaudu");
        c.gridx = 1;
        c.gridy = 0;
        pane.add(button, c);

        button = new JButton("Kokeile kirjautumatta");
        c.gridx = 3;
        c.gridy = 0;
        pane.add(button, c);

        JLabel basicGuide = new JLabel("Kirjoita ruutuun tuleva teksti kymmensormijärjestelmällä.");
        c.gridx = 0;
        c.gridy = 1;
        pane.add(basicGuide, c);

        JLabel text = new JLabel("Kirjoita tämä");
        c.gridx = 0;
        c.gridy = 5;
        pane.add(text, c);

        JTextField writeThis = new JTextField("Kirjoita tähän");
        c.gridx = 0;
        c.gridy = 6;
        writeThis.setEditable(true);
        pane.add(writeThis, c);
    }

    public JFrame getFrame() {
        return frame;
    }

}
