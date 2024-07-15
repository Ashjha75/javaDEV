package org.ashish.utils;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.security.SecureRandom;
import java.time.Instant;

public class alphanumericPrimaryKeygenerator implements IdentifierGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int LENGTH = 8; // Adjust length for your needs

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < LENGTH; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return "ID" + Instant.now().toEpochMilli() + sb.toString(); // Prefix with "ID" and append current timestamp and random part
    }
}
