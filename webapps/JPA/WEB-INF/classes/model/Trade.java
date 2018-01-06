package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the trades database table.
 * 
 */
@Entity
@Table(name="trades")
@NamedQuery(name="Trade.findAll", query="SELECT t FROM Trade t")
public class Trade implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TradePK id;

	@Lob
	private String chart;

	private String learn;

	private String notes;

	public Trade(TradePK id) {
	this.id=id;
	}

	public Trade() {
	}
	
	public TradePK getId() {
		return this.id;
	}

	public void setId(TradePK id) {
		this.id = id;
	}

	public String getChart() {
		return this.chart;
	}

	public void setChart(String chart) {
		this.chart = chart;
	}

	public String getLearn() {
		return this.learn;
	}

	public void setLearn(String learn) {
		this.learn = learn;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Trade [id=" + id + ", chart=" + chart + ", learn=" + learn + ", notes=" + notes + "]";
	}

	
	
}