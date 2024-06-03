package com.example.pr24;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class FootballerServiceTest {
    @Mock
    private FootballerRepository footballerRepository;

    @Captor
    ArgumentCaptor<Footballer> captor;

    @Test
    public void getFootballers() {
        Footballer footballer1 = new Footballer();
        footballer1.setId(5);
        footballer1.setFirstName("Leo");
        footballer1.setLastName("Messi");

        Footballer footballer2 = new Footballer();
        footballer1.setId(6);
        footballer1.setFirstName("Luis");
        footballer1.setLastName("Suarez");
        Mockito.when(footballerRepository.findAll()).thenReturn(List.of(footballer1, footballer2));
        FootballerService service = new FootballerService(footballerRepository);
        assertEquals(2, service.getFootballers().size());
        assertEquals("Luis", service.getFootballers().get(0).getFirstName());
    }

    @Test
    public void createFootballer() {
        Footballer new_footballer = new Footballer();
        new_footballer.setId(7);
        new_footballer.setFirstName("Andres");
        new_footballer.setLastName("Iniesta");
        FootballerService service = new FootballerService(footballerRepository);
        service.save(new_footballer);
        Mockito.verify(footballerRepository).save(captor.capture());
        Footballer captured = captor.getValue();
        assertEquals("Andres", captured.getFirstName());
    }


    @Test
    public void deleteFootballer() {
        Long id = (long)5;
        footballerRepository.deleteById(id);
    }
}
