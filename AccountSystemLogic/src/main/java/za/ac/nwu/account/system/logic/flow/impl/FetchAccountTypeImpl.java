package za.ac.nwu.account.system.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.account.system.domain.dto.AccountTypeDto;
import za.ac.nwu.account.system.logic.flow.FetchAccountTypeFlow;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class FetchAccountTypeImpl implements FetchAccountTypeFlow {

    @Override
    public List<AccountTypeDto> getAllAccountTypes() {
        List<AccountTypeDto>accountTypeDtos=new ArrayList<>();
        accountTypeDtos.add(new AccountTypeDto("MILES","Miles", LocalDate.now()));
        return null;
    }
}

