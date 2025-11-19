package com.MiniProject02;

import java.util.*;
import java.util.concurrent.Callable;

public class LogProcessor implements Callable<Map<String, Integer>> {

    private List<String> logLines;

    public LogProcessor(List<String> logLines) {
        this.logLines = logLines;
    }

    @Override
    public Map<String, Integer> call() {
        Map<String, Integer> localCount = new HashMap<>();

        for (String line : logLines) {
            String[] words = line.split("\\W+");

            for (String w : words) {
                if (!w.isEmpty()) {
                    w = w.toLowerCase();
                    localCount.put(w, localCount.getOrDefault(w, 0) + 1);
                }
            }
        }

        System.out.println("Thread " + Thread.currentThread().getName() +
                " processed " + logLines.size() + " lines");

        return localCount;   // returns result to main class
    }
}