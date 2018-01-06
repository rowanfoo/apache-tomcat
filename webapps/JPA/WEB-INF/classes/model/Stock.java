package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the stock database table.
 * 
 */
@Entity
@NamedQuery(name="Stock.findAll", query="SELECT s FROM Stock s")
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String code;

	private String aindex;

	private float alertPrice;

	private double buyTrigger;

	private String category;

	private String chart;

	private String consequtivelow;

	private String dailyNotes;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String defendKeyNotes;

	private float defendKeyPrice;

	private String descp;

	private String easyChange;

	private String fundNotes;

	private String FYdate;

	private float keySupportPrice;

	private String keySupportPriceNotes;

	private String marketCap;

	@Lob
	private String moat;

	private String montlyNotes;

	private String name;

	private String news;

	private String nope;

	private String normandyNotes;

	private float normandyPrice;

	@Lob
	private String notes1;

	@Lob
	private String notes2;

	private String oneNotes;

	private String reason;

	private String research;

	private String researchCat;

	private BigInteger shares;

	private String stageGrowth;

	private float stopLoss;

	private String stopLossNotes;

	private String subcategory;

	private String technicalNotes;

	private String top;

	private String trend;

	private String weeklyNotes;

	private String whenBuy;

	private double whenBuyPrice;

	private String wishlist;

	////bi-directional many-to-one association to Trade
