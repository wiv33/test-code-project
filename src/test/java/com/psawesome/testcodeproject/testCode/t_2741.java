package com.psawesome.testcodeproject.testCode;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class t_2741 {
    public static void main(String[] args) {

    }

    @Test
    void name() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int read = Integer.parseInt(br.readLine());
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
            for (int i = 1; i <= read; i++) {
                bw.write(i);
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
