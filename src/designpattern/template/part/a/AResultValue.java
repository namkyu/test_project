package designpattern.template.part.a;

import lombok.Data;
import designpattern.template.core.DataMakerResultValue;

@Data
public class AResultValue implements DataMakerResultValue {

	private String data;

	@Override
	@SuppressWarnings("unchecked")
	public Object getResult() {
		return this;
	}
}