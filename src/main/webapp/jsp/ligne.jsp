<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>	
<%@page import = "java.util.List" %>
<%@page import = "com.example.demo.model.Feuille" %>
<%@page import = "com.example.demo.model.ligne" %>
<head>
    <title>Votre titre ici</title>
    <style>
      table {
    border-collapse: collapse;
    width: 100%;
  }
  th, td {
    border: 1px solid black;
    padding: 8px;
    text-align: center;
  }
  th {
    background-color: #af4c9e;
    color: rgb(15, 9, 9);
  }
  input[type=text] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 2px solid #ccc;
    border-radius: 4px;
  }
  button[type=submit] {
    background-color: #af4caa;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }
  button[type=submit]:hover {
    background-color: #a0457d;
  }
  
  table {
    border-collapse: collapse;
    width: 100%;
  }
  th, td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
  }
  th {
    background-color: #f2f2f2;
  }
  tr:hover {
    background-color: #f5f5f5;
  }
  a {
    color: blue;
    text-decoration: none;
  }
  a:hover {
    text-decoration: underline;
  }

    </style>
  </head>

<h2> Bonjour ${prenom} ${nom}</h2>
<h2> La feuille de presence du mois  ${feuille.mois}  </h2>
<h3> Ajout d'une ligne</h3>
<form action="/fp/${feuille.mois}/ajouterligne" method="post">
    <div>
        <label for="jour">Jour :</label>
        <input type="date" id="jour" name="jour" required>
    </div>
    <div>
        <label for="debut">Debut :</label>
        <input type="text" id="debut" name="debut" required>
    </div>
    <div>
        <label for="fin">Fin :</label>
        <input type="text" id="fin" name="fin" required>
    </div>
    <div>
        <label for="matiere">Matiere :</label>
        <input type="text" id="matiere" name="matiere" required>
    </div>
    <div>
        <label for="enseignant">Enseignant :</label>
        <input type="text" id="enseignant" name="enseignant" required>
    </div>
    <div>
        <button type="submit">Confirmer</button>
    </div>
</form>

<table>
  <thead>
    <tr>
      <th>Jour</th>
      <th>Début</th>
      <th>Fin</th>
      <th>Matiere</th>
      <th>Enseignant</th>
      <th>Action</th>
    </tr>
  </thead>
  <tbody>
    <% for (ligne ligne : (List<ligne>) request.getAttribute("lignes")) { %>
      <tr>
        <td><%=ligne.getJour()%></td>
        <td><%=ligne.getDebut()%></td>
        <td><%=ligne.getFin()%></td>
        <td><%=ligne.getMatiere()%></td>
        <td><%=ligne.getEnseignant()%></td>
        
        <td><a href="/delete/<%=ligne.getFeuilleDePresence().getMois()%>/<%=ligne.getId()%>"> supprimer</a></td>
      </tr>
    <% } %>
  </tbody>
</table>
<form action="/logout" method="get">
  <button type="submit">Logout</button>
</form>



