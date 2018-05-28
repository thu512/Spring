package com.gsitm.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@Entity
public class ItemVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2717334534840422106L;

	@Getter
	@Setter
	@Column(name="row_num")
	int rn; //리스트 번호
	

	@Getter
	@Setter
	@Id
	@Column(name="item_code")
	String ic; //품목 코드

	@Getter
	@Setter
	@Column(name="item_name")
	String in; //품목 명



}
