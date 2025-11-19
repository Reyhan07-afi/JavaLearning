package com.MiniProject02;

import java.util.*;
import java.util.concurrent.*;

public class LogAnalyzer {

    private final ExecutorService executor;
    private final ConcurrentHashMap<String, Integer> finalResult;

    public LogAnalyzer(int threadCount) {
        this.executor = Executors.newFixedThreadPool(threadCount);
        this.finalResult = new ConcurrentHashMap<>();
    }

    public void analyze(List<List<String>> logFiles) throws Exception {

        long startTime = System.currentTimeMillis();
        List<Future<Map<String, Integer>>> tasks = new ArrayList<>();

        // Submit each log file to thread pool
        for (List<String> log : logFiles) {
            tasks.add(executor.submit(new LogProcessor(log)));
        }

        // Merge results from all workers
        for (Future<Map<String, Integer>> future : tasks) {
            Map<String, Integer> localMap = future.get();
            mergeToFinalResult(localMap);
        }

        long endTime = System.currentTimeMillis();
        printResult(endTime - startTime);

        executor.shutdown();
    }

    // Merge worker map into global ConcurrentHashMap
    private void mergeToFinalResult(Map<String, Integer> workerData) {
        workerData.forEach((word, count) ->
                finalResult.merge(word, count, Integer::sum));
    }

    // Print the final output summary
    private void printResult(long timeTaken) {
        System.out.println("\n=== FINAL RESULT ===");
        System.out.println("Total Execution Time: " + timeTaken + " ms");
        System.out.println("Keyword Count: " + finalResult);
    }
}
