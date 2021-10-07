package za.ac.nwu.account.system.domain.persistence;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@Table(name="Account_Type",schema="VITRSA_SANDBOX")
public class AccountTransaction implements Serializable {
    @Id
    @SequenceGenerator(name="VIT_RSA_GENERIC_SEQ",sequenceNmae="VITRSA_SANDBOX.VIT_RSA_GENERIC_SEQ",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="VIT_RSA_GENERIC_SEQ")
    @Column(name= "TX.ID")
    private Long transactionID;

    @Column(name="ACCOUNT_TYPE_ID")
    private Long accountTypeId;

    @Column(name="Member_ID")
    private Long memberId;

    @Column(name="Amount")
    private Long amount;

    @Column(name="TX_DATE")
    private LocalDate transactionDate;

    public AccountTransaction(Long transactionID, Long accountTypeId, Long memberId, Long amount, LocalDate transactionDate) {
        this.transactionID = transactionID;
        this.accountTypeId = accountTypeId;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransaction() {
    }

    public Long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Long transactionID) {
        this.transactionID = transactionID;
    }
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ACCOUNT_TYPE_ID")
    public Long getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountTransaction)) return false;
        AccountTransaction that = (AccountTransaction) o;
        return getTransactionID().equals(that.getTransactionID()) && getAccountTypeId().equals(that.getAccountTypeId()) && getMemberId().equals(that.getMemberId()) && getAmount().equals(that.getAmount()) && getTransactionDate().equals(that.getTransactionDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTransactionID(), getAccountTypeId(), getMemberId(), getAmount(), getTransactionDate());
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transactionID=" + transactionID +
                ", accountTypeId=" + accountTypeId +
                ", memberId=" + memberId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
