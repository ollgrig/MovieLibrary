package org.olga.repository;

public class IDGenerator {
    private static long id = 0;
    public static synchronized long getId(){
        return id++;
    }
}
