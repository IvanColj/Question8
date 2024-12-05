import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastClient {
    public void start() {
        final String MULTICAST_IP = "230.0.0.1"; // Многоадресный IP-адрес
        final int PORT = 4446; // Порт для получения данных

        try (MulticastSocket socket = new MulticastSocket(PORT)) {
            InetAddress group = InetAddress.getByName(MULTICAST_IP);
            socket.joinGroup(group); // Присоединяемся к группе

            System.out.println("Клиент присоединился к группе: " + MULTICAST_IP);

            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            System.out.println("Ожидание сообщения...");
            socket.receive(packet); // Получаем пакет

            String receivedMessage = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Получено сообщение: " + receivedMessage);

            socket.leaveGroup(group); // Покидаем группу
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
