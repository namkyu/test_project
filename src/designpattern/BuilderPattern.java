package designpattern;

/**
 * @FileName : BuilderPattern.java
 * @Project : test_project
 * @Date : 2016. 1. 18.
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class BuilderPattern {

	public static void main(String[] args) {

		OrderBean orderBea = new OrderBean.Builder()
									.setOrderName("감자").setOrderCnt(3)
									.setCustomerCnt(3).setTableNumber(123)
									.build();

		System.out.println(orderBea);
	}
}
