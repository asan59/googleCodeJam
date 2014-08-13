package org.sezavar.cj.util;

public enum InputOutputType {
	SMALL("small-practice.in", "small.out", 1), LARGE("large-practice.in",
			"large.out", 2),VERY_SMALL("very-small-practice.in", "very-small.out", 1);

	private String inputName;
	private String outputName;
	private int id;

	private InputOutputType(String inputName, String outputName, int id) {
		this.inputName = inputName;
		this.outputName = outputName;
		this.id = id;
	}

	public String getInputName() {
		return inputName;
	}

	public String getOutputName() {
		return outputName;
	}

	public int getId() {
		return id;
	}

}
