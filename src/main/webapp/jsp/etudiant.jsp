<h1> Bienvenue  ${prenom} ${nom} </h1>

<form action="/etudiant/feuille-de-presence" method="POST">
    <label for="matiere">Matière :</label>
    <select id="matiere" name="matiere">
        <option value="Mathématiques">Mathématiques</option>
        <option value="Physique">Physique</option>
        <option value="Chimie">Chimie</option>
    </select>
    <br>
    <label for="date">Date :</label>
    <input type="date" id="date" name="date">
    <br>
    <label for="present">Présent :</label>
    <input type="checkbox" id="present" name="present">
    <br>
    <button type="submit">Valider</button>
</form>