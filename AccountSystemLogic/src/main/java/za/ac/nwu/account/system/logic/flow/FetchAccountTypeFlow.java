package za.ac.nwu.account.system.logic.flow;

import za.ac.nwu.account.system.domain.dto.AccountTypeDto;

import java.util.List;

public interface FetchAccountTypeFlow {
    List<AccountTypeDto>getAllAccountTypes();
}
