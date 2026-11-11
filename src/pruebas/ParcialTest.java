package pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Logica.Parcial;

public class ParcialTest {

    private Parcial parcial;

    @BeforeEach
    public void setUp() {
        parcial = new Parcial();
    }

    @Test
    public void testDosRaicesReales() throws Exception {
        assertEquals(
            "x=3.0, x=2.0",
            parcial.calcularRaices(1, -5, 6)
        );
    }

    @Test
    public void testRaicesIguales() throws Exception {
        assertEquals(
            "x=1.0, x=1.0",
            parcial.calcularRaices(1, -2, 1)
        );
    }

    @Test
    public void testCoeficienteACero() {
        Exception excepcion = assertThrows(
            Exception.class,
            () -> parcial.calcularRaices(0, 2, 1)
        );

        assertEquals(
            "El coeficiente a no puede ser cero.",
            excepcion.getMessage()
        );
    }

    @Test
    public void testRaicesComplejas() {
        Exception excepcion = assertThrows(
            Exception.class,
            () -> parcial.calcularRaices(1, 0, 1)
        );

        assertEquals(
            "La ecuacion tiene raices complejas.",
            excepcion.getMessage()
        );
    }

    @Test
    public void testRaicesDecimales() throws Exception {
        assertEquals(
            "x=1.5, x=1.0",
            parcial.calcularRaices(2, -5, 3)
        );
    }

    @Test
    public void testCoeficienteANegativo() throws Exception {
        assertEquals(
            "x=-2.0, x=2.0",
            parcial.calcularRaices(-1, 0, 4)
        );
    }
}
