package ru.gb.java2.chat.client.sevice;

import ru.gb.java2.chat.client.Network;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ChatHistory implements AutoCloseable {
    private final String login;
    private static final String FILENAME_PATTERN = "./history/history_%s.txt";
    private File historyFile;
    private PrintWriter printWriter;

    public ChatHistory(String login) {
        this.login = login;
    }

    public void init() {
        try {
            historyFile = createHistoryFile();
            this.printWriter = new PrintWriter(new BufferedWriter(new FileWriter(FILENAME_PATTERN, StandardCharsets.UTF_8, true)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private File createHistoryFile() throws IOException {
        String filePh = String.format(FILENAME_PATTERN);
        File file = new File(filePh);
        if (!file.isFile()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        return file;
    }
    public void append(String text) {
        printWriter.print(text);
        printWriter.flush();
    }

    @Override
    public void close() {
        if (printWriter != null) {
            printWriter.close();
        }
    }
}

