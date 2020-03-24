<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.List"
    import="java.util.ArrayList"
    import="vaestorekisteri.Person"
    import="vaestorekisteri.Building"
    import="vaestorekisteri.Property"
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Väestorekisteri</title>
<style>
  label{
  	width: 100px; 
  	display:inline-block;
  }
</style>

</head>
<body>

<h1>Tervetuloa Väestörekisteriin.</h1>

 <% 	 
 	 boolean result = (boolean) request.getAttribute("successStatus");
 	 if ( result == true) { 
 %>
  	
  	<div>
  		<label>Nimi: </label>
  		<input type="text" disabled name="name" value="${person.getName()}"><br>
  		<label>Hetu: </label>
  		<input type="text" disabled name="hetu" value="${person.getHetu()}"><br>
  		<label>Osoite: </label>
  		<input type="text" disabled name="address" value="${person.getAddress()}"><br>
  		<label>Kansalaisuus: </label>
  		<input type="text" disabled name="hetu" value="${person.getNationality()}"><br>
  		<label>Kieli: </label>
  		<input type="text" disabled name="hetu" value="${person.getNativeLanguage()}"><br>
  		<label>Perhe: </label>
  		<input type="text" disabled name="hetu" value="${person.getFamilyInfo()}"><br>
  		<label>Syntyi: </label>
  		<input type="text" disabled name="hetu" value="${person.getBorn()}"><br>
  		<label>Kuoli: </label>
  		<input type="text" disabled name="hetu" value="${person.getDeathInfo()}"><br>  		
  	</div>
  
  <%  Person person = (Person) request.getAttribute("person");
 	  List<Building> buildings = (List<Building>) person.getBuildings();
 	  List<Property> properties = (List<Property>) person.getProperties();
 %>
   	  <h2>Henkilö ${person.getName()} omistaa rakennuksia <%= buildings.size() %> kpl. </h2> 
   <%  
 	  for (int a=0; a < buildings.size();a++) { 
 	 		
    %> 
  		<h3>Rakennus <%= a+1 %>: </h3>
  			<div>
		  		<label>ID: </label>
		  		<input type="text" disabled name="name" value="<%= buildings.get(a).getBuildingID() %>"><br>
		  		<label>Sijainti: </label>
		  		<input type="text" disabled name="hetu" value="<%= buildings.get(a).getLocation() %>"><br>
		  		<label>Pinta-ala: </label>
		  		<input type="text" disabled name="address" value="<%= buildings.get(a).getSquareMeter() %>"><br>
		  		<label>Varusteet: </label>
		  		<input type="text" disabled name="hetu" value="<%= buildings.get(a).getSupply() %>"><br>
		  		<label>Yhteydet: </label>
		  		<input type="text" disabled name="hetu" value="<%= buildings.get(a).getConnections() %>"><br>
		  		<label>Käyttötarkoitus: </label>
		  		<input type="text" disabled name="hetu" value="<%= buildings.get(a).getUsedFor() %>"><br>
		  		<label>Valmistui: </label>
		  		<input type="text" disabled name="hetu" value="<%= buildings.get(a).getReadyDate() %>"><br>	
		  	</div>
  			
 <% 
 	 	}
  %>
  	  <h2>Henkilö ${person.getName()} omistaa kiinteistöjä <%= properties.size() %> kpl. </h2> 
   <%  
 	  for (int a=0; a < properties.size();a++) { 
 	 		
    %> 
  		<h3>Kiinteistö <%= a+1 %>: </h3>
  			<div>
		  		<label>ID: </label>
		  		<input type="text" disabled name="name" value="<%= properties.get(a).getPropertyID() %>"><br>
		  		<label>Sijainti: </label>
		  		<input type="text" disabled name="hetu" value="<%= properties.get(a).getLocation() %>"><br>
		  		<label>Rekisteröity: </label>
		  		<input type="text" disabled name="address" value="<%= properties.get(a).getRegisterationDate() %>"><br>
		  	</div>
  			
 <% 
 	 	}
 	 } 

     else {
  %>
    <h3>${successStatusInfo}</h3>

  <%
      }
  %>
    
  
</body>
</html>