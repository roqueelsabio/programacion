package Act7;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Estudiante e1 = new Estudiante("Paco", 12, 173);
        Estudiante e2 = new Estudiante("Pepe", 43, 170);
        Estudiante e3 = new Estudiante("Juan", 72, 148);
        Estudiante e4 = new Estudiante("Alberto", 52, 168);
        Estudiante e5 = new Estudiante("Fran", 35, 189);
        Estudiante e6 = new Estudiante("Roque", 53, 189);

        Estudiante[] array = new Estudiante[6];
        array[0] = e1;
        array[1] = e2;
        array[2] = e3;
        array[3] = e4;
        array[4] = e5;
        array[5] = e6;

        System.out.println("Array de estudiantes sin ordenar:");
        for (Estudiante e: array) {
            System.out.println(e.toString() + " " + e.getAltura() + " " + e.getEdad());
        }

        Arrays.sort(array);
        System.out.println("\nArray de estudiantes ordenado por altura y edad:");
        for (Estudiante e: array) {
            System.out.println(e.toString() + " " + e.getAltura() + " " + e.getEdad());
        }
    }
}
