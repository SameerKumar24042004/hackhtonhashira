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

## Example Output

```
Testing first case:
Value of C: <calculated_value>

Testing second case:
Value of C: <calculated_value>
```

## Contributing

Feel free to submit issues and enhancement requests.

## License

This project is available under the MIT License.
