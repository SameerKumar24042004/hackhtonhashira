import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class PolynomialSolver {
    private List<Point> points;
    private int n, k;

    public static class Point {
        double x, y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public PolynomialSolver() {
        points = new ArrayList<>();
    }

    public void readTestCases(String jsonFilePath) {
        try {
            String json = readFile(jsonFilePath);
            json = json.replaceAll("\\s+", ""); // Remove all whitespace
            
            // Parse n and k
            String keysPattern = "\"keys\":\\{\"n\":(\\d+),\"k\":(\\d+)\\}";
            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(keysPattern);
            java.util.regex.Matcher matcher = pattern.matcher(json);
            
            if (matcher.find()) {
                n = Integer.parseInt(matcher.group(1));
                k = Integer.parseInt(matcher.group(2));
            }

            // Parse points
            points = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                String pointPattern = "\"" + i + "\":\\{\"base\":\"([^\"]+)\",\"value\":\"([^\"]+)\"\\}";
                pattern = java.util.regex.Pattern.compile(pointPattern);
                matcher = pattern.matcher(json);
                
                if (matcher.find()) {
                    String base = matcher.group(1);
                    String value = matcher.group(2);
                    double x = i;
                    double y = parseBaseValue(base, value);
                    points.add(new Point(x, y));
                }
            }
        } catch (Exception e) {
            System.err.println("Error reading test cases: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line.trim());
            }
        }
        return content.toString();
    }

    private double parseBaseValue(String base, String value) {
        try {
            return new BigInteger(value, Integer.parseInt(base)).doubleValue();
        } catch (NumberFormatException e) {
            System.err.println("Error parsing value: " + value + " in base " + base);
            return 0.0;
        }
    }

    public double findC() {
        // Using Lagrange Interpolation Formula with k points
        double c = 0.0;
        
        for (int i = 0; i < k; i++) {
            double term = points.get(i).y;
            for (int j = 0; j < k; j++) {
                if (i != j) {
                    term *= (-points.get(j).x) / (points.get(i).x - points.get(j).x);
                }
            }
            c += term;
        }
        
        return c;
    }

    public static void main(String[] args) {
        PolynomialSolver solver = new PolynomialSolver();
        
        // Test both cases
        System.out.println("Testing first case:");
        solver.readTestCases("testcases.json");
        System.out.println("Value of C: " + solver.findC());
        
        solver = new PolynomialSolver(); // Reset for second test
        System.out.println("\nTesting second case:");
        solver.readTestCases("testcases2.json");
        System.out.println("Value of C: " + solver.findC());
    }
}
