public class Battleship {

    private Player player1;
    private Player player2;
    private String[][] ocean = new String[10][10];

    private Battleship() {
        for(int i = 0; i < this.ocean.length; i++) {
            for(int j = 0; j < this.ocean[i].length; j++) {
                this.ocean[i][j] = " ";
            }
        }
    }

    public Battleship setPlayers(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        return this;
    }

    public static Battleship build() {
        return new Battleship();
    }

    private void playTurn(Player player, Player other) {
        var guess = player.guess();
        int x = guess[0];
        int y = guess[1];
        boolean isHuman = player.getClass() == HumanPlayer.class;
        if(player.getShips().shipIsPresentAt(x, y)) {
            System.out.println(
                    isHuman ?
                            "You sank one of your own ships! The general won't be happy about this one..." :
                            "The computer sank one of its own ships! How lucky!"
            );
            if (false == isHuman) {
            	String filepath = "HIT.wav";
				Sound hit = new Sound();
				hit.playSoundHit(filepath);
            } else {
            	String filepath = "ALARM.wav";
				Sound alarm = new Sound();
				alarm.playSoundAlarm(filepath);
            }
            player.sinkShip(x, y);
            this.ocean[x][y] = "x";
        } else if(other.getShips().shipIsPresentAt(x, y)) {
            System.out.println(
                isHuman ?
                    "Hit!  You sank one of the computer's ship!" :
                    "The computer sank one of your ships!"
            );
            if (true == isHuman) {
            	String filepath = "HIT.wav";
				Sound hit = new Sound();
				hit.playSoundHit(filepath);
            } else {
            	String filepath = "ALARM.wav";
				Sound alarm = new Sound();
				alarm.playSoundAlarm(filepath);
            }
            other.sinkShip(x, y);
            this.ocean[x][y] = "x";
        } else {
            System.out.println(
                    isHuman ?
                            "You missed!" :
                            "The computer missed!"
            );
            if (this.ocean[x][y] != "x") {
            		this.ocean[x][y] = "-";
            }
            if (true == isHuman) {
            	String filepath = "MISS.wav";
				Sound miss = new Sound();
				miss.playSoundMiss(filepath);
            }
        }
    }

    private void displayOcean() {
        System.out.println("   0123456789   ");
        for(int i = 0; i < this.ocean.length; i++) {
            String row = i + " |";
            for(int j = 0; j < this.ocean[i].length; j++) {
                row += this.ocean[i][j];
            }
            row += "| " + i;
            System.out.println(row);
        }
        System.out.println("   0123456789   ");
        String player1Name = this.player1.getClass() == HumanPlayer.class ? "Player 1" : "Computer";
        String player2Name = this.player2.getClass() == HumanPlayer.class ? "Player 2" : "Computer";
        System.out.println(
                player1Name + " ships: " + this.player1.getShipsRemaining() +
                " | " +
                player2Name + " ships: " + this.player2.getShipsRemaining()
        );
    }

    private void displayShips() {
        if(this.player1.getClass() == HumanPlayer.class) {
            for(var ship : this.player1.getShips()) {
                int x = ship.getPosition()[0];
                int y = ship.getPosition()[1];
                this.ocean[x][y] = "@";
            }
        }
        if(this.player2.getClass() == HumanPlayer.class) {
            for(var ship : this.player1.getShips()) {
                int x = ship.getPosition()[0];
                int y = ship.getPosition()[1];
                this.ocean[x][y] = "@";
            }
        }
    }

    public void playGame() {
        System.out.println("Welcome to Battleship!");
        this.player1.deployShips();
        this.player2.deployShips();
        this.displayShips();
        boolean playerOneTurn = true;
        while(this.player1.getShipsRemaining() > 0 && this.player2.getShipsRemaining() > 0) {
            this.playTurn(
                    playerOneTurn ? this.player1 : this.player2,
                    !playerOneTurn ? this.player1 : this.player2
            );
            this.displayOcean();
            playerOneTurn = !playerOneTurn;
        }
        if(player1.getShipsRemaining() == 0) {
            System.out.println("The computer wins... Hopefully you did that on purpose");
            String filepath = "LOSE.wav";
			Sound lose = new Sound();
			lose.playSoundLose(filepath);
        } else {
            System.out.println("You have conquered the artifical intelligence! The rise of robots has been delayed... for now");
            String filepath = "WIN.wav";
			Sound win = new Sound();
			win.playSoundWin(filepath);
        }
    }
}