package com.warkoczewski.AgroAdventureBooking.repository.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.warkoczewski.AgroAdventureBooking.config.db.FirebaseDB;
import com.warkoczewski.AgroAdventureBooking.repository.FirebaseRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class FirebaseRepositoryImpl implements FirebaseRepository {
    private final FirebaseDB firebaseDB;
    private Map<String, Object> docData;

    public FirebaseRepositoryImpl(FirebaseDB firebaseDB) {
        this.firebaseDB = firebaseDB;
        docData = new HashMap<>();
    }

    @Override
    //@EventListener(ApplicationReadyEvent.class)
    public void add() throws IOException, ExecutionException, InterruptedException {
        docData.put("name", "Los Angels");
        docData.put("state", "CA");
        docData.put("country", "USA");
        docData.put("regions", Arrays.asList("west_coast", "socal"));

        Firestore firestore = firebaseDB.FirebaseDB();
        ApiFuture<WriteResult> future = firestore.collection("cities").document("LA").set(docData);
        System.out.println(future.get().getUpdateTime());
        System.out.println("Hi Firebase");
    }

}
