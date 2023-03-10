<html>
<head>
    <meta charset="UTF-8">
    <title>Login & Signup</title>
</head>

<style>


body {
  font-family: Arial, sans-serif;
  background-color: #f7f7f7;
  color: #333;
}

h1 {
  text-align: center;
  margin-top: 50px;
}

h2 {
  margin-top: 30px;
}

/* Styles pour les formulaires */
form {
  margin: 30px auto;
  padding: 20px;
  width: 400px;
  background-color: #fff;
  border-radius: 5px;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
}

label {
  display: block;
  margin-bottom: 10px;
  font-weight: bold;
}

input[type="email"],
input[type="password"],
input[type="text"] {
  width: 100%;
  padding: 10px;
  margin-bottom: 20px;
  border-radius: 3px;
  border: 1px solid #ccc;
  font-size: 16px;
}

input[type="submit"] {
  background-color: #af4c72;
  color: #fff;
  padding: 10px 20px;
  border: none;
  border-radius: 3px;
  cursor: pointer;
  font-size: 16px;
}

input[type="submit"]:hover {
  background-color: #8e3e6a;
}
</style>
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
        <label for="prenom">Prenom:</label>
        <input type="text" id="prenom" name="prenom" required><br>
        <label for="nom">Nom:</label>
        <input type="text" id="nom" name="nom" required><br>
        <label for="mdp">Mot de passe:</label>
        <input type="password" id="mdp" name="mdp" required><br>
        <input type="submit" value="S'inscrire">
    </form>
</body>
</html>