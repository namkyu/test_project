package designpattern.strategy.core;



public abstract class AbstractDataMaker<T> implements Part {

	private DataMakerParam param;
	private DataMakerResultValue value;

	@Override
	public void setParam(DataMakerParam param) {
		this.param = param;
	}
	@Override
	public void setValue(DataMakerResultValue value) {
		this.value = value;
	}
	@Override
	public void executeService() {
		service();
	}

	public boolean service() {
		try {
			// 유효성 체크
			boolean valid = checkParam(param);
			if (!valid) {
				return false;
			}

			// 데이터 생성
			T data = getData();
			makeParam(data, value);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return true;
	}


	protected abstract boolean checkParam(DataMakerParam param);
	protected abstract T getData();
	protected abstract void makeParam(T data, DataMakerResultValue value);
}