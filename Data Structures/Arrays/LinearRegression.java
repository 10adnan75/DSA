// Compute least squares solution to y = beta * x + alpha.
// Simple linear regression.

public class LinearRegression {
    private final double intercept, slope;
    private final double r2;
    private final double svar0, svar1;

    public LinearRegression(double[] x, double[] y) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("array lengths are unequal");
        }
        int n = x.length;

        double sumX = 0.0, sumY = 0.0, sumX2 = 0.0;
        for (int i=0; i<n; i++) {
            sumX += x[i];
            sumX2 += x[i] * x[i];
            sumY += y[i];
        }
        double xBar = sumX / n;
        double yBar = sumY / n;

        double xxBar = 0.0, yyBar = 0.0, xyBar = 0.0;
        for (int i=0; i<n; i++) {
            xxBar += (x[i] - xBar) * (x[i] - xBar);
            yyBar += (y[i] - yBar) * (y[i] - yBar);
            xyBar += (x[i] - xBar) * (y[i] - yBar);
        }
        slope = xyBar / xxBar;
        intercept = yBar - slope * xBar;

        double rss = 0.0; // residual sum of squares
        double ssr = 0.0; // regression sum of squares
        for (int i=0; i<n; i++) {
            double fit = slope * x[i] + intercept;
            rss += (fit - y[i]) * (fit - y[i]);
            ssr += (fit - yBar) * (fit - yBar);
        }

        int degreeOfFreedom = n-2;
        r2 = ssr / yyBar;
        double svar = rss / degreeOfFreedom;
        svar1 = svar / xxBar;
        svar0 = (svar / n) + (xBar * xBar * svar1);
    }

    public double getIntercept() {
        return intercept;
    }

    public double getSlope() {
        return slope;
    }

    public double getR2() {
        return r2;
    }

    public double interceptStdErr() {
        return Math.sqrt(svar0);
    }

    public double slopeStdErr() {
        return Math.sqrt(svar1);
    }

    public double predict(double x) {
        return slope * x + intercept;
    }

    public String toString() {
        return String.format("%.2f n + %.2f", getSlope(), getIntercept()) + "(R^2 = " + String.format("%.3f", getR2()) + ")";
    }
}
