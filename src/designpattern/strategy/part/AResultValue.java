package designpattern.strategy.part;

import lombok.Data;
import designpattern.strategy.core.DataMakerResultValue;

@Data
public class AResultValue implements DataMakerResultValue {

	private String data;

	@Override
	@SuppressWarnings("unchecked")
	public Object getResult() {
		return this;
	}
}