interface Payable {
    void pay(double amount);
}

abstract class PaymentMethod {
    protected String accountName;
    protected String paymentId;

    public PaymentMethod(String accountName, String paymentId) {
        this.accountName = accountName;
        this.paymentId = paymentId;
    }
    //Phương thức kiểm tra hợp lệ
    public abstract void validate();
}
//Phần 2
class CreditCard extends PaymentMethod implements Payable {
    private String cardNumber;
    private String cvv;
    private double creditLimit;

    public CreditCard(String accountName, String paymentId,String cardNumber,String cvv,double creditLimit) {
        super(accountName, paymentId);
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.creditLimit = creditLimit;
    }

    @Override
    public void validate() {
        if (cardNumber.length() == 16 && cardNumber.matches("\\d{16}")) {
            System.out.println("Thẻ hợp lệ.");
        } else {
            System.out.println("Số thẻ không hợp lệ");
        }
    }

    @Override
    public void pay(double amount) {
        if (amount <= creditLimit) {
            creditLimit -= amount;
            System.out.println("Thanh toán thành công bằng Credit Card.");
            System.out.println("Hạn mức còn lại: " + creditLimit);
        } else {
            System.out.println("Vượt quá hạn mức tín dụng");
        }
    }
}

class EWallet extends PaymentMethod implements Payable {
    private String phoneNumber;
    private double balance;

    public EWallet(String accountName,String paymentId,String phoneNumber,double balance) {
        super(accountName, paymentId);
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    @Override
    public void validate() {
        if (phoneNumber.matches("\\d{10}")) {
            System.out.println("Số điện thoại hợp lệ.");
        } else {
            System.out.println("Số điện thoại không hợp lệ");
        }
    }

    @Override
    public void pay(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Thanh toán thành công bằng E-Wallet.");
            System.out.println("Số dư còn lại: " + balance);
        } else {
            System.out.println("Không đủ số dư");
        }
    }
}
//Phần 3
public class ThucHanh {
    public static void main(String[] args) {
        CreditCard card = new CreditCard("Nguyen Van A","CC001","1234567812345678","123",5000000);

        card.validate();
        card.pay(1000000);

        System.out.println("------------------");

        EWallet wallet = new EWallet("Tran Thi B","EW001","0987654321",2000000);

        wallet.validate();
        wallet.pay(500000);

        System.out.println("------------------");

        Payable rewardPoints = new Payable() {
            @Override
            public void pay(double amount) {
                double points = amount / 1000; //1000đ = 1 điểm
                System.out.println("Thanh toán bằng điểm thưởng.");
                System.out.println("Quy đổi: " + amount + " VND = " + points + " điểm.");
            }
        };

        rewardPoints.pay(200000);
    }
}