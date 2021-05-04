package com.pragmatists.bank;

public class Printable {

    private String value = "";

    public void println(String line){
        value += line + '\n';
    }

    public void println(StringBuilder builder) {
        println(builder.toString());
    }

    public String getValue() {
        return value;
    }

    public void printWith(java.io.PrintStream out) {
        out.print(value);
    }
}
