
public class SorLSquare extends SnLSquare {

	private int endSquare;

	public SorLSquare(int number, int endSquare) {
		super(number);
		if (number == endSquare) {
			throw new IllegalArgumentException();
		}
		this.endSquare = endSquare;
	}

	public int getEndSquare() {
		return endSquare;
	}

	public int landOn() {
		return endSquare;
	}

	public String toString() {
		return getNumber() + ":" + endSquare;
	}

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
