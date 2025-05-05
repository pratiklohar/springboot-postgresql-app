package com.myapp.springbootpostgresqlapp.util;

import java.util.UUID;

public class IdGenerator {

    // Generic method to generate an ID
    public static UUID generateId() {
        return UUID.randomUUID();
    }
}
