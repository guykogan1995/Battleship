---

# Battleship Game

This is a text-based implementation of the Battleship game. The game allows two players to place their ships on a game board and take turns guessing the positions of their opponent's ships. The first player to sink all of their opponent's ships wins the game.

## Instructions

1. Clone the repository and navigate to the project directory.
2. Compile the Java classes using a Java compiler.
3. Run the `Main` class to start the game.

## Gameplay

Sample Interaction:

```
Player 1, place your ships on the game field

  1 2 3 4 5 6 7 8 9 10
A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~

Enter the coordinates of the Aircraft Carrier (5 cells):
A1 A5

  1 2 3 4 5 6 7 8 9 10
A O O O O ~ ~ ~ ~ ~ ~
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~

Enter the coordinates of the Battleship (4 cells):
B1 B4

...

Player 2, place your ships on the game field
...

Enter the coordinates of the Destroyer (2 cells):
H6 H7

...

Player 1, it's your turn:
D1

  1 2 3 4 5 6 7 8 9 10
A O O O O ~ ~ ~ ~ ~ ~
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
D X O O O ~ ~ ~ ~ ~ ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~

...

Player 2, it's your turn:
H6

  1 2 3 4 5 6 7 8 9 10
A O O O O ~ ~ ~ ~ ~ ~
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
D X O O O ~ ~ ~ ~ ~ ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H X ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~

...

You sank the last ship. You won. Congratulations!
```

## How to Play
Clone the repository and navigate to the project directory.  
Compile the Java classes using a Java compiler.  
Run the Main class to start the game.  
Player 1 will be prompted to place their ships on the game board.  
Player 2 will be prompted to place their ships on the game board.  
Players will take turns guessing the positions of their opponent's ships by entering coordinates on the game board.  
If a guess hits an opponent's ship, it will be marked with an 'X'. If the guess misses, it will be marked with an 'M'.  
The game continues until one player sinks all of their opponent's ships.  
The player who sinks all of their opponent's ships first is declared the winner.  

## License
This project is licensed under the MIT License.  

## Author
Guy Kogan  
Contributions  
Contributions to the project are welcome. If you would like to contribute, please follow these steps:  
  
Fork the repository.  
Create a new branch for your contribution.  
Make your changes and commit them.  
Push your changes to your forked repository.  
Submit a pull request explaining your changes.  

---

