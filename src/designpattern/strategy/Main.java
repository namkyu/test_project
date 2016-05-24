package designpattern.strategy;

import designpattern.strategy.core.DataMakerParam;
import designpattern.strategy.core.DataMakerResultValue;
import designpattern.strategy.core.Part;
import designpattern.strategy.part.AParam;
import designpattern.strategy.part.APart;
import designpattern.strategy.part.AResultValue;

public class Main {

	public static void main(String[] args) {
		DataMakerParam param = new AParam();
		DataMakerResultValue resultValue = new AResultValue();

		Part part = new APart();
		part.setParam(param);
		part.setValue(resultValue);
		part.executeService();
		System.out.println(resultValue);
	}
}
