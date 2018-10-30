/**
 * The Class SnakesAndLadders.
 * 
 * @author Daniel Innes 101067175
 */
public class SnakesAndLadders {

	/** The number of players. */
	public int NUM_PLAYERS;

	/** The number of squares. */
	public int NUM_SQUARES = 100;
	/** The snakes and ladders board */
	private SnLSquare[] board;
	/** The players positions */
	private int[] players;
	/** The dice emulator */
	private Dice dice;

	/**
	 * Instantiates a 2 player game of snakes and ladders.
	 */
	public SnakesAndLadders() {
		this(2);
	}

	/**
	 * Instantiates a nPlayers player game of snakes and ladders.
	 *
	 * @param nPlayers the number of players
	 */
	public SnakesAndLadders(int nPlayers) {
		NUM_PLAYERS = nPlayers;
		players = new int[NUM_PLAYERS];
		dice = new Dice();
		for (int i = 0; i < NUM_PLAYERS; ++i) {
			players[i] = 1;
		}
		//Parse the provided board string in order to generate the board 
		board = new SnLSquare[NUM_SQUARES];
		String boardStr = "| 1 | 2 | 3 | 4+14 | 5 | 6 | 7 | 8 | 9+31 | 10"
				+ "| 11 | 12 | 13 | 14 | 15 | 16 | 17-7 | 18 | 19 | 20+38"
				+ "| 21 | 22 | 23 | 24 | 25 | 26 | 27 | 28+84 | 29 | 30"
				+ "| 31 | 32 | 33 | 34 | 35 | 36 | 37 | 38 | 39 | 40+59"
				+ "| 41 | 42 | 43 | 44 | 45 | 46 | 47 | 48 | 49 | 50"
				+ "| 51 | 52 | 53 | 54-34 | 55 | 56 | 57 | 58 | 59 | 60"
				+ "| 61 | 62-18 | 63+81 | 64-60 | 65 | 66 | 67 | 68 | 69 | 70"
				+ "| 71+91 | 72 | 73 | 74 | 75 | 76 | 77 | 78 | 79 | 80"
				+ "| 81 | 82 | 83 | 84 | 85 | 86 | 87-24 | 88 | 89 | 90"
				+ "| 91 | 92 | 93-73 | 94 | 95-75 | 96 | 97 | 98 | 99-78 | 100";
		//Remove nuisance characters.
		boardStr = boardStr.replaceAll("\\s+", "");
		if (boardStr.startsWith("|")) {
			boardStr = boardStr.substring(1);
		}
		if (boardStr.endsWith("|")) {
			boardStr = boardStr.substring(0, boardStr.length() - 1);
		}
		//Parse by vertical line 
		String[] cellsStr = boardStr.split("[|]");
		String cellStr;
		for (int i = 0; i < cellsStr.length; ++i) {
			cellStr = cellsStr[i];
			//Check If there's a snake or ladder
			if (cellStr.contains("+")) {
				String[] ladder = cellStr.split("[+]");
				board[i] = new LadderSquare(Integer.parseInt(ladder[0]), Integer.parseInt(ladder[1]));
			} else if (cellStr.contains("-")) {
				String[] snake = cellStr.split("[-]");
				board[i] = new SnakeSquare(Integer.parseInt(snake[0]), Integer.parseInt(snake[1]));
			} else {
				board[i] = new SnLSquare(Integer.parseInt(cellStr));
			}
		}
		//Fill in the board if the string isn't complete 
		for (int i = cellsStr.length; i < NUM_SQUARES; ++i) {
			board[i] = new SnLSquare(i);
		}
	}

	/**
	 * Move the player to a new space.
	 *
	 * @param player the player to moving
	 * @return true, if the player rolled doubles
	 */
	public boolean takeTurn(int player) {
		int tot = dice.roll();
		if (players[player] + tot > board.length) {
			players[player] = board[board.length - (players[player] + tot - board.length) - 1].landOn();
		} else {
			players[player] = board[players[player] + tot - 1].landOn();
		}
		System.out.println("Player " + player + " rolled " + tot);
		return dice.hasDoubles();
	}

	/**
	 * Checks if the player a winner.
	 *
	 * @param player the player to check
	 * @return true, if the player a winner
	 */
	public boolean isPlayerWinner(int player) {
		return players[player] == 100;
	}

	/**
	 * Gets the winner.
	 *
	 * @return the winner
	 */
	public int getWinner() {
		for (int i = 0; i < players.length; ++i) {
			if (players[i] == 100) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Gets the player position.
	 *
	 * @param player the player
	 * @return the player position
	 */
	public int getPlayerPosition(int player) {
		return players[player];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String string = "";
		SnLSquare cell;
		int numLine = (int) Math.sqrt(board.length);
		for (int i = 0; i < board.length; ++i) {
			cell = board[i];
			if (cell.getNumber() < cell.landOn()) {
				string += "|" + cell.getNumber() + "+" + cell.landOn();
			} else if (cell.getNumber() > cell.landOn()) {
				string += "|" + cell.getNumber() + "-" + cell.landOn();
			} else {
				string += "|" + cell.getNumber();
			}
			if (i % numLine == 0 && i != 0) {
				string += "\n";
			}
		}
		return string;
	}

	/**
	 * Generate a string of all the player locations.
	 *
	 * @return the string
	 */
	public String toStringCurrentPositions() {
		String string = "";
		for (int i = 0; i < players.length; ++i) {
			string += i + ":" + players[i] + " ";
		}
		return string;
	}

	/**
	 * The snakes and ladders client runs a random game of snakes and ladders.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		int NUM_PLAYERS = 100;
		SnakesAndLadders sal = new SnakesAndLadders(NUM_PLAYERS);
		int player = 0;
		System.out.println(sal.toString());
		while (sal.getWinner() == -1) {
			while (sal.takeTurn(player)) {
				if (sal.isPlayerWinner(player)) {
					break;
				}
			}
			System.out.println(sal.toStringCurrentPositions());
			player++;
			if (player >= NUM_PLAYERS) {
				player = 0;
			}
		}
		System.out.println("Player " + sal.getWinner() + " wins.");
	}
}
