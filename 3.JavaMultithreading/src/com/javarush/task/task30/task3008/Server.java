package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

        private static class Handler extends Thread {
            private Socket socket;

            Handler(Socket socket) {
                this.socket = socket;
            }

            public void run() {
                String userName = null;
                ConsoleHelper.writeMessage("Было установлено соединение с удаленным адресом " + socket.getRemoteSocketAddress());
                try (Connection connection = new Connection(socket)) {
                    userName = serverHandshake(connection);
                    sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                    notifyUsers(connection, userName);
                    serverMainLoop(connection, userName);

                } catch (IOException | ClassNotFoundException e) {
                    ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом");
                }

                if (userName != null) {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }
                ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто");
            }


        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message message = null;
            do {
                connection.send(new Message(MessageType.NAME_REQUEST, "Введите имя пользователя"));
                message = connection.receive();
            } while (message.getType() != MessageType.USER_NAME
                    || message.getData().isEmpty()
                    || connectionMap.containsKey(message.getData()));

            connectionMap.put(message.getData(), connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED, "Ваше имя принято"));
            return message.getData();
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (String name : connectionMap.keySet()) {
                if (!name.equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, name));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    String newMessage = userName + ": " + message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, newMessage));
                } else {
                    ConsoleHelper.writeMessage("Нe верный формат сообщения отличный от \"TEXT\"!");
                }
            }
        }

    }

    public static void main(String[] args) {
        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Сервер запущен.");

            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (IOException e) {
            System.out.println("Ошибка сервера.");

        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {

                }
            }
        }
    }

    public static void sendBroadcastMessage(Message message) {
        try {
            for (Connection conn : connectionMap.values()) {
                conn.send(message);
            }
        } catch (IOException e) {
            System.out.println("Ошибка. Сообщение не отправлено.");
        }
    }
}
