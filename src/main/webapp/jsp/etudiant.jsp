<h1> Bienvenue  ${prenom} ${nom} </h1>
<h2>Liste des feuilles de presence</h2>

<h2>Liste des feuilles de présence :</h2>
<ul>
    <c:forEach items="${feuilles}" var="feuille">
        <li>${feuille.mois}</li>
    </c:forEach>
</ul>
<h2>                     </h2>
<form action="/add" method="post">
    <label for="mois">Mois :</label>
    <input type="text" id="mois" name="mois" placeholder="Entrez le mois de la feuille de présence">
    <button type="submit">Confirmer</button>
</form>

<form action="/logout" method="get">
    <button type="submit">Logout</button>
</form>