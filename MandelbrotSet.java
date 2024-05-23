public class MandelbrotSet {
    public static void main(String[] args) {

        // How long is the length of the coast, it depends on what you are.
        
        int width = 80;
        int height = 40;
        double minX = -2.0;
        double maxX = 2.0;
        double minY = -1.5;
        double maxY = 1.5;

        char[][] pixels = new char[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                double x0 = map(col, 0, width, minX, maxX);
                double y0 = map(row, 0, height, minY, maxY);
                double x = 0, y = 0;
                int iteration = 0;
                int maxIterations = 100;

                while (x * x + y * y <= 4 && iteration < maxIterations) {
                    double xTemp = x * x - y * y + x0;
                    y = 2 * x * y + y0;
                    x = xTemp;
                    iteration++;
                }

                if (iteration == maxIterations) {
                    pixels[row][col] = '#'; // Inside the Mandelbrot Set
                } else {
                    pixels[row][col] = ' '; // Outside the Mandelbrot Set
                }
            }
        }

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                System.out.print(pixels[row][col]);
            }
            System.out.println();
        }
    }

    public static double map(double value, double start1, double stop1, double start2, double stop2) {
        return start2 + (stop2 - start2) * ((value - start1) / (stop1 - start1));
    }
}
