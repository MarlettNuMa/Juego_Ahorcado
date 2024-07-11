import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Declaración de variables
        String[] listaPalabras = {"microservicios", "escritorio", "universidad", "videojuegos",
                "adorno", "vacaciones", "recamara", "parangaricutirimicuaro",
                "ornitorrinco", "dentista", "programador", "cumpleaños", "computadora",
                "estufa", "deportes", "concierto", "escaleras", "vestuario", "mascota"};
        int opcionLista;
        String palabraSecreta;  //legida aleatoriamente de una lista
        char[] arregloJuego;   //arreglo que se muestra a jugador con intentos

        int nivel;
        boolean opcionValida = false;

        int intentosMaximos = 0;
        boolean palabraAdivinada = false;

        char letra;
        int cont = 0;
        int intentos = 0;



        //Eleccion de palabra para el juego
        opcionLista = (int)(Math.random() * listaPalabras.length);
        palabraSecreta = listaPalabras[opcionLista];


        //Condiciones iniciales del arreglo que se le muestra al jugador
        arregloJuego = new char[palabraSecreta.length()];

        for(int i = 0; i < palabraSecreta.length(); i++) {
            arregloJuego[i] = '-';  // "-" si usara String
        }

        System.out.println("¡Bienvenido al juego del Ahorcado!");
        //Nivel de juego elegido por el usuario
        do {
            
            System.out.println("\nElige el nivel de juego: \n1.Facil. \n2.Medio. \n3.Avanzado");
            nivel = scanner.nextInt();

            switch (nivel) {
                case 1:
                    intentosMaximos = palabraSecreta.length() + palabraSecreta.length()/2 + 3;
                    break;
                case 2:
                    intentosMaximos = palabraSecreta.length() + palabraSecreta.length()/2;
                    break;
                case 3:
                    intentosMaximos = palabraSecreta.length();
                    break;
                default:
                    System.out.println("Elige una opción válida");
                    break;
            }

            if (nivel >= 1 && nivel <= 3)
                opcionValida = true;

        } while (!opcionValida);    //Realiza hasta que la opción de nivel sea válida


        //Inicio de Juego
        System.out.println("\nTienes " + intentosMaximos + " oportunidades para ganar.\n\t¡Empecemos!\n");

        //Mecanica de juego mientras haya intentos
        while(intentos < intentosMaximos && !palabraAdivinada){

            for (int i = 0; i < arregloJuego.length; i++) {
                System.out.print(" " + arregloJuego[i]);
            }

            System.out.println("\nIngresa una letra: ");
            letra = Character.toLowerCase(scanner.next().charAt(0));
            //solo captura el primer caracter de lo que recibe y pasamos a minusculas

            for(int i = 0; i < arregloJuego.length; i++) {

                if(palabraSecreta.charAt(i) == letra) {
                    arregloJuego[i] = letra;
                    cont++;

                    if (cont == arregloJuego.length) {
                        palabraAdivinada = !palabraAdivinada;
                    }
                }
            }

            intentos++;

                if(intentos == (palabraSecreta.length()/2) ) {
                System.out.println("\n¡Cuidado, tienes : " + intentos + " " + ((intentos == 1) ? "intento" : "intentos") + " restantes");
            }

        }

        if(palabraAdivinada){
            System.out.println ("\n\t" + palabraSecreta);
            System.out.println("\t¡Felicidades! \nAdivinaste la palabra en: " + intentos + " " + ((intentos == 1) ? "intento" : "intentos"));
        } else {
            System.out.println("\n¡Has perdido :P! \nLa palabra secreta era: "+ palabraSecreta);
        }

        scanner.close();

    }
}