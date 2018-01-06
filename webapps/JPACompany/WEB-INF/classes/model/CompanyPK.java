package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the company database table.
 * 
 */
@Embeddable
public class CompanyPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	
	private String code;
	
	private String year;

	public CompanyPK() {
	}
	public CompanyPK(String code , String year) {
		this.code=code ;
		this.year=year;
	}
	public String getCode() {
		return this.code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getYear() {
		return this.year;
	}
	public void setYear(String year) {
		this.year = year;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CompanyPK)) {
			return false;
		}
		CompanyPK castOther = (CompanyPK)other;
		return 
			this.code.equals(castOther.code)
			&& this.year.equals(castOther.year);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.code.hashCode();
		hash = hash * prime + this.year.hashCode();
		
		return hash;
	}
}