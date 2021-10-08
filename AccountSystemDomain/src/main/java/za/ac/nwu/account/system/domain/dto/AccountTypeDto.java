package za.ac.nwu.account.system.domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.account.system.domain.persistence.AccountType;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value="AccountType",description="A DTO that represents the AccountType")

public class AccountTypeDto implements Serializable {
    private String mnemonic;
    private String accountTypeName;
    private LocalDate creationTime;

    public AccountTypeDto() {
    }

    public AccountTypeDto(String mnemonic, String accountTypeName, LocalDate creationTime) {
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationTime = creationTime;
    }

    public AccountTypeDto(AccountType accountType) {
    }
    @ApiModelProperty(Position=1,
            value="AccountType Mnemonic",
            name="Mnemonic",
            notes="Uniquely idetifies the AccountTypes",
            dataType="java.lang.String",
            example="Miles",
            allowEmptyValue=false,
            required=false)

    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String anemonic) {
        this.mnemonic = anemonic;
    }
    @ApiModelProperty(Position=2,
            value="AccountType Name",
            name="Name",
            notes="This name of the AccountType",
            dataType="java.lang.String",
            example="Miles",
            required=true)
    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }
    @ApiModelProperty(Position=3,
            value="AccountType Creation Date",
            name="CreationDate",
            notes="This is the date on which the AccountType was created",
            dataType="java.lang.String",
            example="2021-02-01",
            allowEmptyValue=true,
            required=false)
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
        return getMnemonic().equals(that.getMnemonic()) && getAccountTypeName().equals(that.getAccountTypeName()) && getCreationTime().equals(that.getCreationTime());
    }
    @JsonIgnore
    public AccountType getAccountType(){
        return new AccountType(getMnemonic(),getAccountTypeName(),getCreationTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMnemonic(), getAccountTypeName(), getCreationTime());
    }

    @Override
    public String toString() {
        return "AccountTypeDto{" +
                "anemonic='" + mnemonic + '\'' +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", creationTime=" + creationTime +
                '}';
    }
}
