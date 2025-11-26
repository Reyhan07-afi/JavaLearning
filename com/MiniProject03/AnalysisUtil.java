package com.MiniProject03;

public class AnalysisUtil {
        public static long timeMillis(Runnable task) {
            long s = System.nanoTime();
            task.run();
            long e = System.nanoTime();
            return (e - s) / 1_000_000;
        }

        /**
         * Returns average execution time of N iterations.
         */
        public static double benchmarkMillis(Runnable task, int iterations) {
            task.run(); // warm-up

            long total = 0;

            for (int i = 0; i < iterations; i++) {
                long s = System.nanoTime();
                task.run();
                long e = System.nanoTime();
                total += (e - s);
            }
            return (total / (double) iterations) / 1_000_000;
        }
    }


