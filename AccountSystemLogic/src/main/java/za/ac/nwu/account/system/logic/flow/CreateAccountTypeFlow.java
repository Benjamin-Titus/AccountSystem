package za.ac.nwu.account.system.logic.flow;

import za.ac.nwu.account.system.domain.dto.AccountTypeDto;

public interface CreateAccountTypeFlow {
    AccountTypeDto create(AccountTypeDto accountType);
}
