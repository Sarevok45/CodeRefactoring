package com.bartoszwalter.students.taxes.output;

import com.bartoszwalter.students.taxes.config.Result;

import java.io.PrintStream;

public class SendToOutput {
    private PrintStream stream;

    public SendToOutput() {
    }

    public SendToOutput(PrintStream stream) {
        this.stream = stream;
    }

    public PrintStream getStream() {
        return stream;
    }

    public void setStream(PrintStream stream) {
        this.stream = stream;
    }

    public void Send(Result result) {
        stream.println(result.toString());
    }

}
