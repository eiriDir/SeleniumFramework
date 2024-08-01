package org.example.utils;

import org.example.models.Credentials;

public interface ICredentialsReader {
    public Credentials readCredentials(String source);
}
