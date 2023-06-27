package utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Properties;

public class WebScarper {

    private static final String SESSION_TOKEN;

    static {
        try {
            SESSION_TOKEN = DataCollector.getFirstLine("Java/src/utils/cookies.txt").split("=")[1];
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };

    public static void main(String[] args) throws IOException {
        WebScarper webScarper = new WebScarper();
        String url = "https://adventofcode.com/2022/day/10/input";
        webScarper.getWebInput(url);
    }

    private static void log(String title, Object...args) {
        System.out.printf(title + "\n", args);
    }

    public String getWebInput(String url) throws IOException {

        String[] urlParts = url.split("/");
        int day = Integer.parseInt(urlParts[5]);
        int year = Integer.parseInt(urlParts[3]);
        String possibleFilePath = String.format("Java/src/advent%d/day%d/puzzledata", year, day);
        if(Files.exists(Path.of(possibleFilePath))){
            log("File already exists");

            StringBuilder existingInput = new StringBuilder();
            DataCollector.getStream(possibleFilePath).forEach(s -> existingInput.append(s).append("\n"));
            return existingInput.toString();
        }


        String input =  Jsoup.connect(url)
                .data("query","java")
                .userAgent("Mozilla")
                .cookie("session",SESSION_TOKEN)
                .timeout(3000)
                .post()
                .body()
                .wholeOwnText();

        try(FileOutputStream fileOutputStream = new FileOutputStream(url)){
            fileOutputStream.write(input.getBytes(StandardCharsets.UTF_8));
        };

        return input;
    }
}
