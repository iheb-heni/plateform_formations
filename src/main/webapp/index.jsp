<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Plateforme de Gestion des Formations</title>
    <!-- Lien vers le CSS de Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
        }
        .header {
            margin-bottom: 30px;
            background: #007bff;
            color: white;
            padding: 50px 0;
        }
        .header h1 {
            font-size: 2.5rem;
        }
        .card {
            margin-bottom: 20px;
        }
        .form-container {
            margin-top: 40px;
        }
        footer {
            background-color: #343a40;
            color: white;
            padding: 20px;
        }
    </style>
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">FormationPro</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="#">Accueil</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#formations">Nos Formations</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#contact">Contact</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#inscription">S'inscrire</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Header -->
<div class="header text-center text-white">
    <h1>Bienvenue sur notre plateforme de gestion des formations</h1>
    <p>Explorez nos formations et inscrivez-vous facilement</p>
</div>

<!-- Authentication Buttons (Login and Register) -->
<div class="container text-center">
    <h3 class="mb-4">Deja un compte ?</h3>
    <button onclick="window.location.href='./login'" class="btn btn-primary btn-lg mb-3">Se Connecter</button>
    <h3>Pas encore inscrit ?</h3>
    <button onclick="window.location.href='./register'" class="btn btn-success btn-lg">S'inscrire</button>
</div>

<!-- Section des formations -->
<div class="container" id="formations">
    <h2 class="text-center mb-4">Nos Formations</h2>
    <div class="row row-cols-1 row-cols-md-3 g-4">
        <div class="col">
            <div class="card shadow-sm">
                <img src="https://via.placeholder.com/300x200" class="card-img-top" alt="Formation 1">
                <div class="card-body">
                    <h5 class="card-title">Développement Web</h5>
                    <p class="card-text">Apprenez à développer des sites web modernes avec HTML, CSS, JavaScript et PHP.</p>
                    <a href="#inscription" class="btn btn-primary">S'inscrire</a>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card shadow-sm">
                <img src="https://via.placeholder.com/300x200" class="card-img-top" alt="Formation 2">
                <div class="card-body">
                    <h5 class="card-title">Data Science</h5>
                    <p class="card-text">Maîtrisez les techniques d'analyse de données avec Python et les outils de Machine Learning.</p>
                    <a href="#inscription" class="btn btn-primary">S'inscrire</a>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card shadow-sm">
                <img src="https://via.placeholder.com/300x200" class="card-img-top" alt="Formation 3">
                <div class="card-body">
                    <h5 class="card-title">Marketing Digital</h5>
                    <p class="card-text">Apprenez à promouvoir votre entreprise sur les réseaux sociaux et à utiliser Google Ads.</p>
                    <a href="#inscription" class="btn btn-primary">S'inscrire</a>
                </div>
            </div>
        </div>
    </div>
</div>



<!-- Section Contact -->
<div class="container" id="contact">
    <h2 class="text-center mb-4">Contactez-nous</h2>
    <p class="text-center">Si vous avez des questions, n'hésitez pas à nous contacter.</p>
</div>

<!-- Footer -->
<footer class="text-center py-4">
    <p>&copy; 2024 FormationPro - Tous droits réservés</p>
</footer>

<!-- Bootstrap JS and dependencies -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"></script>
</body>
</html>
