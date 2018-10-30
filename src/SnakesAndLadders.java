
public class SnakesAndLadders {

	public int NUM_PLAYERS;
	public int NUM_SQUARES = 100;
	private SnLSquare[] board;
	private int[] players;
	private Dice dice;

	public SnakesAndLadders() {
		this(2);
	}

	public SnakesAndLadders(int nPlayers) {
		NUM_PLAYERS = nPlayers;
		players = new int[NUM_PLAYERS];
		dice = new Dice();
		for (int i = 0; i < NUM_PLAYERS; ++i) {
			players[i] = 1;
		}
		board = new SnLSquare[101];
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
		boardStr = boardStr.replaceAll("\\s+", "").substring(1);
		String[] cellsStr = boardStr.split("[|]");
		String cellStr;
		for (int i = 0; i < cellsStr.length; ++i) {
			cellStr = cellsStr[i];
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
	}

	public static void main(String[] args) {
		int NUM_PLAYERS = 1;
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

	public int getPlayerPosition(int player) {
		return players[player];
	}

	public String toStringCurrentPositions() {
		String string = "";
		for (int i = 0; i < players.length; ++i) {
			string += i + ":" + players[i] + " ";
		}
		return string;
	}

	public boolean takeTurn(int player) {
		int tot = dice.roll();
		if (players[player] + tot > 100) {
			players[player] = board[100 - (players[player] + tot - 100)].landOn();
		} else {
			players[player] = board[players[player] + tot].landOn();
		}
		System.out.println("Player " + player + " rolled " + tot);
		return dice.hasDoubles();
	}

	public boolean isPlayerWinner(int player) {
		return players[player] == 100;
	}

	public int getWinner() {
		for (int i = 0; i < players.length; ++i) {
			if (players[i] == 100) {
				return i;
			}
		}
		return -1;
	}

	public String toString() {
		String string = "";
		SnLSquare cell;
		int numLine = (int) Math.sqrt(board.length);
		for (int i = 0; i < board.length; ++i) {
			cell = board[i];
			if (cell != null) {
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
		}
		return string;
	}

}