//	@OneToMany(mappedBy="stock")
	//private List<Trade> trades;

	public Stock() {
	}

	public Stock(String code) {
		this.code=code;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAindex() {
		return this.aindex;
	}

	public void setAindex(String aindex) {
		this.aindex = aindex;
	}

	public float getAlertPrice() {
		return this.alertPrice;
	}

	public void setAlertPrice(float alertPrice) {
		this.alertPrice = alertPrice;
	}

	public double getBuyTrigger() {
		return this.buyTrigger;
	}

	public void setBuyTrigger(double buyTrigger) {
		this.buyTrigger = buyTrigger;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getChart() {
		return this.chart;
	}

	public void setChart(String chart) {
		this.chart = chart;
	}

	public String getConsequtivelow() {
		return this.consequtivelow;
	}

	public void setConsequtivelow(String consequtivelow) {
		this.consequtivelow = consequtivelow;
	}

	public String getDailyNotes() {
		return this.dailyNotes;
	}

	public void setDailyNotes(String dailyNotes) {
		this.dailyNotes = dailyNotes;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDefendKeyNotes() {
		return this.defendKeyNotes;
	}

	public void setDefendKeyNotes(String defendKeyNotes) {
		this.defendKeyNotes = defendKeyNotes;
	}

	public float getDefendKeyPrice() {
		return this.defendKeyPrice;
	}

	public void setDefendKeyPrice(float defendKeyPrice) {
		this.defendKeyPrice = defendKeyPrice;
	}

	public String getDescp() {
		return this.descp;
	}

	public void setDescp(String descp) {
		this.descp = descp;
	}

	public String getEasyChange() {
		return this.easyChange;
	}

	public void setEasyChange(String easyChange) {
		this.easyChange = easyChange;
	}

	public String getFundNotes() {
		return this.fundNotes;
	}

	public void setFundNotes(String fundNotes) {
		this.fundNotes = fundNotes;
	}

	public String getFYdate() {
		return this.FYdate;
	}

	public void setFYdate(String FYdate) {
		this.FYdate = FYdate;
	}

	public float getKeySupportPrice() {
		return this.keySupportPrice;
	}

	public void setKeySupportPrice(float keySupportPrice) {
		this.keySupportPrice = keySupportPrice;
	}

	public String getKeySupportPriceNotes() {
		return this.keySupportPriceNotes;
	}

	public void setKeySupportPriceNotes(String keySupportPriceNotes) {
		this.keySupportPriceNotes = keySupportPriceNotes;
	}

	public String getMarketCap() {
		return this.marketCap;
	}

	public void setMarketCap(String marketCap) {
		this.marketCap = marketCap;
	}

	public String getMoat() {
		return this.moat;
	}

	public void setMoat(String moat) {
		this.moat = moat;
	}

	public String getMontlyNotes() {
		return this.montlyNotes;
	}

	public void setMontlyNotes(String montlyNotes) {
		this.montlyNotes = montlyNotes;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNews() {
		return this.news;
	}

	public void setNews(String news) {
		this.news = news;
	}

	public String getNope() {
		return this.nope;
	}

	public void setNope(String nope) {
		this.nope = nope;
	}

	public String getNormandyNotes() {
		return this.normandyNotes;
	}

	public void setNormandyNotes(String normandyNotes) {
		this.normandyNotes = normandyNotes;
	}

	public float getNormandyPrice() {
		return this.normandyPrice;
	}

	public void setNormandyPrice(float normandyPrice) {
		this.normandyPrice = normandyPrice;
	}

	public String getNotes1() {
		return this.notes1;
	}

	public void setNotes1(String notes1) {
		this.notes1 = notes1;
	}

	public String getNotes2() {
		return this.notes2;
	}

	public void setNotes2(String notes2) {
		this.notes2 = notes2;
	}

	public String getOneNotes() {
		return this.oneNotes;
	}

	public void setOneNotes(String oneNotes) {
		this.oneNotes = oneNotes;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getResearch() {
		return this.research;
	}

	public void setResearch(String research) {
		this.research = research;
	}

	public String getResearchCat() {
		return this.researchCat;
	}

	public void setResearchCat(String researchCat) {
		this.researchCat = researchCat;
	}

	public BigInteger getShares() {
		return this.shares;
	}

	public void setShares(BigInteger shares) {
		this.shares = shares;
	}

	public String getStageGrowth() {
		return this.stageGrowth;
	}

	public void setStageGrowth(String stageGrowth) {
		this.stageGrowth = stageGrowth;
	}

	public float getStopLoss() {
		return this.stopLoss;
	}

	public void setStopLoss(float stopLoss) {
		this.stopLoss = stopLoss;
	}

	public String getStopLossNotes() {
		return this.stopLossNotes;
	}

	public void setStopLossNotes(String stopLossNotes) {
		this.stopLossNotes = stopLossNotes;
	}

	public String getSubcategory() {
		return this.subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public String getTechnicalNotes() {
		return this.technicalNotes;
	}

	public void setTechnicalNotes(String technicalNotes) {
		this.technicalNotes = technicalNotes;
	}

	public String getTop() {
		return this.top;
	}

	public void setTop(String top) {
		this.top = top;
	}

	public String getTrend() {
		return this.trend;
	}

	public void setTrend(String trend) {
		this.trend = trend;
	}

	public String getWeeklyNotes() {
		return this.weeklyNotes;
	}

	public void setWeeklyNotes(String weeklyNotes) {
		this.weeklyNotes = weeklyNotes;
	}

	public String getWhenBuy() {
		return this.whenBuy;
	}

	public void setWhenBuy(String whenBuy) {
		this.whenBuy = whenBuy;
	}

	public double getWhenBuyPrice() {
		return this.whenBuyPrice;
	}

	public void setWhenBuyPrice(double whenBuyPrice) {
		this.whenBuyPrice = whenBuyPrice;
	}

	public String getWishlist() {
		return this.wishlist;
	}

	public void setWishlist(String wishlist) {
		this.wishlist = wishlist;
	}

//	public List<Trade> getTrades() {
	//	return this.trades;
	//}

	//public void setTrades(List<Trade> trades) {
		//this.trades = trades;
//	}
/*
	public Trade addTrade(Trade trade) {
		getTrades().add(trade);
		trade.setStock(this);

		return trade;
	}

	public Trade removeTrade(Trade trade) {
		getTrades().remove(trade);
		trade.setStock(null);

		return trade;
	}
*/
}