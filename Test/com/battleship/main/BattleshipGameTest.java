package com.battleship.main;

import com.battleship.boards.ShipBoard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class BattleshipGameTest {

    private BattleshipGame game;
    private ShipBoard player1Shipboard;
    private ShipBoard player2Shipboard;

    @Before
    private void startUp() {
        game = new BattleshipGame();
        player1Shipboard = game.getPlayer1Shipboard();
        player2Shipboard = game.getPlayer2Shipboard();
        player1Shipboard = new ShipBoard();
    }



    /*-placeRounds test-----------------------------------------------------------------------------------------------*/
    @Test
    public void playRounds_player1Wins_whenAllPlayer2ShipSunk() {

        // TODO: how do I simulate all player2's ships sunk?
        // TODO: game must correctly identify player1 as the winner
        assertTrue("Player 1 should win if all Player 2's ships are sunk", player2Shipboard.allShipsSunk());
    }

    @Test
    public void playRounds_player2Wins_whenAllPlayer1ShipSunk() {
        // TODO: how do I simulate all player1's ships sunk?
        // TODO: game must correctly identify player2 as the winner
        assertTrue("Player 2 should win if all Player a's ships are sunk", player1Shipboard.allShipsSunk());
    }

    @Test
    public void playRounds_gameContinues_whenShipsRemainOnBothSides() {
        // TODO: how do I simulate all player1 and player2 ships not sunk?
        // TODO: game must identify that there is no winner yet - all ships not sunk
        assertFalse("Game should continue if both players have ships remaining.", player1Shipboard.allShipsSunk()
                || player2Shipboard.allShipsSunk());
    }

    /*-startGame test-------------------------------------------------------------------------------------------------*/

    /*-placeShipsForPlayers test--------------------------------------------------------------------------------------*/

    /*-takeTurn test-------------------------------------------------------------------------------------------------*/
}