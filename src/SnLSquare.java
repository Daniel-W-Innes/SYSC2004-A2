
public class SnLSquare {

	private int number;

	public SnLSquare(int number) {

	}

	public int getNumber() {
		return number;
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
