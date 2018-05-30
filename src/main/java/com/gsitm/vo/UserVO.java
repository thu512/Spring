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
public class UserVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -140192797149410804L;


	@Getter
	@Setter
	@Id
	@Column(name="id")
	String id; //리스트 번호
	

	@Getter
	@Setter
	@Column(name="password")
	String pwd; //품목 코드

	@Getter
	@Setter
	@Column(name="roll_name")
	String rn; //품목 명

	


}
