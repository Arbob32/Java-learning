package com.ru.vsgutu.chapter14.b;

import java.io.IOException;
import java.net.InetAddress;

public class NetworkScanner {

    public static void scanNetwork(String startIp, String endIp, int timeout) {
        long start = ipToLong(startIp);
        long end = ipToLong(endIp);

        if (start > end) {
            System.out.println("Начальный IP должен быть меньше или равен конечному IP.");
            return;
        }

        System.out.println("Сканирование сети...");

        for (long currentIp = start; currentIp <= end; currentIp++) {
            String ip = longToIp(currentIp);
            if (isHostReachable(ip, timeout)) {
                System.out.println("Активный хост: " + ip);
            }
        }

        System.out.println("Сканирование завершено.");
    }

    private static boolean isHostReachable(String ip, int timeout) {
        try {
            InetAddress address = InetAddress.getByName(ip);
            return address.isReachable(timeout);
        } catch (IOException e) {
            return false;
        }
    }

    private static long ipToLong(String ipAddress) {
        String[] octets = ipAddress.split("\\.");
        long result = 0;
        for (int i = 0; i < 4; i++) {
            result |= (Long.parseLong(octets[i]) << (24 - (8 * i)));
        }
        return result;
    }

    private static String longToIp(long ip) {
        return String.format(
                "%d.%d.%d.%d", (ip >> 24) & 0xFF, (ip >> 16) & 0xFF, (ip >> 8) & 0xFF, ip & 0xFF);
    }
}
