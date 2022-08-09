package com.ahmad.dockerclass.firstchallenge.model;

public class HelloWorld {

    private static final String camelCaseRegex = "(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])";
    private static final String greetingsWord = "Hello";
    private static final String noNamePerson = "Stranger";
    private final String Message;

    public HelloWorld(String name) {
        Message = getGreetingMessage(name);
    }

    public String getMessage() {
        return Message;
    }

    private String getGreetingMessage(String name)
    {
        String extractedName = IsNullOrBlank(name)? noNamePerson : getCamelCaseSplitName(name);

        return String.format("%s %s", greetingsWord, extractedName);
    }

    private String getCamelCaseSplitName(String name) {
        if (IsNullOrBlank(name)) {
            return name;
        }

        var camelCaseSplitName = name.split(camelCaseRegex);
        return String.join(" ", camelCaseSplitName);
    }

    private boolean IsNullOrBlank(String name)
    {
        return name == null || name.isBlank();
    }
}
