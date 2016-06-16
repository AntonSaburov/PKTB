package com.second;

import com.string.password.PasswordGenerator;

/**
 * Created by antonsaburov on 16.06.16.
 */
public class SecondGenerator implements PasswordGenerator
{
    @Override
    public String generatePassword() {
        return "Password from SecondGenerator";
    }
}
