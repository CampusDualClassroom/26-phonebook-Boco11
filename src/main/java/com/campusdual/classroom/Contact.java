package com.campusdual.classroom;

import java.text.Normalizer;

public class Contact implements ICallActions {
    private String name;
    private String surnames;
    private String phone;
    private String code;

    public Contact(String name, String surnames, String phone) {
        this.name = name;
        this.surnames = surnames;
        this.phone = phone;
        this.code = generateCode(name, surnames);
    }

    private String generateCode(String name, String surnames) {
        ///  Convertimos los apellidos a minúsculas y  eliminamos signos diacríticos
        String normalized = Normalizer.normalize(surnames.toLowerCase(), Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

    /// Separamos los apellidos por espacios, por ejemplo Cotelo Vilanova ["Cotelo", "Vilanova"]

        String[] parts = normalized.split(" ");
    /// Creamos un StringBuilder para construir el código final
        StringBuilder codeBuilder = new StringBuilder();
        ///Añadimos la primera letra del nombre en minúscula
        codeBuilder.append(Character.toLowerCase(name.charAt(0)));
        ///Si solo hay un apellido, lo añadimos completo
        if (parts.length == 1) {
            codeBuilder.append(parts[0]);
        } else {
            /// SE HAY MAIS DE UN APELLIDO AÑADESE A PRIMEIRA LETRA DO PRIMER APELLIDO
            codeBuilder.append(parts[0].charAt(0));
            /// AQUI AÑADESE O RESTO DOS APELLIDOS SEN ESPACIOS
            for (int i = 1; i < parts.length; i++) {
                codeBuilder.append(parts[i]);
            }
        }

        return codeBuilder.toString();
    }

    public String getName() {
        return name;
    }

    public String getSurnames() {
        return surnames;
    }

    public String getPhone() {
        return phone;
    }

    public String getCode() {
        return code;
    }

    @Override
    public void callMyNumber() {
        System.out.println("Te estás llamando a ti mismo:");
        System.out.println("Nombre: " + name);
        System.out.println("Apellidos: " + surnames);
        System.out.println("Número: " + phone);
    }

    @Override
    public void callOtherNumber(String number) {
        System.out.println("Estás llamando al número: " + number);
        System.out.println("Desde el contacto:");
        System.out.println("Nombre: " + name);
        System.out.println("Apellidos: " + surnames);
    }

    @Override
    public void showContactDetails() {
        System.out.println("Nombre: " + name);
        System.out.println("Apellidos: " + surnames);
        System.out.println("Número: " + phone);
        System.out.println("Código: " + code);
    }
}



