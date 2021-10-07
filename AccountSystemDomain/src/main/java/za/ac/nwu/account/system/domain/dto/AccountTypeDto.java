package za.ac.nwu.account.system.domain.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class AccountTypeDto implements Serializable {
    private String anemonic;
    private String accountTypeName;
    private LocalDate creationTime;

    public AccountTypeDto() {
    }

    public AccountTypeDto(String anemonic, String accountTypeName, LocalDate creationTime) {
        this.anemonic = anemonic;
        this.accountTypeName = accountTypeName;
        this.creationTime = creationTime;
    }

    public String getAnemonic() {
        return anemonic;
    }

    public void setAnemonic(String anemonic) {
        this.anemonic = anemonic;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    public LocalDate getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDate creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountTypeDto)) return false;
        AccountTypeDto that = (AccountTypeDto) o;
        return getAnemonic().equals(that.getAnemonic()) && getAccountTypeName().equals(that.getAccountTypeName()) && getCreationTime().equals(that.getCreationTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAnemonic(), getAccountTypeName(), getCreationTime());
    }

    @Override
    public String toString() {
        return "AccountTypeDto{" +
                "anemonic='" + anemonic + '\'' +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", creationTime=" + creationTime +
                '}';
    }
}
