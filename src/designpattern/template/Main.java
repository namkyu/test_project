package designpattern.template;

import designpattern.template.core.DataMakerParam;
import designpattern.template.core.DataMakerResultValue;
import designpattern.template.core.Part;
import designpattern.template.part.a.AParam;
import designpattern.template.part.a.APart;
import designpattern.template.part.a.AResultValue;

public class Main {

	public static void main(String[] args) {
		DataMakerParam param = new AParam();
		DataMakerResultValue resultValue = new AResultValue();

		Part part = new APart();
		part.executeService(param, resultValue);
		System.out.println(resultValue);
	}
}
