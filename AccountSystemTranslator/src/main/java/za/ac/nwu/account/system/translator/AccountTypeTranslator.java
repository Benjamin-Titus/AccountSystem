package za.ac.nwu.account.system.translator;


import za.ac.nwu.account.system.domain.dto.AccountTypeDto;
import za.ac.nwu.account.system.domain.persistence.AccountType;

import java.util.List;

public interface AccountTypeTranslator {
    List<AccountTypeDto>getAllAccountTypes();

    AccountTypeDto create(AccountTypeDto accountType);

    AccountTypeDto save(AccountType accountType);

    AccountTypeDto getAccountTypeByMnemonicNativeQuery(String mnemonic);

    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);

    AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic);

    void someMethod();

    AccountTypeDto getAccountTypeDbEntityByMnemonic(String mnemonic);

    void delete(AccountType accountType);
}
