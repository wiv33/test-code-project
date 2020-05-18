package com.psawesome.testcodeproject.testCode;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;

public class t_15552 {
    @Test
    void testBufferedReader() {
        new BufferedReader(new InputStreamReader(System.in))
                .lines()
                .filter(f -> f.contains(" "))
                .forEach(v -> {
                    String[] s = v.split(" ");
                    int x = Integer.parseInt(s[0]);
                    int y = Integer.parseInt(s[1]);
                    int c = x + y;
                    try {
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
                        bw.write(c);
                        bw.newLine();
                        bw.flush();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = br.readLine();
            int cnt = Integer.parseInt(s);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
            for (int i = 0; i < cnt; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int sum = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
                bw.write(sum + "\n");
            }

            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
