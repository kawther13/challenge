package com.pfe.challenge.Service;

import com.pfe.challenge.Model.User;
import com.pfe.challenge.Repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;



@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    // service/AuthService.java


    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long EXPIRATION_TIME = 864_000_000; // 10 jours en millisecondes

    public Map<String, Object> login(String username, String password) {
        Map<String, Object> response = new HashMap<>();

        // 1. Validation des paramètres d'entrée
        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            response.put("success", false);
            response.put("message", "Nom d'utilisateur et mot de passe sont requis");
            return response;
        }

        // 2. Recherche de l'utilisateur
        User user = userRepository.findByUsername(username);
        if (user == null) {
            response.put("success", false);
            response.put("message", "Nom d'utilisateur ou mot de passe incorrect");
            return response; // Message générique pour la sécurité
        }

        // 3. Vérification du mot de passe
        if (!encoder.matches(password, user.getPassword())) {
            response.put("success", false);
            response.put("message", "Nom d'utilisateur ou mot de passe incorrect");
            return response; // Même message pour éviter l'énumération d'utilisateurs
        }

        // 4. Création du token JWT
        try {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", user.getId());
            claims.put("username", user.getUsername());
            claims.put("role", user.getRole());

            String token = Jwts.builder()
                    .setClaims(claims)
                    .setSubject(user.getUsername()) // Utilisation du vrai username
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .signWith(SECRET_KEY)
                    .compact();

            // 5. Préparation de la réponse
            response.put("success", true);
            response.put("token", token);
            response.put("user", Map.of(
                    "id", user.getId(),
                    "username", user.getUsername(),
                    "role", user.getRole()
            ));

        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Erreur lors de la génération du token");

        }

        return response;
    }



    public String update(User user, Long id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        existingUser.setUsername(user.getUsername());
        existingUser.setRole(user.getRole());
        existingUser.setPassword(user.getPassword()); // ⚠️ À chiffrer si mot de passe !

        userRepository.save(existingUser);

        return "Mise à jour réussie";
    }


    public User register(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return user;
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword())); // 🔒 cryptage
        userRepository.save(user);
        return user;
    }
}
