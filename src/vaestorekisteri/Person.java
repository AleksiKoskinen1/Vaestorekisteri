package vaestorekisteri;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String hetu;
    private String address;
    private String nationality;
    private String nativeLanguage;
    private String familyInfo;
    private String born;
    private String deathInfo;
    private List<Building> buildings;
    private List<Property> properties;

    /* 
     * Luodaan henkilö kannassa olevilla tiedoilla, jotka saadaan parametrina
     */
    public Person(String name, String hetu, String address, String natio, String nativeL, String famInfo, String born, String death) {
        this.name = name;
        this.hetu = hetu;
        this.address = address;
        this.nationality = natio;
        this.nativeLanguage = nativeL;
        this.familyInfo = famInfo;
        this.born = born;
        this.deathInfo = death;
    }

    /*
     * Jos henkilö omistaa rakennuksia, liitetään Building tyyppinen lista henkilöön 
     * (Lista sisältää 1..* Building tyyppistä olioo)
     */
	public void setBuildings(List<Building> buildings) {
		this.buildings = buildings;
	}
	
	public List<Building> getBuildings(){
		return buildings;
	}
	
	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHetu() {
		return hetu;
	}

	public void setHetu(String hetu) {
		this.hetu = hetu;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getNativeLanguage() {
		return nativeLanguage;
	}

	public void setNativeLanguage(String nativeLanguage) {
		this.nativeLanguage = nativeLanguage;
	}

	public String getFamilyInfo() {
		return familyInfo;
	}

	public void setFamilyInfo(String familyInfo) {
		this.familyInfo = familyInfo;
	}

	public String getBorn() {
		return born;
	}

	public void setBorn(String born) {
		this.born = born;
	}

	public String getDeathInfo() {
		return deathInfo;
	}

	public void setDeathInfo(String deathInfo) {
		this.deathInfo = deathInfo;
	}

	
}