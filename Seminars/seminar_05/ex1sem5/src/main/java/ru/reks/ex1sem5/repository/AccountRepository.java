package ru.reks.ex1sem5.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.reks.ex1sem5.model.Account;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {

    @Query("SELECT * FROM account WHERE name = :name")
    List<Account> findByName(String name);

    @Modifying
    @Query("UPDATE account SET amount = :amount WHERE id = :id")
    void changeAmount(long id, BigDecimal amount);
}
