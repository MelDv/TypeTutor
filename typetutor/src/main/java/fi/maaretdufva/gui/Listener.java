/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.maaretdufva.gui;

import fi.maaretdufva.logic.Game;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Maaret Dufva
 */
public class Listener implements KeyListener {

    private Component component;
    private Game game;
    private char type;

    public Listener(Game game, Component component) {
        this.game = game;
        this.component = component;
        this.type = 'f';
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if (ke.getKeyCode() == game.sendToListener()) {
            game.newCharacter();
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

}
