import java.math.BigDecimal;

public class ManejoDeDatos {
    public static void main(String[] args) {
        float real = 14.444f;
        int entero = (int)real;
        //Redondea un número al entero inferior más próximo que sea igual o menor que él (int).
        System.out.println("Mostrando el " +  entero);


        //Para no perder precisión recomiendo el constructor con String
        //BigDecimal es una manera exacta de representar números, y permite trabajar con mayor precisión que, por ejemplo, el tipo de dato double.
        BigDecimal numero = new BigDecimal("14.44");
        //BigDecimal numero = new BigDecimal(14.44f); La f indica que el número es de tipo float o double (resultado con mas decimales)
        int iPart = numero.intValue();
        // Tipo de valor devuelto: un valor numérico representado por el objeto después de la conversión al tipo entero
        BigDecimal fraccion = numero.remainder(BigDecimal.ONE);
        //El operador resto ( % ) devuelve el resto de la división entre dos operandos
        //es como una constante y le dará un valor directo (BigDecimal.ONE).
        System.out.println("entero:  " + iPart);
        System.out.println("decimal:  " + fraccion);


        //OTRA FORMA


        float prueba = (float)10.554;
        //El método valueOf de String devuelve el valor primitivo de un objeto String como un tipo de dato cadena
        String str = String.valueOf(prueba);
        //El mètodo Integer.parseInt Convierte una cadena de texto en un número entero.
        int intPrueba = Integer.parseInt(str.substring(0, str.indexOf('.')));
        //El mètodo Float.parseFloat Convierte una cadena de texto en un número decimal (float).
        float decimalPrueba = Float.parseFloat(str.substring(str.indexOf('.')));
        System.out.println(intPrueba);
        System.out.println(decimalPrueba);








    }
}
