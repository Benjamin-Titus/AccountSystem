package za.ac.nwu.account.system.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.account.system.domain.dto.AccountTypeDto;
import za.ac.nwu.account.system.domain.persistence.AccountTransaction;
import za.ac.nwu.account.system.domain.persistence.AccountType;
import za.ac.nwu.account.system.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.account.system.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Transactional
@Component("createAccountTypeFlowName")
public class CreateAccountTypeFlowImpl implements CreateAccountTypeFlow {

    private final AccountTypeTranslator accountTypeTranslator;

    public CreateAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator){
        this.accountTypeTranslator=accountTypeTranslator;
    }
    @Override
    public AccountTypeDto create(AccountTypeDto accountTypeDto){
        if(null==accountTypeDto.getCreationTime()){
            accountTypeDto.setCreationTime(LocalDate.now());
        }
        AccountType accountType = accountTypeDto.getAccountType();
        Set<AccountTransaction>accountTransactions=new HashSet<>();
        accountTransaction.add(new AccountTransaction(accountType,123L,50L,LocalDate.now()));
        AccountType.setAccountTransactions(accountTransactions);


        return AccountTypeTranslator.save(accountType);
    }
}
