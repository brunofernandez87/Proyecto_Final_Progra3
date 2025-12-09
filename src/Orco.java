public class Orco extends Personaje{

    public Orco(String nombre, String apodo, String fecha_de_nacimiento, Integer edad, Integer velocidad, Integer destreza, Integer fuerza, Integer nivel, Integer armadura) throws Exception {
        super(nombre, apodo, fecha_de_nacimiento, edad, velocidad, destreza, fuerza, nivel, armadura);
    }

    @Override
    public Integer PD(){
        return this.destreza*this.fuerza*this.nivel;

    }

    @Override
    public Double Efectividad_disparo() {
        int valor= (int) (Math.random() * 100)+1;
        double porcentaje=valor;
        System.out.println("El valor es"+porcentaje/100);
        return porcentaje/100;
    }

    @Override
    public Double Valor_ataque() {
        return PD()*Efectividad_disparo();

    }

    @Override
    public Integer valor_defensa() {
        return this.armadura*this.velocidad;
    }

    @Override
    public Double atacar(int defensa) {
        return ((((Valor_ataque()*Efectividad_disparo())-defensa)/500)*100)*1.05;
    }

    @Override
    public String toString() {
        return "Personaje{" +"Raza=" + "Orco"+'\''+
                "nombre='" + nombre + '\'' +
                ", salud=" + salud +
                ", apodo='" + apodo + '\'' +
                ", fecha_de_nacimiento='" + fecha_de_nacimiento + '\'' +
                ", edad=" + edad +
                ", velocidad=" + velocidad +
                ", destreza=" + destreza +
                ", fuerza=" + fuerza +
                ", nivel=" + nivel +
                ", armadura=" + armadura +
                '}';
    }
}
