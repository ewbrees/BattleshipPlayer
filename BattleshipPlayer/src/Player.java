import java.util.Set;

public abstract class Player {
    private int shipsRemaining = 5;
    protected ShipSet ships;
    protected Set<Integer[]> guesses;

    abstract Integer[] guess();
    abstract void deployShips();

    public int getShipsRemaining() {
        return this.shipsRemaining;
    }

    public ShipSet getShips() {
        return this.ships;
    }

    public void sinkShip(int x, int y) {
        this.shipsRemaining -= 1;
        this.ships.remove(x, y);
    }
}
