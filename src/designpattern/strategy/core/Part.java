package designpattern.strategy.core;

public interface Part {

	void executeService();

	void setParam(DataMakerParam param);

	void setValue(DataMakerResultValue value);
}
