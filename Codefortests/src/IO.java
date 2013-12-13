public class IO {
	String input;
	String output;

	public IO(String input, String output) {
		this.input = input;
		this.output = output;
	}

	@Override
	public String toString() {
		return input + " " + output;
	}
}