
public class SorLSquare extends SnLSquare {

	private int EndSquare;

	public SorLSquare(int number, int endSquare) {
		super(number);
	}

	public int getEndSquare() {
		return EndSquare;
	}

	public int landOn() {
		return 0;
	}

	public String toString() {
		return null;
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
