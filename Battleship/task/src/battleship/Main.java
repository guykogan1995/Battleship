package battleship;

public class Main {

    public static void main(String[] args) {
        GameBoard battleShipGame = null;
        GameBoard hiddenBoard = null;
        GameBoard battleShipGame2 = null;
        GameBoard hiddenBoard2 = null;
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                System.out.println("\nPlayer 1, place your ships on the game field");
                battleShipGame = new GameBoard();
                hiddenBoard = new GameBoard();
                System.out.println("\n" + battleShipGame.getBoard());
                System.out.println("\nEnter the coordinates of the Aircraft Carrier (5 cells):");
                battleShipGame.setShipAircraftCarrier();
                System.out.println("\n" + battleShipGame.getBoard());
                System.out.println("\nEnter the coordinates of the Battleship (4 cells):");
                battleShipGame.setShipBattleship();
                System.out.println("\n" + battleShipGame.getBoard());
                System.out.println("\nEnter the coordinates of the Submarine (3 cells):");
                battleShipGame.setShipSubmarine();
                System.out.println("\n" + battleShipGame.getBoard());
                System.out.println("\nEnter the coordinates of the Cruiser (3 cells):");
                battleShipGame.setShipCruiser();
                System.out.println("\n" + battleShipGame.getBoard());
                System.out.println("\nEnter the coordinates of the Destroyer (2 cells):");
                battleShipGame.setShipDestroyer();
                System.out.println("\n" + battleShipGame.getBoard());
            } else {
                System.out.println("Player 2, place your ships on the game field");
                battleShipGame2 = new GameBoard();
                hiddenBoard2 = new GameBoard();
                System.out.println("\n" + battleShipGame2.getBoard());
                System.out.println("\nEnter the coordinates of the Aircraft Carrier (5 cells):");
                battleShipGame2.setShipAircraftCarrier();
                System.out.println("\n" + battleShipGame2.getBoard());
                System.out.println("\nEnter the coordinates of the Battleship (4 cells):");
                battleShipGame2.setShipBattleship();
                System.out.println("\n" + battleShipGame2.getBoard());
                System.out.println("\nEnter the coordinates of the Submarine (3 cells):");
                battleShipGame2.setShipSubmarine();
                System.out.println("\n" + battleShipGame2.getBoard());
                System.out.println("\nEnter the coordinates of the Cruiser (3 cells):");
                battleShipGame2.setShipCruiser();
                System.out.println("\n" + battleShipGame2.getBoard());
                System.out.println("\nEnter the coordinates of the Destroyer (2 cells):");
                battleShipGame2.setShipDestroyer();
                System.out.println("\n" + battleShipGame2.getBoard());
            }
            System.out.println();
            battleShipGame.enterScan();
        }

        int i = 2;
        while (!battleShipGame.isGameOver() || !battleShipGame2.isGameOver()) {
            if(i % 2 == 0) {
                System.out.println(hiddenBoard2.getBoard());
                System.out.println("---------------------\n" + battleShipGame.getBoard());
                System.out.println("\nPlayer 1, it's your turn:");
                battleShipGame2.moveBoard(hiddenBoard2);
            } else {
                System.out.println(hiddenBoard.getBoard());
                System.out.println("---------------------\n" + battleShipGame2.getBoard());
                System.out.println("\nPlayer 2, it's your turn:");
                battleShipGame.moveBoard(hiddenBoard);
            }
            i++;
            battleShipGame.enterScan();
        }
    }
}
