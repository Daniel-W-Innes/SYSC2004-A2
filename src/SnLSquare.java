/**
 * The Class SnLSquare.
 */
public class SnLSquare {

	/** The square number. */
	private int number;

	/**
	 * Instantiates a new square.
	 *
	 * @param number the square number
	 */
	public SnLSquare(int number) {
		this.number = number;
	}

	/**
	 * Gets the square number.
	 *
	 * @return the square number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Gets square the snake or ladder lands on. If it is not a snake or ladder it
	 * is equivalent to number.
	 *
	 * @return the new number
	 */
	public int landOn() {
		return number;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return Integer.toString(number);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (o == null)
			return false;
		if (this.getClass() != o.getClass())
			return false;
		return (this.getNumber() == ((SnLSquare) o).getNumber());
	}
}
