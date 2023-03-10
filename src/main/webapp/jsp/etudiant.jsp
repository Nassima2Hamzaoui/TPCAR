<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>	
<%@page import = "java.util.List" %>
<%@page import = "com.example.demo.model.Feuille" %>
<!DOCTYPE html>
<html>
<head>

<style>

body {
		background-color: #f2f2f2;
		font-family: Arial, sans-serif;
	  }
	  
	  h1, h2 {
		text-align: center;
	  }
	  
	  table {
		border-collapse: collapse;
		margin: 20px auto;
		background-color: white;
		box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.2);
	  }
	  
	  th {
		background-color: #af4c8e;
		color: white;
		text-align: left;
		padding: 10px;
	  }
	  
	  td {
		border: 1px solid #ddd;
		padding: 10px;
	  }
	  
	  tr:nth-child(even) {
		background-color: #f2f2f2;
	  }
	  
	  button {
		background-color: #803a6e;
		color: white;
	  }
</style>
	
	<meta charset="UTF-8">
	<title>  </title>
	<h2>Bonjour ${prenom} ${nom} </h2>
</head>
<body>
	<h1> Feuille de presence  </h1>
	
	
	  
	
	<form action="/add" method="post">
    	<label for="mois"> Mois </label>
        <input type="text" id="mois" name="mois">
        <br>
        <button type="submit">Confirmer</button>
    </form>
    
    <br/>
    
	<table>
		
			<thead>
				<tr>
					<th>Mois</th>
					<th>ligne</th>
					

					
				</tr>
			</thead>
			
		<tbody>
			<% 
				List<Feuille> feuilles = (List<Feuille>) request.getAttribute("feuilles");
				
			%>
			<% if (feuilles.isEmpty()) { %>
            <% } else { %>
			<% for (Feuille feuille : feuilles) { %>
				<tr>

					
					<td>  <a href="/fp/<%= feuille.getMois() %>"><%= feuille.getMois() %></a> </td>

					<td>
						<form action="/ligne" method="post">
							<input type="hidden" name="id" value="<%=feuille.getId() %>">
							<button type="submit">Ligne</button>
						</form>

					</td>
					
				</tr>
			
				
			<% 
				} 
			%>
			<% 
				} 
			%>
		</tbody>
	</table>
	


<form action="/logout" method="get">
    <button type="submit">Logout</button>
</form>
	  
</body>
</html>