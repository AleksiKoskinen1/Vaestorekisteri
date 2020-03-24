package vaestorekisteri;

import java.io.Serializable;

public class Property implements Serializable {
    private static final long serialVersionUID = 1L;

	private String propertyID;
    private String location;
    private String registerationDate;
    private String owner;
    
    public Property(String id, String loc, String regDate, String owner) {
    	this.propertyID = id;
    	this.location = loc;
    	this.registerationDate = regDate;
    	this.owner = owner;
    }
    
	public String getPropertyID() {
		return propertyID;
	}
	public void setPropertyID(String propertyID) {
		this.propertyID = propertyID;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRegisterationDate() {
		return registerationDate;
	}
	public void setRegisterationDate(String registerationDate) {
		this.registerationDate = registerationDate;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
    
    
    
}
