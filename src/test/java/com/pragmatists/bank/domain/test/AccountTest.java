package com.pragmatists.bank.domain.test;

import com.pragmatists.bank.domain.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AccountTest {

    private Account account;

    @Before
    public void initialise() {
        account = new Account();
    }

    @Test
    public void should_xxx() {
        account.deposit();
    }
}
