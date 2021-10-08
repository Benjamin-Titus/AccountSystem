package za.ac.nwu.account.system.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="ACCOUNT_TYPE",schema="VITRSA_SANDBOX")
public class AccountType implements Serializable {
    @Id
    @SequenceGenerator(name="VIT_RSA_GENERIC_SEQ",sequenceName="VITRSA_SANDBOX.VIT_RSA_GENERIC_SEQ",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="VIT_RSA_GENERIC_SEQ")
    @Column(name="ACCOUNT_TYPE_ID")
    private Long accountTypeId;

    @Column(name="MNEMONIC")
    private String mnemonic;

    @Column(name="ACCOUNT_TYPE_NAME")
    private String accountTypeName;

    //@JsonSerialize(using=LocalDateSerializer.class)
   // @JsonDeserialize(using=LocalDateDeserialize.class)
    @Column(name="CREATION_NAME")
    private LocalDate creationDate;
    private Set<AccountTransaction> accountTransactions;

    public AccountType(Long accountTypeId, String mnemonic, String accountTypeName, LocalDate creationDate, Set<AccountTransaction> accountTransactions) {
        this.accountTypeId = accountTypeId;
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;
        AccountTransactions = accountTransactions;
    }
    private Set<AccountTransaction>AccountTransactions;

    public AccountType(Set<AccountTransaction> accountTransactions) {
        AccountTransactions = accountTransactions;
    }

    public AccountType(String mnemonic, String accountTypeName, LocalDate creationTime) {
    }

    @OneToMany(targetEntity=AcoountTransaction.class,fetch=FetchType.LAZY,mappedBy="accountType",orphanRemoval=true,cascade=CascadeType.PERSIST)
    public Set<AccountTransaction>getAccountTransactions(){

        return accountTransanction;
    }
    public void setAccountTransactions(Set<AccountTransaction> accountTransactions){
        this.accountTransactions=accountTransactions;
    }

    public Long getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountType)) return false;
        AccountType that = (AccountType) o;
        return getAccountTypeId().equals(that.getAccountTypeId()) && getMnemonic().equals(that.getMnemonic()) && getAccountTypeName().equals(that.getAccountTypeName()) && getCreationDate().equals(that.getCreationDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountTypeId(), getMnemonic(), getAccountTypeName(), getCreationDate());
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accountTypeId=" + accountTypeId +
                ", mnemonic='" + mnemonic + '\'' +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
