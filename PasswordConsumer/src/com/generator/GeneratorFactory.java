package com.generator;

import com.string.password.PasswordGenerator;

/**
 * Created by antonsaburov on 16.06.16.
 */
public class GeneratorFactory
{
    private static String className = "com.second.SecondGenerator";

    public static PasswordGenerator createGenerator() {
        try {
            Class cl = Class.forName(className);
            PasswordGenerator pg = (PasswordGenerator)cl.newInstance();
            return pg;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
