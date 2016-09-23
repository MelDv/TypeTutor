/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.maaretdufva.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
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

    private void createComponents(Container container) {

    }

    public JFrame getFrame() {
        return frame;
    }

}
