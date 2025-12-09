import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Juego {
    protected List<Personaje> jugador1 = new ArrayList<>();
    protected List<Personaje> jugador2 = new ArrayList<>();
    public void Menu(){
        int opcion;
        do{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al menu:");
        System.out.println("1 jugar");
        System.out.println("2 ver partidas anteriores");
        System.out.println("3 como jugar");
        System.out.println("0 salir");
        System.out.println("Ingrese una opcion");
        opcion = scanner.nextInt();
        opciones(opcion);
        }while(opcion != 0);
    }
    public void opciones(int opcion){
        Scanner scanner = new Scanner(System.in);
            if (opcion != 0){
                switch (opcion){
                    case 1:
                        System.out.println("¿Desea crear los personajes usted?");
                        String opcion2= scanner.next();
                        if (opcion2.toLowerCase().equals("si")){
                            crearPersonajes(1);
                            crearPersonajes(2);
                            System.out.println("Esto son los personajes del jugador 1");
                            Recorrer_personajes(jugador1);
                            System.out.println("Estos son los personajes del jugador 2");
                            Recorrer_personajes(jugador2);
                            Partida();
                            break;
                        }
                        else{
                            crearPersonajesRandom(1);
                            crearPersonajesRandom(2);
                            System.out.println("Esto son los personajes del jugador 1");
                            Recorrer_personajes(jugador1);
                            System.out.println("Estos son los personajes del jugador 2");
                            Recorrer_personajes(jugador2);
                            Partida();
                            break;
                        }
                    case 2:
                        System.out.println("Cargando partidas anteriores");
                        break;
                    case 3:
                        System.out.println("Las reglas del juego son:");
                        break;
                }
            }
            else {
                System.out.println("Saliendo del juego");
            }


    }
    //comprobar que no todo este al maximo nadie es dios
    //tirar un excepcion en caso de que todo este al maximo
    //usar excepcions en caso de superar el limite de rango de edad,velocidad,etc..
    // Sistema de puntos para crear personajes o limite de 2 stats al maximo
    private void crearPersonajes(int jugador){
        Scanner scanner =  new Scanner(System.in);
        for (int i=1; i<=3; i++){
            Personaje personaje=null;
            System.out.println("creando el personaje"+i);
            System.out.println("Escriba su nombre");
            String nombre= scanner.next();
            System.out.println("Escriba su apodo");
            String apodo=scanner.next();
            System.out.println("Escriba su fecha de nacimiento");
            String nacimiento= scanner.next();
            System.out.println("Escriba su edad");
            System.out.println("Entre 0 y 300");
            int edad= scanner.nextInt();
            System.out.println("Escriba su velocidad");
            System.out.println("Min 1 y Maximo 10");
            int velocidad = scanner.nextInt();
            System.out.println("Escriba su destreza");
            System.out.println("Min 1 y Maximo 5");
            int destreza = scanner.nextInt();
            System.out.println("Escriba su fuerza");
            System.out.println("Min 1 y Maximo 10");
            int fuerza = scanner.nextInt();
            System.out.println("Escriba su nivel");
            System.out.println("Min 1 y Maximo 10");
            int nivel= scanner.nextInt();
            System.out.println("Escriba su armadura");
            System.out.println("Min 1 y Maximo 10");
            int armadura= scanner.nextInt();
            System.out.println("Eliga una raza:");
            System.out.println("Humano, Elfo u Orco");
            String raza=scanner.next();
            try {
                switch(raza.toLowerCase()) {
                    case "humano":
                        personaje = new Humano(
                                nombre,apodo,nacimiento,edad,velocidad,destreza,fuerza,nivel,armadura
                        );
                        break;
                    case "elfo":
                        personaje = new Elfo(
                                nombre,apodo,nacimiento,edad,velocidad,destreza,fuerza,nivel,armadura
                        );
                        break;
                    case"orco":
                        personaje = new Orco(
                                nombre,apodo,nacimiento,edad,velocidad,destreza,fuerza,nivel,armadura
                        );
                        break;
                    default:
                        System.out.println("No selecciono ninguna opcion");
                        break;
                }

            }catch (Exception e){
                System.out.println(e);
                break;
            }
            System.out.println("Este es su personaje");
            System.out.println(personaje.toString());
            System.out.println("Desea borrarlo y crearlo de nuevo?");
            String opcion2= scanner.next();
            if (opcion2.equals("si")){
                i=i-1;
            }
            else{
                if (jugador==1){
                    jugador1.add(personaje);
                }else {
                    jugador2.add(personaje);
                }
                System.out.println("Okey creando siguiente personaje");
            }
        }
    }
    private  void crearPersonajesRandom(int jugador){
        for (int i=1; i<=3;i++){
            String nombre= "Generico";//Reemplaza cn api
            String apodo= "Generico";
            String nacimiento="8/7/2002";
            int edad= (int)(Math.random()*300)+1;
            int velocidad=(int)(Math.random()*10)+1;
            int destreza=(int)(Math.random()*5)+1;
            int fuerza=(int)(Math.random()*10)+1;
            int nivel=(int)(Math.random()*10)+1;
            int armadura=(int)(Math.random()*10)+1;
            Personaje personaje = null;
            int raza=(int)(Math.random()*3)+1;
            try{
                switch (raza){
                    case 1:
                        personaje=new Humano(nombre,apodo,
                                nacimiento,edad,velocidad,destreza,fuerza,nivel,armadura);
                        System.out.println("Creando Humano");

                        break;
                    case 2:
                        personaje=new Elfo(nombre,apodo,
                                nacimiento,edad,velocidad,destreza,fuerza,nivel,armadura);
                        System.out.println("Creando Elfo");

                        break;
                    case 3:
                        personaje=new Orco(nombre,apodo,
                                nacimiento,edad,velocidad,destreza,fuerza,nivel,armadura);
                        System.out.println("Creando orco");

                        break;
                    case 4:
                        System.out.println("Hubo un error el numero es:"+raza);
                        break;

                }
                if (jugador == 1){
                    jugador1.add(personaje);
                }else{
                    jugador2.add(personaje);
                }
            }catch (Exception e){
                System.out.println(e);
                i=i-1;
            }
        }
    }
    public void Partida(){
        System.out.println("Creando Partida");
        System.out.println("El largo es"+jugador1.size());
        do {
            int tamaño1=(jugador1.size()-1);
            int tamaño2=(jugador2.size()-1);
            int posicion1 = (int) (Math.random() * tamaño1);
            int posicion2 = (int) (Math.random() * tamaño2);
            System.out.println("Posicion 1 es"+posicion1+"posicion 2 es"+posicion2);
            Personaje personaje1 = jugador1.get(posicion1);
            Personaje personaje2 = jugador2.get(posicion2);
            do {
                System.out.println("Ataca el pj" + personaje1.getNombre());
                System.out.println("Defiende el pj" + personaje2.getNombre());
                int defensa = personaje2.valor_defensa();
                double accion = personaje1.atacar(defensa);
                int salud = personaje2.getSalud();
                int resultado = (int) (salud + accion);
                personaje2.setSalud(resultado);
                System.out.println("ataca pj 2");
                defensa = personaje1.valor_defensa();
                accion = personaje2.atacar(defensa);
                salud = personaje1.getSalud();
                resultado = (int) (salud + accion);
                System.out.println("El resultado es"+resultado);
                personaje1.setSalud(resultado);
                System.out.println("Salud del pj1 es"+personaje1.getSalud());
                System.out.print("Salud del pj2 es"+personaje2.getSalud());
            } while (personaje2.getSalud() > 0 && personaje1.getSalud() > 0);
            if (personaje1.getSalud() <= 0) {
                jugador1.remove(personaje1);
            } else {
                jugador2.remove(personaje2);
            }
        }while(jugador1.size()>0&&jugador2.size()>0);
        if (jugador1.size()==0){
            System.out.println("Jugador 1 gana");
        }else{
            System.out.println("Jugador 2 gana");
        }
    }
    public void Recorrer_personajes(List<Personaje>jugador){
        for (int i=1;i<=3;i++){
            Personaje personaje=jugador.get(i-1);
            System.out.println("Este es el personaje numero "+i);
            System.out.println(personaje.toString());
        }
    }
}
