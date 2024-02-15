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
    President testPresident1 = new President(1L, "Abe", "Lincoln", false, 1L, 4L);
    President testPresident2 = new President(2L, "Joe", "Biden", true, 1L, 4L);

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
        Long presId = 1L;
        String expectedPresName = "Abe";
        when(presidentsRepository.findById(presId)).thenReturn(Optional.ofNullable(testPresident1));

        Optional<President> getPres = presidentsService.getPresidentById(presId);

        assertTrue(getPres.isPresent());
        assertEquals(expectedPresName, getPres.get().getFirstName());
        verify(presidentsRepository, times(1)).findById(presId);
    }

    //    @Test
//    void removePresidentById() {
//
//    }
}





