package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        System.out.println("Step 1: Creating mock object for ExternalApi");
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        System.out.println("Step 2: Stubbing getData() to return 'Mock Data'");
        when(mockApi.getData()).thenReturn("Mock Data");

        System.out.println("Step 3: Creating MyService with mock");
        MyService service = new MyService(mockApi);

        System.out.println("Step 4: Calling fetchData()");
        String result = service.fetchData();

        System.out.println("Step 5: Verifying result");
        assertEquals("Mock Data", result);
        System.out.println("Test Passed: fetchData() returned 'Mock Data'");
    }
}
