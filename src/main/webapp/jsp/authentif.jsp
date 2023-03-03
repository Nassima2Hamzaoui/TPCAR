<html>
<head>
    <meta charset="UTF-8">
    <title>Login & Signup</title>
</head>
<body>
    <h1>Login & Signup</h1>

    <!-- Formulaire de connexion -->
    <h2>Connexion</h2>
    <form action="/login" method="post">
        <label for="mail">Email:</label>
        <input type="email" id="mail" name="mail" required><br>
        <label for="mdp">Mot de passe:</label>
        <input type="password" id="mdp" name="mdp" required><br>
        <input type="submit" value="Se connecter">
    </form>

    <!-- Formulaire d'inscription -->
    <h2>Inscription</h2>
    <form action="/signup" method="post">
        <label for="mail">Email:</label>
        <input type="email" id="mail" name="mail" required><br>
        <label for="mdp">Mot de passe:</label>
        <input type="password" id="mdp" name="mdp" required><br>
        <label for="prenom">Prenom:</label>
        <input type="text" id="prenom" name="prenom" required><br>
        <label for="nom">Nom:</label>
        <input type="text" id="nom" name="nom" required><br>
        <input type="submit" value="S'inscrire">
    </form>
</body>
</html>