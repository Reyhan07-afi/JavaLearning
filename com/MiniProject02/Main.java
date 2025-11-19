package com.MiniProject02;

import java.util.*;
public class Main{
    public static void main(String[] args) throws Exception {

        //  sample logs declared in main cls
        List<String> log1 = Arrays.asList(
                "Error occurred in module",
                "Module failed to load"
        );
        List<String> log2 = Arrays.asList(
                "User login success",
                "User loaded dashboard"
        );
        List<String> log3 = Arrays.asList(
                "Network error detected",
                "Retry connection error"
        );
        List<List<String>> allLogs = Arrays.asList(log1, log2, log3);
        // Create analyzer with 3 threads
        LogAnalyzer analyzer = new LogAnalyzer(3);

        analyzer.analyze(allLogs);
    }
}