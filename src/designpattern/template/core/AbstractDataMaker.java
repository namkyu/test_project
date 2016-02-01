package designpattern.template.core;



public abstract class AbstractDataMaker<T> implements Part {

	@Override
	public void executeService(DataMakerParam param, DataMakerResultValue value) {
		service(param, value);
	}

	public boolean service(DataMakerParam param, DataMakerResultValue value) {
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