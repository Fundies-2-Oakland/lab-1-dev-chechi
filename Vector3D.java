public class Vector3D {
    // Question 1:
    private final double x;
    private final double y;
    private final double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Question 2:
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    // Question 3:
    @Override
    public String toString() {
        return "(" + String.format("%.2f", x) + " , " + String.format("%.2f", y) + ", " + String.format("%.2f", z) + ")";
    }

    // Question 4:
    public double getMagnitude() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    // Question 5:
    public Vector3D normalize() {
        double magnitude = getMagnitude();
        if (magnitude == 0) {
            throw new IllegalStateException();
        }
        return new Vector3D(x / magnitude, y / magnitude, z / magnitude);
    }

    // Question 6:
    public Vector3D add(Vector3D other) {
        double newX = this.x + other.x;
        double newY = this.y + other.y;
        double newZ = this.z + other.z;
        return new Vector3D(newX, newY, newZ);
    }

    // Question 7:
    public Vector3D multiply(double num) {
        double newX = this.x * num;
        double newY = this.y * num;
        double newZ = this.z * num;
        return new Vector3D(newX, newY, newZ);
    }

    // Question 8:
    public double dotProduct(Vector3D other) {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    //Question 9:
    public double angleBetween(Vector3D other) {
        double magnitude1 = this.getMagnitude();
        double magnitude2 = other.getMagnitude();
        if (magnitude1 == 0 || magnitude2 == 0) {
            throw new IllegalStateException();
        }
        double dotProduct = this.dotProduct(other);
        double theta = dotProduct / (magnitude1 * magnitude2);
        theta = Math.max(-1, Math.min(1, theta));
        double radians = Math.acos(theta);
        return Math.toDegrees(radians);
    }

    // Question 10:
    public Vector3D crossProduct(Vector3D other) {
        double newX = this.y * other.z - this.z * other.y;
        double newY = this.z * other.x - this.x * other.z;
        double newZ = this.x * other.y - this.y * other.x;
        return new Vector3D(newX, newY, newZ);
    }

    // Main Method:
    public static void main(String[] args) {
        // Create two vector instances
        Vector3D v1 = new Vector3D(3, 4, 0);
        Vector3D v2 = new Vector3D(1, 2, 3);

        // Question 2:
        System.out.println("v1.x = " + v1.getX());
        System.out.println("v1.y = " + v1.getY());
        System.out.println("v1.z = " + v1.getZ());

        // Question 3:
        System.out.println("v1 = " + v1);

        // Question 4:
        System.out.println("Magnitude of v1 = " + v1.getMagnitude());

        // Question 5:
        try {
            Vector3D v1Normalized = v1.normalize();
            System.out.println("Normalized v1 = " + v1Normalized.toString());
        } catch (IllegalStateException e) {
            System.out.println("Cannot normalize a zero vector.");
        }

        // Question 6:
        Vector3D vSum = v1.add(v2);
        System.out.println("v1 + v2 = " + vSum.toString());

        // Question 7:
        Vector3D v1Scaled = v1.multiply(2);
        System.out.println("v1 * 2 = " + v1Scaled.toString());

        // Question 8:
        double dotProd = v1.dotProduct(v2);
        System.out.println("Dot product of v1 and v2 = " + dotProd);

        // Question 9:
        try {
            double angle = v1.angleBetween(v2);
            System.out.println("Angle between v1 and v2 = " + angle + " degrees");
        } catch (IllegalStateException e) {
            System.out.println("Cannot calculate angle with a zero vector.");
        }

        // Question 10:
        Vector3D crossProd = v1.crossProduct(v2);
        System.out.println("Cross product of v1 and v2 = " + crossProd.toString());
    }
}
