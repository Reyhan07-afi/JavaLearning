# **Multi-Threaded Log Analyzer Using Java Concurrency & Thread Pools**

## 📌 **Objective**

To design and implement a concurrent system that analyzes multiple log files in parallel using
ExecutorService, Callable, Future, and ConcurrentHashMap,
while comparing sequential vs. concurrent execution performance.

## 📂 **Project Description**

This project demonstrates multithreading in Java by processing multiple log files simultaneously.

Each log file is handled by a separate worker thread, which counts keyword occurrences.
The results are merged into a thread-safe ConcurrentHashMap to generate a final summary.

The system also measures and prints the total execution time, proving the speed improvement of multithreading.

## 🚀 **Features**

✔ Processes multiple log files in parallel
✔ Uses ExecutorService with a fixed thread pool
✔ Each file handled by a Callable worker
✔ Aggregates results using ConcurrentHashMap
✔ Logs thread activity in console
✔ Measures and compares performance
✔ Outputs final keyword count summary

## **Concurrency Strategy**

This mini-project uses Java’s ExecutorService, Callable, Future, and ConcurrentHashMap to implement safe and scalable parallel log analysis.
Below is the exact concurrency strategy followed in the project:

1️⃣ Fixed Thread Pool (ExecutorService)

2️⃣ Callable Tasks for File Processing

3️⃣ Future Objects for Retrieving Results

4️⃣ ConcurrentHashMap for Thread-Safe Aggregation

5️⃣ Execution Time Measurement

