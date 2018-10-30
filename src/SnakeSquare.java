
/**
 * The Class SnakeSquare.
 * 
 * @author Daniel Innes 101067175
 */
public class SnakeSquare extends SorLSquare {

	/**
	 * Instantiates a new snake square.
	 *
	 * @param number    the square number
	 * @param endSquare the end square
	 */
	public SnakeSquare(int number, int endSquare) {
		super(number, endSquare);
		if (number <= endSquare) {
			throw new IllegalArgumentException();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SorLSquare#landOn()
	 */
	public int landOn() {
		return getEndSquare();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SorLSquare#toString()
	 */
	public String toString() {
		return getNumber() + "-" + getEndSquare();
	}

}
