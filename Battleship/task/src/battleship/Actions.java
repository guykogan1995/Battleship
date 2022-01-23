package battleship;

import java.util.Locale;
import java.util.Scanner;

public class Actions {
    private final static Scanner scanner = new Scanner(System.in);
    private int lengthBound = 0;
    private int row = 0;
    private int col = 0;
    private int upperRow = 0;
    private int upperCol = 0;
    private int byCol = 0;
    int lengthColLow;
    int lengthColHigh;
    int lengthRowLow;
    int lengthRowHigh;
    int moveRow;
    int moveCol;
    int count = 0;


    public void move() {
        String move = scanner.next();
        if (move.length() == 3 && move.charAt(2) != '0' && move.charAt(1) != '1') {
            System.out.println("\nError! You entered the wrong coordinates! Try again:\n");
            move();
        } else if(move.length() == 3) {
            this.moveCol = 9;
        }else{
            this.moveCol = move.charAt(1) - 49;
        }
        this.moveRow = move.charAt(0) - 65;
    }

    public void enterScan() {
        System.out.println("Press Enter and pass the move to another player");
        String toke = "On";
        System.out.println("...");
        scanner.nextLine();
        while (!toke.isEmpty()) {
            toke = scanner.nextLine();
        }
        System.out.println();
        count++;
    }
    public void scanShip() {
        System.out.println();
        String firstBound = scanner.next().toUpperCase(Locale.ROOT);
        if (firstBound.length() == 3) {
            System.out.println("10 or higher detected corrected to 10!");
            this.col = 9;
        } else {
            this.col = firstBound.charAt(1) - 49;
        }
        String secondBound = scanner.next().toUpperCase(Locale.ROOT);
        if (secondBound.length() == 3) {
            this.upperCol = 9;
        } else {
            this.upperCol = secondBound.charAt(1) - 49;
        }
        this.row = firstBound.charAt(0) - 65;
        this.upperRow = secondBound.charAt(0) - 65;
        lengthColLow = Math.min((this.col + 1), (this.upperCol + 1));
        lengthColHigh = Math.max((this.col + 1), (this.upperCol + 1));
        lengthRowLow = Math.min((this.row + 1), (this.upperRow + 1));
        lengthRowHigh = Math.max((this.row + 1), (this.upperRow + 1));
        if (firstBound.charAt(0) == secondBound.charAt(0)) {
            this.lengthBound = Math.abs(lengthColHigh - lengthColLow) + 1;
            this.byCol = 1;
        } else if (firstBound.charAt(1) == secondBound.charAt(1)) {
            this.lengthBound = Math.abs((lengthRowHigh - lengthRowLow) + 1);
            this.byCol = 0;
        } else {
            System.out.println("\nError! Invalid input! must be row row or col col! Try again:");
            scanner.nextLine();
            scanShip();
        }
    }

    public void setDestroyerOnBoard() {
        scanShip();
    }
    public void setAircraftCarrier() {
        scanShip();
    }

    public void setBattleship() {
        scanShip();
    }

    public void setCruiser() {
        scanShip();
    }

    public void setSubmarine() {
        scanShip();
    }

    public int getLengthBound() {
        return this.lengthBound;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int getUpperCol() {
        return upperCol;
    }

    public int getUpperRow() {
        return upperRow;
    }

    public int getByCol() {
        return byCol;
    }

    public int getLengthColHigh() {
        return lengthColHigh;
    }

    public int getLengthColLow() {
        return lengthColLow;
    }

    public int getLengthRowHigh() {
        return lengthRowHigh;
    }

    public int getLengthRowLow() {
        return lengthRowLow;
    }
}