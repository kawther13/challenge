package com.pfe.challenge.Service;

import com.pfe.challenge.Model.User;
import com.pfe.challenge.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public String login(String username, String password) {
        // 1. Recherche de l'utilisateur
        User user = userRepository.findByUsername(username);

        // 2. Vérification si l'utilisateur existe
        if (user == null) {
            return "Utilisateur n'existe pas";
        }

        // 3. Comparaison sécurisée des mots de passe (avec BCrypt)
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(password, user.getPassword())) {
            return "Mot de passe incorrect";  // Lancer une exception ici n'est pas recommandé pour l'API
        }

        // 4. Retour du résultat
        return "Connexion réussie - Rôle: " + user.getRole();
    }

    public String register(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return "Username already exists";
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword())); // 🔒 cryptage
        userRepository.save(user);
        return "User registered successfully";
    }
}
