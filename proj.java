import java.util.Scanner;

public class proj {

  static final int ACCOUNT_MAX = 5;

  static String names[] = new String[ACCOUNT_MAX];
  static double balance[] = new double[ACCOUNT_MAX];

  static int accountCou = 0;

  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int choice, check;

    do {
      System.out.println("Welcome To ATM 🏦");
      System.out.println("1. Creat Account");
      System.out.println("2. Check Balance");
      System.out.println("3. Deposit Money");
      System.out.println("4. Withdraw Money");
      System.out.println("0. to Exit");
      System.out.print("Choice: ");
      choice = scanner.nextInt();

      switch (choice) {
        case 1:
          creatAcc();
          break;
        case 2:
          if (accountCou == 0) {
            System.out.println("there is no account sign in ‼");
          } else {
            check = selectAcc();
            checkBal(check);
          }
          break;
        case 3:
          if (accountCou == 0) {
            System.out.println("there is no account sign in ‼");
          } else {
            check = selectAcc();
            DepositMon(check);
          }
          break;
        case 4:
          if (accountCou == 0) {
            System.out.println("there is no account sign in ‼");
          } else {
            check = selectAcc();
            withdrawMon(check);
          }
          break;
        default:
          System.out.println("Invalid choice ⚠️");
          break;
      }
    } while (choice != 0);

    System.out.println("see you later 😁");
    scanner.close();
  }

  public static void creatAcc() {
    while (accountCou >= ACCOUNT_MAX) {
      System.out.println("you hit the max number for account is 5, you can't add more!");
      return;
    }

    System.out.println("Enter Name for Account: ");
    String name = scanner.nextLine();

    System.out.println("Enter Initial deposit: ");
    double intialDep = scanner.nextDouble();

    while (intialDep < 0) {
      System.out.println("");
      intialDep = scanner.nextDouble();
    }

    names[accountCou] = name;
    balance[accountCou] = intialDep;
    accountCou++;

    System.out.println("your account name is " + name + "and the balance is " + intialDep + "$");
  }

  public static int selectAcc() {
    System.out.println("=> Choice Account");
    for (int i = 0; i < accountCou; i++) {
      System.out.println((i + 1) + ". " + names[i]);
    }

    System.out.println("Enter The Account Number: ");
    int accountNum = scanner.nextInt();

    while (accountNum < 1 || accountNum > accountCou) {
      System.out.println("invalid account number, try agine: ");
      accountNum = scanner.nextInt();
    }

    return accountNum - 1;
  }

  public static void checkBal(int check1) {
    System.out.println("account name: " + names[check1]);
    System.out.println("balance is: " + balance[check1]);
  }

  public static void DepositMon(int check2) {
    System.out.print("Enter How Mech You Went To Deposit: ");
    double deposit = scanner.nextDouble();

    while (deposit <= 0) {
      System.out.print("Must be over than zero, try agine: ");
      deposit = scanner.nextDouble();
    }

    balance[check2] += deposit;
    System.out.println("new balance is: " + balance[check2]);
  }

  public static void withdrawMon(int check3) {
    System.out.print("Enter How Mech You Went To Withdraw: ");
    double withdraw = scanner.nextDouble();

    while (withdraw > balance[check3]) {
      System.out.print("Must be you have that mech meony in your account, try agine: ");
      withdraw = scanner.nextDouble();
    }

    while (withdraw <= 0) {
      System.out.print("Must be over than zero, try agine: ");
      withdraw = scanner.nextDouble();
    }

    balance[check3] -= withdraw;
    System.out.println("new balance is: " + balance[check3]);
  }
}
