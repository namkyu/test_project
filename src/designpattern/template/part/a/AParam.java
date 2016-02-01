package designpattern.template.part.a;

import lombok.Data;
import designpattern.template.core.DataMakerParam;

@Data
public class AParam implements DataMakerParam {

	private int id;

	@Override
	@SuppressWarnings("unchecked")
	public Object getParam() {
		AParam aParam = new AParam();
		aParam.setId(100);
		return aParam;
	}


}
