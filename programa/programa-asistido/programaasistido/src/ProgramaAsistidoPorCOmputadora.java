import java.util.Random;
import java.util.Scanner;

public class ProgramaAsistidoPorCOmputadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int nivelDificultad;
        int tipoProblema;
        int preguntasCorrectas = 0;
        int preguntasIncorrectas = 0;

        do {
            System.out.println("Elija el nivel de dificultad (1-9): ");
            nivelDificultad = scanner.nextInt();

            System.out.println("Elija el tipo de problema (1: suma, 2: resta, 3: multiplicación, 4: división, 5: mezcla aleatoria): ");
            tipoProblema = scanner.nextInt();

            while (preguntasCorrectas < 10) {
                int num1 = generarNumero(nivelDificultad);
                int num2 = generarNumero(nivelDificultad);
                String operador = obtenerOperador(tipoProblema);
                int resultado = calcularResultado(num1, num2, operador);

                System.out.print("¿Cuánto es " + num1 + " " + operador + " " + num2 + "? ");
                int respuestaUsuario = scanner.nextInt();

                if (respuestaUsuario == resultado) {
                    preguntasCorrectas++;
                    System.out.println(obtenerRespuestaPositiva(random));
                } else {
                    preguntasIncorrectas++;
                    System.out.println(obtenerRespuestaNegativa(random));
                }
            }

            double porcentajeCorrectas = (double) preguntasCorrectas / (preguntasCorrectas + preguntasIncorrectas) * 100;
            if (porcentajeCorrectas < 75) {
                System.out.println("Por favor pide ayuda adicional a tu instructor.");
            } else {
                System.out.println("Felicidades, estás listo para pasar al siguiente nivel!");
            }

            System.out.println("¿Desea probar de nuevo? (1: Sí, 2: No): ");
        } while (scanner.nextInt() == 1);
    }

    public static int generarNumero(int nivelDificultad) {
        Random random = new Random();
        return random.nextInt(nivelDificultad) + 1;
    }

    public static String obtenerOperador(int tipoProblema) {
        String operador = "";
        switch (tipoProblema) {
            case 1:
                operador = "+";
                break;
            case 2:
                operador = "-";
                break;
            case 3:
                operador = "*";
                break;
            case 4:
                operador = "/";
                break;
            default:
                operador = obtenerOperador(generarNumero(4));
                break;
        }
        return operador;
    }

    public static int calcularResultado(int num1, int num2, String operador) {
        int resultado = 0;
        switch (operador) {
            case "+":
                resultado = num1 + num2;
                break;
            case "-":
                resultado = num1 - num2;
                break;
            case "*":
                resultado = num1 * num2;
                break;
            case "/":
                resultado = num1 / num2;
                break;
        }
        return resultado;
    }

    public static String obtenerRespuestaPositiva(Random random) {
        String[] respuestasPositivas = {"¡Muy bien!", "¡Excelente!", "¡Buen trabajo!", "¡Sigue así!"};
        return respuestasPositivas[random.nextInt(respuestasPositivas.length)];
    }

    public static String obtenerRespuestaNegativa(Random random) {
        String[] respuestasNegativas = {"No. Por favor intenta de nuevo.", "Incorrecto. Intenta una vez más.", "¡No te rindas!", "No. Sigue intentando."};
        return respuestasNegativas[random.nextInt(respuestasNegativas.length)];
    }
}
