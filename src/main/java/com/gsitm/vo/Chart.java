package com.gsitm.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Chart {
	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	private int price;

	public Chart(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	
}
