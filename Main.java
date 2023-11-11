import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        String archivo = "colocamos la ruta del archivo";

        // con esto leemos el archivo y su contenido lo almacenamos en en una lista
        List<String> textoOriginal = Files.readAllLines(Paths.get(archivo));
        // muestramos el contenido original del archivo
        System.out.println("este es el contenido original sin aplicar el transformador de mayusculas\n");
        for (String linea : textoOriginal) {
            System.out.println(linea);
        }

        //aplica la transformacion a mayusculas y se muestra el resultado por pantalla
        TransformadorDeTexto transformadorMayusculas = String::toUpperCase;

        List<String> textoEnMayusculas = transformarConMayusculas(textoOriginal, transformadorMayusculas);

        System.out.println("\nEste es el contenido con la transformacion en mayuscula\n");
        for (String texto : textoEnMayusculas) {
            System.out.println(texto);
        }
    }

    //metodo para la transformacion a maysculas
    public static List<String> transformarConMayusculas(List<String> lista, TransformadorDeTexto transformador) {
        List<String> resultado = new ArrayList<>();
    //este for itera en cada linea y aplica el cambio de minuscula a mayuscula
        for (String cadena : lista) {
            resultado.add(transformador.transformar(cadena));
        }

        return resultado;
    }
}
