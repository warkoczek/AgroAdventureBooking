package com.warkoczewski.AgroAdventureBooking.config.db;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;

@Component
@Configuration
public class FirebaseDB  {
    @Bean
    public Firestore FirebaseDB() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("C:\\Users\\andre\\IdeaProjects\\AgroAdventureBooking\\src\\main\\resources\\agro-adventure-firebase-adminsdk-5ietz-99d7551971 (1).json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://agro-adventure-default-rtdb.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);
        return FirestoreClient.getFirestore();
    }

}
