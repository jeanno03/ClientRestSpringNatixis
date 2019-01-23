package myEntities;

import java.util.Arrays;

public class Data {
	
	private result[] result;

	public Data() {
		super();
	}

	public result[] getResult() {
		return result;
	}

	public void setResult(result[] result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Data [result=" + Arrays.toString(result) + "]";
	}
	
	

}
