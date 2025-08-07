package com.javatrainingschool.model;
import java.util.ArrayList;
import java.util.List;



	
	
	/*
	 * 
	 * Das Model verwaltet die Daten und die Logik. Es ist zuständig für die Speicherung, Abfrage und Bearbeitung der Chat-Nachrichten. Im Moment übernimmt die statische Liste im Servlet diese Rolle.

Was Sie tun müssen:

Erstellen Sie eine neue Java-Klasse, z. B. ChatModel.java, im Verzeichnis src/main/java/com/javatrainingschool/model.

Verschieben Sie die static List<String> messages und die Logik zum Hinzufügen von Nachrichten aus dem Servlet in diese Klasse.

Stellen Sie öffentliche Methoden bereit, um Nachrichten hinzuzufügen (addMessage(String message)) und alle Nachrichten abzurufen (getMessages()).
	 * 
	 * */
	
	
public class ChatModel {
	    // Die statische Liste speichert alle Chat-Nachrichten im Speicher
	    private static List<String> messages = new ArrayList<>();

	    // Methode zum Hinzufügen einer neuen Nachricht
	    public void addMessage(String message) {
	        // Optionale Überprüfung, ob die Nachricht gültig ist
	        if (message != null && !message.trim().isEmpty()) {
	            messages.add(message);
	        }
	    }

	    // Methode zum Abrufen aller Nachrichten
	    public List<String> getMessages() {
	        // Gibt eine Kopie der Liste zurück, um die interne Liste vor externen Änderungen zu schützen
	        return new ArrayList<>(messages);
	    }
	}
