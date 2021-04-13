package tdd.practice;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import tdd.practice.entity.UserName;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest //이러면 그냥 통합 테스트인가?
//이렇게 하는게 맞는가?
class TddTestServiceTest {

    private UserNameRepository userNameRepository = new UserNameRepository() {
        @Override
        public Long countByUserName(String userName) {
            return null;
        }

        @Override
        public List<UserName> findAll() {
            return null;
        }

        @Override
        public List<UserName> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<UserName> findAllById(Iterable<Long> iterable) {
            return null;
        }

        @Override
        public <S extends UserName> List<S> saveAll(Iterable<S> iterable) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends UserName> S saveAndFlush(S s) {
            return null;
        }

        @Override
        public void deleteInBatch(Iterable<UserName> iterable) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public UserName getOne(Long aLong) {
            return null;
        }

        @Override
        public <S extends UserName> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends UserName> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<UserName> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends UserName> S save(S s) {
            return null;
        }

        @Override
        public Optional<UserName> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(UserName userName) {

        }

        @Override
        public void deleteAll(Iterable<? extends UserName> iterable) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends UserName> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends UserName> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends UserName> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends UserName> boolean exists(Example<S> example) {
            return false;
        }
    };
    private TddTestService tddTestService = new TddTestService(userNameRepository);

    @Test
    void getAnagramsTest() {
        //given
        String givenName = "wonmocyberschool";

        ArrayList<String> result = new ArrayList<>();

        //when
        result = tddTestService.getAnagrams(givenName);

        //then : 0번 : wonmo, 1, 2, 3 번 각 달라야 함.
        Boolean success = (result.get(1) != result.get(2)
                && result.get(1) != result.get(3)
                && result.get(2) != result.get(3));


        assertEquals("wonmocyberschool", result.get(0));
        assertEquals(true,success);
    }
}