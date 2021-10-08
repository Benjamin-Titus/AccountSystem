package za.ac.nwu.account.system.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.account.system.domain.dto.AccountTypeDto;
import za.ac.nwu.account.system.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.account.system.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchAccountTypeImpl<accountTypeTranslator> implements FetchAccountTypeFlow {
    private final AccountTypeTranslator accountTypeTranslator;

    @Autowired
    public FetchAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator)

    public FetchAccountTypeImpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes() {

        return accountTypeTranslator.getAllAccountTypes();
    }
    @Override
    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic){
        return AccountTypeTranslator.getAccountTypeByMnemonic(mnemonic);
    }
}

