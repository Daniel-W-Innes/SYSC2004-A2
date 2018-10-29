
public class SnLSquare {

	private int number;

	public SnLSquare(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public int landOn() {
		return number;
	}

	public String toString() {
		return Integer.toString(number);
	}

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
