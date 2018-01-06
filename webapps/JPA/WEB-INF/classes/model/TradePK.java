package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the trades database table.
 * 
 */
@Embeddable
public class TradePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	
	private String code;

	@Temporal(TemporalType.DATE)
	private java.util.Date date;

	private String type;
	public TradePK( String code,java.util.Date date,String type) {
		this.code=code;

		this.date=date;
		this.type=type;

		}
	public TradePK() {
	}
	public String getCode() {
		return this.code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public java.util.Date getDate() {
		return this.date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TradePK)) {
			return false;
		}
		TradePK castOther = (TradePK)other;
		return 
			this.code.equals(castOther.code)
			&& this.date.equals(castOther.date)
			&& this.type.equals(castOther.type);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.code.hashCode();
		hash = hash * prime + this.date.hashCode();
		hash = hash * prime + this.type.hashCode();
		
		return hash;
	}
	@Override
	public String toString() {
		return "TradePK [code=" + code + ", date=" + date + ", type=" + type + "]";
	}
	
	
	
	
}