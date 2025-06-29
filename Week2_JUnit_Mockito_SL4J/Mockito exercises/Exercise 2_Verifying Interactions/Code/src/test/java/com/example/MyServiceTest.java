package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        System.out.println("Created mock for ExternalApi.");

        MyService service = new MyService(mockApi);
        System.out.println("Injected mock into MyService.");

        service.fetchData();
        System.out.println("Called fetchData() on MyService.");

        verify(mockApi).getData();
        System.out.println("Verified: mockApi.getData() was called.");
    }
}
