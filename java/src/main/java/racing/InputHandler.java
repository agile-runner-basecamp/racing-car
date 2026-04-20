package racing;

import java.io.*;
import java.util.*;

public class InputHandler {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public List<String> readCarNames() throws IOException {
        String str = br.readLine();
        List<String> carNames = Arrays.stream(str.split(","))
                .map(String::trim)
                .toList();
        return carNames;
    }

    public int readRound() throws IOException {
        String str = br.readLine().trim();
        int round = Integer.parseInt(str);
        return round;
    }
}