package com.first;

import com.string.password.PasswordGenerator;

/**
 * Created by antonsaburov on 16.06.16.
 */
public class FirstGenerator implements PasswordGenerator
{
    @Override
    public String generatePassword() {
        return "Password from FirstGenerator";
    }
}
