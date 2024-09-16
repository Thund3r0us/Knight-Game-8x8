/* Nicole Walsh
 * Dr. Steinberg
 * COP3503 Fall 2024
 * Programming Assignment 1
 */

//package all;
import java.util.Random;

public class Game 
{
    private int[][] board; // 8x8 board to track movement
    private char[] playerTwoMoves; // Stores moves for Player 2
    private Random random;  // Reference to Random object
    private int p1X, p1Y; // Player 1's position
    private int p2X, p2Y; // Player 2's position

    
    // Constructor taking Random object
    public Game(Random random) 
    {
        this.random = random;
        this.board = new int[8][8]; // 8x8 board, all initially 0
        this.playerTwoMoves = new char[] {'d', 'r', 'b'}; // Player 2 moves: 'd', 'r', 'b'
        
        this.p1X = 0; // Player 1 starts at (0, 0)
        this.p1Y = 0;
        this.p2X = 0; // Player 2 starts at (0, 0)
        this.p2Y = 0;
    }

    
    // Method to select a random move for Player 2
    public char selectPlayerTwoMove() 
    {
        int index = random.nextInt(3); // Choose 'd', 'r' or 'b'
        return playerTwoMoves[index];
    }

    
    // Method to move Player 1 based on winning strategy
    private void movePlayer1Knight() 
    {
        if (p1X < 7 && p1Y < 7) 
        {
            p1X++; p1Y++; // Prefer diagonally if possible
        }
        else if (p1X < 7) 
        {
            p1X++; // Move down
        }
        else if (p1Y < 7) 
        {
            p1Y++; // Move right
        } 
    }

    
    // Method to move Player 2 randomly
    private void movePlayer2Knight() 
    {
        char move = selectPlayerTwoMove();
    
        if (move == 'd' && p2X < 7 && p2Y < 7) 
        {
            p2X++; p2Y++; // Move diagonally
        } 
        else if (move == 'b' && p2X < 7) 
        {
            p2X++; // Move down
        }
        else if (move == 'r' && p2Y < 7) 
        {
            p2Y++; // Move right
        } 
    }

    
    // Method to simulate a game round
    public int play() 
    {
        while ((p1X < 7 || p1Y < 7) && (p2X < 7 || p2Y < 7)) 
        {
            // Player 1's move
            movePlayer1Knight();

            // Check if Player 1 won
            if (p1X == 7 && p1Y == 7) 
            {
                return 1; // Player 1 wins
            }

            // Player 2's move 
            movePlayer2Knight();

            // Check if Player 2 won
            if (p2X == 7 && p2Y == 7) 
            {
                return 2; // Player 2 wins
            }
        }

        // Return if neither Player 1 or Player 2 wins
        return -1; 
    }
}