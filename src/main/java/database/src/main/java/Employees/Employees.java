package Employees;

import org.json.JSONObject;
import org.json.JSONWriter;

import java.util.ArrayList;
import java.util.Scanner;


public class Employees {

    static Scanner sc = new Scanner(System.in);
    private int id = 0;
    public String name;
    public String surname;
    public String mail;

//    public Employees() {
//        id = (int) (Math.random() * 1000);
//    }

    public Employees(String name, String surname, String mail) {

        id = (int) (Math.random()*100);
        this.name = name;
        this.surname = surname;
        this.mail = mail;

    }

    public JSONObject getAsJSON(){//Obtener como JSON

        JSONObject employee = new JSONObject();
        employee.put("id", this.getId());
        employee.put("nombre", this.name);
        employee.put("Apellido", this.surname);
        employee.put("Correo", this.mail);
        return employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    //METODO PARA CREAR EMPLEADOS

    public ArrayList<Employees> createEmployee() {

        ArrayList<Employees> employees = new ArrayList<Employees>();

        for (int i = 0; i < 1; i++) {
            String name;
            String surname;
            String mail;
            System.out.println("Introduzca el nombre del empelado");
            name = sc.nextLine();
            System.out.println("Introduzca el apellido del empelado");
            surname = sc.nextLine();
            System.out.println("Introduzca el correo del empelado");
            mail = sc.nextLine();
            employees.add(new Employees(name, surname, mail));


        }
        return employees;

    }

    @Override
    public String toString() {
        return ("Id Empleado: " + getId() + "\nNombre: " + getName() + "\nApellido: " + getSurname() + "\nCorreo: " + getMail());
    }
}



