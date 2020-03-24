package vaestorekisteri;

import java.io.Serializable;

public class Building implements Serializable {
    private static final long serialVersionUID = 1L;

    private String buildingID;
    private String location;
    private String owner;
    private String squareMeter;
    private String supply;
    private String connections;
    private String usedFor;
    private String readyDate;
    
    /* 
     * Luodaan Rakennus kannassa olevilla tiedoilla, jotka saadaan parametrina
     */
    public Building(String id, String loc, String owner, String sm, String supply, String conn, String uFor, String rdy) {
    	this.buildingID = id;
    	this.location = loc;
    	this.owner = owner;
    	this.squareMeter = sm;
    	this.supply = supply;
    	this.connections = conn;
    	this.usedFor = uFor;
    	this.readyDate = rdy;
    }
    
	public String getBuildingID() {
		return buildingID;
	}

	public void setBuildingID(String buildingID) {
		this.buildingID = buildingID;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getSquareMeter() {
		return squareMeter;
	}

	public void setSquareMeter(String squareMeter) {
		this.squareMeter = squareMeter;
	}

	public String getSupply() {
		return supply;
	}

	public void setSupply(String supply) {
		this.supply = supply;
	}

	public String getConnections() {
		return connections;
	}

	public void setConnections(String connections) {
		this.connections = connections;
	}

	public String getUsedFor() {
		return usedFor;
	}

	public void setUsedFor(String usedFor) {
		this.usedFor = usedFor;
	}

	public String getReadyDate() {
		return readyDate;
	}

	public void setReadyDate(String readyDate) {
		this.readyDate = readyDate;
	}
}