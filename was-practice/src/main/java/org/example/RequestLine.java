package org.example;

public class RequestLine {
    private final String method;   // GET
    private final String urlPath; // /calculate?operand1=11&operator*=null&operand2=55

    private String queryString;

    public RequestLine(String requestLine) {
        String[] tokens = requestLine.split(" ");
        this.method = tokens[0];

        String[] urlPathTokens = tokens[1].split("\\?");
        this.urlPath = urlPathTokens[0];

        if (urlPathTokens.length == 2){
            this.queryString = urlPathTokens[1];
        }
    }
}
