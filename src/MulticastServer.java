import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MulticastServer {
    public static void main(String[] args) {
        final String MULTICAST_IP = "230.0.0.1"; // Многоадресный IP-адрес
        final int PORT = 4446; // Порт для отправки данных

        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress group = InetAddress.getByName(MULTICAST_IP);
            String message = "Привет, клиенты!"; // Сообщение для отправки
            byte[] buffer = message.getBytes();

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, PORT);

            System.out.println("Сервер отправляет сообщение: " + message);
            socket.send(packet);
            System.out.println("Сообщение успешно отправлено группе: " + MULTICAST_IP);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
