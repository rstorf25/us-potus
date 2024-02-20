package com.rs.uspotus.repository;

import com.rs.uspotus.model.President;
import org.apache.commons.collections4.IterableUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PresidentRepositoryTest {

    President TEST_PRESIDENT = new President(1L, "George", "Washington", false, 1L, 2L);
    President TEST_PRESIDENT_1 = new President(2L, "John", "Adams", false, 1L, 2L);

    @Autowired
    private PresidentsRepository presidentsRepository;

    @Test
    void savePresidentTest() {

        President savedPres = presidentsRepository.save(TEST_PRESIDENT);

        assertNotNull(savedPres.getId());
        assertEquals(savedPres.getFirstName(), TEST_PRESIDENT.getFirstName());

    }

    @Test
    void findPresidentByIdTest() {
        President savedPres = presidentsRepository.save(TEST_PRESIDENT);

        Optional<President> recalledPres = presidentsRepository.findById(TEST_PRESIDENT.getId());

        assertTrue(recalledPres.isPresent());
        assertEquals(savedPres, recalledPres.get());
    }

    @Test
    void getAllPresidentsTest() {
        President savedPres1 = presidentsRepository.save(TEST_PRESIDENT);
        President savedPres2 = presidentsRepository.save(TEST_PRESIDENT_1);

        Iterable<President> presidents = presidentsRepository.findAll();

        List<President> presList = IterableUtils.toList(presidents);

        assertTrue(presList.contains(savedPres1));
        assertTrue(presList.contains(savedPres2));

    }

    @Test
    void deletePresidentByIdTest() {
        President savedPres1 = presidentsRepository.save(TEST_PRESIDENT);
        President savedPres2 = presidentsRepository.save(TEST_PRESIDENT_1);

        presidentsRepository.deleteById(TEST_PRESIDENT.getId());

        Iterable<President> allPresidents = presidentsRepository.findAll();

        List<President> presList = IterableUtils.toList(allPresidents);

        assertTrue(presList.contains(savedPres2));
        assertFalse(presList.contains(savedPres1));
    }

}
