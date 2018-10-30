
/**
 * The Class SorLSquare.
 * 
 * @author Daniel Innes 101067175
 */
public class SorLSquare extends SnLSquare {

	/** The square that the snake or ladder lands on.*/
	private int endSquare;

	/**
	 * Instantiates a new snake or ladder square.
	 *
	 * @param number the square number
	 * @param endSquare the square that the snake or ladder lands on
	 */
	public SorLSquare(int number, int endSquare) {
		super(number);
		if (number == endSquare) {
			throw new IllegalArgumentException();
		}
		this.endSquare = endSquare;
	}

	/**
	 * Gets square the snake or ladder lands on
	 *
	 * @return the end square
	 */
	public int getEndSquare() {
		return endSquare;
	}

	/* (non-Javadoc)
	 * @see SnLSquare#landOn()
	 */
	public int landOn() {
		return endSquare;
	}

	/* (non-Javadoc)
	 * @see SnLSquare#toString()
	 */
	public String toString() {
		return getNumber() + ":" + endSquare;
	}

	/* (non-Javadoc)
	 * @see SnLSquare#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (o == null)
			return false;
		if (this.getClass() != o.getClass())
			return false;
		return (this.getNumber() == ((SorLSquare) o).getNumber());
	}
}
