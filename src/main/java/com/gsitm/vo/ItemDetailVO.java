package com.gsitm.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
public class ItemDetailVO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1324786697845539776L;


    @Getter
    @Setter
    @Column(name = "row_num")
    int rn; //리스트 번호

    @Getter
    @Setter
    @Column(name = "item_code")
    String ic; //품목 코드

    @Getter
    @Setter
    @Id
    @Column(name = "sale_date")
    Date sd; //가격일자

    @Getter
    @Setter
    @Id
    @Column(name = "product_id")
    String pi; //상품ID

    @Getter
    @Setter
    @Column(name = "product_name")
    String pn; //상품name

    @Getter
    @Setter
    @Column(name = "sale_price")
    int sp; //판매가격

    @Getter
    @Setter
    @Column(name = "discount_price")
    int dp; //할인가격

    @Getter
    @Setter
    @Column(name = "benefit_price")
    int bp; //해택가격


}
