# Polynomial Solver

A Java application that solves for the constant term (C) in a polynomial using Lagrange Interpolation.

## Overview

This project implements a polynomial solver that:
- Reads test cases from JSON files
- Handles numbers in different bases (2-16)
- Uses Lagrange Interpolation to find the constant term C
- Supports multiple test cases with configurable parameters

## Requirements

- Java 8 or higher
- JSON input files with test cases

## File Structure

- `PolynomialSolver.java` - Main implementation file
- `testcases.json` - Sample test cases file with smaller dataset
- `testcases2.json` - Sample test cases file with larger dataset

## Input Format

The JSON input files should follow this structure:
```json
{
    "keys": {
        "n": <number_of_points>,
        "k": <points_to_use>
    },
    "1": {
        "base": "<base_number>",
        "value": "<value_in_given_base>"
    },
    // ... more points
}
```

## Usage

1. Compile the Java file:
```bash
javac PolynomialSolver.java
```

2. Run the program:
```bash
java PolynomialSolver
```

The program will automatically process both test case files and output the value of C for each case.

## How It Works

1. The program reads JSON input files containing test cases
2. For each test case:
   - Parses the number of points (n) and points to use (k)
   - Converts values from their given base to decimal
   - Applies Lagrange Interpolation to find the constant term C
3. Outputs the calculated C value

## Test Results

### Test Case 1
Input parameters:
- n = 4 points
- k = 3 points to use
- Points in various bases (10, 2, 10, 4)

Result:
```
Value of C: 3.0
```

### Test Case 2
Input parameters:
- Larger dataset
- Complex calculations

Result:
```
Value of C: 7.9836264046592E13
```



