package com.campusdual.classroom;

import java.util.Scanner;

public class Exercise {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        Phonebook phonebook = new Phonebook();

        int option;
        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Mostrar todos los contactos");
            System.out.println("3. Buscar contacto por código");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Acciones de un contacto");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1: {
                    System.out.print("Nombre: ");
                    String name = scanner.nextLine();
                    System.out.print("Apellidos: ");
                    String surnames = scanner.nextLine();
                    System.out.print("Número de teléfono: ");
                    String phone = scanner.nextLine();

                    Contact contact = new Contact(name, surnames, phone);
                    phonebook.addContact(contact);
                    System.out.println("Contacto añadido con código: " + contact.getCode());
                    break;
                }

                case 2: {
                    phonebook.showPhonebook();
                    break;
                }

                case 3: {
                    System.out.print("Introduce el código del contacto: ");
                    String code = scanner.nextLine();
                    Contact c = phonebook.getData().get(code);
                    if (c != null) {
                        c.showContactDetails();
                    } else {
                        System.out.println("No se encontró el contacto.");
                    }
                    break;
                }

                case 4: {
                    System.out.print("Introduce el código del contacto a eliminar: ");
                    String code = scanner.nextLine();
                    phonebook.deleteContact(code);
                    System.out.println("Contacto eliminado (si existía).");
                    break;
                }

                case 5: {
                    System.out.print("Introduce el código del contacto: ");
                    String code = scanner.nextLine();
                    Contact c = phonebook.getData().get(code);
                    if (c != null) {
                        int subOption;
                        do {
                            System.out.println("\n--- ACCIONES DE CONTACTO ---");
                            System.out.println("1. Llamar a mi número");
                            System.out.println("2. Llamar a otro número");
                            System.out.println("3. Mostrar detalles");
                            System.out.println("0. Volver");
                            System.out.print("Selecciona una opción: ");
                            subOption = Integer.parseInt(scanner.nextLine());

                            switch (subOption) {
                                case 1: {
                                    c.callMyNumber();
                                    break;
                                }
                                case 2: {
                                    System.out.print("Número a llamar: ");
                                    String otherNumber = scanner.nextLine();
                                    c.callOtherNumber(otherNumber);
                                    break;
                                }
                                case 3: {
                                    c.showContactDetails();
                                    break;
                                }
                                case 0: {
                                    System.out.println("Volviendo al menú principal...");
                                    break;
                                }
                                default: {
                                    System.out.println("Opción no válida.");
                                    break;
                                }
                            }
                        } while (subOption != 0);
                    } else {
                        System.out.println("No se encontró el contacto.");
                    }
                    break;
                }

                case 0: {
                    System.out.println("¡Hasta luego!");
                    break;
                }

                default: {
                    System.out.println("Opción no válida.");
                    break;
                }
            }

        } while (option != 0);

        scanner.close();
    }
}

