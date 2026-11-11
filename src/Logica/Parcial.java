package Logica;

public class Parcial {

    public String calcularRaices(double a, double b, double c) throws Exception {
        if (a == 0) {
            throw new Exception("El coeficiente a no puede ser cero.");
        }

        double discriminante = (double) b * b - 4.0 * a * c;

        if (discriminante < 0) {
            throw new Exception("La ecuacion tiene raices complejas.");
        }

        double x1 = (-((double) b) + Math.sqrt(discriminante)) / (2.0 * a);
        double x2 = (-((double) b) - Math.sqrt(discriminante)) / (2.0 * a);

        return "x=" + x1 + ", x=" + x2;
    }
}
