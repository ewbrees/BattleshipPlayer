import java.util.HashSet;

public class ComputerPlayer extends Player {

    public ComputerPlayer() {
        super();
        this.guesses = new HashSet<>();
    }

    @Override
    public Integer[] guess() {
        System.out.println("The Computer fires its cannons!");
        Integer[] guess = new Integer[2];
        while(true) {
            guess[0] = RandInt.getWithinRange(0, 9);
            guess[1] = RandInt.getWithinRange(0, 9);
            if(!this.guesses.contains(guess)) {
                this.guesses.add(guess);
                break;
            }
        }
        return guess;
    }

    @Override
    public void deployShips() {
        System.out.println("The computer is deploying its ships!");
        int count = 1;
        this.ships = new ShipSet();
        while(this.ships.size() != 5) {
            int x = RandInt.getWithinRange(0, 9);
            int y = RandInt.getWithinRange(0, 9);
            var ship = new Ship(x, y);
            if(this.ships.contains(ship)) {
                continue;
            } else {
                this.ships.add(ship);
                System.out.println("Computer deployed ship #" + count + "!");
                count += 1;
            }
        }
        System.out.println("Computer ships are deployed");
    }
}