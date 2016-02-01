package designpattern;

import lombok.Data;
import lombok.Getter;

@Data
public class OrderBean {

	private String orderName;
	private int orderCnt;
	private int tableNumber;
	private int customerCnt;

	private OrderBean(Builder builder) {
		this.orderName = builder.getOrderName();
		this.orderCnt = builder.getOrderCnt();
		this.tableNumber = builder.getTableNumber();
		this.customerCnt = builder.getCustomerCnt();
	}

	public static class Builder {
		@Getter	private String orderName;
		@Getter private int orderCnt;
		@Getter private int tableNumber;
		@Getter private int customerCnt;

		public Builder setCustomerCnt(int customerCnt) {
			this.customerCnt = customerCnt;
			return this;
		}

		public Builder setOrderCnt(int orderCnt) {
			this.orderCnt = orderCnt;
			return this;
		}

		public Builder setOrderName(String orderName) {
			this.orderName = orderName;
			return this;
		}

		public Builder setTableNumber(int tableNumber) {
			this.tableNumber = tableNumber;
			return this;
		}

		public OrderBean build() {
			return new OrderBean(this);
		}

	}
}
