/** Author: Ammar_Sathar_40182146 */
package coen352.ch4.dictionary;


public class InventoryRecord implements Comparable<InventoryRecord>, ADTInventoryRecord{
	private String	inventoryID;
	private String	name;
	private String	description;
	private double unitPrice;
	private long	qtyInStock;
	private double inventoryValue;
	private int reorderLevel;
	private int reorderTime;
	private int reorderQty;
	private boolean discontinued;
	public String getInventoryID() {
		return inventoryID;
	}
	public void setInventoryID(String sku) {
		this.inventoryID = sku;
	}
	public String getName() {
			return name;
	}
	public void setName(String name) {this.name = name;}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	/** Constructors */
	InventoryRecord(String inventoryID,String name,String description,double unitPrice,long qtyInStock,double inventoryValue,int reorderLevel,int reorderTime, int reorderQty,boolean discontinued) {
		this.inventoryID = inventoryID;
		this.name = name;
		this.description = description;
		this.unitPrice = unitPrice;
		this.qtyInStock = qtyInStock;
		this.inventoryValue= inventoryValue;
		this.reorderLevel= reorderLevel;
		this.reorderTime= reorderTime;
		this.reorderQty= reorderQty;
		this.discontinued= discontinued;
	}


	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getUnitPrice() {return unitPrice;}
	public void setReorderLevel(int reorderLevel){this.reorderLevel = reorderLevel;}
	public int getReorderLevel(){return reorderLevel;}
	public void setReorderTime(int reorderTime){this.reorderTime = reorderTime;}
	public int	getReorderTime(){return reorderTime;}
	public void setReorderQty(int reorderQty){this.reorderQty = reorderQty;}
	public int getReorderQty(){return reorderQty;}
	public long getQtyInStock() {
		return qtyInStock;
	}
	public void setQtyInStock(long qty) {
		this.qtyInStock = qty;
	}
	public double getInventoryValue() {
		return inventoryValue;
	}
	public void setInventoryValue(double inventoryValue) {
		this.inventoryValue = inventoryValue;
	}

	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}

	public boolean getDiscontinued(){return discontinued;}


	public int compareTo(InventoryRecord other)
     {
    	 return this.getInventoryID().compareTo(other.getInventoryID());
     }


	 public String print() {
		return "InventoryRecord{" +
				"inventoryID='" + inventoryID + '\'' +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", unitPrice=" + unitPrice +
				", qtyInStock=" + qtyInStock +
				", inventoryValue=" + inventoryValue +
				", reorderLevel=" + reorderLevel +
				", reorderTime=" + reorderTime +
				", reorderQty=" + reorderQty +
				", discontinued=" + discontinued +
                "}";
	}
	
}
