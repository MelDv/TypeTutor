/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.maaretdufva.gui;

import fi.maaretdufva.logic.Game;
import fi.maaretdufva.logic.Letters;
import fi.maaretdufva.users.User;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Maaret Dufva
 */
public class Listener implements KeyListener {

    private Game game;
    private Component component;
    private User user;

    public Listener(User user, Component component) {
        this.game = new Game();
        this.user = user;
        this.component = component;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if (ke.getKeyCode() == game.sendToListener()) {
            game.addPoint();
        } else {
            game.deductPoint();
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

}
