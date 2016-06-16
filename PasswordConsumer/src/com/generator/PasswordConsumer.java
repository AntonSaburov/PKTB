package com.generator;

import com.string.password.PasswordGenerator;

/**
 * Created by antonsaburov on 16.06.16.
 */
public class PasswordConsumer
{
    public static void main(String[] args) {
        PasswordConsumer pc = new PasswordConsumer();
        pc.generate();
    }

    private void generate() {
        PasswordGenerator pg = GeneratorFactory.createGenerator();
        String s = pg.generatePassword();
        System.out.println("Password:" + s);
    }
}


