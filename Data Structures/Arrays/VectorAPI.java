public class VectorAPI {

    private final int d;
    private final double[] data;

    public VectorAPI(int d) {
        this.d = d;
        data = new double[d];
    }

    public VectorAPI(double... a) {
        d = a.length;
        data = new double[d];
        System.arraycopy(a, 0, data, 0, d);
    }

    @Deprecated
    public int length() {
        return d;
    }

    public int dimension() {
        return d;
    }

    public double dot(VectorAPI that) {
        if (this.d != that.d) throw new IllegalArgumentException("Dimensions don't agree!");
        double sum = 0.0;
        for (int i=0; i<d; i++) {
            sum += (this.data[i] * that.data[i]);
        }
        return sum;
    }

    public double magnitude() {
        return Math.sqrt(this.dot(this));
    }

    public double distanceTo(VectorAPI that) {
        if (this.d != that.d) throw new IllegalArgumentException("Dimensions don't agree!");
        return this.minus(that).magnitude();
    }

    public VectorAPI plus(VectorAPI that) {
        if (this.d != that.d) throw new IllegalArgumentException("Dimensions don't agree!");
        VectorAPI c = new VectorAPI(d);
        for (int i=0; i<d; i++) {
            c.data[i] = this.data[i] + that.data[i];
        }
        return c;
    }

    public VectorAPI minus(VectorAPI that) {
        if (this.d != that.d) throw new IllegalArgumentException("Dimensions don't agree!");
        VectorAPI c = new VectorAPI(d);
        for (int i=0; i<d; i++) {
            c.data[i] = this.data[i] - that.data[i];
        }
        return c;
    }

    public double cartesian(int i) {
        return data[i];
    }

    @Deprecated
    public VectorAPI times(double alpha) {
        VectorAPI c = new VectorAPI(d);
        for (int i=0; i<d; i++) {
            c.data[i] = alpha * data[i];
        }
        return c;
    }

    public VectorAPI scale(double alpha) {
        VectorAPI c = new VectorAPI(d);
        for (int i=0; i<d; i++) {
            c.data[i] = alpha * data[i];
        }
        return c;
    }

    public VectorAPI direction() {
        if (this.magnitude() == 0.0) throw new ArithmeticException("Zero-vector has no direction!");
        return this.times(1.0 / this.magnitude());
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i=0; i<d; i++) {
            s.append(data[i]).append(" ");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        double[] xdata = {1.0, 2.0, 3.0, 4.0};
        double[] ydata = {5.0, 2.0, 4.0, 1.0};
        VectorAPI x = new VectorAPI(xdata);
        VectorAPI y = new VectorAPI(ydata);

        System.out.println("   x       = " + x);
        System.out.println("   y       = " + y);

        VectorAPI z = x.plus(y);
        System.out.println("   z       = " + z);

        z = z.times(10.0);
        System.out.println(" 10z       = " + z);

        System.out.println("  |x|      = " + x.magnitude());
        System.out.println(" <x, y>    = " + x.dot(y));
        System.out.println("dist(x, y) = " + x.distanceTo(y));
        System.out.println("dir(x)     = " + x.direction());
    }
}

/*      OUTPUT:
           x       = 1.0 2.0 3.0 4.0
           y       = 5.0 2.0 4.0 1.0
           z       = 6.0 4.0 7.0 5.0
         10z       = 60.0 40.0 70.0 50.0
          |x|      = 5.477225575051661
         <x, y>    = 25.0
        dist(x, y) = 5.0990195135927845
        dir(x)     = 0.18257418583505536 0.3651483716701107 0.5477225575051661 0.7302967433402214
 */
