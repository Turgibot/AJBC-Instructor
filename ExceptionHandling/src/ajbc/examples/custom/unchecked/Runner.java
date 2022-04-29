package ajbc.examples.custom.unchecked;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;

import ajbc.examples.custom.unchecked.BusinessLogicException.ErrorCode;

public class Runner {

	public static boolean addUserToDB(User user) throws BusinessLogicException {
		int age = LocalDate.now().getYear() - user.bDay.getYear();
		if (age < 18)
			throw new BusinessLogicException("value: " + age, BusinessLogicException.ErrorCode.ILLEGAL_AGE);
		if (user.id <= 0)
			throw new BusinessLogicException("value: " + user.id, BusinessLogicException.ErrorCode.INVALID_ID);
		return true;
	}

	public static void main(String[] args) {
		String msg = "";
		User user1 = new User("David", 123l, LocalDate.now().minus(18, ChronoUnit.YEARS));
		String dbMsg = addUserToDB(user1) ? "Success" : "Failure"; // unchecked exception might be thrown here- Danger!
		System.out.println("Added User1 to DB: " + dbMsg);

		User user2 = new User("David", 123l, LocalDate.now().minus(10, ChronoUnit.YEARS));
		try {
			dbMsg = addUserToDB(user2) ? "Success" : "Failure";
			System.out.println("Added User2 to DB: " + dbMsg);
		} catch (BusinessLogicException e) {
			ErrorCode errorCode = e.getErrorCode();
			msg = "DB Error: " + e.getMessage() + ", " + errorCode.name() + ", code " + errorCode.codeNum;
		} finally {
			JOptionPane.showMessageDialog(null, msg);
		}
	}

}
