package com.colleger.student.student_service.model;

import java.util.concurrent.ThreadLocalRandom;

public class IDGenerator {

    private final Long id_a = ThreadLocalRandom.current().nextLong(100000,999999);
    private final Long id_b = ThreadLocalRandom.current().nextLong(200000,999999);
    private final Long id_c = ThreadLocalRandom.current().nextLong(300000,999999);

    private final Long id = id_a + id_b + id_c;

    public Long getId(){
        return id_a + id_b + id_c;
    }


}
