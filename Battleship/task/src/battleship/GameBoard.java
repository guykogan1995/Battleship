package battleship;

import java.awt.*;

public class GameBoard extends Ships {
    private final int BOARD_SIZE = 10;
    private final char[][] board;
    private final Ships battleShip = new Ships();
    private final Ships aircraftCarrier = new Ships();
    private final Ships submarine = new Ships();
    private final Ships cruiser = new Ships();
    private final Ships destroyer = new Ships();
    private final Actions action = new Actions();
    Point[][] array = new Point[5][5];
    int track = 0;
    int count = 0;

    public GameBoard() {
        aircraftCarrier.setLength(5);
        aircraftCarrier.setName("Aircraft Carrier");
        battleShip.setLength(4);
        battleShip.setName("BattleShip");
        submarine.setLength(3);
        submarine.setName("Submarine");
        cruiser.setLength(3);
        cruiser.setName("Cruiser");
        destroyer.setLength(2);
        destroyer.setName("Destroyer");
        this.board = new char[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                this.board[i][j] = '~';
            }
        }
    }

    public StringBuilder getBoard() {
        StringBuilder linesOfBoard = new StringBuilder("  1 2 3 4 5 6 7 8 9 10\n");
        int count = 0;
        char firstRow = 65;
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE * 2 + 2; j++) {
                if(j == BOARD_SIZE * 2 + 2 - 1 && i != BOARD_SIZE - 1) {
                    linesOfBoard.append("\n");
                    count = 0;
                }else if(j == 0) {
                    linesOfBoard.append(firstRow++);
                } else if (j % 2 != 0) {
                    linesOfBoard.append(" ");
                }  else {
                    linesOfBoard.append(this.board[i][count++]);
                }
            }
        }
        return linesOfBoard;
    }


    public void setBoardPiece(int row, int col, char piece) {
        this.board[row][col] = piece;
    }

    public void setShipDestroyer() {
        action.setDestroyerOnBoard();
        BoardShipRuleChecker(destroyer);
    }

    public void setShipAircraftCarrier() {
        action.setAircraftCarrier();
        BoardShipRuleChecker(aircraftCarrier);
    }

    public void setShipBattleship() {
        action.setBattleship();
        BoardShipRuleChecker(battleShip);
    }

    public void setShipCruiser() {
        action.setCruiser();
        BoardShipRuleChecker(cruiser);
    }

    public void setShipSubmarine() {
        action.setSubmarine();
        BoardShipRuleChecker(submarine);
    }
    private void BoardShipRuleChecker(Ships destroyer) {
        int tracker = 0;
        while (tracker == 0) {
            int lowerCol = action.getLengthColLow();
            int lowerRow = action.getLengthRowLow();
            int HigherCol = action.getLengthColHigh();
            int HigherRow = action.getLengthRowHigh();
            int colTracker = lowerCol;

            if(action.getByCol() == 1) {
                for (int i = colTracker; i < action.getLengthBound() + colTracker; i++) {
                    if (this.board[action.getRow()][i - 1] == 'O') {
                        tracker = 3;
                    }
                    if (HigherRow != 10 && this.board[action.getRow() + 1][i - 1] == 'O'
                            ||  lowerRow != 1 && this.board[action.getRow() - 1][i - 1] == 'O') {
                        tracker = 2;
                        break;
                    }
                }
                if (tracker == 3) {
                    System.out.println("\nError! Wrong ship location! Try again:\n");
                    action.scanShip();
                    tracker = 0;
                } else if (tracker == 2) {
                    System.out.println("\nError! You placed it too close to another one. Try again:\n");
                    action.scanShip();
                    tracker = 0;
                } else if (HigherCol != 10 && this.board[action.getRow()][HigherCol] == 'O') {
                    System.out.println("\nError! You placed it too close to another one. Try again:\n");
                    action.scanShip();
                }
                else if (lowerCol != 1 && this.board[action.getRow()][lowerCol - 2] == 'O') {
                    System.out.println("\nError! You placed it too close to another one. Try again:\n");
                    action.scanShip();
                } else {
                    tracker = 1;
                }
            } else {
                colTracker = action.getLengthRowLow();
                for (int i = colTracker; i < action.getLengthBound() + colTracker; i++) {
                    if (this.board[i - 1][action.getCol()] == 'O') {
                        tracker = 3;
                    }
                    if (HigherCol != 10 && this.board[i - 1][action.getCol() + 1] == 'O'
                            ||  lowerCol != 1 && this.board[i - 1][action.getCol() - 1] == 'O') {
                        tracker = 2;
                        break;
                    }
                }
                if (tracker == 3) {
                    System.out.println("\nError! Wrong ship location! Try again:\n");
                    action.scanShip();
                    tracker = 0;
                } else if (tracker == 2) {
                    System.out.println("\nError! You placed it too close to another one. Try again:\n");
                    action.scanShip();
                    tracker = 0;
                } else if (HigherRow != 10 && this.board[HigherRow][action.getCol()] == 'O') {
                    System.out.println("\nError! You placed it too close to another one. Try again:\n");
                    action.scanShip();
                }
                else if (lowerRow != 1 && this.board[lowerRow - 2][action.getCol()] == 'O') {
                    System.out.println("\nError! You placed it too close to another one. Try again:\n");
                    action.scanShip();
                } else {
                    tracker = 1;
                }
            }
        }
        shipMethodLengthCheck(destroyer);
    }

    private void shipMethodLengthCheck(Ships battleShip) {
        while (battleShip.getLength() != action.getLengthBound()) {
            System.out.println();
            if (battleShip.getLength() > action.getLengthBound() || battleShip.getLength() < action.getLengthBound()) {
                String name = battleShip.getName();
                String nameAppend = String.format("Error! wrong length of the %s! Try again:", name);
                System.out.println(nameAppend);
            }
            action.scanShip();
        }
        lowerNum();
    }

    public void moveBoard(GameBoard board) {
        action.move();
        Point check = new Point(action.moveRow, action.moveCol);
        int rowPos = 0;
        int r;
        int c;
        int rowC = 0;

        while ((action.moveRow > 10 || action.moveRow < 0 || action.moveCol > 10 || action.moveCol < 0) || (this.board[action.moveRow][action.moveCol] != '~' && this.board[action.moveRow][action.moveCol] != 'O' )) {
            System.out.println("\nError! You entered the wrong coordinates! Try again:\n");
            action.move();
            check = new Point(action.moveRow, action.moveCol);
        }
        if (this.board[action.moveRow][action.moveCol] == 'O') {
            count = 0;
            setBoardPiece(action.moveRow, action.moveCol, 'X');
            board.setBoardPiece(action.moveRow, action.moveCol, 'X');
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (array[i][j] == null) {
                        break;
                    }
                    if (array[i][j].equals(check)) {
                        rowPos = i;
                        break;
                    }
                }
            }
            for (int z = 0; z < array[rowPos].length; z++) {
                if (array[rowPos][z] == null) {
                    break;
                }
                rowC++;
                r = (int) array[rowPos][z].getX();
                c = (int) array[rowPos][z].getY();
                if (this.board[r][c] == 'X') {
                    count++;
                }
            }

            if (board.isGameOver()) {
                System.out.println("\nYou sank the last ship. You won. Congratulations!");
                System.exit(0);
            } else if (count == rowC) {
                System.out.println("\nYou sank a ship!");
            } else if (count != array[rowPos].length) {
                setBoardPiece(action.moveRow, action.moveCol, 'X');
                board.setBoardPiece(action.moveRow, action.moveCol, 'X');
                System.out.println("\nYou hit a ship!");
            }
        } else if (this.board[action.moveRow][action.moveCol] == '~') {
            setBoardPiece(action.moveRow, action.moveCol, 'M');
            board.setBoardPiece(action.moveRow, action.moveCol, 'M');
            System.out.println("\nYou missed!");
        }
    }

    public boolean isGameOver() {
        int gameOver = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (this.board[i][j] == 'X') {
                    gameOver++;
                }
            }
            if (gameOver == 17) {
                return true;
            }
        }
        return false;
    }

    private void lowerNum() {
        int lowerNum = Math.min(action.getCol(), action.getUpperCol());
        int lowerNum2 = Math.min(action.getRow(), action.getUpperRow());
        if (action.getByCol() == 1) {
            for (int i = 0; i < action.getLengthBound(); i++) {
                array[track][i] = new Point(action.getRow(),lowerNum);
                setBoardPiece(action.getRow(), lowerNum++, 'O');
            }
        } else {
            for (int i = 0; i < action.getLengthBound(); i++) {
                array[track][i] = new Point(lowerNum2, action.getCol());
                setBoardPiece(lowerNum2++, action.getCol(), 'O');
            }
        }
        track++;
    }
}

