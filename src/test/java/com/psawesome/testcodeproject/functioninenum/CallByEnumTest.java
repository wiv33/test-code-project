package com.psawesome.testcodeproject.functioninenum;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class CallByEnumTest {

    static Map<String, String> stateMap;
    static {
        stateMap = new HashMap<>();
        stateMap.put("1", "READY");
        stateMap.put("2", "END");
        stateMap.put("3", "START");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String state = br.readLine();
        System.out.println(BaseballState.valueOf(stateMap.get(state)));
    }

    @Test
    void testCallFunctionInEnum() throws InterruptedException {
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(() -> {
            System.out.println(Thread.currentThread().getName());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            final String state = br.readLine();
            System.out.println(BaseballState.valueOf(state));

            return null;
        });
        System.out.println(Thread.currentThread().getName());

        es.awaitTermination(1, TimeUnit.MINUTES);

    }

}

enum BaseballState {
    READY(),
    START(),
    END();

    BaseballState(Function<>) {
    }
}

enum UserAct {
    START(),
    SUBMIT(),
    QUIT()
}