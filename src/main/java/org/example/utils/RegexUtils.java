package org.example.utils;


import java.util.regex.Pattern;

public class RegexUtils {

    private static final String NAME_REGEX = "^[A-Za-z]{2,15}$";
    public static final Pattern NAME_PATTERN = Pattern.compile(NAME_REGEX);
}
