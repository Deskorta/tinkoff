package ru.tinkoff.edu.java.linkParser;

import java.net.MalformedURLException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        LinkParser githubParser = new GithubParser();
        LinkParser stackOverflowParser = new StackOverflowParser();
        githubParser.setNextParser(stackOverflowParser);

        String[] githubResult = githubParser.parse("https://github.com/sanyarnd/tinkoff-java-course-2022/");
// githubResult = {"sanyarnd", "tinkoff-java-course-2022"}

        String[] stackOverflowResult = githubParser.parse("https://stackoverflow.com/questions/1642028/what-is-the-operator-in-c");
// stackOverflowResult = {"1642028"}

        String[] unsupportedResult = githubParser.parse("https://unsupported.com");
// unsupportedResult = null
        System.out.println(Arrays.toString(githubResult));
        System.out.println(Arrays.toString(stackOverflowResult));
        System.out.println(Arrays.toString(unsupportedResult));
    }
}
