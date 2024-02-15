package com.rs.uspotus.service;

import com.rs.uspotus.model.President;
import com.rs.uspotus.repository.PresidentsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PresidentsServiceTest {
    Long PRES_ID = 1L;
    Long TERM_SERVED = 1L;
    President testPresident1 = new President(PRES_ID, "Abe", "Lincoln", false, TERM_SERVED, 4L);
    President testPresident2 = new President(2L, "Joe", "Biden", true, TERM_SERVED, 4L);


    @Mock
    private PresidentsRepository presidentsRepository;

    @InjectMocks
    private PresidentsService presidentsService;

    @Test
    void addPresidentTest() {

        when(presidentsRepository.save(any())).thenReturn(testPresident1);

        President savedPresident = presidentsService.addPresident(testPresident1);

        assertEquals(testPresident1.getFirstName(), savedPresident.getFirstName());
        verify(presidentsRepository, times(1)).save(any());
    }


    @Test
    void getAllPresidentsTest() {
        List<President> presidents = Arrays.asList(testPresident1, testPresident2);
        when(presidentsRepository.findAll()).thenReturn(presidents);

        Iterable<President> allPresidents = presidentsService.getAllPresidents();

        assertEquals(presidents.size(), ((List<President>) allPresidents).size());
        verify(presidentsRepository, times(1)).findAll();
    }

    @Test
    void getPresidentByIdTest() {
        String expectedPresName = "Abe";
        when(presidentsRepository.findById(PRES_ID)).thenReturn(Optional.ofNullable(testPresident1));

        Optional<President> getPres = presidentsService.getPresidentById(PRES_ID);

        assertTrue(getPres.isPresent());
        assertEquals(expectedPresName, getPres.get().getFirstName());
        verify(presidentsRepository, times(1)).findById(PRES_ID);
    }

    @Test
    void removePresidentByIdTest() {
        doNothing().when(presidentsRepository).deleteById(PRES_ID);

        presidentsService.removePresidentById(PRES_ID);

        verify(presidentsRepository, times(1)).deleteById(PRES_ID);

    }
}





