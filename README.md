# Snake and Ladders
This project is a simulator of the game [Snake and Ladders](https://en.wikipedia.org/wiki/Snakes_and_ladders), with some addtionals features.

## Structure of <small>`/src`</small>
* **Board:** Store all the elements related Squares and their type.
* **Death:** Specific type of Square.
* **Die:** Class related to the functions that represent a Die.
* **FirstSquare:** Specific type of Square.
* **Game:** Store all elements related to the functionality of the game, like the Winner, an instance of the Board or the Players.
* **Main:** Make an instance of the Game.
* **Player:** Store all data required to the player.
* **SnakeOrLadder:** Specific type of Square.
* **Square:** General class of Square.
* **snakeAndLadders.puml:** Class diagram of the implementation.

## Input
* Number of players and their names
* Number of squares
* Pairs of from-to positions of snakes and ladders.

## Output 
* Number rolled by die
* Who is and moves of current player
* Current state of game
* Who's the winner