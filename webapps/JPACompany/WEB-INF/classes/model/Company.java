package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the company database table.
 * 
 */
@Entity
@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CompanyPK id;

	private double asset;

	private double cash;

	private String category;

	private double cf;

	private double debt;

	private String desc;

	private double dividend;

	private double ebit;

	private double eps;

	private double equity;

	private double npat;

	private double sales;

	public Company() {
	}

	
	public Company(CompanyPK id){
		this.id=id;
	}
	
	public CompanyPK getId() {
		return this.id;
	}

	public void setId(CompanyPK id) {
		this.id = id;
	}

	public double getAsset() {
		return this.asset;
	}

	public void setAsset(double asset) {
		this.asset = asset;
	}

	public double getCash() {
		return this.cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getCf() {
		return this.cf;
	}

	public void setCf(double cf) {
		this.cf = cf;
	}

	public double getDebt() {
		return this.debt;
	}

	public void setDebt(double debt) {
		this.debt = debt;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getDividend() {
		return this.dividend;
	}

	public void setDividend(double dividend) {
		this.dividend = dividend;
	}

	public double getEbit() {
		return this.ebit;
	}

	public void setEbit(double ebit) {
		this.ebit = ebit;
	}

	public double getEps() {
		return this.eps;
	}

	public void setEps(double eps) {
		this.eps = eps;
	}

	public double getEquity() {
		return this.equity;
	}

	public void setEquity(double equity) {
		this.equity = equity;
	}

	public double getNpat() {
		return this.npat;
	}

	public void setNpat(double npat) {
		this.npat = npat;
	}

	public double getSales() {
		return this.sales;
	}

	public void setSales(double sales) {
		this.sales = sales;
	}

}