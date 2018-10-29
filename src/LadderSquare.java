
public class LadderSquare extends SorLSquare {

	public LadderSquare(int number, int endSquare) {
		super(number, endSquare);
		if (number >= endSquare) {
			throw new IllegalArgumentException();
		}
	}

	public int landOn() {
		return getEndSquare();
	}

	public String toString() {
		return getNumber() + "+" + getEndSquare();
	}
}
