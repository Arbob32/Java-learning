package com.ru.vsgutu.chapter14;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.ru.vsgutu.chapter14.b.NetworkScanner;
import java.io.IOException;
import java.net.InetAddress;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class NetworkScannerTest {

    @Test
    void testScanNetwork() throws IOException {
        InetAddress mockAddress = mock(InetAddress.class);

        Mockito.mockStatic(InetAddress.class);
        when(InetAddress.getByName(anyString())).thenReturn(mockAddress);

        when(mockAddress.isReachable(anyInt())).thenReturn(true);

        assertDoesNotThrow(
                () -> {
                    NetworkScanner.scanNetwork("192.168.1.1", "192.168.1.3", 1000);
                });

        Mockito.clearAllCaches();
    }
}
