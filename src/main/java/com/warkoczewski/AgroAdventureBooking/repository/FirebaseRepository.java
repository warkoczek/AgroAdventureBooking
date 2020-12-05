package com.warkoczewski.AgroAdventureBooking.repository;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public interface FirebaseRepository {
    void add() throws IOException, ExecutionException, InterruptedException;
}
