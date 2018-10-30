/**
 * The Class LadderSquare.
 * 
 * @author Daniel Innes 101067175
 */
public class LadderSquare extends SorLSquare {

	/**
	 * Instantiates a new ladder square.
	 *
	 * @param number    the square number
	 * @param endSquare the end square
	 */
	public LadderSquare(int number, int endSquare) {
		super(number, endSquare);
		if (number >= endSquare) {
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
		return getNumber() + "+" + getEndSquare();
	}
}
