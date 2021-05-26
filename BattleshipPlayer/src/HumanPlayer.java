import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.HashSet;

public class HumanPlayer extends Player {

    Scanner input;

    public HumanPlayer(Scanner input) {
        super();
        this.input = input;
        this.guesses = new HashSet<>();
    }

    @Override
    public Integer[] guess() {
        Integer[] guess = new Integer[2];
        System.out.println("Fire the cannons!");
        while(true) {
            try {
                System.out.print("Enter a value for Y: ");
                guess[0] = this.input.nextInt();
                System.out.print("Enter a value for X: ");
                guess[1] = this.input.nextInt();
                if (!this.guesses.contains(guess)) {
                    this.guesses.add(guess);
                    break;
                } else {
                    System.out.println("You've already tried that location!  Try again!");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Invalid coordinate input, use only numbers");
                this.input.next();
            }
        }
        return guess;
    }

    @Override
    public void deployShips() {
        System.out.println("Please deploy your own ships! Coordinates range from 0 to 9");
        int count = 1;
        this.ships = new ShipSet();
        while(this.ships.size() != 5) {
            try {
                System.out.print("Enter Y Coordinate for Ship #" + count + ": ");
                int x = this.input.nextInt();
                System.out.print("Enter X Coordinate for Ship #" + count + ": ");
                int y = this.input.nextInt();
                if (x < 0 || x > 9 || y < 0 || y > 9) {
                    System.out.println("Invalid coordinates! Remember, coordinates range from 0 to 9");
                    continue;
                }
                var ship = new Ship(x, y);
                if (this.ships.contains(ship)) {
                    System.out.println("You already have a ship there! This isn't checkers soldier!");
                } else {
                    this.ships.add(ship);
                    count += 1;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Invalid coordinate input, use only numbers");
                this.input.next();
            }
        }
        System.out.println("Your ships are deployed!");
    }
}