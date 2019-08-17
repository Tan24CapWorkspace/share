package com.cg.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author tanmpath
 *
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="invoice")
public class Invoice {
	@Id
	@Column(name="invoiceid")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer invoiceId;
	
	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}

	private Integer userid;
	
	private String firstname;
	
	private String lastname;
	
	private Long mobileno;
	
	private String emailid;
	
	private Integer productid;
	
	private String productname;
	
	private Double price;
	
	private Integer quantity;
	
	private Integer merchantid;
	
	private String merchantname;
	
	private String merchantemailid;
	
	private Date dateofpurchanse;
	
	public Invoice() {
		// TODO Auto-generated constructor stub
	}

	public Invoice(Integer userid, String firstname, String lastname, Long mobileno, String emailid, Integer productid,
			String productname, Double price, Integer quantity, Integer merchantid, String merchantname,
			String merchantemailid, Date dateofpurchanse) {
		super();
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobileno = mobileno;
		this.emailid = emailid;
		this.productid = productid;
		this.productname = productname;
		this.price = price;
		this.quantity = quantity;
		this.merchantid = merchantid;
		this.merchantname = merchantname;
		this.merchantemailid = merchantemailid;
		this.dateofpurchanse = dateofpurchanse;
	}


	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Long getMobileno() {
		return mobileno;
	}

	public void setMobileno(Long mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getMerchantid() {
		return merchantid;
	}

	public void setMerchantid(Integer merchantid) {
		this.merchantid = merchantid;
	}

	public String getMerchantname() {
		return merchantname;
	}

	public void setMerchantname(String merchantname) {
		this.merchantname = merchantname;
	}

	public String getMerchantemailid() {
		return merchantemailid;
	}

	public void setMerchantemailid(String merchantemailid) {
		this.merchantemailid = merchantemailid;
	}

	public Date getDateofpurchanse() {
		return dateofpurchanse;
	}

	public void setDateofpurchanse(Date dateofpurchanse) {
		this.dateofpurchanse = dateofpurchanse;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceId=" + invoiceId + ", userid=" + userid + ", firstname=" + firstname + ", lastname="
				+ lastname + ", mobileno=" + mobileno + ", emailid=" + emailid + ", productid=" + productid
				+ ", productname=" + productname + ", price=" + price + ", quantity=" + quantity + ", merchantid="
				+ merchantid + ", merchantname=" + merchantname + ", merchantemailid=" + merchantemailid
				+ ", dateofpurchanse=" + dateofpurchanse + "]";
	}
	
	
	
	
}
