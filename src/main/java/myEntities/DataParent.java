package myEntities;

public class DataParent {
	
	private Data data;
	private Meta meta;
	private Error error;

	public DataParent() {
		super();
	}

	public DataParent(Data data) {
		super();
		this.data = data;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "DataParent [data=" + data + "]";
	}
	
	

}
