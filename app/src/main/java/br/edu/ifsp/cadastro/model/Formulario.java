package br.edu.ifsp.cadastro.model;

import java.util.Objects;

public class Formulario {
    private final String name;
    private final String phone;
    private final String email;
    private final String gender;
    private final boolean isInList;
    private final String city;
    private final String state;

    public Formulario(String name, String phone, String email, String gender, boolean isInList,
                      String city, String state) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.isInList = isInList;
        this.city = city;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public boolean getInList() {
        return isInList;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Formulario that = (Formulario) o;
        return Objects.equals(name, that.name) && Objects.equals(phone, that.phone) && Objects.equals(email, that.email) && Objects.equals(gender, that.gender) && Objects.equals(isInList, that.isInList) && Objects.equals(city, that.city) && Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone, email, gender, isInList, city, state);
    }

    @Override
    public String toString() {
        return "Nome: " + name + "\n" +
                "Telefone: " + phone + "\n" +
                "E-mail: " + email + "\n" +
                "Sexo: " + gender + "\n" +
                "Lista de e-mail: " + isInList + "\n" +
                "Cidade: " + city + "\n" +
                "Estado: " + state;
    }
}
