package vaestorekisteri;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VaestoServlet")
public class VaestoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public VaestoServlet() {
        super();        
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=UTF-8"); 
		String url = "/result.jsp"; 
		String hetu = request.getParameter("hetu");  //Otetaan talteen syötetty hetu
		
		if(checkHetu(hetu)) { //Jos oli hetu 'kannassa'
			
			Person person = getPerson(hetu); //Haetaan hetulla person (todettu, että löytyy)
			
			 /*
			 * Haetaan hetulla, kaikki kyseisen henkilön mahdollisesti
			 * omistamat rakennukset( 0 .. * ) (Rakennuksen omistaja = henkilön hetu)
			 * 
			 */
			List<Building> buildings = getBuildings(hetu); //otetaan Building tyyppinen lista rakennuksista
			List<Property> properties = getProperties(hetu); //otetaan Property tyyppinen lista kiinteistöistä
			if(buildings.size() != 0) person.setBuildings(buildings);  //Yhdistetään rakennukset aiemmin luotuun henkilöön
			if(properties.size() != 0) person.setProperties(properties);  //Yhdistetään kiinteistöt aiemmin luotuun henkilöön
			
			request.setAttribute("successStatus", true); //Laitetaan requestiin tieto, että hetu on löytynyt
			request.setAttribute("person", person);  //Laitetaan hetun osoittama henkilö mukaan
		}
		else {
			request.setAttribute("successStatus", false); //Ei ollut hetua
			request.setAttribute("successStatusInfo", "Hetua ei ole kannassa");  //Laitetaan fail info
		}		
			    
		getServletContext().getRequestDispatcher(url).forward(request, response); //Näytetään result.jsp
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);		
	}
	
	protected boolean checkHetu(String hetu) {	
		
		/*
		 * Katsottaisiin tietokannasta, onko hetua olemassa taulussa,
		 * nyt testimielessä mennään eteenpäin, jos on syötetty 123
		 */
		if(hetu.equals("123")) return true;
		else return false;
		
	}
	
	protected Person getPerson(String hetu) {
		
		/*
		 * Etsittäisiin kannasta hetulla oikea ihminen, ja palautettaisiin 
		 * sen tiedoilla Person olio. Nyt vain palautetaan ko. olio
		 */
		return new Person("Aleksi", "123456-123A", "TestiKatu 3", "Suomi", "Suomi", "Avoliitossa, 2 lasta", "27.07.1986", null );
		
	}
	
	protected ArrayList<Building> getBuildings(String hetu){
		
		ArrayList<Building> list = new ArrayList<Building>();
		/*
		 * Haettaisiin hetulla tietokannasta, rakennukset taulusta 
		 * kaikki rakennukset, mitä ko. henkilö omistaa, ja niiden tiedot.
		 * Nyt laitetaan niin, että henkilö omistaa 2 rakennusta 
		 * hetu avaimena molempiin tauluihin (person, building)
		 */
		int Results = 2; 
		for(int x=0; x<Results; x++) {
			//otettaisiin resultista tiedot, mutta nyt kierretään se
			list.add(new Building("raktunnus"+x, "Helsinki", hetu , "100m", "Hyvät varusteet", "Liittymät", "Lepotarkoitus", "24.4.1985"));
		}
		
		return list;
		
	}
	
	protected ArrayList<Property> getProperties(String hetu){
		
		ArrayList<Property> list = new ArrayList<Property>();
		/*
		 * Haettaisiin hetulla tietokannasta, rakennukset taulusta 
		 * kaikki kiinteistöt, mitä ko. henkilö omistaa, ja niiden tiedot.
		 * Nyt laitetaan niin, että henkilö omistaa 1 kiinteistön 
		 * hetu avaimena molempiin tauluihin (person, property)
		 */
		int Results = 1; 
		for(int x=0; x<Results; x++) {
			//otettaisiin resultista tiedot, mutta nyt kierretään se
			list.add(new Property("kiintunnus"+x, "Helsinki", "24.4.2014" , hetu ));
		}
		
		return list;
		
	}

}
