package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        //reads file
        String contents = new String(Files.readAllBytes(Paths.get("sample.txt")));
        List<String> splitWords= splitsString(contents);
        Integer numberOfEmails= validEmails(splitWords);
        System.out.println(numberOfEmails);
    }

    public static List<String> splitsString (String contents) {
        String[] parts = contents.split("\\s");
        List<String> splitWords = new ArrayList<>();
        for (int i = 0; i < parts.length; i++) {
            splitWords.add(parts[i]);
        } return splitWords;
    }

    public static Integer validEmails (List <String> splitWords) {
        Pattern validEmail = Pattern.compile("^(.+)@(.+)$");

        int numberOfEmails = 0;

        for (int i = 0; i < splitWords.size(); i++) {
            Matcher matcher = validEmail.matcher(splitWords.get(i));
            if (matcher.find()) {
                numberOfEmails++;
            }
        } return numberOfEmails;
    }
}








