package designpattern.strategy.part;

import designpattern.strategy.core.AbstractDataMaker;
import designpattern.strategy.core.DataMakerParam;
import designpattern.strategy.core.DataMakerResultValue;

public class APart extends AbstractDataMaker<AData> {

	@Override
	protected boolean checkParam(DataMakerParam param) {
		AParam aParam = param.getParam();
		if (aParam.getId() == 0) {
			return false;
		}

		return true;
	}

	@Override
	protected AData getData() {
		AData aData = new AData();
		aData.setMsg("nkee");
		return aData;
	}

	@Override
	protected void makeParam(AData data, DataMakerResultValue value) {
		AResultValue resultValue = value.getResult();
		resultValue.setData(data.getMsg());
	}
}