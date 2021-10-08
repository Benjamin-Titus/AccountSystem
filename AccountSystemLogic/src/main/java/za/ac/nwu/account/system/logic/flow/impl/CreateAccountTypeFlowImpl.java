package za.ac.nwu.account.system.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.account.system.domain.dto.AccountTypeDto;
import za.ac.nwu.account.system.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.account.system.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createAccountTypeFlowName")
public class CreateAccountTypeFlowImpl implements CreateAccountTypeFlow {

    private final AccountTypeTranslator accountTypeTranslator;

    public CreateAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator){
        this.accountTypeTranslator=accountTypeTranslator;
    }
    @Override
    public AccountTypeDto create(AccountTypeDto accountType){
        if(null==accountType.getCreationTime()){
            accountType.setCreationTime(LocalDate.now());
        }
        return AccountTypeTranslator.create(accountType);
    }
}
