package za.ac.nwu.account.system.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.account.system.domain.dto.AccountTypeDto;
import za.ac.nwu.account.system.domain.persistence.AccountType;
import za.ac.nwu.account.system.repository.persistence.AccountTypeRepo;
import za.ac.nwu.account.system.translator.AccountTypeTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTypeTranslatorImpl implements AccountTypeTranslator {
    private final AccountTypeRepo accountTypeRepo;

    @Autowired
    public AccountTypeTranslatorImpl(AccountTypeRepo accountTypeRepo) {

        this.accountTypeRepo = accountTypeRepo;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes() {
        List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
        try {
            for (AccountType accountType : accountTypeRepo.findAll()) {
                AccountTypeDtos.add(new AccountTypeDto(accountType));
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }
        return AccountTypeDtos;
    }

    @Override
    public AccountTypeDto create(AccountTypeDto accountTypeDto) {
        try {
            AccountType accountType = accountTypeRepo.save(accountTypeDto.getAccountType());
            return new AccountTypeDto(accountType);
        } catch (Exception e) {
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

    @Override
    public AccountTypeDto getAccountTypeByMnemonicNativeQuery(String mnemonic) {
        try {
            AccountType accountType = accountTypeRepo.getAccountTypeByMnemonicNativeQuery(mnemonic);
            return new AccountTypeDto(accountType);
        } catch (Exception e) {
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }
        @Override
        public AccountTypeDto getAccountTypeByMnemonic (String mnemonic){
            try {
                AccountType accountType = accountTypeRepo.getAccountTypeByMnemonic(mnemonic);
                return new AccountTypeDto(accountType);
            } catch (Exception e) {
                throw new RuntimeException("Unable to save to the DB", e);
            }
        }
    @Override
    public AccountTypeDto getAccountTypeDtoByMnemonic (String mnemonic){
        try {
            AccountType accountType = accountTypeRepo.getAccountTypeDtoByMnemonic(mnemonic);
            return new AccountTypeDto(accountType);
        } catch (Exception e) {
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

    }

